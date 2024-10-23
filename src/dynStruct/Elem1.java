package dynStruct;

public class Elem1 {
    private int data;
    private Elem1 next;

    public Elem1(int data) {
        this.data = data;
    }

    public Elem1(Elem1 next, int data) {
        this.next = next;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Elem1 getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Elem1 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Elem1{" +
                "data=" + data +
                '}';
    }
}
