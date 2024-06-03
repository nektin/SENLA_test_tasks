package Task5;

public class Item {
    private final String name;
    private final int cost;
    private final int weight;

    public Item(int weight, int cost, String name) {
        this.weight = weight;
        this.cost = cost;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public static void printInfo(Item item) {
        System.out.printf("%s - весом %s и стоимостью %s\n", item.getName(), item.getWeight(), item.getCost());
    }


}
