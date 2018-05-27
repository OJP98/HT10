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
        int decision2;
        boolean power = true;
        Scanner teclado = new Scanner(System.in);
        
        Implementacion implementacion = new Implementacion();
        
        System.out.println("Bienvenido al programa!");
        System.out.println("Creando los grafos...");
     
        grafo = hacerGrafos();    
                       
        int[][] matriz = implementacion.hacerMatriz(grafo.getVertices() ,grafo.getAdjList() );        
        Set vertices = grafo.getVertices();
        implementacion.mostarMatriz(matriz);
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
                for (int i = 0; i < grafo.getVertices().size(); i++){
                    System.out.println(grafo.getVertices().toArray()[i]);
                }
                System.out.println("Por favor ingrese la ciudad1 y la ciudad 2: ");
                teclado.nextLine();
                String ciudad1 = teclado.nextLine();
                String ciudad2 = teclado.nextLine();
                if (grafo.getVertices().contains(ciudad1) && grafo.getVertices().contains(ciudad2)) {
                    System.out.print(implementacion.caminoMasCorto(grafo.getVertices() ,grafo.getAdjList(), ciudad1, ciudad2));
                } else {
                    System.out.print("Ciudades no existentes");
                }
                
            } else if (decision==2){
                
                System.out.println(implementacion.centroDelGrafo(grafo.getVertices() ,grafo.getAdjList()));
                
            } else if (decision==3) {
                
                System.out.println("\nSeleccione la modificacion:");
                System.out.println("1. Interrupcion de trafico entre un par de ciudades");
                System.out.println("2. Conexion entre ciudades");
                System.out.print("\nDecision: ");
                
                while (!teclado.hasNextInt()) {
                    System.err.println("\nCaracter no valido"); 
                    System.out.print("Por favor ingrese una opcion valida: ");
                    teclado.next();            
                }
                
                decision2 = teclado.nextInt();
                if (decision2==1) {
                    for (int i = 0; i < grafo.getVertices().size(); i++){
                        System.out.println(grafo.getVertices().toArray()[i]);
                    }
                    System.out.println("Por favor ingrese la ciudad1 y la ciudad 2: ");
                    teclado.nextLine();
                    String ciudad1 = teclado.nextLine();
                    String ciudad2 = teclado.nextLine();
                    if (grafo.getVertices().contains(ciudad1) && grafo.getVertices().contains(ciudad2)) {
                        //Si hay trafico se agregan 10km a la distancia
                        int distancia = (int)grafo.getEdge(ciudad1, ciudad2)+ 10;
                        grafo.addEdge(ciudad1, ciudad2, distancia);
                    } else {
                        System.out.print("Ciudades no existentes");
                    }
                } else if (decision2==2){
                    System.out.println("Por favor ingrese la ciudad 1 y la ciudad 2: ");
                    teclado.nextLine();
                    String ciudad1 = teclado.nextLine();
                    String ciudad2 = teclado.nextLine();
                    System.out.println("Por favor ingrese la distancia: ");
                    int distancia = teclado.nextInt();
                    grafo.addEdge(ciudad1, ciudad2, distancia);
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
