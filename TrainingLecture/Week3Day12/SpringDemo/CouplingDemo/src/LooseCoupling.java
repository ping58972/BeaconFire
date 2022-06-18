public class LooseCoupling {

    public static void main(String[] args) {

        CarB car = new CarB();
        PlaneB planeB = new PlaneB();


        TravellerB traveller = new TravellerB(car); // constructor

        traveller.setV(car);  // setter


        traveller.setV(planeB);
        traveller.travel();
    }
}

class TravellerB{
    Vehicle v;

    public TravellerB(Vehicle v) {
        this.v = v;
    }

    public void setV(Vehicle v) {
        this.v = v;
    } // injecting dependency

    public void travel(){
        v.move();
    }
}

interface Vehicle{
    void move();
}

class CarB implements Vehicle{

    @Override
    public void move() {
        System.out.println("Move by car.");
    }
}

class PlaneB implements Vehicle{

    @Override
    public void move() {
        System.out.println("Move by plane.");
    }
}

class BoatB implements Vehicle{

    @Override
    public void move() {
        System.out.println("Move by boat.");
    }
}

class Rocket implements Vehicle{
    @Override
    public void move() {
        System.out.println("Fly");
    }
}