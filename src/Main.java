import arrays.Array;
import arrays2d.ArrayBasics;
import arrays2d.Arrays2d;

import java.util.Random;

public class Main {

    /**
     * Práce z polem - přidání, odebrání, zvětšení, výpis
     *
     * @param arrayCount
     */

    public static void start(int arrayCount) {
        //LinkedList<Integer> arr = new LinkedList<>();

        //ArrayList<Integer> arr = new ArrayList<Integer>(arrayCount);

        Array arr = new Array(arrayCount);
        for (int i = 0; i < arrayCount; i++) {
            arr.add(i);
        }

        long tic = System.nanoTime();
        arr.binarySearch(0);
        long tac = System.nanoTime();

        //System.out.println(arr.toString());
        System.out.print("$Took " + (tac - tic) / 1.0E+6 + "ms");

    }

    /**
     * Práce s dvojrozměrným polem - Flipování, přehození řádku x sloupců,
     */
    public static void createMatrix() {
        final int size = 1 << 14;

        Arrays2d matrix = new Arrays2d(size);
        //matrix.generateData();

        long tic = System.nanoTime();
        /*for (int i = 0; i < 10000; i++) {
            matrix.swampColumns(0, i%size);
        }*/
        //matrix.flipHorizontaly();
        matrix.symetricNut2();
        long tac = System.nanoTime();
        //matrix.print();
        System.out.print("Took " + (tac - tic) / 1.0E+6 + "ms");
    }

    /**
     * Spouštění třídících algoritmů
     */
    public static void sort() {
        ArrayBasics bsc = new ArrayBasics();
        int N = 1 << 20;

        int[] random = generateRandomArray(N);
        int[] random2 = generateRandomArray(N);

        //int[] a = bsc.selectionSort_new(random);
        /*int[] a2 = bsc.selectionSort_new(random2);*/

        long tic = System.nanoTime();
        bsc.treeSort(random);
        long tac = System.nanoTime();

        long tic2 = System.nanoTime();
        bsc.mergeSort(random2);
        long tac2 = System.nanoTime();

        /*for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }*/

        System.out.println();
        System.out.print("Sort1: " + (tac - tic) / 1.0E+6 + "ms");
        System.out.println();
        System.out.print("Sort2: " + (tac2 - tic2) / 1.0E+6 + "ms");

        /*random = generateRandomArray(N);

        long tic1 = System.nanoTime();
        int[] a2 = bsc.bubbleSortUpgrade_new(random);
        long tac1 = System.nanoTime();*/

//        for (int i = 0; i < a2.length; i++) {
//            System.out.print(a2[i] + " ");
//        }


    }

    public static int[] generateRandomArray(int N) {
        int[] random = new int[N];
        for (int i = 0; i < N; i++) {
            Random r = new Random();
            random[i] = r.nextInt(N);
        }
        return random;
    }

    public static void main(String[] args) {
        //start(100);
        //createMatrix();
        sort();

    }
}