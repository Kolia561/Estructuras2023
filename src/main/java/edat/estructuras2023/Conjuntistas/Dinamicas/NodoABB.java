package edat.estructuras2023.Conjuntistas.Dinamicas;

public class NodoABB<T extends Comparable<T>> {

    private T elem;

    private NodoABB<T> izq;

    private NodoABB<T> der;

    public NodoABB(T elem) {
        this.elem = elem;
        this.izq = null;
        this.der = null;
    }

    public T getElem() {
        return this.elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public NodoABB<T> getIzq() {
        return this.izq;
    }

    public void setIzq(NodoABB<T> izq) {
        this.izq = izq;
    }

    public NodoABB<T> getDer() {
        return this.der;
    }

    public void setDer(NodoABB<T> der) {
        this.der = der;
    }

    public boolean esHoja() {
        return this.izq == null && this.der == null;
    }

    public boolean esMenor(T elem) {
        return this.elem.compareTo(elem) < 0;
    }

    public boolean esMayor(T elem) {
        return this.elem.compareTo(elem) > 0;
    }

    public boolean esIgual(T elem) {
        return this.elem.compareTo(elem) == 0;
    }





}
