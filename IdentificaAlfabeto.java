import java.util.*;

public class IdentificaAlfabeto {
  // Se crea una arraylist donde se guardará la cadena caracter por caracter
  ArrayList<Character> cadenaChar = new ArrayList<Character>();
  //Pilas donde se guardarán las cadenas encontradas por sublenguaje
  PilaA ciclos = new PilaA();
  PilaA delimitadores = new PilaA();
  PilaA operadores = new PilaA();
  PilaA reservadas = new PilaA();
  PilaA escape = new PilaA();
  // Se crea un alfabeto, es la clase donde se define el lenguaje
  Alfabeto alfa = new Alfabeto();

  String cadena = "";
  String[] split;
  //Iteradores que se utilizaran
  int iteradorC =0, iteradorI=0, iteradorO=0, iteradorR=0, iteradorE=0, dec=0;

  public IdentificaAlfabeto(String cadena, String[] split, ArrayList<Character> cadenachar){
    this.cadena = cadena;
    this.cadenaChar = cadenachar;
    this.split = split;
  }

  //Se valida el alfabeto
  boolean validarAlfabeto(){
    /*Se eliminan todos los caracteres iguales en la lista cadenaChar a 
    excepcion de los que no se contiene, así se puede saber si ingresaron
    una que no pertenece al alfabeto*/
    cadenaChar.removeAll(alfa.alfabeto);
    /*Se comprueba, si cadenaChar tiene al menos un dato, significa que hay un
    caracter no comprendido en el alfabeto*/
    if (cadenaChar.size()==0) return true;
    return false;
  }

  //Valida si la cadena proporcionada contiene algún ciclo de nuestro lenguaje
  void validarCiclos(){
    for (int i = 0; i < alfa.ciclos.size(); i++)
      for (int j = 0; j < split.length; j++) 
        /*Si nuestro sublenguaje contiene una cadena igual a la de la cadena
        proporcionada, se inserta en la pila correspondiente y se 
        aumenta el contador para saber cuántas cadenas hay en la pila*/
        if (alfa.ciclos.get(i).equals(split[j])) {
          ciclos.insert(split[j]);
          iteradorC++;
        }
  }

  //Valida si la cadena contiene algún Delimitador de nuestro lenguaje
  void validarDelimitadores() {
    for (int i = 0; i < alfa.delimitadores.size(); i++)
      for (int j = 0; j < split.length; j++)
        if (alfa.delimitadores.get(i).equals(split[j].charAt(0))) {
          delimitadores.insert(split[j]);
          iteradorI++;
        }
  }

  //Valida si la cadena contiene algún Operador de nuestro lenguaje
  void validarOperadores() {
    for (int i = 0; i < alfa.operadores.size(); i++)
      for (int j = 0; j < split.length; j++)
        if (alfa.operadores.get(i).equals(split[j])) {
          operadores.insert(split[j]);
          iteradorO++;
        }
  }

  // Valida si la cadena contiene alguna palabra reservada de nuestro lenguaje
  void validarPalabrasRes() {
    for (int i = 0; i < alfa.reservadas.size(); i++)
      for (int j = 0; j < split.length; j++)
        if (alfa.reservadas.get(i).equals(split[j])) {
          reservadas.insert(split[j]);
          iteradorR++;
        }
  }

  //Valida si la cadena contiene alguna secuencia de escape de nuestro lenguaje
  void validarSecuenciaE() {
    for (int i = 0; i < alfa.escape.size(); i++)
      for (int j = 0; j < split.length; j++)
        if (alfa.escape.get(i).equals(split[j])) {
          escape.insert(split[j]);
          iteradorE++;
        }
  }

    //Método para imprimir los resultados
  void resultado(){
    //Se crean cadenas solo para no pasar las 80 columnas en el programa
    String si,no;
    si = "Todos los caracteres forman parte del alfabeto\n";
    no = "La cadena ingresada tiene un ";
    no += "caracter que no forma parte del alfabeto\n";
    /*Si la validacion del alfabeto devuelve true imprime que el caracter
    forma parte del alfabeto, de otro modo imprime que hay un caracter que no
    forma parte de el*/
    if (validarAlfabeto()) System.out.println(si);
    else System.out.println(no);

    //Imprime todos los ciclos encontrados en la cadena sólo si hay
    if (iteradorC>0){
      System.out.println("-------Ciclos-------");
      for (int i = 0; i < iteradorC; i++) 
        System.out.println(ciclos.extract()+"\n");
    }

    // Imprime todos los delimitadores encontrados en la cadena sólo si hay
    if (iteradorI > 0){
      System.out.println("------Delimitadores-------");
      for (int i = 0; i < iteradorI; i++) 
        System.out.println(delimitadores.extract() + "\n");
    }

    // Imprime todos los operadores encontrados en la cadena sólo si hay
    if (iteradorO > 0){
      System.out.println("-------Operadores---------");
      for (int i = 0; i < iteradorO; i++) 
        System.out.println(operadores.extract() + "\n");
    }

    // Imprime las palabras reservadas encontrados en la cadena sólo si hay
    if (iteradorR > 0){
      System.out.println("---------Palabras Reservadas---------");
      for (int i = 0; i < iteradorR; i++)
        System.out.println(reservadas.extract() + "\n");
    }
    
    // Imprime las secuencias de escape encontrados en la cadena sólo si hay
    if (iteradorE > 0){
      System.out.println("--------Secuencias de Escape--------");
      for (int i = 0; i < iteradorE; i++)
        System.out.println(escape.extract() + "\n");
    }
  }
}
