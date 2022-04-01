public class Delimitadores {
  int contador = 0;
  char[] cadChar;
  boolean aceptacion;
  String[] nCad;

  Alfabeto alfa = new Alfabeto();

  void inicio(String cadena) {
    nCad = cadena.split(" ");
    cadChar = nCad[0].toCharArray();
    aceptacion = q0(cadChar[contador]);
  }

  boolean q0(char cad){
     for (int i = 0; i < alfa.delimitadores.size(); i++)
      if (alfa.delimitadores.get(i) == cad) return true;
      return false;
  }
}
