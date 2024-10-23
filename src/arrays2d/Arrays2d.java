package arrays2d;

import static java.lang.String.format;

public class Arrays2d {

    final int row;
    final int column;
    double[][] data;

    public Arrays2d(int column, int row) {
        this.column = column;
        this.row = row;
        data = new double[column][row];
    }

    public Arrays2d(int size) {
        this.column = size;
        this.row = size;
        data = new double[size][size];
    }

    /**
     * Vygeneruje data
     */

    public void generateData() {
        double value = 0;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                data[i][j] = value;
                value++;
            }
        }
    }

    /**
     * Převrátí řádky
     * Složitost - 3n operací
     * @param i
     * @param k
     */
    public void swampRows(int i, int k) {
        if (i < 0 || i >= row || k < 0 || k >= row) {
            System.out.println("Error Rows out of bounds");
        } else {
            for (int j = 0; j < column; j++) {
                double tmp = data[i][j];
                data[i][j] = data[k][j];
                data[k][j] = tmp;
            }
        }
    }

    /**
     * Převrátí sloupce
     * Pomalejší oproti rows columns
     * @param i
     * @param k
     */
    public void swampColumns(int i, int k) {
        if (i < 0 || i >= row || k < 0 || k >= row) {
            System.out.println("Error Column out of bounds");
        } else {
            for (int j = 0; j < column; j++) {
                double tmp = data[j][i];
                data[j][i] = data[j][k];
                data[j][k] = tmp;
            }
        }
    }

    /**
     * Obrátí matici
     * 3/2n operací
     */
    public void flipHorizontaly() {
        for (int i = 0; i < column /2; i++) {
            swampRows(i, column-1-i);
        }
    }

    /**
     * čtvercová matice kde diagonály jsou 0 a ostatní sektory číselné (1,2,3,4)
     */
    public void symetricNut(int size) {
        if (size <= 0) {
            System.out.println("Nelze zadat záporné či nůlové číslo!");
            return;
        }

        int[][] arr = new int[size][size];

        int diagonalEnd = size - 1;

        for (int i = 0; i < arr.length; i++) {
            //System.out.println();
            for (int j = 0; j < arr.length; j++) {
                if (i == j || diagonalEnd - i == j) {
                    arr[i][j] = 0;
                } else if (i < j && j < diagonalEnd - i) {
                    arr[i][j] = 1;
                } else if (i < diagonalEnd - j) {
                    arr[i][j] = 2;
                } else if (i < j) {
                    arr[i][j] = 3;
                } else {
                    arr[i][j] = 4;
                }
                //System.out.print(arr[i][j] + " ");
            }
        }
    }

    /**
     * Bauer řešení
     * Horní a dolní kvadrant pomocí řádků (dolní se překlopí)
     * Pravý a levý pomocí sloupců (transpozice) - to velmi snižuje rychlost
     */
    public void symetricNut2() {
        for (int i = 0; i < column /2; i++) {
            //System.out.println();
            for(int j = i+1; j < column-1-i;j++) {
                data[i][j] = 1;
                data[j][i] = 4;
                data[j][column-1-i] = 3;
                data[column-1-i][j] = 2;
                //System.out.print(data[i][j] + " ");
            }
        }
    }

    public void print() {
        System.out.println("");
        for (int i = 0; i < column; i++) {
            System.out.println();
            for (int j = 0; j < row; j++) {
                String s = String.valueOf(data[i][j]);
                System.out.print(String.format("%5s", s));
            }
        }
    }
}
