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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Usuario
 */
public class Implementacion {
    
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
                
                Vertex vertex1 = new Vertex(Ciudad1);
                Vertex vertex2 = new Vertex(Ciudad2);
                Edge edge = new Edge(vertex1,vertex2,Distancia);                                

                grafo.addVertex(vertex1);
                grafo.addVertex(vertex2);
                grafo.addEdge(edge);               

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
     * @return: La matriz de aydacencia
     */
    public int[][] hacerMatriz(Vertex[] listaVertex, Edge[] listaEdge){
        
        int[][] matriz = new int[listaVertex.length][listaVertex.length];

        for (int i = 0; i < listaEdge.length; i++) {

            Vertex vertice1 = listaEdge[i].v1;
            Vertex vertice2 = listaEdge[i].v2;

            int peso = listaEdge[i].weight;

            int x = devolverPosicion(listaVertex, vertice1);
            System.out.println("La posicion x de " + vertice1.getLabel() + " es: " + x);
            int y = devolverPosicion(listaVertex, vertice2);
            System.out.println("La posicion y de " + vertice2.getLabel() + " es: " + y);
            
            matriz[x][y] = peso;
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
