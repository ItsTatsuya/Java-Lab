/*Write a program to illustrate finalize() method. */

class FinalizeMain
{
    public static void main(String args[])
    {
        FinalizeDemo obj = new FinalizeDemo();
        obj = null;
        System.gc();
        System.out.println("End of main");
    }
}

class FinalizeDemo
{
    public void finalize()
    {
        System.out.println("Finalize method called");
    }
}