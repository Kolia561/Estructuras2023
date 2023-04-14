package edat.estructuras2023.Lineales;

import edat.estructuras2023.Lineales.Dinamicas.Lista;

public class TestingLista {


    static String sOk = "OK";
    static String sErr = "ERROR";

    public static void main(String[] args) {

        System.out.println("Testing Lista");
        System.out.println("-------------");

        Lista lista = new Lista();

        System.out.println("Insertar 1 en la posicion 1: " + (lista.insertar(1, 1) ? sOk : sErr));
        System.out.println("Insertar 2 en la posicion 2: " + (lista.insertar(2, 2) ? sOk : sErr));
        System.out.println("Insertar 3 en la posicion 3: " + (lista.insertar(3, 3) ? sOk : sErr));
        System.out.println("Insertar 4 en la posicion 4: " + (lista.insertar(4, 4) ? sOk : sErr));
        
        System.out.println("Insertar 5 en la posicion 5: " + (lista.insertar(5, 5) ? sOk : sErr));
        System.out.println("Insertar 6 en la posicion 6: " + (lista.insertar(6, 6) ? sOk : sErr));
        System.out.println("Insertar 7 en la posicion 7: " + (lista.insertar(7, 7) ? sOk : sErr));
        System.out.println("Insertar 8 en la posicion 8: " + (lista.insertar(8, 8) ? sOk : sErr));
        System.out.println("Insertar 9 en la posicion 9: " + (lista.insertar(9, 9) ? sOk : sErr));
        System.out.println("Insertar 10 en la posicion 10: " + (lista.insertar(10, 10) ? sOk : sErr));
        System.out.println("Insertar 11 en la posicion 11: " + (lista.insertar(11, 11) ? sOk : sErr));
        System.out.println("Insertar 12 en la posicion 12: " + (lista.insertar(12, 12) ? sOk : sErr));
        System.out.println("Insertar 13 en la posicion 13: " + (lista.insertar(13, 13) ? sOk : sErr));
        System.out.println("Insertar 14 en la posicion 14: " + (lista.insertar(14, 14) ? sOk : sErr));

        System.out.println("espera \t ( [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [11] [12] [13] [14] )");
        System.out.println("obtengo \t ( " + lista.toString() + " )");


        System.out.println("Eliminar en la posicion 1: " + (lista.eliminar(1) ? sOk : sErr)+ "\t\t" +lista.toString());
        System.out.println("Eliminar en la posicion 2: " + (lista.eliminar(2) ? sOk : sErr)+ "\t\t" +lista.toString());
        System.out.println("Eliminar en la posicion 3: " + (lista.eliminar(3) ? sOk : sErr)+ "\t\t" +lista.toString());
        System.out.println("Eliminar en la posicion 4: " + (lista.eliminar(4) ? sOk : sErr)+ "\t\t" +lista.toString());
        System.out.println("Eliminar en la posicion 5: " + (lista.eliminar(5) ? sOk : sErr)+ "\t\t" +lista.toString());
        System.out.println("Eliminar en la posicion 6: " + (lista.eliminar(6) ? sOk : sErr)+ "\t\t" +lista.toString());

        System.out.println("espera \t\t\t ( [2] [4] [6] [8] [10] [12] [13] [14] )");
        System.out.println("obtengo \t\t\t ( " + lista.toString() + " )");


        System.out.println("Insertar 15 en la posicion 1: " + (lista.insertar(15, 1) ? sOk : sErr));

        if(lista.recuperar(1).equals(15)){
            System.out.println("Si apilo correctamente al inicio debera obtener 15: " + sOk);
        }

        System.out.println("espera \t ( [15] [2] [4] [6] [8] [10] [12] [13] [14] )");
        System.out.println("obtenido \t " + lista.toString());
        System.out.println("Longitud esperada: 9"+ (lista.longitud()== 9 ? sOk : sErr));

        Lista lista2 = lista.clone();

        System.out.println("Clonar lista: " + (lista2 != null ? sOk : sErr)+ 
        " (espera: [15] [2] [4] [6] [8] [10] [12] [13] [14] )"+" (obtenido: "+lista2.toString()+")");

        while(!lista.esVacia()){
            System.out.println("Elimina pos 1: " + (lista.eliminar(1) ? sOk : sErr)+"\t--> " + lista.toString()+"longitud: "+lista.longitud());
           
        }

        System.out.println("Se vacio la lista: " + (lista.esVacia() ? sOk : sErr));
        System.out.println("Eliminar en lista vacia espera false: " + (!lista.eliminar(1) ? sOk : sErr));
        System.out.println("Recuperar en lista vacia espera null: " + (lista.recuperar(1) == null ? sOk : sErr));

        System.out.println("Verificar que la lista clonada no se modifico: " + (lista2.toString().equals("( [15] [2] [4] [6] [8] [10] [12] [13] [14] )") ? sOk : sErr)+ "\t" +lista2.toString());

        System.out.println("Insertar 1 en la posicion 2: " + (lista2.insertar(1, 2) ? sOk : sErr)+ "\t\t\t\t" +lista2.toString());
        System.out.println("Insertar 3 en la posicion 4: " + (lista2.insertar(3, 4) ? sOk : sErr)+ "\t\t\t\t" +lista2.toString());
        System.out.println("Insertar 5 en la posicion 6: " + (lista2.insertar(5, 6) ? sOk : sErr)+ "\t\t\t\t" +lista2.toString());
        System.out.println("Insertar 7 en la posicion 8: " + (lista2.insertar(7, 8) ? sOk : sErr)+ "\t\t\t\t" +lista2.toString());
        System.out.println("Insertar 9 en la posicion 10: " + (lista2.insertar(9, 10) ? sOk : sErr)+ "\t\t\t" +lista2.toString());
        System.out.println("Insertar 11 en la posicion 12: " + (lista2.insertar(11, 12) ? sOk : sErr)+ "\t\t\t" +lista2.toString());
        
        System.out.println("Eliminar en la posicion 3: "+ (lista2.eliminar(3) ? sOk : sErr)+ "\t\t\t\t" +lista2.toString());
        System.out.println("Eliminar en la posicion 5: "+ (lista2.eliminar(5) ? sOk : sErr)+ "\t\t\t\t" +lista2.toString());
        System.out.println("Eliminar en la posicion 7: "+ (lista2.eliminar(7) ? sOk : sErr)+ "\t\t\t\t" +lista2.toString());
        
    }
    
}