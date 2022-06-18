
/*
 * Author: Ping Nalongsone Danddank.
 * email: ndanddank@gmail.com
 * Question 1: Java 8 Stream API practices.
 * */
import java.util.*;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// a. Create an Employee class with two instance fields: a String name and an Integer salary
public class Employee {
    private String name;
    private Integer salary;
    public Employee(){}
    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        // b. Create a List of employees (be sure to implement the equals and hashcode methods)
        final List<Employee> employees = new ArrayList<>();
        IntStream.range(1, 11).forEach(i -> {
            employees.add(new Employee(""+(char)(65+ i)+"_employee", i*10000));
        });
//        System.out.println(employees);
        // c. Use Java 8 Stream and Lambda Expression to achieve the following:
        // i. Calculate the average salary of the list of employees
        double  averageSalary = employees.stream().map(emp -> emp.getSalary())
                .reduce(0, (empSalary1, empSalary2) -> empSalary1 + empSalary2)
                / (employees.size()*1.0);
        System.out.println(String.format("the average salary of the list of employees: %.2f",averageSalary));

        // ii. Filter for employees whose salary exceeds 80000 and print out their names.
        System.out.println("Employee's name whose salary exceeds 80000");
        employees.stream().filter(emp -> emp.getSalary() > 80000)
                .forEach(emp -> System.out.println(emp.name));

        // iii. Collect a Map of employees where the key is the name of employee
        // (String) and the value is the employee object (Employee)
        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName, Function.identity()));
        System.out.println("Map of employees: " + employeeMap);

        // iv. Find any Employee whose name starts with the character X
        //      1. If such an employee exists then print out the name, if not
        //      then print “no such employee exists”
        Optional<String> employee_X =  employeeMap.entrySet().stream()
                .filter(e -> e.getKey().startsWith("X"))
                .map(Map.Entry::getKey).findAny();
        System.out.println("Looking for employee name starts with X: "
                + employee_X.orElse("no such employee exists"));
        Optional<String> employee_B =  employeeMap.entrySet().stream()
                .filter(e -> e.getKey().startsWith("B"))
                .map(Map.Entry::getKey).findAny();
        System.out.println("Looking for employee name starts with B: "
                + employee_B.orElse("no such employee exists"));

        // v. Create a String that contains the name of every single
        // employee in the list concatenated together.
        String names = employees.stream().map(Employee::getName).reduce("All employee names: { ", (a, b) -> a+ b + ", ");
        System.out.println(names + "};");
    }
}
