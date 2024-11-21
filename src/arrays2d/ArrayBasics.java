package arrays2d;

import dynStruct.BinTree;

public class ArrayBasics {
    /**
     * Kvadratická náročnost
     * (n * (n-1))/2 - počet porovnání (na nich nejvíce záleží)
     * n-1 - počet výměň (při nejhorším scénáři) - lineární člen
     * Poctivý pracant, neví kam má kopat, ale pořád kope :D
     *
     * @param a
     */
    public int[] selectionSort_new(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        return a;
    }

    /**
     * Kvadratická náročnost
     * Počet porovnání - stejný jako u selectionSort
     * Počet výměn - 3*(n(n-1))/2 --> 2n*(n-1)
     * Měl by být 4* pomalejší než selectionSort
     *
     * @param a
     * @return
     */
    public int[] bubbleSort_new(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * Zjištuje pomocí výměny zdali je už seřazený a o to
     *
     * @param a
     * @return
     */
    public int[] bubbleSortUpgrade_new(int[] a) {
        int n = a.length;
        int posledniVymena = n - 1;
        for (int i = 0; i < n - 1 && posledniVymena > 0; i++) {
            int index = 0;
            for (int j = 0; j < posledniVymena; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    index = j;
                }
            }
            posledniVymena = index;
        }
        return a;
    }

    /**
     * Kvadratická náročnost
     * InsertionSort
     * i/2 - porovnání
     * V nejhorším případě 1/2*n*(n-1)
     */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int k = i - 1;
            int aux = a[i];

            while ((k >= 0) && (aux < a[k])) {
                a[k + 1] = a[k];
                k--;
            }
            a[k + 1] = aux;
        }
    }

    /**
     * Merge
     * Spojí dvě seřazené pole do jednoho
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;

       /* while(c.length -1 > i) {
            while (i < a.length -1 && j < b.length -1 && a[i] < b[j]) {
                j++;y
            }
            c[i] = a[i];
            c[i+1] = b[j];
            k+=2;
            j = i;
        }*/

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j])
                c[k] = a[i++];
            else
                c[k] = b[j++];
            k++;
        }
        while (i < a.length) {
            c[k] = a[i++];
            k++;
        }
        while (j < b.length) {
            c[k] = b[j++];
            k++;
        }
        return c;
    }

    /**
     * Logaritimická náročnost
     * Už potřebují víc paměti
     * @param a
     */

    public static int[] mergeSort(int[] a) {
        int n = a.length;
        int[] source = a;
        int[] target = new int[n];

        for (int len = 1; len < n; len *= 2) {
            for (int start = 0; start < n; start += 2 * len) {
                int i = start;
                int j = start + len;
                int k = start;
                while (i < start + len && j < start + 2 * len) {
                    target[k++] = source[i] < source[j] ? target[i++] : target[j++];
                }
                while (i < start + len) {
                    target[k++] = source[i++];
                }
                while (j < start + 2 * len) {
                    target[k++] = source[j++];
                }
                int[] ref = source;
                source = target;
                target = ref;
            }

            if(source != a) {
                System.arraycopy(source, 0, a, 0, source.length);
            }
        }
        return source;
    }

    private static void merge_segment(int [] source, int [] target, int s, int len)
    {
        int i = s;
        int j = s + len;
        int k = s;
        while (i < s + len && j < s + 2*len)
        {
            if (source[i] <= source[j])
                target[k] = source[i++];
            else
                target[k] = source[j++];
            k++;
        }
        while (i < s + len)
        {
            target[k] = source[i++];
            k++;
        }
        while (j < s + 2*len)
        {
            target[k] = source[j++];
            k++;
        }

    }
    public static void mergeSort2(int [] a)
    {
        int n = a.length;
        int [] source = a;
        int [] target = new int[n];

        for (int k = 1; k < n; k *= 2)
        {
            for (int j = 0; j < n; j += 2*k)
                merge_segment(source,target,j,k);

            int [] tmp = source;
            source = target;
            target = tmp;
        }

        if (source != a)
            System.arraycopy(source, 0, a, 0, n);
    }
    public static void swapElems(int [] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void split(int[] a, int l, int r)
    {
        int k = (l + r) / 2;
        int value = a[k];
//        System.out.println(value);
        int i = l;
        int j = r;
        while (i < j)
        {
            while (i <= j && a[i] < value)
                i++;
            while (j >= i && a[j] > value)
                j--;
            if (i <= j) {
                swapElems(a, i, j);
                i++;
                j--;
            }
        }
//        ArrayTools.printArray(a,l ,r+1,j);
        if (l < j)
            split(a,l,j);
        if (i < r)
            split(a,i,r);
    }
    public static void quickSort(int[] a) {
        split(a,0,a.length-1);
    }
    public static void treeSort(int[] a) {
        BinTree tree = new BinTree();
        for(int i=0;i<a.length;i++) {
            tree.add(a[i]);
        }
        tree.toArray(a);
    }
}
