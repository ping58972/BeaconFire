// demonstration of the keyword 'this'

class ThisDemo {
    private int number, level;

    public ThisDemo() {
        // calls the constructor with single parameter
        this(1);
    }

    public ThisDemo(int number){
        // refers to the current class instance variable
        this.number = number;
//        System.out.println("this reference: " + this);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void displayNumber() {
        // passes the current object as an argument to a method
        timesTwo(this);
    }

    private void timesTwo(ThisDemo demo) {
        System.out.println("displayNumber: " + demo.number);
    }

    public static void main(String[] args) {
        ThisDemo demo1 = new ThisDemo(42);
        System.out.println("demo1 getNumber: " + demo1.getNumber());
//        System.out.println("object reference: " + demo1);

        ThisDemo demo2 = new ThisDemo();
        System.out.println("demo2 getNumber: " + demo2.getNumber());
        demo2.displayNumber();

    }
}