public class Iterador {
  int contador=0;
  boolean aceptacion;
  char[] cadChar;
  String cadena;
  String cadAux[];
  Letras lyr = new Letras();
  Numeros numb = new Numeros();
  Alfabeto alfa = new Alfabeto();

  void inicio(String cadena) {
    this.cadena = cadena;
    aceptacion = q0(cadena);
  }

  boolean q0(String cad) {
    if (cad.charAt(0) == '$') return q3(cad); 
    return false;
  }

  boolean q3(String cad){
    /*Se elimina el caracter $ de la cadena para validar si lo demás
    son letras*/
    String Ncadena = cadena.replace("$", "");
    cadAux = Ncadena.split(" ");
    lyr.inicio(cadAux[0]);
    if (lyr.aceptacion) return q1();
    return false;
  }
  
  boolean q1(){
    if (cadAux[1].equals("=")) return q2();
    return false;
  }

  boolean q2(){
    numb.inicio(cadAux[2]);
    if (numb.aceptacion) return true;
    else return false;
  }
}
