interface Animal {
    public void speak();
    public default void defaultSpeak() {
        System.out.println("default sound");
    }
}

interface Superpower {
    public void superpower();
}

class Bunny implements Animal {
    public void speak() {
        System.out.println("squeak");
    }

    @Override
    public void defaultSpeak() {
        System.out.println("override default speak");
    }
}

class SuperBunny implements Animal, Superpower {
    public void speak() {
        System.out.println("squeak");
    }
    public void superpower() {
        System.out.println("levitation");
    }
}

class Tiger implements Animal {
    public void speak() {
        System.out.println("roar");
    }
}

class AnimalMain {
    public static void main(String[] args) {
        Bunny bunny = new Bunny();
        bunny.speak();

        Tiger tiger = new Tiger();
        tiger.speak();

        Animal bunny2 = new Bunny();
        bunny2.defaultSpeak();
        Bunny bunny3 = new Bunny();
        bunny3.defaultSpeak();

        SuperBunny superBunny = new SuperBunny();
        superBunny.speak();
        superBunny.superpower();
    }
}
