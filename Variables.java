public class Variables {
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
    if (cad.charAt(0) == '$') return q1(cad); 
    return false;
  }

  boolean q1(String cad){
    /*Se elimina el caracter $ de la cadena para validar si lo demás
    son letras*/
    String Ncadena = cadena.replace("$", "");
    cadAux = Ncadena.split(" ");
    lyr.inicio(cadAux[0]);
    return lyr.aceptacion;
  }
}

