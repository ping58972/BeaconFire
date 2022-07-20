import sun.security.rsa.RSAUtil;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountString {
    public static void main(String[] args) {
        String str1 = "Abcbcbcvbe bibbc";
        String str2 = "bc";
        Pattern pattern = Pattern.compile(str2);
        Matcher matcher = pattern.matcher(str1);
        int count =0;
        while(matcher.find()) count++;
        System.out.println(count);
        StringBuilder stringBuilder = new StringBuilder(str1);
        System.out.println(stringBuilder.reverse().toString());
        System.out.println((int)Character.MAX_VALUE);
        //
        List<Employee> employeeList = Arrays.asList(new Employee("Ping", 22), new Employee("Pong", 34));
        employeeList.stream().filter(e->e.age>=30).map(e->e.name).forEach(System.out::println);
    }

}
class Employee{
    String name;
    int age;
    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

}
