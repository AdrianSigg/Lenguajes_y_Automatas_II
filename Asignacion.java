public class Asignacion {
  int contador;
  boolean aceptacion;
  char[] cadChar;
  String cadena;
  String[] cadenaS;
  Variables var = new Variables();
  ConstanteDeCaracter con = new ConstanteDeCaracter();
  Numeros num = new Numeros();
  Letras let = new Letras();

  void inicio(String cadena) {
    this.cadena = cadena;
    cadenaS = cadena.split(" ");
    contador = 0;
    if (cadenaS.length<3) {
      aceptacion = false;
    }else aceptacion = q0();
  }

  boolean q0(){
    var.inicio(cadena);
    con.inicio(cadena);
    if (var.aceptacion) return q3(cadenaS);
    if (con.aceptacion) return q6(cadenaS);
    return false;
  }

  boolean q3(String[] cad){
    String cadena2 = cad[2];
    if (cadenaS[1].equals("=")) {
      num.inicio(cadena2);
      return num.aceptacion;
    }else return false;
  }

  boolean q6(String[] cad) {
    if (cadenaS[1].equals("=")) return q10(cad);
    return false;
  }

  boolean q10(String[] cad) {
    String cadena3 = String.valueOf(cad[2].charAt(0));
    if (cadena3.equals("'")) return q7(cad);
    return false;
  }

  boolean q7(String[] cad) {
    String aux = String.valueOf(cad[2].charAt(1));
    let.inicio(aux);
    num.inicio(aux);
      if (let.aceptacion||num.aceptacion) return q8(cad);
    return false;
  }

  boolean q8(String[] cad){
    String aux = String.valueOf(cad[2].charAt(2));
    if (aux.equals("\'")) return true;
    else return false;
  }
}
