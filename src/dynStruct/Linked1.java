package dynStruct;

public class Linked1 {
    private Elem1 head;
    private Elem1 indent;
    private int elems;
    private final int indentData = Integer.MAX_VALUE;

    public Linked1() {
        this.elems = 0;
        this.indent = new Elem1(indentData);
        this.head = this.indent;
    }

    public int size() {
        return this.elems;
    }

    /**
     * Přiřadí prvek na nějakou obecnou pozici za nějaký prvek
     * @param pred
     * @param value - nová data
     */

    public void add(Elem1 pred, int value) {
        if(pred != null && pred != indent) {
            Elem1 elem = new Elem1(value);
            elem.setNext(pred.getNext());
            pred.setNext(elem);
        }
    }

    /**
     * Přiřadí prvek jako první
     * Nastaví ho jaku hlavu
     * @param elem
     */
    public void add(Elem1 elem) {
        elem.setNext(this.head);
        this.head = elem;
        this.elems++;
    }

    /**
     * Vymazání prvku
     * Lineární složitost (pouze)
     * @param elem
     */
    public void remove(Elem1 elem) {
        if(elem != null && elem != this.indent) {
            Elem1 nextElem = elem.getNext();
            elem.setData(nextElem.getData());
            elem.setNext(nextElem.getNext());
            if(nextElem == this.indent) {
                this.indent = elem;
            }
            this.elems--;
        }
    }

    /**
     * Vyhledání prvku
     * @param index
     * @return
     */
    public Elem1 get(int index) {
        if(index >= this.elems) {
            return null;
        }
        else {
            Elem1 tmp = this.head;
            for(int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            return tmp;
        }
    }
}
