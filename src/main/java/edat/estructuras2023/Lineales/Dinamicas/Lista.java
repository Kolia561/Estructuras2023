package edat.estructuras2023.Lineales.Dinamicas;



public class Lista<T>{

    private Nodo<T> cabecera;
    private int longitud;

    public Lista(){
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar (T nuevoElem, int pos){
        boolean exito = false;

        if(pos>0 && pos<=(longitud+1)){
            
            //System.out.println("entro");

            if(pos == 1){
                if(this.cabecera==null){
                    Nodo<T> nuevoNodo = new Nodo<T>(nuevoElem, this.cabecera);
                    this.cabecera = nuevoNodo;
                    this.longitud=1;
                }else{
                Nodo<T> nuevoNodo = new Nodo<T>(nuevoElem, this.cabecera);
                this.cabecera = nuevoNodo;
                this.longitud++;
                }
            }else{
                Nodo<T> aux = this.cabecera;
                int i = 1;
                while(i < pos-1){
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo<T> nuevoNodo = new Nodo<T>(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevoNodo);

                this.longitud++;
            }
            exito = true;
        }

        return exito;
    }

    public boolean eliminar (int pos){

        boolean exito = false;

        if(pos>0 && pos<=this.longitud){

            if(pos == 1){
                this.cabecera = this.cabecera.getEnlace();
                this.longitud--;
            }else{
                Nodo<T> aux = this.cabecera;
                int i = 1;
                while(i < pos-1){
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
                this.longitud--;
            }
            

            exito = true;
        }
    return exito;
    }

    public T recuperar (int pos){

        T rta=null;

        if (pos>0 && longitud-pos>=0){

            if (pos == 1){
                rta=this.cabecera.getElem();
            }else{
                Nodo<T> aux=this.cabecera;
                int i = 1;
                while(i < pos){
                    aux = aux.getEnlace();
                    i++;
                }
                rta=aux.getElem();
            }

        }

        return rta;

    }

    public int localizar (T elem){

        int rta=-1;
        

        if (elem!=null && longitud > 0){

            if(this.cabecera.getElem().equals(elem)){

                rta=1;
            }else{

                int i = 2;
                boolean exito=false;
                Nodo<T> aux = this.cabecera;
    
                while(i<longitud && !exito){

                    aux=aux.getEnlace();
    
                    if(elem.equals(aux.getElem())){

                        exito=true;
                        rta=i;

                    }else{

                        i++;
                    }
            }
        
           

            }

        }


        return rta;
    }

    public void vaciar(){

        this.cabecera=null;
    }


    public boolean esVacia() {

        boolean rta=false;

        if (this.cabecera==null){

            rta=true;
        }

    
        return rta;
    }

    public int longitud(){

        return this.longitud;
    }

    public Lista<T> clone(){

        Lista<T> clon= new Lista<T>();

        if(longitud>0){

        int i=1;
        Nodo<T> aux = this.cabecera;
        while(i<=this.longitud){

            clon.insertar(aux.getElem(), i);
            aux=aux.getEnlace();
            i++;

        }


        }
        return clon;
    }

    public String toString(){

        String rta="(";

        if(longitud>0){
        

        Nodo<T> aux=this.cabecera;

            while(aux!=null){

                String sAux=" [";
                sAux+=aux.getElem().toString();
                sAux+="]";

                rta+=sAux;
                aux=aux.getEnlace();
                

            }

        }

        rta+=" )";

        return rta;
    }
}