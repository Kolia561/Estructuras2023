package edat.estructuras2023.Lineales.Dinamicas;        


public class Cola {

    //Cola dinamica con lista enlazada.

    private Nodo frente;
    private Nodo fin;
    

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object nuevoElem) {
        Nodo nuevoNodo = new Nodo(nuevoElem, null);
        if (this.frente == null) {
            this.frente = nuevoNodo;
        } else {
            this.fin.setEnlace(nuevoNodo);
        }
        this.fin = nuevoNodo;
        return true;
    }

    public boolean sacar() {
        boolean exito = false;
        if (this.frente != null) {
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object elem = null;
        if (this.frente != null) {
            elem = this.frente.getElem();
        }
        return elem;
    }

    public boolean esVacia() {
        return this.frente == null;
    }

    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    public Cola clone() {
        Cola clon = new Cola();
        if (this.frente != null) {
            clon.frente = clonarAux(this.frente);
            clon.fin = clonarAux(this.fin);
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
        Nodo aux = this.frente;
        while (aux != null) {
            cadena = cadena + aux.getElem().toString() + ";";
            aux = aux.getEnlace();
        }
        return cadena;
    }

}