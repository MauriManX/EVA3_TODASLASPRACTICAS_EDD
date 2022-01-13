/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class EVA3_2_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] datos = new int[20];
        llenar(datos);
        imprimir(datos);
        selectionSort(datos);
        imprimir(datos);
        Scanner input = new Scanner(System.in);
        System.out.println("¿Qué número quieres encontrar");
        int iNum = input.nextInt();
        int iPos = binarySearch(datos,iNum);
        System.out.println("Ese número está en la posición "+iPos+" del arreglo");
    }
    
    public static int binarySearch(int[] datos, int valBuscar){
        return binarySearchRecu(datos,valBuscar,0,datos.length-1);
    }
    public static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin){
        int iMid, iResu;
                iMid = ini + ((fin-ini)/2);//Posición a la midad del arreglo
                iResu = -1;//
                if(fin >= ini){//buscamos
                    if(valBuscar == datos[iMid]){//El valor está a la mitad
                        iResu = iMid;
                    }else if(valBuscar < datos[iMid]){//No está a la mitad pero puede estar a la izquierda
                        //Llamamos recursivamente al metodo
                        iResu = binarySearchRecu(datos, valBuscar,ini,iMid-1);
                        
                    }else{
                        iResu = binarySearchRecu(datos, valBuscar,iMid+1,fin);
                    }
                }
                return iResu;
    }
    public static void llenar (int[] datos){
            for(int i=0; i<datos.length;i++){
                datos[i] = (int)(Math.random()*100);
            }
    }
    public static void imprimir (int[] datos){
            for(int i=0; i<datos.length;i++){
                System.out.print("["+datos[i]+"]");
            }
            System.out.println("");
        }
        
        public static void selectionSort(int [] datos){
            for (int i =0; i<datos.length; i++){
                int iMin = i; //Empieza el algoritmo. El mínimo es el primer elemento
                for(int j = i+1; j< datos.length; j++){//Buscar la posicion del valor más bajo
                    //Comprar valor[j] vs valor[min]
                    if(datos[j]<datos[iMin]){//Se compara el actual contra el minimo actual
                        iMin = j;
                    }
                }
                //Intercambio
                if(i != iMin){
                //3 Pasos
                //Se respalda un valor
                int iTemp = datos[i];
                //Se intercambia el valor
                datos[i]=datos[iMin];
                //Reponer el valor respaldado
                datos[iMin] = iTemp;
                }
            }
        
    }
    
}
