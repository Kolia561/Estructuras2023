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

    //clona la cola en un nuevo objeto, con referencias a los elementos de la original

    public Cola clone() {
        Cola colaClon = new Cola();
        if (this.frente != null) {
            colaClon.frente = new Nodo(this.frente.getElem(), null);
            Nodo aux = this.frente.getEnlace();
            Nodo aux2 = colaClon.frente;
            while (aux != null) {
                aux2.setEnlace(new Nodo(aux.getElem(), null));
                aux = aux.getEnlace();
                aux2 = aux2.getEnlace();
            }
            colaClon.fin = aux2;
        }
        return colaClon;
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