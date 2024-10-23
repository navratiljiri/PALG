import arrays.Array;
import arrays2d.Arrays2d;

public class Main {

    /**
     * Práce z polem - přidání, odebrání, zvětšení, výpis
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
        System.out.print("$Took " + (tac - tic)/1.0E+6 + "ms");

    }

    /**
     * Práce s dvojrozměrným polem - Flipování, přehození řádku x sloupců,
     */
    public static void createMatrix() {
        final int size = 1<< 14;

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
        System.out.print("Took " + (tac - tic)/1.0E+6 + "ms");
    }

    public static void main(String[] args) {
        //start(100);
        //createMatrix();

    }
}