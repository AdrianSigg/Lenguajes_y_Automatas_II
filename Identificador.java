import java.util.*;

public class Identificador {
  // Se crea una arraylist donde se guardará la cadena caracter por caracter
  ArrayList<Character> cadenaChar = new ArrayList<Character>();
  Scanner teclado = new Scanner(System.in);
  //Variable donde se guarda la cadena completa
  String cadena = "";
  //Variable donde se guarda la cadena por partes
  String[] split;

  //Método donde se guardan los datos
  void guardarDatos(){
    //Se ingresa la cadena a una listaArreglo para leerla caracter por caracter
    for (int i = 0; i < cadena.length(); i++) cadenaChar.add(cadena.charAt(i));
    //Se separa la cadena cada que haya un espacio y se guarda
    split = cadena.split(" ");
  }
  
  //Se muestra un mensaje en pantalla que explica el programa
  void info(){
    String mensaje = "";
    mensaje = "Programa que permite validar un lenguaje en\n";
    mensaje+= "distintas etapas de su desarrollo, desde\n";
    mensaje+= "mostrar si la cadena escrita forma parte del lenguaje\n";
    mensaje += "hasta automatas y expresiones regulares\n";
    System.out.println(mensaje);
  }

  //Método para ingresar datos
  void datos(){
    System.out.println("Introduzca la cadena a verificar");
    cadena = teclado.nextLine();
  }

  //Método que llama al programa para verificar alfabeto
  void llamaAlf(){
    IdentificaAlfabeto af = new IdentificaAlfabeto(cadena, split, cadenaChar);
    af.validarCiclos();
    af.validarDelimitadores();
    af.validarOperadores();
    af.validarPalabrasRes();
    af.validarSecuenciaE();
    af.resultado();
  }

  // Método que llama al programa para verificar Expresiones regulares
  void llamaER(){
    IdentificaER er = new IdentificaER(split);

    er.imprimeER();
  }

  //Método que llama al programa para verificar Automatas Finitos Deterministas
  void llamaAF(){
    IdentificaAF af = new IdentificaAF(cadena);

    af.menu();
    af.resultado();
  }

  //Método que llama al programa para verificar el léxico
  void llamaAn(){
    TablasAl al = new TablasAl(cadena, split);

    al.automata();
    al.enumerations();
    al.resultado();
  }

  void llamaAs(){
    TablasAl al = new TablasAl(cadena, split);

    al.automata();
    al.AnalisisSintactico();
  }

  //Método main
  public static void main(String[] args) {
    Identificador id = new Identificador();

    id.info();
    id.datos();
    id.guardarDatos();
    //id.llamaAlf();//llama a la verificacion del alfabeto
    //id.llamaER();//Llama a la verificacion de expresiones regulares
    //id.llamaAF();//Llama a la verificacion de automatas finitos
    //id.llamaAn();//Llama a la verificacion del analizador lexico
    //id.llamaAs();// Llama a la verificacion del analizador sintactico
    // Lib-Mate.lib $c2 = 2 main ( ) { $a2 ** $b2 }
    // Lib-Mate.lib $ a 2 = 3 b ( ) { $ a 2 ** $ b 1 }
  }
} 