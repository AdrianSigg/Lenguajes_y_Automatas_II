import java.util.ArrayList;

public class Alfabeto {
  //Se crean listas de arreglos para guardar la definicion del lenguaje
  ArrayList<Character> alfabeto = new ArrayList<Character>();
  ArrayList<String> ciclos = new ArrayList<String>();
  ArrayList<Character> delimitadores = new ArrayList<Character>();
  ArrayList<String> operadores = new ArrayList<String>();
  ArrayList<String> reservadas = new ArrayList<String>();
  ArrayList<String> escape = new ArrayList<String>();
  ArrayList<Character> Letras = new ArrayList<Character>();
  ArrayList<Character> Numero = new ArrayList<Character>();
  ArrayList<Character> Alfanumerico = new ArrayList<Character>();
  //La variable ascciN se usa para agregar el codigo ascii al alfabeto
  int ascciN = 0;

  public Alfabeto(){
    //Se define el alfabeto ingresando un rango de caracteres en ascii
    for (int i = 0; i < 255; i++) alfabeto.add((char) ++ascciN);
    //Se crea un AL que contenga las letras
    for (int i = 97; i < 123; i++) Letras.add((char) i);
    for (int i = 65; i < 91; i++) Letras.add((char) i);
    // Se crea un AL que contenga los numeros
    for (int i = 48; i < 58; i++) Numero.add((char) i);
    // Se crea un AL que contenga letras y numeros

    //Se definen los ciclos
    ciclos.add("Repetir");
    ciclos.add("Mientras");
    ciclos.add("HMientras");
    // Se definen los delimitadores
    delimitadores.add('<');
    delimitadores.add('>');
    delimitadores.add(':');
    delimitadores.add('$');
    delimitadores.add('#');
    delimitadores.add('{');
    delimitadores.add('}');
    delimitadores.add('(');
    delimitadores.add(')');
    delimitadores.add('\'');
    delimitadores.add('"');
    delimitadores.add('=');
    delimitadores.add('.');
    delimitadores.add('&');
    // Se definen los operadores
    operadores.add("++");
    operadores.add("--");
    operadores.add("**");
    operadores.add("//");
    operadores.add("%%");
    operadores.add("==");
    operadores.add(".-");
    operadores.add(".+");
    operadores.add("<=");
    operadores.add(">=");
    operadores.add("!=");
    operadores.add("->");
    // Se definen las palabras reservadas
    reservadas.add("Lib-");
    reservadas.add("Imp");
    reservadas.add(".lib");
    // Se definen las secuencias de escape
    escape.add("\\n");
    escape.add("\\t");
    escape.add("\\r");
    escape.add("\\f");
    escape.add("\\b");
    escape.add("\\\\");
    escape.add("\\'");
    escape.add("\\\"");
  }
}
