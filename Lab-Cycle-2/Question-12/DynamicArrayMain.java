import java.util.Scanner;

class DynamicArray {
    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static int[] addElement(int[] arr, int element, int position) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < position - 1; i++) {
            newArr[i] = arr[i];
        }
        newArr[position - 1] = element;
        for (int i = position; i < newArr.length; i++) {
            newArr[i] = arr[i - 1];
        }
        return newArr;
    }

    public static int[] removeElement(int[] arr, int element) {
        int[] newArr = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element) {
                newArr[index++] = arr[i];
            }
        }
        return newArr;
    }

    public static void searchElement(int[] arr, int element) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at position " + (index + 1));
        }
    }
}

public class DynamicArrayMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be added:");
        int element = sc.nextInt();
        System.out.println("Enter the position to be added:");
        int position = sc.nextInt();
        arr = DynamicArray.addElement(arr, element, position);
        System.out.println("Enter the element to be removed:");
        element = sc.nextInt();
        arr = DynamicArray.removeElement(arr, element);
        System.out.println("Enter the element to be searched:");
        element = sc.nextInt();
        DynamicArray.searchElement(arr, element);
        DynamicArray.printArray(arr);
        sc.close();
    }
}
