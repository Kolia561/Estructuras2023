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


    private boolean eliminarRec(NodoABB<T> nodo, T elem){

        boolean rta=false;

        if (nodo!=null){
            if(nodo.esIgual(elem)){
                if(nodo.esHoja()){
                    nodo=null;
                    rta=true;
            }else{

                if(nodo.getIzq()!=null && nodo.getDer()!=null){
                    nodo.setElem(buscarMin(nodo.getIzq()));
                    rta=eliminarRec(nodo.getDer(),nodo.getElem());
                }else{
                    if(nodo.getIzq()!=null){
                        nodo.setElem(buscarMin(nodo.getIzq()));
                        rta=eliminarRec(nodo.getIzq(),nodo.getElem());
                    }else{
                        nodo.setElem(buscarMin(nodo.getDer()));
                        rta=eliminarRec(nodo.getDer(),nodo.getElem());
                    }
                }

            }
        }
    }

        return rta;
    }

    private T buscarMin(NodoABB<T> nodo){

        T rta=null;

        if(nodo!=null){
            if(nodo.getDer()==null){
                rta=nodo.getElem();
            }else{
                rta=buscarMin(nodo.getDer());
            }
        }

        return rta;
    }

    
}