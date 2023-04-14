package edat.estructuras2023.Lineales.Dinamicas;

public class Nodo {
    private Object elem;
    private Nodo enlace;
    
    public Nodo(Object elem, Nodo enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    public Nodo() {
        this.elem = null;
        this.enlace = null;
    }
    
    public Object getElem() {
        return elem;
    }
    
    public void setElem(Object elem) {
        this.elem = elem;
    }
    
    public Nodo getEnlace() {
        return enlace;
    }
    
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}    
