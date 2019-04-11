//Nota: EL canvas debe estar encima de la etiqueta script en la pagina HTML.
var villa = document.getElementById("platzi");
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
  url: "tile.png" ,//Los atributos dentro de un objeto deben separarse por coma,
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
}
function cargarVaca(){
  vaca.cargaOK = true;
  dibujar();
}
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
}
//Funciones-Funciones-Funciones-Funciones-Funciones-Funciones-Funciones-Funciones//
