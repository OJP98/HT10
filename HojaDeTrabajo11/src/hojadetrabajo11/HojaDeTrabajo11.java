/**
 * Algoritmos y estructura de datos - seccion 10
 * @author: Oscar Juarez - 17315
 * @author: Paul Belches - 17088
 * @version: 25.05.18
 */
package hojadetrabajo11;

import static hojadetrabajo11.Implementacion.hacerGrafos;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class HojaDeTrabajo11 {
    
    public static void main(String[] args) {
        
        Graph grafo = new Graph();
        int decision;
        boolean power = true;
        Scanner teclado = new Scanner(System.in);
        
        Implementacion implementacion = new Implementacion();
        
        System.out.println("Bienvenido al programa!");
        System.out.println("Creando los grafos...");
     
        grafo = hacerGrafos();    
        
        Set<Vertex> Vertices = grafo.getVertices();
        Set<Edge> Aristas = grafo.getEdges();
        
        Vertex[] listaVertices = Vertices.toArray(new Vertex[0]);        
        Edge[] listaAristas = Aristas.toArray(new Edge[0]);
                        
        //int[][] matriz = implementacion.hacerMatriz(listaVertices, listaAristas);
        
        //implementacion.mostarMatriz(matriz);
                
                               
        while (power) {
            
            System.out.println("\nIngrese la accion que desea realizar: ");
            System.out.println("1. Ruta mas corta");
            System.out.println("2. Ciudad centrica");
            System.out.println("3. Modificar el grafo");
            System.out.println("4. Salir");
            System.out.print("\nDecision: ");
        
            while (!teclado.hasNextInt())   
                
                {
                    System.err.println("\nCaracter no valido"); 

                    System.out.print("Por favor ingrese una opcion valida: ");
                    teclado.next();            
                }

            decision = teclado.nextInt();
            
            if (decision==1) {
                
                System.out.println("");
                
            } else if (decision==2){
                
                System.out.println("");
                
            } else if (decision==3) {
                
                System.out.println("\nSeleccione la modificacion:");
                System.out.println("   1. Interrupcion de trafico entre un par de ciudades");
                System.out.println("   2. Conexion entre ciudades");
                System.out.print("   Decision: ");
                
                while (!teclado.hasNextInt()) {
                    System.err.println("\nCaracter no valido"); 
                    System.out.print("Por favor ingrese una opcion valida: ");
                    teclado.next();            
                }
                
                decision = teclado.nextInt();
                              
                if (decision == 1) {
                    System.out.println("\nIndique el par de ciudades");
                    
                } else if (decision == 2) {
                    System.out.println("\nConexion");                    
                }
                
            } else if (decision == 4) {
                
                System.out.println("\nSaliendo del programa");
                power = false;
                
            } else {
                
                System.out.println("\nPor favor ingrese una opcion valida!");
                
            }
            
            
        }        
    }
}
