public class Sample {

    public static int staticVariable = 100;

    public int instanceVariable;

    public Sample(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    public int getInstanceVariable(){
        return instanceVariable;
    }

    public static int getStaticVariable(){
        return staticVariable;
    }
}
