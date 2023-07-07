public class Student {
    private String name;
    private int rollNo;
    private int[] subjectMarks;
    private int total;

    public void putdetails(String name, int rollNo, int[] subjectMarks) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjectMarks = subjectMarks;
        this.total = 0;
        calculateTotal();
    }

    public void calculateTotal() {
        for (int i = 0; i < subjectMarks.length; i++) {
            total += subjectMarks[i];
        }
    }

    public int getTotal() {
        return total;
    }

    public void printdetails() {
        System.out.println("\nStudent Details: ");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Subject Marks: ");
        for (int i = 0; i < subjectMarks.length; i++) {
            System.out.println(subjectMarks[i]);
        }
        System.out.println("Total: " + total);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        int[] marks = { 10, 20, 30, 40, 50 };
        s1.putdetails("John", 1, marks);
        s1.printdetails();

        Student s2 = new Student();
        int[] marks2 = { 60, 50, 40, 30, 20 };
        s2.putdetails("Doe", 2, marks2);
        s2.printdetails();

        if (s1.getTotal() > s2.getTotal()) {
            s1.printdetails();
        } else {
            s2.printdetails();
        }
    }
}