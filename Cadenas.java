public class Cadenas {
  int contador = 0;
  char[] cadChar;
  boolean aceptacion;
  String[] nCad;

  Alfabeto alfa = new Alfabeto();
  Letras letras = new Letras();

  void inicio(String cadena) {
    aceptacion = q0(cadena);
  }

  boolean q0(String cadena){
    if (cadena.charAt(0) == '"') return q1(cadena);
    return false;
  }

  boolean q1(String cadena){
    String Ncadena = cadena.replace("\"", "");
    letras.inicio(Ncadena);
    if (letras.aceptacion) return q2(cadena);
    return false;
  }

  boolean q2(String cadena){
    int aux = cadena.length()-1;
    if (cadena.charAt(aux) == '"') return true;
    return false;
  }
}
