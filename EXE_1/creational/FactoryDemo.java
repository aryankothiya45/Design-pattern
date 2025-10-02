
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Drawing a Circle."); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing a Rectangle."); }
}

class Triangle implements Shape {
    public void draw() { System.out.println("Drawing a Triangle."); }
}

class ShapeFactory {
    public Shape getShape(String type) {
        switch(type.toLowerCase()) {
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            case "triangle": return new Triangle();
            default: throw new IllegalArgumentException("Unknown Shape");
        }
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.getShape("circle");
        s1.draw();
        Shape s2 = factory.getShape("rectangle");
        s2.draw();
    }
}
