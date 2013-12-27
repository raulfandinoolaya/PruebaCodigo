PruebaCodigo
============
Para correr la aplicación debe desde el IDE ejecutar el método main de la clase Application en el paquete view. En seguida le mostrará las instrucciones: 

"Para empezar por favor ingrese las dimensiones de la superficie:
(Valores enteros y positivos)"

Y usted deberá ingresar el número de filas y columnas de la superficie donde desea se mueva el carro, tenga en cuenta que sólo se admiten valores númericos enteros mayores a cero, y apenas haya ingresado estos dos valores se mostrará la superficie que usted configuro con el carro en la posición (0,0). Aquí un ejemplo de salida de la consola para un tablero de 3 filas y 4 columnas:

"Número de filas: 
3
Número de columnas: 
4

Área de desplazamiento: 

--- --- --- 
--- --- --- 
--- --- --- 
^.^ --- ---       

Ubicación actual: (0,0)."

Note que los caracteres: "^.^" simbolizan la posición de la superficie donde actualmente se encuentra el carro, y los caracteres "---" simbolizan posiciones libres de la misma.

De aquí en adelante usted sólo debe ingresar los comandos de movimiento del carro en el formato: 

<Desplazamiento>,<Dirección> = <comando de movimiento>
      ^               ^
      |               |
      |               |
      |           Y este se refiere a la dirección en que lo hará, será "N" hacia el norte, "S" hacia el sur, 
      |           "O" hacia el oeste (a su izquierda) y "E" hacia el este (a su derecha)
      |
    Este valor se refiere al número de posiciones que se moverá el carro

y también puede enviar una cadena de formatos de la forma:

<comando 1>;<comando 2>;....;<comando n>

Nota: Entre los valores de cada comando y los comandos se permiten espacios en blanco, no pasa lo mismo entre los números que compongan el valor del desplazamiento.

Las siguientes líneas ejemplifican el caso de mover el carro dos posiciones hacia el norte:

"Ingrese el comando o comandos de movimiento (Si desea salir digite únicamente '0'):
2,N
Movimiento realizado, nueva posición: (0,2)

Área de desplazamiento: 

--- --- --- 
^.^ --- --- 
--- --- --- 
--- --- --- 

Ubicación actual: (0,2)."

Y las siguientes mover un espacio al este y uno al sur:

"Ingrese el comando o comandos de movimiento (Si desea salir digite únicamente '0'):
1,E;1,S
Movimiento realizado, nueva posición: (1,2)
Movimiento realizado, nueva posición: (1,1)

Área de desplazamiento: 

--- --- --- 
--- --- --- 
--- ^.^ --- 
--- --- --- 

Ubicación actual: (1,1)."

En cualquier momento puede salir de la aplicación enviando como comando el caracter cero (0):

"Ingrese el comando o comandos de movimiento (Si desea salir digite únicamente '0'):
0

Gracias por usar nuestra aplicación :)"

Y eso es todo, muchas gracias por leer estas instrucciones.

Realizado por:
Raúl Fernando Fandiño Olaya
C.C. 1022948822
