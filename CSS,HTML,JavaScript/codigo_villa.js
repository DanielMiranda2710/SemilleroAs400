/*
//Nota: EL canvas debe estar encima de la etiqueta script en la pagina HTML.
var villa = document.getElementById("villa");
var lienzo = villa.getContext("2d");
document.addEventListener("keydown", moverLobo);
document.addEventListener("keydown", moverVaca);
var xLobo=aleatorio(0,10);
var yLobo=aleatorio(0,10);
var xVaca=aleatorio(0,10);
var yVaca=aleatorio(0,10);
xLobo*=40;
yLobo*=40;
xVaca*=20;
yVaca*=20;
var count=0;
//Variables-objetos-Variables-objetos-Variables-objetos-Variables-objetos-Variables-objetos-//
var fondo = { //Estructura para crear una variable de varios atributos.
  url: "anatomia.png" ,//Los atributos dentro de un objeto deben separarse por coma,
  cargaOK: false
}
var vaca = {
  url: "vaca.png",
  cargaOK: false //pongo los mismos atributos que en fondo para hacer de todo una buena practica y entender como está compuesto mi objeto por dentro
}
var lobo = {
  url: "lobo.png",
  cargaOK: false
}
//Variables-objetos-Variables-objetos-Variables-objetos-Variables-objetos-Variables-objetos-//

//Creacion_de_objeto_Para_cargar_imagen-Creacion_de_objeto_Para_cargar_imagen-Creacion_de_objeto_Para_cargar_imagen-//
fondo.imagen = new Image(); //En este caso el fondo.imagen es mi objeto ya implementado. No tengo que poner dentro de mi objeto con varios atributos esto. Estoy creando mi propio objeto, nombre de primera letra del objeto se le pone en mayuscula
fondo.imagen.src = fondo.url;// Pongo el atributo que me almacena mi direccion, en este caso fondo.url
fondo.imagen.addEventListener("load", cargarFondo);

vaca.imagen = new Image();
vaca.imagen.src = vaca.url; //como defini url en los atributos de mi objeto, con src busco la url. Busco mi imagen
vaca.imagen.addEventListener("load", cargarVaca); //load es mi evento que me carga las imagenes.

lobo.imagen = new Image();
lobo.imagen.src = lobo.url;
lobo.imagen.addEventListener("load", cargarLobo);
//Creacion_de_objeto_Para_cargar_imagen-Creacion_de_objeto_Para_cargar_imagen-Creacion_de_objeto_Para_cargar_imagen-//

//Funciones-Funciones-Funciones-Funciones-Funciones-Funciones-Funciones-Funciones//
function cargarFondo(){
  fondo.cargaOK = true;
  dibujar();
}/*
function cargarVaca(){
  vaca.cargaOK = true;
  dibujar();
}
/*
function cargarLobo(){
  lobo.cargaOK = true;
  dibujar();
}
function dibujar(){
  if(fondo.cargaOK){
    lienzo.drawImage(fondo.imagen, 0,0);
  }if(vaca.cargaOK){
    lienzo.drawImage(vaca.imagen, xVaca,yVaca);
  }if(lobo.cargaOK){
    lienzo.drawImage(lobo.imagen, xLobo,yLobo);
  }
}
function moverLobo(evento){
      //console.log(evento);
      if(xVaca==xLobo && yVaca==yLobo){
      alert("Game over");
      }
      if(evento.keyCode==38){
          yLobo-=10;
          dibujar(xLobo,yLobo);
      }if(evento.keyCode==39){
          xLobo+=10;
          dibujar(xLobo,yLobo);
      }if(evento.keyCode==40){
          yLobo+=10;
          dibujar(xLobo,yLobo);
      }if(evento.keyCode==37){
          xLobo-=10;
          dibujar(xLobo,yLobo);
      }
}
function moverVaca(evento){
      //console.log(evento);
      if(evento.keyCode==87){
          yVaca-=10;
          dibujar(xVaca,yVaca);
      }if(evento.keyCode==68){
          xVaca+=10;
          dibujar(xVaca,yVaca);
      }if(evento.keyCode==83){
          yVaca+=10;
          dibujar(xVaca,yVaca);
      }if(evento.keyCode==65){
          xVaca-=10;
          dibujar(xVaca,yVaca);
      }
}
function aleatorio(min,max){
  var resultado = parseInt(Math.random()*(max - min +1)) + min;
  return resultado;
}*/
//Funciones-Funciones-Funciones-Funciones-Funciones-Funciones-Funciones-Funciones//

var texto = document.getElementById("textos");
var boton = document.getElementById("botones");
boton.addEventListener("click", dibujoPorClick); //Es una funcion para escuchar cuando hay un evento. En este caso el evento es que se active mi funcion cuando yo de click
var d = document.getElementById("plano");
var lienzo = d.getContext("2d");
var ancho = d.width;//para saber cual es el ancho de mi canvas.
//alert(ancho);
function dibujarLinea(color, xinicial, yinicial, xfinal, yfinal){

lienzo.beginPath(); //es lo que me inicializa el dibujo
lienzo.strokeStyle = color; //color
lienzo.moveTo(xinicial,yinicial);
lienzo.lineTo(xfinal,yfinal);  //origen y final
lienzo.stroke() //esta funcion me permiter graficar mi linea el formato
lienzo.closePath(); //es lo que me permite terminar mi trazos
}
function dibujoPorClick(){
  //texto.value: texto no es lo que está adentro, es toda la etiqueta HTML, para mirar el valor de una caja de texto debo poner su atributo, en este caso texto.value me permite aclarar lo que está adentro.
  //Saber que tiene texto por dentro, el texto.value es para obtener datos de un usuario sin el prompt, si no de una caja de texto
var datos = prompt("Ingrese el color que desea para el dibujo: ");
  var usuario =   parseInt(texto.value);//parseInt lo uso para pasar de string a entero.

  var lineas = usuario;
  var calculo = ancho/lineas;
  for(var i=0; i<lineas; i++){
   dibujarLinea(datos,0,i*calculo,i*calculo,300);
   dibujarLinea(datos,300,i*calculo,300-i*calculo,300);
   dibujarLinea(datos,0,300-i*calculo,i*calculo,0);
   dibujarLinea(datos,300,300-i*calculo,300-i*calculo,0);
  }
}
