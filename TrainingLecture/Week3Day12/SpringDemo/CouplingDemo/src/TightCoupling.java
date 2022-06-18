public class TightCoupling {

    public static void main(String[] args) {
        TravellerA t = new TravellerA();
        t.travel();
    }

}

class TravellerA{
    CarA c = new CarA();
    PlaneA a = new PlaneA();


    public void travel(){
        a.move();
    }
}

class CarA{
    public void move(){
        System.out.println("Move by car.");
    }
}

class PlaneA{
    public void move(){
        System.out.println("Move by plane");
    }
}

class BoatA{
    public void move(){
        System.out.println("Move by boat");
    }
}
