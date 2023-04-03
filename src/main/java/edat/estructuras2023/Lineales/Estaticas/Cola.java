package edat.estructuras2023.Lineales.Estaticas;

public class Cola {

    //Cola estatica con arreglo de tamaño fijo definido por el usuario.

    private Object[] arreglo;
    private int frente;
    private int fin;
    private int cant;

    public Cola(int tamaño) {
        this.arreglo = new Object[tamaño];
        this.frente = 0;
        this.fin = -1;
        this.cant = 0;
    }

    public boolean poner(Object nuevoElem) {
        boolean exito = false;
        if (this.cant < this.arreglo.length) {
            this.fin++;
            if (this.fin == this.arreglo.length) {  //Si llego al final del arreglo, vuelve al principio.
                this.fin = 0;                       //Siempre que el arreglo sea circular.
            }                                       
            this.arreglo[this.fin] = nuevoElem;
            this.cant++;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = false;
        if (this.cant != 0) {
            this.arreglo[this.frente] = null;
            this.frente++;
            if (this.frente == this.arreglo.length) {
                this.frente = 0;
            }
            this.cant--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object elem = null;
        if (this.cant != 0) {
            elem = this.arreglo[this.frente];
        }
        return elem;
    }

}