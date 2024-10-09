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
    public static void createMatrix() {
        final int size = 10;

        Arrays2d matrix = new Arrays2d(size);
        matrix.generateData();
        //matrix.print();

        long tic = System.nanoTime();
        /*for (int i = 0; i < 10000; i++) {
            matrix.swampColumns(0, i%size);
        }*/

        //matrix.flipHorizontaly();
        matrix.symetricNut(1<<10);
        long tac = System.nanoTime();

        //matrix.print();
        System.out.println(" ");
        System.out.print("Took " + (tac - tic)/1.0E+6 + "ms");
    }

    public static void main(String[] args) {
        //start(100);
        createMatrix();
    }
}