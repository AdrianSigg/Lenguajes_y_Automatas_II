public class Automatas {
  char[] cadChar;
  Letras let = new Letras();
  Numeros num = new Numeros();
  Variables var = new Variables();
  ConstanteDeCaracter cc = new ConstanteDeCaracter();
  Asignacion as = new Asignacion();
  Delimitadores del = new Delimitadores();
  Operadores op = new Operadores();
  ConstanteNumerica cn = new ConstanteNumerica();
  SecuenciasDeEscape esc = new SecuenciasDeEscape();
  Iterador it = new Iterador();
  Libreria lib = new Libreria();
  PalabraReservada pr = new PalabraReservada();
  Condicion con = new Condicion();
  Cadenas cad = new Cadenas();
  
  void letras(String cadena){
    let.inicio(cadena);
  }

  void numeros(String cadena) {
    num.inicio(cadena);
  }

  void variables(String cadena){
    var.inicio(cadena);
  }

  void constantesCaracter(String cadena) {
    cc.inicio(cadena);
  }

  void asignacion(String cadena){
    as.inicio(cadena);
  }

  void delimitadores(String cadena){
    del.inicio(cadena);
  }

  void operadores(String cadena){
    op.inicio(cadena);
  }

  void ConstanteNumerica(String cadena){
    cn.inicio(cadena);
  }

  void secuenciasDeEscape(String cadena){
    esc.inicio(cadena);
  }

  void iterador(String cadena){
    it.inicio(cadena);
  }

  void libreria(String cadena){
    lib.inicio(cadena);
  }

  void palabraReservada(String cadena){
    pr.inicio(cadena);
  }

  void condicion(String cadena){
    con.inicio(cadena);
  }

  void cadenas(String cadena) {
    cad.inicio(cadena);
  }
}
