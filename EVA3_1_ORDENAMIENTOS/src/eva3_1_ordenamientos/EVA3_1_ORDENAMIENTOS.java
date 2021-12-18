/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamientos;

/**
 *
 * @author Mauricio
 */
public class EVA3_1_ORDENAMIENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Se ordenará un arreglo de enteros
        int [] datos = new int[10];
        llenar(datos);//Se llena el arreglo con valores aleatorios
        imprimir(datos);//Se imprime el arreglo
        selectionSort(datos);
        System.out.println("");
        imprimir(datos);
        
        
    }
        //LLENADO del arreglo con valores aleatorios desde 0 a 99
        public static void llenar (int[] datos){
            for(int i=0; i<datos.length;i++){
                datos[i] = (int)(Math.random()*100);
            }
        }
        //COPIAS DE ARREGLOS
        //IMPRIMIR ARREGLOS
        public static void imprimir (int[] datos){
            for(int i=0; i<datos.length;i++){
                System.out.print("["+datos[i]+"]");
            }
        }
        
        //Eficiencia O(n^2)
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
