package edat.estructuras2023.Lineales;
import edat.estructuras2023.Lineales.Dinamicas.Pila;

public class TestPropioPila {


    static String sOk = "OK!", sErr = "ERROR";

    public static void main(String[] arg) {
        testPila();
    }

    public static void testPila() {

        System.out.println("COMIENZO TEST PROPIO PILA");
        Pila p1 = new Pila();
        Pila p2 = new Pila();

        for (int i = 1; i <= 10; i++) {
            p1.apilar(i);
            p2.apilar(i);
        }

        System.out.print("Inicia P1 \t[1 2 3 4 5 6 7 8 9 10 ]");
        System.out.println("\t\t\t\t\t\t\t\t--> " + p1.toString());
        System.out.print("Inicia P2 \t[1 2 3 4 5 6 7 8 9 10 ]");
        System.out.println("\t\t\t\t\t\t\t\t--> " + p2.toString());

        //Apila los elementos de la pila 1 en la pila 2 si la pila es dinamica. Si no, no hace nada.
        
        System.out.println("Intenta apilar los elementos de la pila 1 en la pila 2 si la pila es dinamica.");

        if (p2.apilar(p1.obtenerTope())) {
            while (!p1.esVacia()) {
                p2.apilar(p1.obtenerTope());
                p1.desapilar();
            }

            System.out.print("espera \t[1 2 3 4 5 6 7 8 9 10 10 9 8 7 6 5 4 3 2 1]");
            System.out.println("\t\t\t\t\t\t\t\t--> " + p2.toString());
            
        }else{
           
            System.out.println("La Pila es estatica, no se puede apilar. Prodece a sumar ambas pilas");
            Pila p3 = new Pila();
            Pila cp1 = p1.clone();
            Pila cp2 = p2.clone();

            while (!cp1.esVacia()) {
                p3.apilar((int) cp1.obtenerTope() + (int) cp2.obtenerTope());
                cp1.desapilar();
                cp2.desapilar();
            }
    
            //SE MUESTRA EL CONTENIDO DE LA NUEVA PILA
            System.out.print("espera \t[ 20 18 16 14 12 10 8 6 4 2]");
            System.out.println("\t\t\t\t\t\t\t\t--> " + p3.toString());
            System.out.print(" P1 \t[1 2 3 4 5 6 7 8 9 10 ]");
            System.out.println("\t\t\t\t\t\t\t\t--> " + p1.toString());
            System.out.print(" P2 \t[1 2 3 4 5 6 7 8 9 10 ]");
            System.out.println("\t\t\t\t\t\t\t\t--> " + p2.toString());
        }

        
        }
        

        

        

        
        



    
    }
