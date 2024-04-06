package edat.estructuras2023.Lineales.Dinamicas;

public class Pila {
    
    /**
     * TDA Pila Dinamica es una estructura de Tipo lineal por la estructura
     * de como se almacenan los datos y dinamica, por que puede ajustar 
     * la memoria que consume dependiendo de la cantidad de elementos que posea
     */

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    /**
     * Metodo para apilar un elemento en el tope de la pila
     * tipo de orden O(1)
     * @return boolean
     */
    public boolean apilar(Object nuevoElem) {
        Nodo nuevoNodo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevoNodo;
        return true;
    }

    
    /**
     * Metodo para desapilar un elemento en el tope de la pila
     * tipo de orden O(1)
     * @return boolean
     */
    public boolean desapilar() {
        boolean exito = true;
        if (this.tope != null) {
            this.tope = this.tope.getEnlace();
        } else {
            exito = false;
        }
        return exito;
    }

    /**
     * Metodo para obtener una copia del elemento tope de la pila.
     * tipo de orden O(1)
     * @return Object.
     */
    public Object obtenerTope() {
        Object elem = null;
        if (this.tope != null) {
            elem = this.tope.getElem();
        }
        return elem;
    }

     /**
     * Metodo para saber si la pila esta vacia.
     * tipo de orden O(1)
     * @return boolean
     */
    public boolean esVacia() {
        return this.tope == null;
    }

     /**
     * Metodo para vaciar el contenido de la pila, el borrado se hace
     * con cambio de referencia y el Garbage collection de java.
     * tipo de orden O(1) 
     */
    public void vaciar() {
        this.tope = null;
    }
    
    @Override
      /**
     * Metodo para clonar la estructura de tipo pila con sus elementos
     * tipo de orden O(N) 
     * @return Pila
     */
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
    
    /**
     * devuelve una cadena de texto para representar el contenido de
     * la estructura Pila O(N)
     * @return String
     * @exception Solo para debug.
     */
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
