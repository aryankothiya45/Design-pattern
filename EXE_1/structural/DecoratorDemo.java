
interface Coffee {
    String getDescription();
    double getCost();
}

class PlainCoffee implements Coffee {
    public String getDescription() { return "Plain Coffee"; }
    public double getCost() { return 20.0; }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class Milk extends CoffeeDecorator {
    public Milk(Coffee c) { super(c); }
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double getCost() { return coffee.getCost() + 5.0; }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee c) { super(c); }
    public String getDescription() { return coffee.getDescription() + ", Sugar"; }
    public double getCost() { return coffee.getCost() + 2.0; }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee c = new PlainCoffee();
        System.out.println(c.getDescription() + " -> Rs." + c.getCost());

        c = new Milk(c);
        c = new Sugar(c);
        System.out.println(c.getDescription() + " -> Rs." + c.getCost());
    }
}
