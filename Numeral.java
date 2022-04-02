public class Numeral {
  int contador = 0, aux = 0;
  String cadChar1, cadChar2;
  boolean aceptacion;
  String[] nCad;

  Alfabeto alfa = new Alfabeto();
  Numeros num = new Numeros();

  void inicio(String cadena) {
    nCad = cadena.split("\\.");
    if (nCad.length>1 && !(cadena.charAt(0)=='.')) {
      cadChar1 = nCad[0];  
      cadChar2 = nCad[1];
      aceptacion = q0(cadChar1);
    }else aceptacion = false;
  }

  boolean q0(String cad){
    num.inicio(cad);
    if (num.aceptacion) {
      return q1(cadChar2);
    }
    return false;
  }

  boolean q1(String cad){
    num.inicio(cad);
    return num.aceptacion;
  }
}
