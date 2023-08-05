import java.util.Scanner;

class ExceptionHandling {
    String str;

    public ExceptionHandling() {
        str = "";
    }

    public ExceptionHandling(String str) {
        this.str = str;
    }

    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Input: ");
        str = sc.next();
        sc.close();
    }

    public void handlenumberformatexception() {
        try {
            int num = Integer.parseInt(str);
            System.out.println("The number is: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }

    public void handlenullpointexception() {
        try {
            if (str == null) {
                throw new NullPointerException();
            } else {
                System.out.println("The string is: " + str);
            }
        } catch (NullPointerException e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }

}

public class ExceptionHandlingMain {
    public static void main(String[] args) {
        ExceptionHandling obj = new ExceptionHandling();
        obj.getDetails();
        obj.handlenumberformatexception();
        obj.handlenullpointexception();
    }
}