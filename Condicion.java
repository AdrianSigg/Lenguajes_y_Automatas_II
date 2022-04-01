public class Condicion {
  int contador=0;
  boolean aceptacion;
  char[] cadChar;
  String cadena;
  String cadAux[];
  Letras lyr = new Letras();
  Numeros numb = new Numeros();
  Alfabeto alfa = new Alfabeto();
  Variables var = new Variables();

  void inicio(String cadena) {
    this.cadena = cadena;
    aceptacion = q0(cadena);
  }

  boolean q0(String cad) {
    cadAux = cad.split(" ");
    if (cadAux.length == 1) {
      return false;
    }else {
      if (cadAux[0].charAt(0) == '$') return q6(cad); 
      else{
      numb.inicio(cadAux[0]);
      if (numb.aceptacion) return q2();
      }
    }
    return false;
  }

  boolean q6(String cad){
    var.inicio(cadAux[0]);
    if (var.aceptacion) return q1();
    else return false;
  } 

  boolean q2(){
    for (int i = 0; i < alfa.operadores.size(); i++)
      if (cadAux[1].equals(alfa.operadores.get(i))) return q8();
    return false;
  }

  boolean q8(){
    numb.inicio(cadAux[2]);
    if (numb.aceptacion) return true;
    return false;
  }

  boolean q1(){
    for (int j = 0; j < alfa.operadores.size(); j++)
      if (cadAux[1].equals(alfa.operadores.get(j))) return q3();
    return false;
  }

  boolean q3(){
    numb.inicio(cadAux[2]);
    if (numb.aceptacion) return true;
    var.inicio(cadAux[2]);
    if (var.aceptacion) return true;
    return false;
  }
}
