import arrays.Array;

public class Main {

    /**
     * Práce z polem - přidání, odebrání, zvětšení, výpis
     * @param arrayCount
     */

    public static void start(int arrayCount) {
        //LinkedList<Integer> arr = new LinkedList<>();

        //ArrayList<Integer> arr = new ArrayList<Integer>(arrayCount);

        Array arr = new Array(arrayCount);
        /*for (int i = 0; i < arrayCount; i++) {
            arr.add(i);
        }*/

        long tic = System.nanoTime();
        //arr.binarySearch(120);
        arr.nut(3);
        long tac = System.nanoTime();

        //System.out.println(arr.toString());
        System.out.print("$Took " + (tac - tic)/1.0E+6 + "ms");

    }

    public static void main(String[] args) {
        start(1);
    }
}