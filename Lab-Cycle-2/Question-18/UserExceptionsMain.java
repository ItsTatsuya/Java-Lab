import java.util.Scanner;

class InvalidAgeException extends Exception
{
    InvalidAgeException(String s)
    {
        super(s);
    }
}

class UserExceptionsMain
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        try
        {
            if(age < 18)
                throw new InvalidAgeException("Invalid age");
            else
                System.out.println("Valid age");
        }
        catch(InvalidAgeException e)
        {
            System.out.println(e);
        }
    }
}
