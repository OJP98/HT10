/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadetrabajo11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class Implementacion<E> {
    
    /**
     * Lectura del archivo txt y creacion del grafo
     * @return: El grafo creado
     */
    public static Graph hacerGrafos(){
        
        File archivo = null;
        FileReader fr = null;
        FileReader frr = null;
        BufferedReader br = null;
        BufferedReader brr = null;      
        Graph grafo = new Graph(); 
          
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader("guategrafo.txt");
            br = new BufferedReader(fr);

            // Lectura del fichero        
            String[] partes;
            String linea;
            String Ciudad1;
            String Ciudad2;
            String DistanciaStr;
            int Distancia;                                  
            
            while((linea=br.readLine())!=null){                                                  

                partes = linea.split(" ");
                Ciudad1 = partes[0];          
                Ciudad2 = partes[1];
                DistanciaStr = partes[2];                
                Distancia = Integer.parseInt(DistanciaStr);       
                grafo.addEdge(Ciudad1,Ciudad2,Distancia);

            }                
        } catch(IOException e){
            
    } finally {
            
        // En el finally cerramos el fichero, para asegurarnos
        // que se cierra tanto si todo va bien como si salta 
        // una excepcion.
        try{                    
            if( null != fr ){   
               fr.close();     
            }                  
        }catch (IOException e2){ }         
    }                    
        return grafo;        
    } 
    /**
     * Busca el centro del grafo
     * @param listaVertex: La lista de los vertices
     * @param elemento: el elemento a buscar
     * @return: El centro del grafo
     */
    public String centroDelGrafo(Set listaVertex, Map<String, Map<String, Integer >> listaEdge){
         int[][] matriz =  hacerMatriz(listaVertex,listaEdge);
         for (int i = 0; i < listaVertex.size(); i++) {
            boolean centro = true;
            for (int j = 0; j < listaVertex.size()-1; j++) {
                if ((i!=j)&&((i+1)!=(j+1))){
                    if ((matriz[i][j]!=matriz[i][j+1])||(100000==matriz[i][j])){
                        centro = false;
                    }
                }
            }
            if (centro){
                return "El centro es: "+listaVertex.toArray()[i];
            }
         }
         return "No hay ninguna ciudad que sea el centro";
    }
   
    
    /**
     * Metodo para el camino mas corto
     * @param listaVertex: La lista de los vertices
     * @param listaEdge: La lista de aristas
     * @return 
     * @return: Vector con el camino más corto
     */
    public String caminoMasCorto(Set listaVertex, Map<String, Map<String, Integer >> listaEdge,String ciudad1,String ciudad2){
        int[][] matrizValores = Crear(listaVertex ,listaEdge );
        String [][] matriz = new String[listaVertex.size()][listaVertex.size()];
        for (int i = 0; i < listaVertex.size(); i++) {
            for (int j = 0; j < listaVertex.size(); j++) {
                matriz[i][j] = "Camino no disponible";
                if (listaEdge.containsKey(listaVertex.toArray()[i])){
                    if (listaEdge.get(listaVertex.toArray()[i]).containsKey(listaVertex.toArray()[j])){
                        matriz[i][j] = ",";
                    }
                } 
            }  
        } 
        // Algoritmo de Floyd
        for (int i = 0; i < listaVertex.size(); i++) {
            for (int j = 0; j < listaVertex.size(); j++) {
               for (int k = 0; k < listaVertex.size(); k++) {
                   if (matrizValores[i][j]>(matrizValores[i][k] + (matrizValores[k][j]))){
                       matrizValores[i][j] = matrizValores[i][k] + matrizValores[k][j];
                       matriz[i][j] = matriz[i][j] + listaVertex.toArray()[k] + ",";
                   }
               } 
            }  
        } 
        //Obtener la poscion de las ciudades que se requisita
        int x = 0;
        int y = 0;
        for (int i = 0; i < listaVertex.size(); i++) {
            if (listaVertex.toArray()[i].equals(ciudad1)){
                x = i;
            }
            if (listaVertex.toArray()[i].equals(ciudad2)){
                y = i;
            }
        }
        
        String ciudades = matriz[x][y];
        if (ciudades.equals("Camino no disponible")) {
            return "Camino no disponible";
        } else {
            return ciudad1+ciudades+ciudad2+" "+matrizValores[x][y]+" Km";
        }
    }
    
    /**
     * Metodo que crea la matriz de adyacencia
     * @param listaVertex: La lista de los vertices
     * @param listaEdge: La lista de aristas
     * @return 
     * @return: La matriz de aydacencia
     */
    public int[][] hacerMatriz(Set listaVertex, Map<String, Map<String, Integer >> listaEdge){
        
        int[][] matriz = Crear(listaVertex ,listaEdge );
        // Algoritmo de Floyd
        for (int i = 0; i < listaVertex.size(); i++) {
            for (int j = 0; j < listaVertex.size(); j++) {
               for (int k = 0; k < listaVertex.size(); k++) {
                   if (matriz[i][j]>(matriz[i][k] + (matriz[k][j]))){
                       matriz[i][j] = matriz[i][k] + matriz[k][j];
                   }
               } 
            }  
        } 
        return matriz;
    }
    /**
     * Metodo que crea la matriz de adyacencia sin floyd
     * @param listaVertex: La lista de los vertices
     * @param listaEdge: La lista de aristas
     * @return 
     * @return: La matriz de aydacencia
     */
    public int[][] Crear(Set listaVertex, Map<String, Map<String, Integer >> listaEdge){
        int[][] matriz = new int[listaVertex.size()][listaVertex.size()];
        
        for (int i = 0; i < listaVertex.size(); i++) {
            for (int j = 0; j < listaVertex.size(); j++) {
                matriz[i][j] = 100000;
                if (i==j){
                  matriz[i][j] = 0;  
                }
                if (listaEdge.containsKey(listaVertex.toArray()[i])){
                    if (listaEdge.get(listaVertex.toArray()[i]).containsKey(listaVertex.toArray()[j])){
                        matriz[i][j] = (listaEdge.get(listaVertex.toArray()[i]).get(listaVertex.toArray()[j]));
                    }
                } 
            }  
        } 
        return matriz;
    }
    /**
     * Metodo que imprime cada fila y columna de la matriz
     * @param matriz: La matriz que se quiere imprimir
     */
    public void mostarMatriz(int matriz[][]){
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+"    "); 
            }            
            System.out.println();
        }        
        System.out.println();
        
    }
    
}
