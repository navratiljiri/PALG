package arrays;

public class Array {
    private int elems = 0;
    //private ArrayList<Integer> data;
    private int[] data;

    public Array(int size) {
        this.data = new int[size];
        //this.data = new ArrayList<Integer>(1);
    }

    /**
     * Přidání prvku do pole
     *
     * @param value
     */

    public void add(int value) {
        if (elems == data.length) {
            this.grow();
        }
        //data.add(value);
        this.data[elems++] = value;
    }

    /**
     * Přidání prvku na specifický index
     *
     * @param index
     * @param value
     */
    public void addToSpecific(int index, int value) {
        grow();
        elems++;
        for (int i = elems; i > index; i--) {
            this.data[i] = data[i - 1];
        }
        this.data[index] = value;
    }

    /**
     * Odebrání specifického prvku
     *
     * @param index
     */
    public void deleteSpecific(int index) {
        for (int i = index; i < elems - 1; i++) {
            this.data[i] = data[i + 1];
        }
        elems--;
    }

    /**
     * Vyhledání specifické hodnoty z pole z leva
     *
     * @param value
     * @return vrátí index při nalezení jinak -1
     */

    public int indexOf(int value) {
        for (int i = 0; i < elems; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Vyhledání specifické hodnoty z pole zprava
     *
     * @param value
     * @return vrátí index při nalezení jinak -1
     */
    public int lastIndexOf(int value) {
        for (int i = elems - 1; i > 0; i--) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Vyhledání ze seřazeného pole
     *
     * @param value
     * @return
     */
    public int binarySearch(int value) {
        int start = 0;
        int end = elems - 1;

        while (end - start > 0) {
            int half = (start + end) / 2;

            if (data[half] == value) {
                return half;
            } else if (data[half] > value) {
                end = half - 1;
            } else {
                start = half + 1;
            }
        }
        return -1;
    }

    /**
     * Vyhledání ze seřazeného pole (o něco rychlejší varianta)
     *
     * @param value
     * @return
     */
    public int binarySearch2(int value) {
        int start = 0;
        int end = elems - 1;

        while (end - start > 1) {
            int half = (start + end) / 2;

            if (value > data[half]) {
                end = half + 1;
            } else {
                start = half;
            }
        }
        return (value == data[start]) ? start : -1;
    }

    /**
     * Zvětšení pole
     */
    private void grow() {
        int[] bigger = new int[data.length * 2];
        System.arraycopy(this.data, 0, bigger, 0, elems);
        data = bigger;
    }
    //TODO udělat čtvercovou matici kde diagonály budou 0 a ostatní sektory číselné (1,2,3,4)

    public void nut(int size) {
        int[][] arr = new int[size][size];

        int diagonalEnd = size - 1;

        for (int i = 0; i < arr.length; i++) {
            System.out.println();
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
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elems; i++) {
            sb.append(data[i]).append(" ");
        }
        return sb.toString();
    }
}
