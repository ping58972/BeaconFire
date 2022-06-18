
import java.sql.SQLOutput;
import java.util.List;
import java.util.SortedMap;

public class Driver {

    public static void main(String[] args) {
        int simpleVariable = 1;
        Sample objectVariable = new Sample(1);
        Sample objectVariable1 = new Sample(2);

        // Conversion
//        int integerVal = 1;
//        double doubleIntegerVal = integerVal;
//        System.out.println(doubleIntegerVal);

        // Casting
        double doubleVal = 1.1;
        int integerDoubleVal = (int) doubleVal;
//        System.out.println(integerDoubleVal);

        int k = (int) 2147483648.0;
//        System.out.println(k);

        char c = (char) 74;
//        System.out.println(c);

        // Question???
//        System.out.println( (int)5.0/2.0 );
//
//        System.out.println( (int)(5.0/2.0) );


        // Regarding on when will the String be pooled into the String Pool

        // When we initialize a String using String literal.
        // In the example below, "1" is stored in the String pool,
        // If we compare the memory reference of these two variables,
        // the result will be true

        String str1 = "1";
        String str2 = "1";
        String str3 = new String("1");
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str1.equals(str3));


//        System.out.println(Sample.staticVariable);
        Sample sample = new Sample(1);
        Sample sample1 = new Sample(2);
        System.out.println(sample.instanceVariable);
        System.out.println(sample1.instanceVariable);

        sample.instanceVariable = 3;
        System.out.println(sample.instanceVariable);
        System.out.println(sample1.instanceVariable);

        System.out.println(sample.staticVariable);
        System.out.println(sample1.staticVariable);

        sample.staticVariable = 101;

        System.out.println(sample.staticVariable);
        System.out.println(sample1.staticVariable);

        System.out.println(Sample.getStaticVariable());
        System.out.println(sample1.getInstanceVariable());


    }

}
