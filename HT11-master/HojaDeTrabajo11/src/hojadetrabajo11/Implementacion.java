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
     * Busca la posicion de un elemento especifico en una lista de vertices
     * @param listaVertex: La lista de los vertices
     * @param elemento: el elemento a buscar
     * @return: La poicion del elemento
     */
    public int devolverPosicion(Vertex[] listaVertex, Vertex elemento){                
        
        int posicion=0;
        
        for (int i = 0; i < listaVertex.length; i++) {
            
            if (listaVertex[i].equals(elemento)){
                
                posicion = i;                
            }            
        }
        
        return posicion;
    }
    
    /**
     * Metodo que crea la matriz de adyacencia
     * @param listaVertex: La lista de los vertices
     * @param listaEdge: La lista de aristas
     * @return 
     * @return: La matriz de aydacencia
     */
    
    public int[][] hacerMatriz(Set listaVertex, Map<String, Map<String, Integer >> listaEdge){
        
        int[][] matriz = new int[listaVertex.size()][listaVertex.size()];
        
        for (int i = 0; i < listaVertex.size(); i++) {
            for (int j = 0; j < listaVertex.size(); j++) {
                matriz[i][j] = -1;
                if (listaEdge.containsKey(listaVertex.toArray()[i])){
                    if (listaEdge.get(listaVertex.toArray()[i]).containsKey(listaVertex.toArray()[j])){
                        matriz[i][j] = (listaEdge.get(listaVertex.toArray()[i]).get(listaVertex.toArray()[j]));
                    }
                } 
                /*
                if (listaEdge.get(listaVertex.toArray()[i]).containsKey(listaVertex.toArray()[j])){
                    matriz[i][j] = listaEdge.get(listaVertex.toArray()[i]).get(listaVertex.toArray()[j]);
                } else {
                    matriz[i][j] = -1;
                }
                */
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
