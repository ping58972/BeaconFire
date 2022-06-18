class Player {
    private String name;
    private int level;
    private Inventory inventory; // aggregate/composite field

    public Player() {}

    public Player(String name, int level, Inventory inventory) {
        this.name = name;
        this.level = level;
        this.inventory = inventory;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", inventory=" + inventory +
                '}';
    }
}

class Inventory {
    private int capacity;
    private String type;

    public Inventory() {}

    public Inventory(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
    }

    // getters
    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    // setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}

class PlayerMain {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.setType("backpack");
        inventory.setCapacity(20);

        Player player = new Player("bob", 10, inventory);
        System.out.println(player.getInventory().getType());
        System.out.println(player.getInventory().getCapacity());

        System.out.println(player);
    }
}