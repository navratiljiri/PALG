import arrays.Array;

public class Main {

    public static void start(int arrayCount) {
        Array arr = new Array(arrayCount);
        long tic = System.nanoTime();
        for (int i = 0; i < arrayCount; i++) {
            arr.add(i);
        }
        arr.addToSpecific(2,4);
        //arr.deleteSpecific(1);
        long tac = System.nanoTime();

        System.out.println(arr.toString());
        System.out.println("Took " + (tac - tic)/1.0E+6 + "ms");
    }

    public static void main(String[] args) {
        start(10);
    }
}