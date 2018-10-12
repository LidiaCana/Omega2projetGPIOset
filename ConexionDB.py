import onionGpio
from firebase import firebase
import threading
import time

class ConexionDB(threading.Thread):



    def __init__(self, cb):
        threading.Thread.__init__(self)
        self.callback = cb

        # Inicializamos un objeto firebase con la direccion de nuestra DB en Firebase
        self.fire = firebase.FirebaseApplication('https://prueba1-aed02.firebaseio.com/', None)

         # Obtenemos el estado actual de la variable de control
        self.ultimo_estado0 = self.fire.get('/led', None)
        
        # Retornamos a la funcion que nos llamo el estado actual de la variable de control
        self.callback(self.ultimo_estado0)

    def run(self):

               # Variable de control para revisar si hubo un cambio en la DB de ser asi hacemos el cambio de estado en nuestro GPIO
                E = []
                E.append(self.ultimo_estado0) # Guardamos el primer resultado de la primera consulta 
                i = 0
                

                while True:
                        self.fire = firebase.FirebaseApplication('https://prueba1-aed02.firebaseio.com/', None)
                        estado_actual0 = self.fire.get('/led', None)
                        
                        E.append(estado_actual0) # Al volver a consultar guardamos el resultado en otro indice de arreglo E
                        
                        if E[i] != E[-1]: # Comparamos si ha habido algun cambio en la variable de control de DB consultada.
                                self.callback(estado_actual0) # Si es asi enviamos a la funcion principal es estado al que se cambio

                        del E[0]
                        i = i+i
                        time.sleep(0.1)
