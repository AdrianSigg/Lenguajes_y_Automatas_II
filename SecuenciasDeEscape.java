public class SecuenciasDeEscape {
  int contador = 0;
  char[] cadChar;
  boolean aceptacion;
  String[] nCad;

  Alfabeto alfa = new Alfabeto();

  void inicio(String cadena) {
    nCad = cadena.split(" ");
    aceptacion = q0(nCad[0]);
  }

  boolean q0(String cad) {
    for (int i = 0; i < alfa.escape.size(); i++)
      if (cad.equals(alfa.escape.get(i))) return true;
    return false;
  }
}
