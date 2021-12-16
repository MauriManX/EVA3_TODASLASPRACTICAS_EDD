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
        
        
    }
        //LLENADO del arreglo con valores aleatorios desde 0 a 99
        public static void llenar (int[] datos){
            for(int i=0; i<datos.length;i++){
                datos[i] = (int)(Math.random());
            }
        }
        //COPIAS DE ARREGLOS
        //IMPRIMIR ARREGLOS
        public static void imprimir (int[] datos){
            for(int i=0; i<datos.length;i++){
                System.out.print("["+datos[i]+"]");
            }
        }
}
