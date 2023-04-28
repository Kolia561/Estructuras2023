package edat.estructuras2023.Jerarquicas.Dinamicas;

import javax.swing.text.DefaultStyledDocument.ElementBuffer;

import edat.estructuras2023.Lineales.Dinamicas.Cola;
import edat.estructuras2023.Lineales.Dinamicas.Lista;


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
                } else if (Character.toLowerCase(lugar) == 'd' && nodoPadre.getDerecho() == null) {
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

        if (this.raiz == null){
            rta=true;
        }

        return rta;
    }


    public void vaciar(){
        this.raiz=null;
    }

    public int altura(){
        int rta;

       
            rta=alturaAux(this.raiz);
        

        return rta;
    }

    private int alturaAux(NodoArbol nodo){
        int rta;
        int altIzq, altDer;

        if (nodo ==null){
            rta=-1;
        }else{
            // rta = 1 + Math.max(alturaAux(nodo.getIzquierdo()), alturaAux(nodo.getDerecho())

            
            altIzq=alturaAux(nodo.getIzquierdo());
            
            altDer=alturaAux(nodo.getDerecho());

            
            
            if(altDer>altIzq){
                rta=altDer+1;
            }else{
                rta=altIzq+1;
            }
           
        }

        return rta;
    }

    public Object padre(Object elem){

        Object rta=null;

        if(this.raiz!=null&& !this.raiz.getElem().equals(elem)){
        rta=padreAux(this.raiz, elem);}
        
        return rta;
    }

    public Object padreAux(NodoArbol nodo, Object elem){
        
        Object rta=null;

        if(nodo!=null){
            //si el nodo no es nulo, comprueba si el hijo izquierdo o derecho contiene elemento buscado
            if(nodo.getIzquierdo()!=null && nodo.getIzquierdo().getElem().equals(elem) ||nodo.getDerecho()!=null && nodo.getDerecho().getElem().equals(elem)){
                //si lo contiene, devuelve el nodo
                rta=nodo.getElem();
            }else{ //si no lo contiene, busca en el hijo izquierdo y derecho
                rta=padreAux(nodo.getIzquierdo(), elem);
                //si no lo encuentra en el hijo izquierdo, busca en el derecho
                if(rta==null){
                    rta=padreAux(nodo.getDerecho(), elem);
                }
            }
        }

        return rta;
    }

    public int nivel(Object elem){
        int rta=-1;

        if(this.raiz!=null){ 
        rta=nivelAux(this.raiz,elem);
        if (rta!=-1){
            rta--;
        }
        }

        return rta;
    }

    private int nivelAux(NodoArbol nodo, Object elem){
        int rta=-1;
        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                rta=0;
            }else{
                rta=nivelAux(nodo.getIzquierdo(), elem);
                if(rta==-1){
                    rta=nivelAux(nodo.getDerecho(), elem);
                }
            }
            if  (rta >-1){
                rta++;
            }
        }

        return rta;
    }

    public Lista listarPreorden(){
        Lista rta=new Lista();
        return listarPreordenAux(this.raiz,rta);
    }

    private Lista listarPreordenAux(NodoArbol nodo, Lista lista){
        
        if(nodo!=null){

        lista.insertar(nodo.getElem(), lista.longitud()+1);
        
        lista = listarPreordenAux(nodo.getIzquierdo(), lista);
        lista = listarPreordenAux(nodo.getDerecho(), lista);
        

        }

        return lista;
    }

    public Lista listarInorden(){
        Lista rta=new Lista();
        return listarInordenAux(this.raiz,rta);
    }

    private Lista listarInordenAux(NodoArbol nodo, Lista lista){
        
        if(nodo!=null){

            lista = listarInordenAux(nodo.getIzquierdo(), lista);
        
        lista.insertar(nodo.getElem(), lista.longitud()+1);

        lista = listarInordenAux(nodo.getDerecho(), lista);


 

        }

        return lista;
    }

    public Lista listarPosorden(){
        Lista rta=new Lista();
        return listarPosordenAux(this.raiz,rta);
    }

    private Lista listarPosordenAux(NodoArbol nodo, Lista lista){
        
        if(nodo!=null){


        lista = listarPosordenAux(nodo.getIzquierdo(), lista);

        lista = listarPosordenAux(nodo.getDerecho(), lista);     

        lista.insertar(nodo.getElem(), lista.longitud()+1);

        }

        return lista;
    }

    public Lista listarPorNiveles(){
        Lista rta=new Lista();
        Cola cola=new Cola();
        NodoArbol aux =this.raiz;

        if (this.raiz!=null) {
            cola.poner(this.raiz);

            while (!cola.esVacia()){
                aux=(NodoArbol)cola.obtenerFrente();
                cola.sacar();
                rta.insertar(aux.getElem(), rta.longitud()+1);
                if(aux.getIzquierdo()!=null){
                    cola.poner(aux.getIzquierdo().getElem());
                }
                if(aux.getDerecho()!=null){
                    cola.poner(aux.getDerecho().getElem());
                }

        
            }

        }

        return rta;
    }

    public ArbolBin clone(){
        ArbolBin clon=new ArbolBin();
        
        if(this.raiz!=null){
            clon.raiz=new NodoArbol(this.raiz.getElem(), null, null);
            cloneAux(this.raiz, clon.raiz);
        }


        return clon;
    }

    private void cloneAux(NodoArbol nodo, NodoArbol clon){
        if(nodo!=null){
            if(nodo.getIzquierdo()!=null){
                clon.setIzquierdo(new NodoArbol(nodo.getIzquierdo().getElem(), null, null));
                cloneAux(nodo.getIzquierdo(), clon.getIzquierdo());
            }
            if(nodo.getDerecho()!=null){
                clon.setDerecho(new NodoArbol(nodo.getDerecho().getElem(), null, null));
                cloneAux(nodo.getDerecho(), clon.getDerecho());
            }
        }
    }


    public String toString(){

        String rta="";

        if(this.raiz!=null){
            rta=toStringAux(this.raiz);
        }

        return rta;
    }

    private String toStringAux(NodoArbol nodo){
        String rta="";

        if(nodo!=null){
            rta=nodo.getElem().toString();
            if(nodo.getIzquierdo()!=null){
                rta=rta + " HI: " + nodo.getIzquierdo().getElem().toString();
            }else{
                rta=rta + " HI: - ";
            }
            if(nodo.getDerecho()!=null){
                rta=rta + " HD: " + nodo.getDerecho().getElem().toString();
            }else{
                rta=rta + " HD: - ";
            }
            rta=rta+"\n";
            rta=rta+toStringAux(nodo.getIzquierdo());
            rta=rta+toStringAux(nodo.getDerecho());
        }

        return rta;
    }

    public Lista frontera(){
        Lista rta=new Lista();
        fronteraAux(this.raiz, rta);
        return rta;
    }

    private void fronteraAux(NodoArbol nodo, Lista lista){
        if(nodo!=null){
            if(nodo.getIzquierdo()==null && nodo.getDerecho()==null){
                lista.insertar(nodo.getElem(), lista.longitud()+1);
            }else{
                fronteraAux(nodo.getIzquierdo(), lista);
                fronteraAux(nodo.getDerecho(), lista);
            }
        }
    }

}

