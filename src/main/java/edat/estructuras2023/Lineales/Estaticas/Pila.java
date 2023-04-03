package edat.estructuras2023.Lineales.Estaticas;

public class Pila {
    //Pila estatica con arreglo de tamaño fijo definido por el usuario.

    private Object[] arreglo;
    private int tope;

    public Pila(int tamaño) {
        this.arreglo = new Object[tamaño];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito = false;
        if (this.tope < this.arreglo.length - 1) {
            this.tope++;
            this.arreglo[this.tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito = false;
        if (this.tope != -1) {
            this.arreglo[this.tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object elem = null;
        if (this.tope != -1) {
            elem = this.arreglo[this.tope];
        }
        return elem;
    }

    public boolean esVacia() {
        return this.tope == -1;
    }

    public void vaciar() {
        this.tope = -1;
    }

    public Pila clone() {
        Pila clon = new Pila(this.arreglo.length);
        if (this.tope != -1) {
            clon.tope = this.tope;
            clon.arreglo = this.arreglo.clone();
        }
        return clon;
    }

    public String toString() {
        String cadena = "";
        if (this.tope != -1) {
            for (int i = this.tope; i >= 0; i--) {
                cadena += this.arreglo[i] + " ";
            }
        }
        return cadena;
    }

}
