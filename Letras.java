public class Letras {
  int contador = 0, aux=0;
  char[] cadChar;
  boolean aceptacion;
  String[] nCad;

  Alfabeto alfa = new Alfabeto();

  void inicio(String cadena) {
    nCad = cadena.split(" ");
    cadChar = nCad[0].toCharArray();
    aux = cadChar.length;
    aceptacion = q0(cadChar[contador]);
  }

  boolean q0(char cad) {
    for (int i = 0; i < alfa.Letras.size(); i++)
      if (alfa.Letras.get(i) == cad) {
        if (aux==1) return true;
        else if(aux>1){
          aux--;
          return q1(cadChar[1]);
        }
      }
    return false;
  }

  boolean q1(char cad){
    return q0(cad);
  }
}