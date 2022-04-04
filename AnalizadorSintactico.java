import java.util.Enumeration;
import java.util.Hashtable;

public class AnalizadorSintactico{
  // Se crean Hashtables para guardar los lexemas
  Hashtable<Integer, String> tokenHashtable = new Hashtable<Integer, String>();
  /*Se utilizan Enum's para representar las tablas generadas de una manera
    mas clara*/
  Enumeration<String> enumerationToken;

  //Expresiones regulares
  ExpresionesRegulares exre = new ExpresionesRegulares();

  //Se definen los terminales de la gramatica
  String[] terminales = {"Lib-Mate.lib","$","#","=","a","b","c","main","Mientras",
                         "Repetir","Haz","Imp->","==",">=","<=","!","++","--",
                         "**","//","%%",".-",".+","1","2","3",",","}",">","\"","(",")","{","&"};
  //Se definen los no terminales de la gramatica
  String[] noTerminales = {"S","L","Z","Z'","M","E","P","T","W","F","H","I",
                           "I'","N","N'","V","C","O","K","G","A","B"};

  String variable = "$", constante = "#", igual = "=", parentesisIzq = "(", parentesisDer = ")",
         llaveIzq = "{", llaveDer = "}", multiplicacion = "**", libreria = "Lib-Mate.lib";
  String tipo = "", tipoLexema = "";
  
  String cadena, terminalInicial = "S", valor2 = "", valor3 = "", indice2 = "";
  String[] split;
  String[][] matrizPredictiva;
  String[] reservadasTable = {"Lib-Mate.lib","Imp","main()"};
  int valor = 0, cont = 0, valorAux = 0, repeticiones = 1, indice = 1;
  //Se crean pilas para guardar los datos
  PilaA pilaX = new PilaA();
  Alfabeto alfabeto = new Alfabeto();
  
  public AnalizadorSintactico(String[][] matriz){
    matrizPredictiva = matriz;
    /* Se crea la pilaX */
    pilaX.insert("&"); 
  }

  void data(String split){
    //Se manda llamar el algoritmo de analisis sintactico
    this.cadena = split;
    sintactico();
  }

  boolean sintactico(){
    //Regla de produccion
    String reglaProd = "", aux;
    String[] regla = {};
    //indices de matriz
    int indexX = 0, indexY = 0;
    do {
      pilaX.insert(terminalInicial);
      aux = pilaX.extract();
      if (terminalInicial == "&") cadena = "&";
      for (int i = 0; i < terminales.length; i++)
        if (aux.equals(terminales[i]))
          //Entra Terminal
          if (aux.equals(cadena)) {
            //Se quita el terminal inicial actual y se apunta al siguiente
            terminalInicial = pilaX.extract();
            //Se agregan marcadores
            tipo(cadena);
            tipoLexema(cadena);
            valor(cadena);
            //Se crea una tabla de tokens
            tokenTable(cadena);
            return true;
          }

      for (int i = 0; i < noTerminales.length; i++) 
        if (aux.equals(noTerminales[i])) {
          // Entra no terminal con el token
          // Crea indices
          indexX = matrizX(cadena);
          indexY = matrizY(aux);
          if(indexY == 4){tipo = "Metodo"; tipoLexema = "Método";}
          // Se extrae la regla de produccion de la matriz
          if (indexX >= 0 && indexY >= 0)
            try {
              reglaProd = matrizPredictiva[indexY][indexX];
              // Se inserta en la pila la regla de produccion
              if (reglaProd!=null) {
                regla = reglaProd.split(" ");
                for (int k = 0; k < regla.length; k++)
                  pilaX.insert(regla[k]);
                terminalInicial = pilaX.extract();
              }else error(cadena);
            } catch (ArrayIndexOutOfBoundsException e) {
              error(cadena);
            } 
          else error(cadena);
        }
    } while (aux != "&"); 
    return false;
  }

  //Método para asignar marcadores de tipo
  void tipo(String cadena){
    if (cadena.equals(variable)) tipo = "simbolo-variable";
    if (cadena.equals(constante)) tipo = "simbolo-constante";
    if (exre.letras(cadena)) tipo = "Identificador";
    if (exre.numeros(cadena))tipo = "numeros";;
    if (cadena.equals(igual)) tipo = "simbolo-igual";
    if (cadena.equals(parentesisIzq)) tipo = "parentesis-izq";
    if (cadena.equals(parentesisDer)) tipo = "parentesis-der";
    if (cadena.equals(llaveIzq)) tipo = "llave-izq";
    if (cadena.equals(llaveDer)) tipo = "llave-der";
    if (cadena.equals(multiplicacion)) tipo = "simbolo-multiplicacion";
    if (cadena.equals(libreria)) tipo = "libreria";
  }

  //Método para asignar marcadores de tipo lexema
  void tipoLexema(String cadena){
    if (cadena.equals(variable)) tipoLexema = "Variable";
    if (cadena.equals(constante)) tipoLexema = "Constante";
    if (exre.cadenas(cadena)) tipoLexema = "Identificador";
    if (exre.numeros(cadena)) tipoLexema = "Entero";
    if (cadena.equals(igual)) tipoLexema = "Delimitador";
    if (cadena.equals(parentesisIzq)) tipoLexema = "Delimitador";
    if (cadena.equals(parentesisDer)) tipoLexema = "Delimitador";
    if (cadena.equals(llaveIzq)) tipoLexema = "Delimitador";
    if (cadena.equals(llaveDer)) tipoLexema = "Delimitador";
    if (cadena.equals(multiplicacion)) tipoLexema = "Operador";
    if (cadena.equals(libreria)) tipoLexema = "Palabra-Reservada";
  }

  void valor(String cadena){
    valorAux = cadena.charAt(0);
    valor2 = String.valueOf(valorAux);
  }

  /*Dependiendo de la pila se le asigna un valor para 
  evaluar en la matriz predictiva*/
  int matrizY(String y){
    switch (y) {
      case "S": return 0;
      case "L": return 1;
      case "Z": return 2;
      case "Z'": return 3;
      case "M": return 4;
      case "E": return 5;
      case "P": return 6;
      case "T": return 7;
      case "W": return 8;
      case "F": return 9;
      case "H": return 10;
      case "I": return 11;
      case "I'": return 12;
      case "N": return 13;
      case "N'": return 14;
      case "V": return 15;
      case "C": return 16;
      case "O": return 17;
      case "K": return 18;
      case "G": return 19;
      case "A": return 20;
      case "B": return 21;
      case "R": return 22;
      default: return -1;
    }
  }

  /*Dependiendo de la cadena se le asigna un valor para 
  evaluar en la matriz predictiva*/
  int matrizX(String w){
    switch (w) {
      case "Lib-Mate.lib": return 0;
      case "$": return 1;
      case "#": return 2;
      case "=": return 3;
      case "a": return 4;
      case "b": return 5;
      case "c": return 6;
      case "main": return 7;
      case "Mientras": return 8;
      case "Repetir": return 9;
      case "Haz": return 10;
      case "Imp->": return 11;
      case "==": return 12;
      case ">=": return 13;
      case "<=": return 14;
      case "!": return 15;
      case "++": return 16;
      case "--": return 17;
      case "**": return 18;
      case "//": return 19;
      case "%%": return 20;
      case ".-": return 21;
      case ".+": return 22;
      case "1": return 23;
      case "2": return 24;
      case "3": return 25;
      case ".": return 26;
      case "}": return 27;
      case ">": return 28;
      case "\"": return 29;
      default: return -1;
    }
  }

  //Tabla de tokens
  void tokenTable(String cadena){
    /*Si la tabla no esta vacía, no es una Palabra reservada, no es un 
    delimitador y si no es valor repetido se guarda en la posicion 
    siguiente de la tabla*/
      if (!tokenHashtable.isEmpty() && !cadena.equals("&")) {
        //Se agrega la llave, el lexema, el tipo de lexema y el tipo
        tokenHashtable.put(valor, cadena+","+tipoLexema+","+tipo+","+valor2);
        valor++;
        indice++;
      }else if (!tokenHashtable.contains(cadena) && !cadena.equals("&")){
        /*Si la tabla esta vacía se gaurda el valor
        en la posicion 1 de la tabla*/
        //Se agrega la llave, el lexema, el tipo de lexema y el tipo
        tokenHashtable.put(valor,cadena+","+tipoLexema+","+tipo+","+valor2);
        valor++;
      }
  }

  void enumerations(){
    /*Se utilizan Enum's para representar las tablas generadas de una manera
    mas clara*/
    enumerationToken = tokenHashtable.elements();
  }

  void error(String cadena){
    System.err.println("ERROR, La cadena "+cadena+" ingresada no es valida");
    System.exit(0);
  }

  void resultado(){
    enumerations();
    if (pilaX.empty()&& cadena == "&") {
      System.out.println("\nPILA VACIA, CADENA VALIDA");
      // Si la tabla de tokens no esta vacia, muestra su contenido
      if (!tokenHashtable.isEmpty()) {
        System.out.println("\nTabla de Tokens");
        while (enumerationToken.hasMoreElements())
        System.out.println(enumerationToken.nextElement());
      }
    }
  }

  void guardavalores(){
    TablaSimbolos obj = new TablaSimbolos(tokenHashtable, tipo, tipoLexema, valor3);
    obj.symbolTable();
    obj.resultado();
  }
}