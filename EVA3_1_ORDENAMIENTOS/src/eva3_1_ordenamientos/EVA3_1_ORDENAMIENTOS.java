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
        int [] datos = new int[1000];
        int [] datos1 = new int[datos.length];
        int [] datos2 = new int[datos.length];
        int [] datos3 = new int[datos.length];
        long iniT, finT;
        llenar(datos);//Se llena el arreglo con valores aleatorios
        
        //Arreglos con los que se trabajará
        copiar(datos,datos1);
        copiar(datos,datos2);
        copiar(datos,datos3);
        
        //Pruebas
        //1
        System.out.println("1. Prueba con Selection Sort: ");
        imprimir(datos1);//Se imprime el arreglo
        iniT=System.nanoTime();
        selectionSort(datos1);
        finT=System.nanoTime();
        imprimir(datos1);
        System.out.println("Tiempo en ordenar: " + (finT-iniT));
        //2
        System.out.println("2. Prueba con Insertion Sort: ");
        imprimir(datos2);//Se imprime el arreglo
        iniT=System.nanoTime();
        insertionSort(datos2);
        finT=System.nanoTime();
        imprimir(datos2);
        System.out.println("Tiempo en ordenar: " + (finT-iniT));        
        //3
        System.out.println("3. Prueba con Bubble Sort: ");
        imprimir(datos3);//Se imprime el arreglo
        iniT=System.nanoTime();
        bubbleSort(datos3);
        finT=System.nanoTime();
        imprimir(datos3);
        System.out.println("Tiempo en ordenar: " + (finT-iniT));
    }
        //LLENADO del arreglo con valores aleatorios desde 0 a 99
        public static void llenar (int[] datos){
            for(int i=0; i<datos.length;i++){
                datos[i] = (int)(Math.random()*100);
            }
        }
        //COPIAS DE ARREGLOS
        public static void copiar(int[] original,int[] copia){
            for(int i=0; i<original.length;i++){
                copia[i] = original[i];
            }
        }
        //IMPRIMIR ARREGLOS
        public static void imprimir (int[] datos){
            for(int i=0; i<datos.length;i++){
                System.out.print("["+datos[i]+"]");
            }
            System.out.println("");
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
        
        public static void insertionSort(int[] datos){
            for(int i=0;i<datos.length;i++){
                int temp = datos[i]; //Valor a insertar
                int insP = i; //Posicion donde vamos a insertar
                for(int prev = i - 1;prev>=0;prev--){//Busca donde insertar
                    if(datos[prev]>temp){
                        datos[insP] = datos[prev];//movemos valor de prev a la posición insP
                        insP--;//retrocede una posicion
                        
                    }else{
                        break;
                    }
                }
                datos[insP]=temp; //Insertamos
            }
        }
        public static void bubbleSort(int[] datos){
            for(int i=0;i<datos.length;i++){
                for(int j=0;j<(datos.length-1);j++){//Comprara e intercambia
                    //Comparamos j vs j+1
                    //Intercambiamos
                    if(datos[j]> datos[j+1]){
                        int temp = datos[j];
                        datos[j] = datos[j+1];
                        datos[j+1] = temp;
                    }
                }
            }
        }
}

        
