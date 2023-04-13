package edat.estructuras2023.Lineales.Dinamicas;

public class Lista{

    private Nodo cabecera;
    private int longitud;

    public Lista(){
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar (Object nuevoElem, int pos){
        boolean exito = false;

        if(pos>0 && longitud-pos >= 0){

            if(pos == 1){
                Nodo nuevoNodo = new Nodo(nuevoElem, this.cabecera);
                this.cabecera = nuevoNodo;
            }else{
                Nodo aux = this.cabecera;
                int i = 1;
                while(i < pos-1){
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevoNodo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevoNodo);
            }
            this.longitud++;

            exito = true;
        }

        return exito;
    }

    public boolean eliminar (int pos){

        boolean exito = false;

        if(pos>0 && longitud-pos > 0){

            if(pos == 1){
                this.cabecera = this.cabecera.getEnlace();
            }else{
                Nodo aux = this.cabecera;
                int i = 1;
                while(i < pos-1){
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;

            exito = true;
        }
    return exito;
    }

    public Object recuperar (int pos){

        Object rta=null;

        if (pos>0 && longitud-pos>0){

            if (pos == 1){
                rta=this.cabecera.getElem();
            }else{
                Nodo aux=this.cabecera;
                int i = 1;
                while(i < pos){
                    aux = aux.getEnlace();
                    i++;
                }
                rta=aux.getElem();
            }

        }

        return Object;

    }

    public int localizar (Object elem){

        int rta=-1;
        

        if (elem!=null && longitud > 0){

            if(this.cabecera.getElem().equals(elem)){

                rta=1;
            }else{

                int i = 2;
                boolean exito=falso;
                Nodo aux = this.cabecera;
    
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

        if (this.cabecera!=null){

            rta=true;
        }

    
        return rta;
    }

    public Lista Clone(){

        Lista clon= new Lista();

        if(longitud>0){

        int i=1;
        Nodo aux = this.cabecera;
        while(i<=this.longitud){

            clon.insertar(aux.getElem(), i);
            aux=aux.getEnlace();
            i++;

        }


        }
        return clon;
    }

    public String toString(){

        String rta="( ";

        if(longitud>0){
        int i=1;

        Nodo aux=this.cabecera;

            while(i<=longitud){

                String sAux="[";
                sAux+=aux.getElem().toString();
                sAux+="]";

                rta+=sAux;
                aux=aux.getEnlace();
                i++;

            }

        }

        rta+=" )";

        return rta;
    }
}