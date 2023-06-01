package edat.estructuras2023.Conjuntistas.Dinamicas;



public class ABB<T extends Comparable<T>> {

    private NodoABB<T> raiz;

    public ABB() {
        this.raiz = null;
    }

    public boolean insertar(T elem) {
        boolean exito = false;
        if (this.raiz == null) {
            this.raiz = new NodoABB<T>(elem);
            exito = true;
        } else {
            exito = insertarAux(this.raiz, elem);
        }
        return exito;
    }


    private boolean insertarAux (NodoABB<T> nodo, T elem){

        boolean rta=false;

        if(nodo!=null && !nodo.esIgual(elem)){  //no acepta repetidos

            if(nodo.esMenor(elem)){
                if(nodo.getIzq()==null){
                    nodo.setIzq(new NodoABB<T>(elem));
                    rta=true;
                }else{
                    rta=insertarAux(nodo.getIzq(), elem);
                }

        }else{

                if(nodo.getDer()==null){
                    nodo.setDer(new NodoABB<T>(elem));
                    rta=true;
                }else{
                    rta=insertarAux(nodo.getDer(), elem);
                }
            }

        }

        return rta;
    }


    public boolean eliminar (T elem){

        boolean rta = false;

        if(this.raiz!=null){

            rta=eliminarRec(this.raiz,elem);
        }

        return rta;


    }


    
}