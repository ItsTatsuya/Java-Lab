class Complex {
    private int real;
    private int imaginary;

    public void putdetails(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void printdetails() {
        System.out.println("Complex Number: " + real + " + " + imaginary + "i");
    }

    public static void main(String[] args) {
        Complex c1 = new Complex();
        c1.putdetails(10, 20);
        c1.printdetails();

        Complex c2 = new Complex();
        c2.putdetails(30, 40);
        c2.printdetails();

        if (c1.real > c2.real) {
            c1.printdetails();
        } else {
            c2.printdetails();
        }
    }
}

class ComplexOperations{
public static Complex add(Complex c1, Complex c2) {
        Complex result = new Complex();
        result.putdetails(c1.real + c2.real, c1.imaginary + c2.imaginary);
        return result;
    }

    public static Complex multiply(Complex c1, Complex c2) {
        Complex result = new Complex();
        double realPart = c1.real * c2.real - c1.imaginary * c2.imaginary;
        double imaginaryPart = c1.real * c2.imaginary + c1.imaginary * c2.real;
        result.initialize(realPart, imaginaryPart);
        return result;
    }

    public static double getModulus(Complex c) {
        return Math.sqrt(c.real * c.real + c.imaginary * c.imaginary);
    }
}