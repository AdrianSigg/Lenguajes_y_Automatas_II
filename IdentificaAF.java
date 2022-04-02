import java.util.Scanner;

public class IdentificaAF {
  int dec=0;
  String cadena;
  Scanner teclado = new Scanner(System.in);

  public IdentificaAF(String cadena){
    this.cadena = cadena;
  }

  void menu(){
    System.out.println("Que automata desea verificar?\nElija una opcion");
    System.out.println("1.-Letras\n2.-Numeros\n3.-Delimitadores\n4.-Operadores");
    System.out.println("5.-Librerias\n6.-Variables\n7.-Constantes caracter");
    System.out.println("8.-Constante numerica\n9.-Asignacion\n10.-Iterador");
    System.out.println("11.-Condicion\n12.-Palabra Imp\n13.-Sec. de Escape");
    dec = Integer.parseInt(teclado.nextLine());
  }

  void resultado() {
      Automatas automata = new Automatas();

      switch (dec) {
      case 1:
          automata.let.inicio(cadena);
          if (automata.let.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Letras");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 2:
          automata.num.inicio(cadena);
          if (automata.num.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Numeros");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 3:
          automata.del.inicio(cadena);
          if (automata.del.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Delimitadores");
              System.out.println("Si cumple con el aut1omata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 4:
          automata.op.inicio(cadena);
          if (automata.op.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Operadores");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 5:
          automata.lib.inicio(cadena);
          if (automata.lib.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Librerias");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 6:
          automata.var.inicio(cadena);
          if (automata.var.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Variables");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 7:
          automata.cc.inicio(cadena);
          if (automata.cc.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Constante de caracter");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 8:
          automata.cn.inicio(cadena);
          if (automata.cn.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Constante de numerica");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 9:
          automata.as.inicio(cadena);
          if (automata.as.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Asignacion");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 10:
          automata.it.inicio(cadena);
          if (automata.it.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Iterador");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 11:
          automata.con.inicio(cadena);
          if (automata.con.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Condicion");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 12:
          automata.pr.inicio(cadena);
          if (automata.pr.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Palabra Reservada para imprimir");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 13:
          automata.esc.inicio(cadena);
          if (automata.esc.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Secuencias de escape");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      case 14:
          automata.re.inicio(cadena);
          if (automata.re.aceptacion) {
              System.out.println("----------------------------");
              System.out.println("Expresion: " + cadena);
              System.out.println("Clasificacion: Numero real");
              System.out.println("Si cumple con el automata");
          } else
              System.out.println("No cumple con el patron");
          break;
      }
  }
}
