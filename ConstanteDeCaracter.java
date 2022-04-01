public class ConstanteDeCaracter {
  int contador;
  boolean aceptacion;
  char[] cadChar;
  String cadena;
  Letras lyr = new Letras();
  Numeros numb = new Numeros();
  Alfabeto alfa = new Alfabeto();

  void inicio(String cadena) {
    this.cadena = cadena;
    cadChar = cadena.toCharArray();
    contador = 0;
    aceptacion = q0(cadChar[contador++]);
  }

  boolean q0(char cad) {
    if (cad == '#') return q1(cadChar[contador++]); 
    return false;
  }

  boolean q1(char cad){
    /*Se elimina el caracter $ de la cadena para validar si lo demás
    son letras*/
    String Ncadena = cadena.replace("#", "");
    do {
      q0(cadChar[contador++]);
      lyr.inicio(Ncadena);
      return lyr.aceptacion;
    } while (contador<cadChar.length);
  }
}
