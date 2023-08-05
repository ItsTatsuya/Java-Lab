import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    DateOfBirth dob = new DateOfBirth();
    DateOfJoining doj = new DateOfJoining();
    double salary;

    public Employee(){
        empId = 0;
        empName = "";
        salary = 0.0;
    }
    public Employee(int empId, String empName,double salary){
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
    static class DateOfBirth {
        int day;
        int month;
        int year;
        public DateOfBirth(){
            day = 0;
            month = 0;
            year = 0;
        }
        public DateOfBirth(int day, int month, int year){
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    static class DateOfJoining {
        int day;
        int month;
        int year;
        public DateOfJoining(){
            day = 0;
            month = 0;
            year = 0;
        }
        public DateOfJoining(int day, int month, int year){
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public void getDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee id: ");
        empId = sc.nextInt();
        System.out.print("Enter the employee name: ");
        empName = sc.next();
        System.out.println("Enter the date of birth: ");
        System.out.print("Enter the day: ");
        dob.day = sc.nextInt();
        System.out.print("Enter the month: ");
        dob.month = sc.nextInt();
        System.out.print("Enter the year: ");
        dob.year = sc.nextInt();
        System.out.println("Enter the date of joining: ");
        System.out.print("Enter the day: ");
        doj.day = sc.nextInt();
        System.out.print("Enter the month: ");
        doj.month = sc.nextInt();
        System.out.print("Enter the year: ");
        doj.year = sc.nextInt();
        System.out.print("Enter the salary: ");
        salary = sc.nextDouble();
        sc.close();
    }
    public void printDetails(){
        System.out.println("Employee id: " + empId);
        System.out.println("Employee name: " + empName);
        System.out.println("Date of birth: " + dob.day + "/" + dob.month + "/" + dob.year);
        System.out.println("Date of joining: " + doj.day + "/" + doj.month + "/" + doj.year);
        System.out.println("Salary: " + salary);
    }
}

class EmployeeList{
    Employee emp[];
    int n;

    public EmployeeList(){
        n = 0;
    }

    public EmployeeList(int n){
        this.n = n;
        emp = new Employee[n];
    }

    public void getlist(){
        for(int i=0;i<n;i++){
            emp[i] = new Employee();
            System.out.println("Enter the details of employee " + (i+1)+" :");
            emp[i].getDetails();
        }
    }
    public void printlist(){
        for(int i=0;i<n;i++){
            System.out.println("Details of employee " + (i+1)+" :");
            emp[i].printDetails();
        }
    }

    public void sort(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(emp[j].salary < emp[j+1].salary){
                    Employee temp = emp[j];
                    emp[j] = emp[j+1];
                    emp[j+1] = temp;
                }
            }
        }
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        EmployeeList empList = new EmployeeList(n);
        empList.getlist();
        empList.sort();
        empList.printlist();
        sc.close();
    }
}