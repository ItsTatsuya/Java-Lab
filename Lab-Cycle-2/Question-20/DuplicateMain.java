/*Write a program to remove duplicate elements from a string array using tree set collection */

import java.util.*;

class DuplicateMain
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.next();
        }
        System.out.println("Original array: " + Arrays.toString(arr));
        Set<String> set = new TreeSet<String>();
        for (String s : arr)
        {
            set.add(s);
        }
        System.out.println("Array after removing duplicates: " + set);
    }
}
