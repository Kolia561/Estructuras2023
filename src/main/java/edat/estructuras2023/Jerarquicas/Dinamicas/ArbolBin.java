package edat.estructuras2023.Jerarquicas.Dinamicas;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object nuevoElem, Object elemPadre, Character lugar) {
        boolean rta = false;

        if (this.raiz == null) {
            this.raiz = new NodoArbol(nuevoElem, null, null);
        rta = true;
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);

            /* Si el nodo padre existe, comprueba si el lugar esta vacio.
             * si esta vacio, inserta el nuevo elemento en el lugar correspondiente
             * y devuelve true. Si no esta vacio, devuelve false.
             */

            if (nodoPadre != null) {
                if (Character.toLowerCase(lugar) == 'i'  && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(nuevoElem, null, null));
                rta = true;
                } else if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new NodoArbol(nuevoElem, null, null));
                rta = true;
                }
            
            }
        }

        return rta;
    }

    private NodoArbol obtenerNodo (NodoArbol nodo, Object elem){
        NodoArbol rta=null;

        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                rta=nodo;
            }else {
                    rta = obtenerNodo(nodo.getIzquierdo(), elem);

                    if( rta==null){

                        rta = obtenerNodo(nodo.getDerecho(), elem);
                    }
                }
            }
        

        return rta;

    }

    public boolean esVacio(){

        boolean rta=false;

        if (this.raiz !=null){
            rta=true;
        }

        return rta;
    }


    public void vaciar(){
        this.raiz=null;
    }

    public int altura(){
        int rta=-1;

        if (this.raiz !=null){
            rta=alturaAux(this.raiz);
        }

        return rta;
    }

    private int alturaAux(NodoArbol nodo){
        int rta=0;

        if (nodo !=null){
            rta=1+Math.max(alturaAux(nodo.getIzquierdo()), alturaAux(nodo.getDerecho()));
        }

        return rta;
    }

    public NodoArbol padre(){

        NodoArbol rta=null;





        return rta;
    }


}