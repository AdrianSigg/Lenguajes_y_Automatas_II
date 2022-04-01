public class PalabraReservada {
  int contador=0;
  boolean aceptacion;
  char[] cadChar;
  String cadena;
  String cadAux[], cadAux2[];
  Letras lyr = new Letras();
  Numeros numb = new Numeros();
  Alfabeto alfa = new Alfabeto();

  void inicio(String cadena) {
    this.cadena = cadena;
    aceptacion = q0(cadena);
  }

  boolean q0(String cad){
    cadAux = cad.split("\"");
    if (cadAux[0].equals("Imp->")) return q1();
    return false;
  }

  boolean q1(){
    cadAux2 = cadAux[1].split("\"");
    lyr.inicio(cadAux2[0]);
    numb.inicio(cadAux2[0]);
    if (lyr.aceptacion||numb.aceptacion) return true;
    return false;
  }
}
