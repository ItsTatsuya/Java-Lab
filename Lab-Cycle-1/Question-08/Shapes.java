import java.util.Scanner;

interface ThreeDShapes {
    void printVolume();
    void printArea();
}

class Cylinder implements ThreeDShapes {
    private double radius;
    private double height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public void printVolume() {
        System.out.println("Volume of Cylinder: " + (Math.PI * radius * radius * height));
    }

    public void printArea() {
        System.out.println("Area of Cylinder: " + (2 * Math.PI * radius * (radius + height)));
    }
}

class Sphere implements ThreeDShapes {
    private double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    public void printVolume() {
        System.out.println("Volume of Sphere: " + ((4 / 3) * Math.PI * radius * radius * radius));
    }

    public void printArea() {
        System.out.println("Area of Sphere: " + (4 * Math.PI * radius * radius));
    }
}

public class Shapes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the Cylinder: ");
        double radius = sc.nextDouble();
        System.out.print("Enter the height of the Cylinder: ");
        double height = sc.nextDouble();
        System.out.print("Enter the radius of the Sphere: ");
        double radius1 = sc.nextDouble();
        Cylinder c = new Cylinder(radius, height);
        Sphere s = new Sphere(radius1);
        c.printVolume();
        c.printArea();
        s.printVolume();
        s.printArea();
        sc.close();
    }
}
