// Generated from sorting-cases.json by mj-java.mjs. Do not edit by hand.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

public class SortingCheck {
    static class Player {
        private String name;
        private int score;
        public Player(String startName, int startScore) { name = startName; score = startScore; }
        public String getName() { return name; }
        public int getScore() { return score; }
        public void addScore(int amount) { score += amount; }
    }

    static class C0 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            selectionSort(data);
        }
    }

    static class C1 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            selectionSort(data);
        }
    }

    static class C2 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            insertionSort(data);
        }
    }

    static class C3 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            insertionSort(data);
        }
    }

    static class C4 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5};
            insertionSort(data);
        }
    }

    static class C5 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5};
            insertionSort(data);
        }
    }

    static class C6 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {5, 4, 3, 2, 1};
            insertionSort(data);
        }
    }

    static class C7 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {5, 4, 3, 2, 1};
            insertionSort(data);
        }
    }

    static class C8 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            System.out.println(binarySearch(data, 23));
        }
    }

    static class C9 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            int r = binarySearch(data, 23);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C10 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            System.out.println(binarySearch(data, 10));
        }
    }

    static class C11 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            int r = binarySearch(data, 10);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C12 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            System.out.println(binarySearch(data, 1));
        }
    }

    static class C13 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            int r = binarySearch(data, 1);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C14 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {7, 3, 9, 4, 6, 2};
            System.out.println(linearSearch(data, 5));
        }
    }

    static class C15 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {7, 3, 9, 4, 6, 2};
            int r = linearSearch(data, 5);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C16 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {4, 9, 2, 7, 1};
            selectionSort(data);
        }
    }

    static class C17 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {4, 9, 2, 7, 1};
            selectionSort(data);
        }
    }

    static class C18 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {4, 9, 2, 7, 1};
            insertionSort(data);
        }
    }

    static class C19 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {4, 9, 2, 7, 1};
            insertionSort(data);
        }
    }

    static class C20 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {3, 6, 9, 12, 15, 18, 21};
            System.out.println(binarySearch(data, 21));
        }
    }

    static class C21 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {3, 6, 9, 12, 15, 18, 21};
            int r = binarySearch(data, 21);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C22 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {3, 1, 2};
            insertionSort(data);
        }
    }

    static class C23 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {3, 1, 2};
            insertionSort(data);
        }
    }

    static class C24 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {6, 1, 5, 2, 4, 3, 7};
            selectionSort(data);
        }
    }

    static class C25 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {6, 1, 5, 2, 4, 3, 7};
            selectionSort(data);
        }
    }

    static class C26 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {8, 6, 4, 2};
            System.out.println(linearSearch(data, 4));
        }
    }

    static class C27 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {8, 6, 4, 2};
            int r = linearSearch(data, 4);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C28 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {3, 6, 9, 12, 15, 18, 21};
            System.out.println(binarySearch(data, 4));
        }
    }

    static class C29 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {3, 6, 9, 12, 15, 18, 21};
            int r = binarySearch(data, 4);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C30 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {2, 4, 6, 8, 10, 12};
            insertionSort(data);
        }
    }

    static class C31 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {2, 4, 6, 8, 10, 12};
            insertionSort(data);
        }
    }

    static class C32 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            System.out.println(linearSearch(data, 8));
        }
    }

    static class C33 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            int r = linearSearch(data, 8);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C34 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            System.out.println(binarySearch(data, 8));
        }
    }

    static class C35 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {5, 3, 8, 1, 9};
            int r = binarySearch(data, 8);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C36 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            System.out.println(linearSearch(data, 6));
        }
    }

    static class C37 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            int r = linearSearch(data, 6);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C38 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            System.out.println(binarySearch(data, 6));
        }
    }

    static class C39 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            int r = binarySearch(data, 6);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C40 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            selectionSort(data);
        }
    }

    static class C41 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            selectionSort(data);
        }
    }

    static class C42 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            insertionSort(data);
        }
    }

    static class C43 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {1, 2, 3, 4, 5, 6};
            insertionSort(data);
        }
    }

    static class C44 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            System.out.println(linearSearch(data, 1));
        }
    }

    static class C45 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            int r = linearSearch(data, 1);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C46 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            System.out.println(binarySearch(data, 1));
        }
    }

    static class C47 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            int r = binarySearch(data, 1);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C48 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            selectionSort(data);
        }
    }

    static class C49 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            selectionSort(data);
        }
    }

    static class C50 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            insertionSort(data);
        }
    }

    static class C51 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {6, 5, 4, 3, 2, 1};
            insertionSort(data);
        }
    }

    static class C52 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            System.out.println(linearSearch(data, 2));
        }
    }

    static class C53 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            int r = linearSearch(data, 2);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C54 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            System.out.println(binarySearch(data, 2));
        }
    }

    static class C55 {
        static int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.print(mid + " ");
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            int r = binarySearch(data, 2);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C56 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            selectionSort(data);
        }
    }

    static class C57 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            selectionSort(data);
        }
    }

    static class C58 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            insertionSort(data);
        }
    }

    static class C59 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {4, 2, 4, 1, 2};
            insertionSort(data);
        }
    }

    static class C60 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            System.out.println(linearSearch(data, 23));
        }
    }

    static class C61 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            int r = linearSearch(data, 23);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C62 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            selectionSort(data);
        }
    }

    static class C63 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            selectionSort(data);
        }
    }

    static class C64 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            insertionSort(data);
        }
    }

    static class C65 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            insertionSort(data);
        }
    }

    static class C66 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            System.out.println(linearSearch(data, 10));
        }
    }

    static class C67 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
            int r = linearSearch(data, 10);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C68 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            System.out.println(linearSearch(data, 1));
        }
    }

    static class C69 {
        static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + " ");
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            int r = linearSearch(data, 1);
            System.out.println();
            System.out.println(r);
        }
    }

    static class C70 {
        static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            selectionSort(data);
        }
    }

    static class C71 {
        static void selectionSort(int[] arr) {
            int comparisons = 0;
            int swaps = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    comparisons++;
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            selectionSort(data);
        }
    }

    static class C72 {
        static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            insertionSort(data);
        }
    }

    static class C73 {
        static boolean greater(int x, int y, int[] count) {
            count[0]++;
            return x > y;
        }
        
        static void insertionSort(int[] arr) {
            int[] count = new int[1];
            int shifts = 0;
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && greater(arr[j], key, count)) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                }
                arr[j + 1] = key;
                for (int x : arr) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);
        }
        static void run() {
            int[] data = {9, 2, 8, 1, 5};
            insertionSort(data);
        }
    }

    static int passed = 0, failed = 0;
    static String capture(Runnable r) {
        PrintStream old = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf, true));
        String tail = "";
        try { r.run(); } catch (RuntimeException e) { tail = "|throws:" + e.getClass().getSimpleName(); } finally { System.setOut(old); }
        return buf.toString().replace(System.lineSeparator(), "\n") + tail;
    }
    static void check(String code, String want, Runnable r) {
        String got = capture(r);
        if (got.equals(want)) passed++;
        else { failed++; System.out.println("FAIL " + show(code) + "\n  Java  " + show(got) + "\n  table " + show(want)); }
    }
    static void compileCheck(JavaCompiler javac, String code, String source, boolean shouldCompile) throws Exception {
        JavaFileObject src = new SimpleJavaFileObject(URI.create("string:///Snip.java"), JavaFileObject.Kind.SOURCE) {
            @Override public CharSequence getCharContent(boolean ignore) { return source; }
        };
        String out = Files.createTempDirectory("snip").toString();
        boolean ok = javac.getTask(null, null, new DiagnosticCollector<JavaFileObject>(), List.of("-d", out), null, List.of(src)).call();
        if (ok == shouldCompile) passed++;
        else { failed++; System.out.println("FAIL " + show(code) + ": Java " + (ok ? "compiles" : "rejects") + " it, the table says it " + (shouldCompile ? "is valid Java" : "does not compile")); }
    }
    static String show(String s) { return "\"" + s.replace("\n", "\\n") + "\""; }

    public static void main(String[] args) throws Exception {
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {5, 3, 8, 1, 9};\nselectionSort(data);", "", C0::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {5, 3, 8, 1, 9};\nselectionSort(data);", "1 3 8 5 9 \n1 3 8 5 9 \n1 3 5 8 9 \n1 3 5 8 9 \ncomparisons 10 swaps 4 shifts 0\n", C1::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {5, 3, 8, 1, 9};\ninsertionSort(data);", "", C2::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {5, 3, 8, 1, 9};\ninsertionSort(data);", "3 5 8 1 9 \n3 5 8 1 9 \n1 3 5 8 9 \n1 3 5 8 9 \ncomparisons 6 swaps 0 shifts 4\n", C3::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {1, 2, 3, 4, 5};\ninsertionSort(data);", "", C4::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {1, 2, 3, 4, 5};\ninsertionSort(data);", "1 2 3 4 5 \n1 2 3 4 5 \n1 2 3 4 5 \n1 2 3 4 5 \ncomparisons 4 swaps 0 shifts 0\n", C5::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {5, 4, 3, 2, 1};\ninsertionSort(data);", "", C6::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {5, 4, 3, 2, 1};\ninsertionSort(data);", "4 5 3 2 1 \n3 4 5 2 1 \n2 3 4 5 1 \n1 2 3 4 5 \ncomparisons 10 swaps 0 shifts 10\n", C7::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nSystem.out.println(binarySearch(data, 23));", "5\n", C8::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nint r = binarySearch(data, 23);\nSystem.out.println();\nSystem.out.println(r);", "4 7 5 \n5\n", C9::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nSystem.out.println(binarySearch(data, 10));", "-1\n", C10::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nint r = binarySearch(data, 10);\nSystem.out.println();\nSystem.out.println(r);", "4 1 2 3 \n-1\n", C11::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {9, 2, 8, 1, 5};\nSystem.out.println(binarySearch(data, 1));", "-1\n", C12::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {9, 2, 8, 1, 5};\nint r = binarySearch(data, 1);\nSystem.out.println();\nSystem.out.println(r);", "2 0 \n-1\n", C13::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {7, 3, 9, 4, 6, 2};\nSystem.out.println(linearSearch(data, 5));", "-1\n", C14::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {7, 3, 9, 4, 6, 2};\nint r = linearSearch(data, 5);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 3 4 5 \n-1\n", C15::run);
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {4, 9, 2, 7, 1};\nselectionSort(data);", "", C16::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {4, 9, 2, 7, 1};\nselectionSort(data);", "1 9 2 7 4 \n1 2 9 7 4 \n1 2 4 7 9 \n1 2 4 7 9 \ncomparisons 10 swaps 4 shifts 0\n", C17::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {4, 9, 2, 7, 1};\ninsertionSort(data);", "", C18::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {4, 9, 2, 7, 1};\ninsertionSort(data);", "4 9 2 7 1 \n2 4 9 7 1 \n2 4 7 9 1 \n1 2 4 7 9 \ncomparisons 9 swaps 0 shifts 7\n", C19::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {3, 6, 9, 12, 15, 18, 21};\nSystem.out.println(binarySearch(data, 21));", "6\n", C20::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {3, 6, 9, 12, 15, 18, 21};\nint r = binarySearch(data, 21);\nSystem.out.println();\nSystem.out.println(r);", "3 5 6 \n6\n", C21::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {3, 1, 2};\ninsertionSort(data);", "", C22::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {3, 1, 2};\ninsertionSort(data);", "1 3 2 \n1 2 3 \ncomparisons 3 swaps 0 shifts 2\n", C23::run);
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {6, 1, 5, 2, 4, 3, 7};\nselectionSort(data);", "", C24::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {6, 1, 5, 2, 4, 3, 7};\nselectionSort(data);", "1 6 5 2 4 3 7 \n1 2 5 6 4 3 7 \n1 2 3 6 4 5 7 \n1 2 3 4 6 5 7 \n1 2 3 4 5 6 7 \n1 2 3 4 5 6 7 \ncomparisons 21 swaps 6 shifts 0\n", C25::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {8, 6, 4, 2};\nSystem.out.println(linearSearch(data, 4));", "2\n", C26::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {8, 6, 4, 2};\nint r = linearSearch(data, 4);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 \n2\n", C27::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {3, 6, 9, 12, 15, 18, 21};\nSystem.out.println(binarySearch(data, 4));", "-1\n", C28::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {3, 6, 9, 12, 15, 18, 21};\nint r = binarySearch(data, 4);\nSystem.out.println();\nSystem.out.println(r);", "3 1 0 \n-1\n", C29::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {2, 4, 6, 8, 10, 12};\ninsertionSort(data);", "", C30::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {2, 4, 6, 8, 10, 12};\ninsertionSort(data);", "2 4 6 8 10 12 \n2 4 6 8 10 12 \n2 4 6 8 10 12 \n2 4 6 8 10 12 \n2 4 6 8 10 12 \ncomparisons 5 swaps 0 shifts 0\n", C31::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {5, 3, 8, 1, 9};\nSystem.out.println(linearSearch(data, 8));", "2\n", C32::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {5, 3, 8, 1, 9};\nint r = linearSearch(data, 8);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 \n2\n", C33::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {5, 3, 8, 1, 9};\nSystem.out.println(binarySearch(data, 8));", "2\n", C34::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {5, 3, 8, 1, 9};\nint r = binarySearch(data, 8);\nSystem.out.println();\nSystem.out.println(r);", "2 \n2\n", C35::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\nSystem.out.println(linearSearch(data, 6));", "5\n", C36::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\nint r = linearSearch(data, 6);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 3 4 5 \n5\n", C37::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\nSystem.out.println(binarySearch(data, 6));", "5\n", C38::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\nint r = binarySearch(data, 6);\nSystem.out.println();\nSystem.out.println(r);", "2 4 5 \n5\n", C39::run);
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\nselectionSort(data);", "", C40::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\nselectionSort(data);", "1 2 3 4 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \ncomparisons 15 swaps 5 shifts 0\n", C41::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\ninsertionSort(data);", "", C42::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {1, 2, 3, 4, 5, 6};\ninsertionSort(data);", "1 2 3 4 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \ncomparisons 5 swaps 0 shifts 0\n", C43::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\nSystem.out.println(linearSearch(data, 1));", "5\n", C44::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\nint r = linearSearch(data, 1);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 3 4 5 \n5\n", C45::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\nSystem.out.println(binarySearch(data, 1));", "-1\n", C46::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\nint r = binarySearch(data, 1);\nSystem.out.println();\nSystem.out.println(r);", "2 0 \n-1\n", C47::run);
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\nselectionSort(data);", "", C48::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\nselectionSort(data);", "1 5 4 3 2 6 \n1 2 4 3 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \n1 2 3 4 5 6 \ncomparisons 15 swaps 5 shifts 0\n", C49::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\ninsertionSort(data);", "", C50::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {6, 5, 4, 3, 2, 1};\ninsertionSort(data);", "5 6 4 3 2 1 \n4 5 6 3 2 1 \n3 4 5 6 2 1 \n2 3 4 5 6 1 \n1 2 3 4 5 6 \ncomparisons 15 swaps 0 shifts 15\n", C51::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {4, 2, 4, 1, 2};\nSystem.out.println(linearSearch(data, 2));", "1\n", C52::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {4, 2, 4, 1, 2};\nint r = linearSearch(data, 2);\nSystem.out.println();\nSystem.out.println(r);", "0 1 \n1\n", C53::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {4, 2, 4, 1, 2};\nSystem.out.println(binarySearch(data, 2));", "-1\n", C54::run);
        check("static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + \" \");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}\n\nint[] data = {4, 2, 4, 1, 2};\nint r = binarySearch(data, 2);\nSystem.out.println();\nSystem.out.println(r);", "2 0 \n-1\n", C55::run);
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {4, 2, 4, 1, 2};\nselectionSort(data);", "", C56::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {4, 2, 4, 1, 2};\nselectionSort(data);", "1 2 4 4 2 \n1 2 4 4 2 \n1 2 2 4 4 \n1 2 2 4 4 \ncomparisons 10 swaps 4 shifts 0\n", C57::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {4, 2, 4, 1, 2};\ninsertionSort(data);", "", C58::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {4, 2, 4, 1, 2};\ninsertionSort(data);", "2 4 4 1 2 \n2 4 4 1 2 \n1 2 4 4 2 \n1 2 2 4 4 \ncomparisons 8 swaps 0 shifts 6\n", C59::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nSystem.out.println(linearSearch(data, 23));", "5\n", C60::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nint r = linearSearch(data, 23);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 3 4 5 \n5\n", C61::run);
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nselectionSort(data);", "", C62::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nselectionSort(data);", "2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \ncomparisons 45 swaps 9 shifts 0\n", C63::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\ninsertionSort(data);", "", C64::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\ninsertionSort(data);", "2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \n2 5 8 12 16 23 38 56 72 91 \ncomparisons 9 swaps 0 shifts 0\n", C65::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nSystem.out.println(linearSearch(data, 10));", "-1\n", C66::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};\nint r = linearSearch(data, 10);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 3 4 5 6 7 8 9 \n-1\n", C67::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {9, 2, 8, 1, 5};\nSystem.out.println(linearSearch(data, 1));", "3\n", C68::run);
        check("static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + \" \");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}\n\nint[] data = {9, 2, 8, 1, 5};\nint r = linearSearch(data, 1);\nSystem.out.println();\nSystem.out.println(r);", "0 1 2 3 \n3\n", C69::run);
        check("static void selectionSort(int[] arr) {\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n    }\n}\n\nint[] data = {9, 2, 8, 1, 5};\nselectionSort(data);", "", C70::run);
        check("static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + comparisons + \" swaps \" + swaps + \" shifts 0\");\n}\n\nint[] data = {9, 2, 8, 1, 5};\nselectionSort(data);", "1 2 8 9 5 \n1 2 8 9 5 \n1 2 5 9 8 \n1 2 5 8 9 \ncomparisons 10 swaps 4 shifts 0\n", C71::run);
        check("static void insertionSort(int[] arr) {\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && arr[j] > key) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = key;\n    }\n}\n\nint[] data = {9, 2, 8, 1, 5};\ninsertionSort(data);", "", C72::run);
        check("static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n        for (int x : arr) {\n            System.out.print(x + \" \");\n        }\n        System.out.println();\n    }\n    System.out.println(\"comparisons \" + count[0] + \" swaps 0 shifts \" + shifts);\n}\n\nint[] data = {9, 2, 8, 1, 5};\ninsertionSort(data);", "2 9 8 1 5 \n2 8 9 1 5 \n1 2 8 9 5 \n1 2 5 8 9 \ncomparisons 9 swaps 0 shifts 7\n", C73::run);
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        if (javac == null) throw new IllegalStateException("A JDK is needed to check compile claims.");

        System.out.println(failed == 0 ? "PASS: " + passed + " programs match Java " + System.getProperty("java.version") : failed + " of " + (passed + failed) + " programs differ");
    }
}
