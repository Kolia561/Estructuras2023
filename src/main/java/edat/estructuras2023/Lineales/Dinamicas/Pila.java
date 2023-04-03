package edat.estructuras2023.Lineales.Dinamicas;

public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        Nodo nuevoNodo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevoNodo;
        return true;
    }

    public boolean desapilar() {
        boolean exito = true;
        if (this.tope != null) {
            this.tope = this.tope.getEnlace();
        } else {
            exito = false;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object elem = null;
        if (this.tope != null) {
            elem = this.tope.getElem();
        }
        return elem;
    }

    public boolean esVacia() {
        return this.tope == null;
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone() {
        Pila clon = new Pila();
        if (this.tope != null) {
            clon.tope = clonarAux(this.tope);
        }
        return clon;
    }

    private Nodo clonarAux(Nodo nodo) {
        Nodo clon = null;
        if (nodo != null) {
            clon = new Nodo(nodo.getElem(), clonarAux(nodo.getEnlace()));
        }
        return clon;
    }

    public String toString() {
        String cadena = "";
        if (this.tope != null) {
            cadena = toStringAux(this.tope);
        }
        return cadena;
    }

    private String toStringAux(Nodo nodo) {
        String cadena = "";
        if (nodo != null) {
            cadena = nodo.getElem() + " " + toStringAux(nodo.getEnlace());
        }
        return cadena;
    }
    
}
