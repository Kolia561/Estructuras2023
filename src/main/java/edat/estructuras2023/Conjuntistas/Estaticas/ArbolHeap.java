package edat.estructuras2023.Conjuntistas.Estaticas;

import java.lang.reflect.Array;

/**
 * ArbolHeap
 */
public class ArbolHeap<E extends Comparable<E>> {

    final private int TAM = 20;
    private E[] heap;
    private int ultimo;

    public ArbolHeap() {
        this.heap = (E[]) Array.newInstance(Comparable.class, this.TAM);
        this.ultimo = 0;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = false;
        if (this.ultimo < this.TAM) {
            this.ultimo++;
            this.heap[this.ultimo] = elem;
            hacerSubir(this.ultimo);
            exito = true;
        }
        return exito;
    }

    private void hacerSubir(int pos) {
        int posPadre = pos / 2;
        Comparable aux;
        if (posPadre > 0) {
            if ((this.heap[pos]).compareTo(this.heap[posPadre]) < 0) {
                aux = this.heap[pos];
                this.heap[pos] = this.heap[posPadre];
                this.heap[posPadre] = aux;
                hacerSubir(posPadre);
            }
        }
    }
    
}