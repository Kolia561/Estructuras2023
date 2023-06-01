package edat.estructuras2023.Conjuntistas.Estaticas;

import java.lang.reflect.Array;


/**
 * ArbolHeap
 */
public class ArbolHeap <T extends Comparable<T>> {

    final private int TAM = 20;
    private T[] heap;
    private int ultimo;

    public ArbolHeap() {
        this.heap = (T[]) Array.newInstance(Comparable.class, this.TAM);
        this.ultimo = 0;
    }

    public boolean insertar(T elem) {
        boolean exito = false;
        if (this.ultimo < this.TAM) {
            this.ultimo++;
            this.heap[this.ultimo] = elem;
            hacerSubir(this.ultimo);
            exito = true;
        }
        return exito;
    }

    private void hacerSubir(int posHijo) {
        int posPadre = posHijo / 2;
        T aux;
        if (posPadre > 0) {
            if ((this.heap[posHijo]).compareTo(this.heap[posPadre]) < 0) {
                // el hijo es menor que el padre
                aux = this.heap[posHijo];
                this.heap[posHijo] = this.heap[posPadre];
                this.heap[posPadre] = aux;
                hacerSubir(posPadre);
            }
        }
    }

    public boolean eliminarCima() {
        boolean exito = false;
        if (this.ultimo > 0) {
            this.heap[1] = this.heap[this.ultimo];
            this.ultimo--;
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    public void hacerBajar(int posPadre){
        int posHijo;
        T aux = this.heap[posPadre];
        boolean salir = false;

        while(!salir){

            posHijo = posPadre * 2;

            if  (posHijo<=this.ultimo){

                if(posHijo < this.ultimo){ //posee hermano derecho
                    if(this.heap[posHijo+1].compareTo(this.heap[posHijo]) < 0){
                        //el hermano derecho es menor que el izquierdo
                        posHijo++;
                    }
                }

                if(this.heap[posHijo].compareTo(aux) <0){
                    //el hijo es menor que el padre
                    this.heap[posPadre] = this.heap[posHijo];
                    this.heap[posHijo] = aux;
                    posPadre = posHijo;
                }else{
                    salir=true;
            
                }
            }else{

                salir = true;

            }
        }
    }
    
    public T recuperarCima() {
        T elem = null;
        if (this.ultimo > 0) {
            elem = this.heap[1];
        }
        return elem;
    }
    
}