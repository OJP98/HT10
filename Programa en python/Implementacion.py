# Universidad del Valle de Guatemala
# Algoritmos y estructura de datos
# Hoja de trabajo 11
# Fecha: 25/05/2018
# Colaboradores:    
    # Oscar Juarez - 17315
    # Paul Belches - 17088

import networkx as nx

errorRuta = "\nError!\nLas ciudades ingresadas no poseen una ruta directa"

G = nx.DiGraph()

def hacerGrafo():

    #Se abre el archivo txr
    file = open("guategrafo.txt","r+")

    #Se ingresa al grafo cada linea de contenido
    for line in file:
        content = line.split(" ")
        ciudad1 = content[0]
        ciudad2 = content[1]
        distancia = float(content[2])

        #Se crean todas las relaciones de las ciudades
        G.add_edge(ciudad1,ciudad2,weight=distancia)

    file.close()     


#Imprime todas las ciudades del archivo txt
def imprimirCiudades():
    Nodes = G.nodes()
    print ("\nLas ciudades son las siguientes: ")
    print ("\n".join(Nodes))
    

#Retorna 2 ciudades seleccionadas por el usuario
def seleccionarCiudades():
    
    Nodes = G.nodes()
    print ("\nLas ciudades son las siguientes: ")
    print ("\n".join(Nodes))

    #Se ingresa la ciudad origen (con validacion)
    ciudadOrigen = input("\nIngrese el nombre de la ciudad origen: ")    

    while ciudadOrigen not in Nodes:        
        ciudadOrigen = input("\nError!\nIngrese una ciudad de la lista: ")


    #Se ingresa la ciudad destino (con validacion)
    ciudadDestino = input("\nIngrese el nombre de la ciudad destino: ")
    
    while ciudadDestino == ciudadOrigen or ciudadDestino not in Nodes:

        if (ciudadDestino == ciudadOrigen):
            ciudadDestino = input("\nError!\nLa ciudad destino debe ser diferente a la ciudad de origen\nIngrese el nombre de la ciudad destino: ")
            
        else:                
            ciudadDestino = input("\nError!\nIngrese una ciudad de la lista: ")

    return ciudadOrigen,ciudadDestino


#Imprime la ruta mas corta entre dos ciudades
def rutaCorta(ciudadOrigen,ciudadDestino):

    ciudadesInt = []
    control = True

    #Se instancia el grafo junto con los caminos en el    
    path = nx.floyd_warshall_predecessor_and_distance(G)    

    try: 
        #Se halla por donde pasa el nodo para llegar a dicha ciudad
        intermedia = path[0][ciudadOrigen][ciudadDestino]
        distancia = path[1][ciudadOrigen][ciudadDestino]
        ciudadesInt.append(intermedia)

        
        while control:

            #Si la ciudad es diferente a donde empezo, se agrega a una
            #lista para saber por donde pasar
            if not(intermedia == ciudadOrigen):
                intermedia1 = path[0][ciudadOrigen][intermedia]
                ciudadesInt.append(intermedia1)
                intermedia = intermedia1
                
            else:
                control = False

        #Se ordena inversamente la lista
        ciudadesInt.reverse()

        #Se imprimen los resultados finales
        print ("\nLa ruta mas corta entre es pasando por: ")
        print (", ".join(ciudadesInt),",",ciudadDestino)
        print ("\nLa distancia total es de", distancia, "km")
        

    except KeyError:
        print (errorRuta)                


#Metodo que agrega una distancia a una arista
def hayTrafico(ciudadOrigen, ciudadDestino):    

    #Se instancian los caminos
    paths = nx.floyd_warshall_predecessor_and_distance(G)

    #Se consigue la distancia actual de los vertices
    try:
        distanciaActual = paths[1][ciudadOrigen][ciudadDestino]
        
    except KeyError:
            print (errorRuta)

    #Si existe una distancia, se le agregan 10 km
    if (distanciaActual!=0):
        try:            
            G[ciudadOrigen][ciudadDestino]['weight'] = 10 + distanciaActual
            print("Agregando 10 km a la distancia para simular el trafico")
        
        except KeyError:
            print (errorRuta)


#Crea una conexion entre dos ciudades
def establecerConexion(ciudad1, ciudad2, distancia):

    #Se valida que el valor ingresado sea un numero entero
    try:
       distancia = int(distancia)       
    except ValueError:
       print("\nError!\nLa distancia ingresada no es un numero")
       return ""

    #Se abre el documento txt, se escribe la ciudad ingresada y se procede a cerrar
    file = open("guategrafo.txt","r+")
    lineas = file.readlines()
    file.write("\n"+ciudad1+" "+ciudad2+" "+str(distancia))
    file.close()

    #Se vuelven a crear los grafos
    hacerGrafo()            

    print("Conexion establecida con exito!")


#Retorna la ciudad en el centro del grafo
def centroGrafo():

    G = nx.Graph()
    
    graphCenter = nx.center(G)
    print ("Las posibles ciudades en el centro son: "+"\n".join(graphCenter))


