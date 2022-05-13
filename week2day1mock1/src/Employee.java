import java.util.*;
import java.util.stream.*;

class Employee{
    private String firstName;
    private String lastName;
    private int age;

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Bs", "ksjd", 244));
        List<Employee> empList = employeeList.stream().filter(e->e.getFirstName().startsWith("B")).filter(e->e.getAge()>40).collect(Collectors.toList());
        System.out.println(empList);
    }
    public Employee(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getAge(){
        return this.age;
    }
}