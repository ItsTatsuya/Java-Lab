import java.util.Scanner;

interface Salary {
    double salaryCalculation(double basicPay);
}

class Employee {
    String name;
    int code;
    double basicPay;

    Employee(String name, int code, double basicPay) {
        this.name = name;
        this.code = code;
        this.basicPay = basicPay;
    }

    void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
        System.out.println("Basic Pay: " + basicPay);
    }
}       

public class SalarySlip extends Employee implements Salary {
    double netSalary;

    SalarySlip(String name, int code, double basicPay) {
        super(name, code, basicPay);
    }

    public double salaryCalculation(double basicPay) {
        double da = 0.1 * basicPay;
        double hra = 0.2 * basicPay;
        double pf = 0.05 * basicPay;
        netSalary = basicPay + da + hra - pf;
        return netSalary;
    }

    void printSalarySlip() {
        System.out.println("Net Salary: " + netSalary);
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the employee: ");
        String name = sc.nextLine();
        System.out.println("Enter the code of the employee: ");
        int code = sc.nextInt();
        System.out.println("Enter the basic pay of the employee: ");
        double basicPay = sc.nextDouble();
        SalarySlip s = new SalarySlip(name, code, basicPay);
        s.printInfo();
        s.salaryCalculation(basicPay);
        s.printSalarySlip();
        sc.close();
    }
}