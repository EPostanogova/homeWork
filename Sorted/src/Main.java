import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[] myArray_1 = new int[10000];
        int[] myArray_2 = new int[10000];
        int[] myArray_3 = new int[10000];
        for (int i = 0; i < 10000; i++) {
            myArray_1[i]=random.nextInt(1000);
            myArray_2[i]=random.nextInt(1000);
            myArray_3[i]=random.nextInt(1000);
        }
        insertionSort(myArray_1);
        bubbleSort(myArray_2);
        sorted_metod(myArray_3);


    }

    public static void bubbleSort(int[] array) throws InterruptedException {
        long start = System.currentTimeMillis();
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
        Thread.sleep(1000);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Сортировка пузырьком заняла, мс: " + elapsed);
    }
    public static void insertionSort(int[] array) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        Thread.sleep(1000);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Сортировка вставками заняла, мс: " + elapsed);
    }
    public static void sorted_metod(int[] array) throws InterruptedException {
        long start = System.currentTimeMillis();
        Arrays.sort(array);
        Thread.sleep(1000);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Сортировка через Arrays.sort() заняла, мс: " + elapsed);
    }
}