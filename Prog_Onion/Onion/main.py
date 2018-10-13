#!/usr/bin/python
#autor: Lidia
import sys
import signal
import onionGpio

# importamos archivo phython en donde realizamos la consulta del estado de la variable de estado del switch en la DB
from Conexion import*
from Conexion1 import*

#Creamos objetos tipo GPIOS en este caso usaremos los pines 1 y 2.
#
gpioObj = onionGpio.OnionGpio(1)
gpioObj1 = onionGpio.OnionGpio(2)


#Se inicializan los GPIO como salidas  en estado bajo
#
status  = gpioObj.setOutputDirection(0)
status1 = gpioObj1.setOutputDirection(0)


# Definimos la funcion procesa en donde recibe como parametro el estado del switch
def procesa(respuesta):
    print respuesta

    if respuesta:
        # si el swith esta encendido seteamos el gpio en estado alto
        status  = gpioObj.setValue(1)

    else:
       # En caso que el swtich este apagado seteamos el GPIO en bajo
        status  = gpioObj.setValue(0)

    sys.stdout.flush()


# Definimos la misma funcion para un segundo GPIO
def procesa1(respuesta1):
    print respuesta1

    if respuesta1:
        status1 = gpioObj1.setValue(1)

    else:

        status1 = gpioObj1.setValue(0)

    sys.stdout.flush()



try:
        print "Inicio"
        t = Conexion(procesa)
        t.daemon=True
        t.start()

        t1 = Conexion1(procesa1)
        t1.daemon=True
        t1.start()


        signal.pause()

except (KeyboardInterrupt, SystemExit):
        raise
        print "Bye bye"
