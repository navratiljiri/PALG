package arrays;

import java.util.ArrayList;

public class Array {
    private int elems = 0;
    //private ArrayList<Integer> data;
    private int[] data;

    public Array(int size) {
        this.data = new int[size];
        //this.data = new ArrayList<Integer>(1);
    }

    public void add(int value) {
        if(elems == data.length) {
            this.grow();
        }
        //data.add(value);
        this.data[elems++] = value;
    }

    public void addToSpecific(int index, int value) {
        grow();
        elems++;
        for(int i = elems; i > index; i--) {
            this.data[i] = data[i - 1];
        }
        this.data[index] = value;
    }
    public void deleteSpecific(int index) {
        for(int i = index; i < elems - 1; i++) {
            this.data[i] = data[i + 1];
        }
        elems--;
    }

    private void grow() {
        int[] bigger = new int[data.length * 2];
        System.arraycopy(this.data, 0, bigger, 0, elems);
        data = bigger;
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
