/*
@autor: Lidia Cana

*/

$(document).ready(function() {

  //creamos un objeto de firebase, y le pasamos la URL como parametro
  var ref = new Firebase("https://prueba1-aed02.firebaseio.com/");
  /*****************************************************************
   Obtenemos el valor del .ltimo estado
  ******************************************************************/
  ref.once("value", function(res) {

    var luzSala = res.child("led").val();
    $('#switch').attr('checked', luzSala); //
    console.log("Estado actual: " +luzSala)

  });
 /*****************************************************************
   Obtenemos el valor del estado de la luz en tiempo real,
   cada vez que haya cambio
  ******************************************************************/
  ref.on("child_changed", function(res) {

    var luz_sala = res.val();
    $('#switch').prop('checked', luz_sala);
    console.log("Cambio de estado: " +luz_sala)

  });

 /*****************************************************************
   Actualizamos el valor, cambiado el estado del Switch
  ******************************************************************/
 $('#switch').on('change', function(){
     if(this.checked)
      {
          console.log("On")
          ref.update({ led: true });
          led.writeSync(1);
         
        }
      else{
          console.log("Off")
          ref.update({ led: false });
          
         }
    });

});
