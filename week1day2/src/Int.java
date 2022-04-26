import java.util.Objects;
/*
* Author: Ping Danddank
8. Create your own int wrapper class.
Hint: What are the fields, constructor and which method should your wrapper class
include(intValue(), shortValue(), equals() etc. ).
 */
public class Int {
    private int integer;
    public Int(int i){
        this.integer = i;
    }
    //@return integer value of this class
    public int intValue(){
        return integer;
    }
    //@return short value that convert from integer available of this class
    public short shortValue(){
        return (short) integer;
    }
    // getter method of integer.
    public int getInteger() {
        return integer;
    }
    // setter method of integer.
    public void setInteger(int integer) {
        this.integer = integer;
    }
    // add another Int object value to this object value
    public void addTo(Int other){
        this.setInteger(other.getInteger() + this.getInteger());
    }
    // subtract another Int object value to this object value
    public void subTo(Int other){
        int result = this.getInteger() - other.getInteger();
        this.setInteger(result);
    }
    // Multiple another Int object value to this object value
    public void mulTo(Int other){
        int result = this.getInteger() * other.getInteger();
        this.setInteger(result);
    }
    // Divide another Int object value to this object value
    public void divBy(Int other){
        int result = 0;
        try {
            result = this.getInteger() / other.getInteger();
            this.setInteger(result);
            return;
        } catch (ArithmeticException ae){
            System.out.println(ae);
        }
    }
    // Compare to another Int object value to this object value
    // return -1 if smeller, 0 if equal, and 1 if bigger.
    public int compareTo(Int other){
        return (this.integer < other.getInteger()) ? -1
                :((this.integer == other.getInteger())? 0:1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int anInt = (Int) o;
        return integer == anInt.integer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(integer);
    }

    @Override
    public String toString() {
        return "Int{" +
                "integer=" + integer +
                '}';
    }
}
