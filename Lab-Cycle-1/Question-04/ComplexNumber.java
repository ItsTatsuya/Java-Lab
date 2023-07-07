import java.util.Scanner;

class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        real = 0;
        imaginary = 0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}

class ComplexOperations {
    public static Complex add(Complex c1, Complex c2) {
        Complex c = new Complex();
        c.setReal(c1.getReal() + c2.getReal());
        c.setImaginary(c1.getImaginary() + c2.getImaginary());
        return c;
    }

    public static Complex multiply(Complex c1, Complex c2) {
        Complex c = new Complex();
        c.setReal(c1.getReal() * c2.getReal() - c1.getImaginary() * c2.getImaginary());
        c.setImaginary(c1.getReal() * c2.getImaginary() + c1.getImaginary() * c2.getReal());
        return c;
    }

    public static double modulus(Complex c) {
        return Math.sqrt(c.getReal() * c.getReal() + c.getImaginary() * c.getImaginary());
    }
}

public class ComplexNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        System.out.println("Enter the real and imaginary parts of the first complex number:");
        c1.setReal(sc.nextDouble());
        c1.setImaginary(sc.nextDouble());
        System.out.println("Enter the real and imaginary parts of the second complex number:");
        c2.setReal(sc.nextDouble());
        c2.setImaginary(sc.nextDouble());
        System.out.println("The first complex number is: " + c1.getReal() + " + " + c1.getImaginary() + "i");
        System.out.println("The second complex number is: " + c2.getReal() + " + " + c2.getImaginary() + "i");
        System.out.println("The sum of the two complex numbers is: " + ComplexOperations.add(c1, c2).getReal() + " + "
                + ComplexOperations.add(c1, c2).getImaginary() + "i");
        System.out.println("The product of the two complex numbers is: "
                + ComplexOperations.multiply(c1, c2).getReal() + " + " + ComplexOperations.multiply(c1, c2).getImaginary()
                + "i");
        System.out.println("The modulus of the first complex number is: " + ComplexOperations.modulus(c1));
        System.out.println("The modulus of the second complex number is: " + ComplexOperations.modulus(c2));
        sc.close();
    }
}
