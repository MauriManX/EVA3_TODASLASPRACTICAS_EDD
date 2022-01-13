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
        int [] datos1 = new int[datos.length];
        int [] datos2 = new int[datos.length];
        int [] datos3 = new int[datos.length];
        int [] datos4 = new int[datos.length];
        long iniT, finT;
        llenar(datos);//Se llena el arreglo con valores aleatorios
        
        //Arreglos con los que se trabajará
        copiar(datos,datos1);
        copiar(datos,datos2);
        copiar(datos,datos3);
        copiar(datos,datos4);
        
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
        //4
        System.out.println("4. Prueba con Quick Sort: ");
        imprimir(datos4);//Se imprime el arreglo
        iniT=System.nanoTime();
        quickSort(datos4);
        finT=System.nanoTime();
        imprimir(datos4);
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
        
        //QuickSort de arranque
        //
        public static void quickSort(int[] datos){
            recuQuickSort(datos,0,datos.length-1); //QuickSort a todo el arreglo
        }
        
        public static void recuQuickSort(int[] datos, int ini, int fin){
            int iPivote; //inicio
            int too_big; //Buscar a los más grandes que el pivote
            int too_small; //Buscar a los más pequeños que el pivote
            boolean stopBig = false, stopSmall = false;
            //Controlar la recursividad
            int tama = fin -ini + 1;
            if(tama > 1){//¿Cuando SÍ puedo realizar QuickSort?
                iPivote = ini;
                too_big = ini + 1;
                too_small = fin;
                for(int i = ini+1 ;i<=fin; i++){//Numero de veces a recorrer
                    if(datos[too_big] < datos[iPivote] && (!stopBig)){//Se avanza
                        too_big++;
                    }else{
                        stopBig = true;// Se detiene cuando encuentra uno más grande
                        
                    }
                    if(datos[too_small] >= datos[iPivote] && (!stopSmall)){//Se retrocede
                        too_small--;//Retrocede
                    }else{
                        stopSmall = true;// Se detiene cuando encuentra uno más pequeño
                        
                    }
                    //Ambos se detienen (swap)
                    if(stopBig && stopSmall){
                        if (too_big<too_small){
                            int temp = datos[too_big];
                            datos[too_big] = datos[too_small];
                            datos[too_small] = temp;
                            //Sigue avanzando
                            stopBig=false;
                            stopSmall=false;
                        }else
                            break;//Termina el ciclo
                    }
                    
                }
                //intercabio el pivote
                int temp = datos[iPivote];
                datos[iPivote] = datos[too_small];
                datos[too_small] = temp;
                iPivote = too_small; //Ta,bién cambia la posición del pivote
                //quicksort (izq)
                recuQuickSort(datos,ini, iPivote-1);
                //quicksort (der)
                recuQuickSort(datos, iPivote+1,fin);
                
                
            }
        }
}

        
