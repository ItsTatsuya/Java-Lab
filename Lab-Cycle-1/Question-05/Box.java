import java.util.Scanner;

public class Box {
    int length, breadth, height, area, volume;

    Box(int side) {
        length = breadth = height = side;
    }

    Box(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        height = 1;
    }

    Box(int length, int breadth, int height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    void calculateArea() {
        area = 2 * (length * breadth + breadth * height + height * length);
    }

    void calculateVolume() {
        volume = length * breadth * height;
    }

    void display() {
        System.out.println("Area: " + area);
        System.out.println("Volume: " + volume);
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side of the cube: ");
        int side = sc.nextInt();
        Box cube = new Box(side);
        cube.calculateArea();
        cube.calculateVolume();
        System.out.println("Cube: ");
        cube.display();
        System.out.println("Enter the length and breadth of the square prism: ");
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        Box squarePrism = new Box(length, breadth);
        squarePrism.calculateArea();
        squarePrism.calculateVolume();
        System.out.println("Square Prism: ");
        squarePrism.display();
        System.out.println("Enter the length, breadth and height of the rectangular prism: ");
        length = sc.nextInt();
        breadth = sc.nextInt();
        int height = sc.nextInt();
        Box rectangularPrism = new Box(length, breadth, height);
        rectangularPrism.calculateArea();
        rectangularPrism.calculateVolume();
        System.out.println("Rectangular Prism: ");
        rectangularPrism.display();
        sc.close();
    }
}