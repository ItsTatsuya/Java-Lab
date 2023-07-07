/*Write a program to create a class called Rectangle with members length, breadth and area. 
Provide functions to find area and get back the area. Create a new class Box by extending 
Rectangle class add two new members, height and volume and also new functions to 
calculate and get back the volume.
 */

import java.util.Scanner;

class Rectangle {
    int length, breadth, area;

    Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    void area() {
        area = length * breadth;
    }

    int getArea() {
        return area;
    }
}

class Box extends Rectangle {
    int height, volume;

    Box(int l, int b, int h) {
        super(l, b);
        height = h;
    }

    void volume() {
        volume = length * breadth * height;
    }

    int getVolume() {
        return volume;
    }
}

public class RectangleBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length and breadth of the rectangle: ");
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        Rectangle rectangle = new Rectangle(length, breadth);
        rectangle.area();
        System.out.println("Area of the rectangle: " + rectangle.getArea());
        System.out.println("Enter the length, breadth and height of the box: ");
        length = sc.nextInt();
        breadth = sc.nextInt();
        int height = sc.nextInt();
        Box box = new Box(length, breadth, height);
        box.area();
        box.volume();
        System.out.println("Area of the box: " + box.getArea());
        System.out.println("Volume of the box: " + box.getVolume());
        sc.close();
    }
}