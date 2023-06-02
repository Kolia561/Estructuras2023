package edat.estructuras2023.Conjuntistas.Dinamicas;

import javax.xml.transform.Source;

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

       

            rta=eliminarRec(this.raiz,elem,null);
        
    

        return rta;


    }

    private boolean caso1(NodoABB<T> nodo){

        boolean rta=false;

        if(nodo.esHoja()){
            nodo=null;
            rta=true;
            
        }

        return rta;
    }
    
    private boolean caso2(NodoABB<T> nodo, NodoABB<T> padre){

        boolean rta=false;

        if(nodo.getIzq()!=null){

            if(padre!=null){
                padre.setIzq(nodo.getIzq());
                rta=true;
            }else{
                this.raiz=nodo.getIzq();
                rta=true;
            }

        }else{

            if(padre!=null){
                padre.setDer(nodo.getDer());
                rta=true;
            }else{
                this.raiz=nodo.getDer();
                rta=true;
            }

        }

        return rta;
    }
    
    private boolean caso3(NodoABB<T> nodo){

        boolean rta=false;
        if(nodo.getIzq()!=null && nodo.getDer()!=null){

            nodo.setElem(buscarMaxIzq(nodo.getIzq()));
            rta=eliminarRec(nodo.getIzq(),nodo.getElem(),nodo);
        }

        return rta;
    }
    
    private boolean eliminarRec(NodoABB<T> nodo, T elem, NodoABB<T> padre){

        boolean rta=false;

        

        if (nodo!=null){

           

            if(nodo.esIgual(elem)){
               
                if(rta=caso1(nodo)){
                        //System.out.println("caso1");
                }else{

                    if(rta=caso3(nodo)){
                        //System.out.println("caso3");
                    }else{
                        //System.out.println("caso2");
                        rta=caso2(nodo,padre);
                        }
                       
                    }
                }

            }else{

                if(nodo.esMenor(elem)){
                    
                    rta=eliminarRec(nodo.getIzq(),elem,nodo);
                
                }else{

                    rta=eliminarRec(nodo.getDer(),elem,nodo);

                }
            }
        

        return rta;
    }

    private T buscarMaxIzq(NodoABB<T> nodo){

        T rta=null;

        if(nodo!=null){
            if(nodo.getDer()==null){
                rta=nodo.getElem();
            }else{
                rta=buscarMaxIzq(nodo.getDer());
            }
        }

        return rta;
    }

    
}