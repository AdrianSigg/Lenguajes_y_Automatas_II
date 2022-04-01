public class ConstanteNumerica {
  boolean aceptacion;
  String[] nCad, newCad;
  Variables var = new Variables();
  Numeros numb = new Numeros();
  Alfabeto alfa = new Alfabeto();

  void inicio(String cadena) {
    nCad = cadena.split(" ");
    aceptacion = q0(nCad);
  }

  boolean q0(String[] cad) {
    var.inicio(cad[0]);
    if (var.aceptacion) return q6(cad);
    return false;
  }

  boolean q6(String[] cad){
    if (cad[1].equals("=")) return q7(cad);
    return false;
  }  

  boolean q7(String[] cad){
    newCad = cad[2].split("\\.");
    numb.inicio(newCad[0]);
    if (numb.aceptacion==true&&newCad.length==1) return true;
    else if (numb.aceptacion==true&&newCad.length>1) return q3(cad);
    return false;
  }

  boolean q3(String[] cad){
    if (cad[2].contains(".")) {
      int aux = cad[2].indexOf(".");
      if (cad[2].charAt(aux) == '.') return q4(newCad);
    }
    return false;
  }

  boolean q4(String[] cad){
    numb.inicio(newCad[1]);
    if (numb.aceptacion) return true;
    return false;
  }
}
