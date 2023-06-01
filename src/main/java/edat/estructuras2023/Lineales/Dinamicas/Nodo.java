package edat.estructuras2023.Lineales.Dinamicas;

public class Nodo<T> {
    private T elem;
    private Nodo<T> enlace;
    
    public Nodo(T elem, Nodo<T> enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    public Nodo() {
        this.elem = null;
        this.enlace = null;
    }
    
    public T getElem() {
        return elem;
    }
    
    public void setElem(T elem) {
        this.elem = elem;
    }
    
    public Nodo<T> getEnlace() {
        return enlace;
    }
    
    public void setEnlace(Nodo<T> enlace) {
        this.enlace = enlace;
    }
}    
