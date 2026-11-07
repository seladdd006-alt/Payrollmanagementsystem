import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PayrollSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new FullTimeEmployee(
                "E01", "Ahmed", 3000,
                LocalDate.of(2022, 1, 10), 500));

        employees.add(new FullTimeEmployee(
                "E02", "Sara", 4000,
                LocalDate.of(2020, 5, 15), 700));

        employees.add(new ContractorEmployee(
                "E03", "Ali",
                LocalDate.of(2023, 3, 20), 20, 100));

        employees.add(new ContractorEmployee(
                "E04", "Mona",
                LocalDate.of(2021, 6, 12), 25, 120));

        double performanceScore = 4.5;

        System.out.println("EMPLOYEES INFORMATION");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Collections.sort(employees);

        System.out.println("\nSORTED BY NET SALARY (HIGHEST TO LOWEST)");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        employees.sort(Comparator.comparing(Employee::getJoinDate));

        System.out.println("\nSORTED BY JOIN DATE (OLDEST FIRST)");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getJoinDate());
        }

        double totalTax = 0;
        double totalBonus = 0;

        System.out.println("\nTAX AND BONUS DETAILS");
        for (Employee employee : employees) {
            double tax = employee.calculateTax();
            double bonus = employee.calculateBonus(performanceScore);

            totalTax += tax;
            totalBonus += bonus;

            System.out.println(employee.getName()
                    + " | Tax: " + tax
                    + " | Bonus: " + bonus);
        }

        System.out.println("\nTotal Tax: " + totalTax);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Payroll Cost (Tax + Bonus): "
                + (totalTax + totalBonus));
    }
}
