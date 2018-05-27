# Universidad del Valle de Guatemala
# Algoritmos y estructura de datos
# Hoja de trabajo 11
# Fecha: 25/05/2018
# Colaboradores:    
    # Oscar Juarez - 17315
    # Paul Belches - 17088

from Implementacion import *

menu = "\nLa lista de funciones es:\n1. Mostrar ruta mas corta entre 2 ciudades\n2. Nombre de la ciudad centrica\n3. Modificar el grafo\n4. Finalizar el programa\n"
power = True;

hacerGrafo()

while (power):

    print (menu)
    seleccion = input("Ingrese la accion que desea realizar: ")

    if (seleccion=="1"):

        ciudadOrigen,ciudadDestino = seleccionarCiudades()
        rutaCorta(ciudadOrigen,ciudadDestino)
        

    elif (seleccion=="2"):
        centroGrafo();        

    elif (seleccion=="3"):

        print ("\nSeleccione una de las opciones: ")
        print("a. Hay trafico entre un par de ciudades \nb. Establecer una conexion entre un par de ciudades")
        ingreso = input("\nIngrese su eleccion: ")  

        if (ingreso == "a"):
            ciudadOrigen,ciudadDestino = seleccionarCiudades()
            hayTrafico(ciudadOrigen, ciudadDestino)
            
        elif (ingreso == "b"):
            
            ciudad1,ciudad2 = seleccionarCiudades()
            distancia = input("\nIngrese la distancia entre estas ciudades: ")
            establecerConexion(ciudad1, ciudad2, distancia)
            

    elif (seleccion=="4"):
        print ("Saliendo del programa...")
        power = False;

    else:
        print ("\nPor favor ingrese una opcion valida")
    
