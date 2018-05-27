/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadetrabajo11;

import org.junit.Test;
import static org.junit.Assert.*;

/** Pruebas unitarias de la implementacion de grafos
 *  Se usan los metodos de la clase Graph por lo se preuban tambien los métodos aca
 * @author paulb
 */
public class ImplementacionTest {
    
    public ImplementacionTest() {
    }

    /**
     * Test of hacerGrafos method, of class Implementacion.
     */
    @Test
    public void testHacerGrafos() {
        Implementacion implementacion = new Implementacion();
        Graph grafo = implementacion.hacerGrafos(); 
        assertEquals(false, grafo==null);
    }

    /**
     * Test of centroDelGrafo method, of class Implementacion.
     */
    @Test
    public void testCentroDelGrafo() {
        Implementacion implementacion = new Implementacion();
        Graph grafo = implementacion.hacerGrafos(); 
        assertEquals("No hay ninguna ciudad que sea el centro", implementacion.centroDelGrafo(grafo.getVertices() ,grafo.getAdjList()));
    }

    /**
     * Test of caminoMasCorto method, of class Implementacion.
     */
    @Test
    public void testCaminoMasCorto() {
         Implementacion implementacion = new Implementacion();
        Graph grafo = implementacion.hacerGrafos(); 
        assertEquals("Guatemala,Antigua 48 Km",implementacion.caminoMasCorto(grafo.getVertices() ,grafo.getAdjList(), "Guatemala", "Antigua"));
    }

    /**
     * Test of hacerMatriz method, of class Implementacion.
     */
    @Test
    public void testHacerMatriz() {
        //El metodo se utiliza en todos los metodos anteriores
    }

    /**
     * Test of Crear method, of class Implementacion.
     */
   
    
}
