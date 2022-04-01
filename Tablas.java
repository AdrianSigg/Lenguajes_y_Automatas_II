import java.util.*;

public class Tablas {
  //Se llaman las clases creadas anteriormente
  ExpresionesRegulares ExpresionesRegulares = new ExpresionesRegulares();
  Automatas automata = new Automatas();
  Alfabeto alfabeto = new Alfabeto();
  //Se crean Hashtables para guardar los lexemas
  Hashtable<Integer,String> errorHashTable= new Hashtable<Integer,String>();
  Hashtable<Integer,String> symbolHashTable= new Hashtable<Integer,String>();
  Hashtable<Integer,String> keywordsHashtable= new Hashtable<Integer,String>();
  Hashtable<Integer,String> tokenHashtable = new Hashtable<Integer,String>();
  /*Se utilizan Enum's para representar las tablas generadas de una manera
    mas clara*/
  Enumeration<String> enumerationError;
  Enumeration<String> enumerationSymbol;
  Enumeration<String> enumerationKeywords;
  Enumeration<String> enumerationToken;

  String cadena; 
  /*En newMark se guardará una cadena que identifique la categoría de la
  cadena que ingresó el usuario evaluada en las expresiones regulares, 
  Ejemplo: Si la categoria de la cadena es un identificador, una variable 
  en ExpresionesRegulares.java llamada mark, guardará el valor de "ID".
  Las categorias son:
  ID: Identificadores
  DEL: Delimitadores
  OP: Operadores
  PR: Palabras Reservadas
  */
  String newMark=""; 
  String[] split;
  String[] reservadasTable = {"Imp","Lib-",".lib","main()"};
  //Se define la matriz predictiva
  String[][] matrizPredictiva =
    {{"M Z L"},
    {"Lib-Mate.lib"},
    {null,"Z' = V","' A ' = C"},
    {null,null,null,null,"A","A","A",null,null,null,null,null,null,null,null,
     null,null,null,null,null,null,null,null,"B","B","B"},
    {null,null,null,null,"} E { ) ( A","} E { ) ( A", "} E { ) ( A"},
    {null,"P",null,null,null,null,null,null,"T","T","T","I"},
    {null,"V O V"},
    {null,null,null,null,null,null,null,null,"W","F","H"},
    {null,null,null,null,null,null,null,null,"E > N < Mientras"},
    {null,null,null,null,null,null,null,null,null,"} E { > K V , N , Z < Repetir"},
    {null,null,null,null,null,null,null,null,null,null,"> N < Mientras } E { Haz"},
    {null,null,null,null,null,null,null,null,null,null,null,"I'\" >-Imp"},
    {null,null,null,null,"\"\"V | \" A >- I' , \" V | \" A >- I' "},
    {null,null,null,null,"N' G A","N' G A","N' G A"},
    {null,null,null,null,"A","A","A",null,null,null,null,null,null,null,null,
     null,null,null,null,null,null,null,null,"B","B","B"},
    {null,"B A $"},
    {null,"B A #"},
    {null,null,null,null,null,null,null,null,
     null,null,null,null,null,null,null,null,"++","--","**","//","%%"},
    {null,null,null,null,null,null,null,null,null,null,null,null,null,
     null,null,null,null,null,null,null,null,"-.","+."},
    {null,null,null,null,null,null,null,null,null,null,null,null,"==","=>",
     "=<","!"},
    {null,null,null,null,"a","b","c"},
    {null,null,null,null,null,null,null,null,null,null,null,null,null,null,
     null,null,null,null,null,null,null,null,null,"1","2","3"}
    };

  //Se crea el objeto de la clase analizador sintactico
  AnalizadorSintactico AnalizSint = new AnalizadorSintactico(matrizPredictiva);
  
  /*Se crea un constructor para guardar una cadena, y guarda esa misma cadena 
  dividida en partes en un arreglo de caracteres que se generan desde la 
  clase del Identificador.java*/
  public Tablas(String cadena, String[] split){
    this.cadena = cadena;
    this.split = split;
  }

  /*Método identificar, recibe una cadena, en este caso es la cadena
  por partes para evaluarse en la clase ExpresionesRegulares.java.
  Este método ayuda a identificar la categoría de la cadena*/
  String identificar(String splitted){
    ExpresionesRegulares.letras(splitted);
    ExpresionesRegulares.numeros(splitted);
    ExpresionesRegulares.cadenas(splitted);
    ExpresionesRegulares.asigER(splitted);
    ExpresionesRegulares.condicER(splitted);
    ExpresionesRegulares.constCharER(splitted);
    ExpresionesRegulares.delimitador(splitted);
    ExpresionesRegulares.hazER(splitted);
    ExpresionesRegulares.impER(splitted);
    ExpresionesRegulares.libER(splitted);
    ExpresionesRegulares.metodoER(splitted);
    ExpresionesRegulares.mientER(splitted);
    ExpresionesRegulares.operador(splitted);
    ExpresionesRegulares.repER(splitted);
    ExpresionesRegulares.varER(splitted);
    ExpresionesRegulares.reservadas(splitted);
    /*Si la marca que devuelve la clase de ExpresionesRegulares.java es = null
    significa que la cadena ingresada no forma parte de las expresiones
    regulares, por lo que se devuelve una cadena con "NULL", de otro modo
    devuelve la cadena mark de ExpresionesRegualares.java*/
    if (ExpresionesRegulares.mark != null) return ExpresionesRegulares.mark;
    return "NULL";
  }

  /*Método que de acuerdo a la categoría léxica, reconoce el lexema
  mediante el AFD, utilizando los autómatas de la clase Automatas.java,
  si la cadena pertenece a un autómata lo guarda en una estructura
  de datos de tipo hashTable, que representa a la tabla de sumbolos,
  si no pertenece al autámata lo guarda en la tabla de errores de tipo
  hashTable tambien*/
  void automata(){
    /*Se crea un for para reconocer cada lexema ingresado por el usuario,
    guardados en el arreglo de caracteres split[]*/
    for (int i = 0; i < split.length; i++) {
      /*Se guarda la categoria lexica que devuelve el método identificar() en 
      la cadena newMark*/
      newMark = identificar(split[i]);
      /*Dependiendo de la categoría léxica, se reconocen los posibles autómatas
      a los que puede pertenecer*/
      switch (newMark) {
      /*Si la marca es igual a "DEL", se evalúa la cadena en el autómata de los
      delimitadores y se llama el metodo tokenTable para guardarlo en la
      tabla de tokens*/
      case "DEL":
        automata.del.inicio(split[i]);
        if(automata.del.aceptacion) {
          tokenTable(split[i]);
          AnalisisSintactico();
        }
        else errorTable(split[i]);
        break;
      /*Si la marca es igual a "OP", se evalúa la cadena en el autómata de los
      operadores y se llama el metodo symbolTable() para guardarlo en la
      tabla de simbolos*/
      case "OP":
        automata.op.inicio(split[i]);
        if(automata.op.aceptacion) symbolTable(split[i]);
        else errorTable(split[i]);
        break;
      /*Si la marca es igual a "ID", se evalúa la cadena en el autómata de las
      letras, Dígitos, Variables y Condiciones y cadenas y se llama el metodo 
      symbolTable() para guardarlo en la tabla de simbolos en caso que el
      estado de acpetacion de alguno de los automatas mencionados sea true*/
      case "ID":
        automata.let.inicio(split[i]);
        automata.var.inicio(split[i]);
        automata.con.inicio(split[i]);
        automata.cad.inicio(split[i]);

        if(automata.var.aceptacion || automata.con.aceptacion ||
          automata.let.aceptacion || automata.cad.aceptacion)
          symbolTable(split[i]);
        else errorTable(split[i]);
        break;
      /*Si la marca es igual a "PR", se evalúa la cadena en el arreglo 
      donde se definieron las palabras reservadas y posteriormente se 
      llama el metodo symbolTable() para guardarlo en la tabla de simbolos*/
      case "PR":
        automata.pr.inicio(split[i]);
        automata.lib.inicio(split[i]);
        if(split[i].equals(reservadasTable[0]) || 
           split[i].equals(reservadasTable[1]) ||
           split[i].equals(reservadasTable[2]) || automata.pr.aceptacion ||
           split[i].equals(reservadasTable[3]) || automata.lib.aceptacion) 
          keywordsTable(split[i]);
        else errorTable(split[i]);
        break;
      
      case "INT":
        automata.num.inicio(split[i]);
        if(automata.num.aceptacion) 
          symbolTable(split[i]);
        else errorTable(split[i]);
        break;

      /*Si la marca es igual a "NULL" significa que la cadena no pertenece
      a ningún autómata y por lo tanto se manda llamar el método errorTable
      para guardar la cadena en la tabla de errores*/
      default:
        errorTable(split[i]);
        break;
      }
    }
  }

  //Tabla de errores
  void errorTable(String cadena){
    //Si la tabla no esta vacía se guarda en la posicion siguiente de la tabla
    if (!errorHashTable.isEmpty()){
      int count = errorHashTable.size();
      if (!errorHashTable.get(count).equals(cadena)) {
        count++;
        errorHashTable.put(count,cadena);
      }
    //Si la tabla está vacia se guarda en la posicion 1
    }else errorHashTable.put(1, cadena);
  }

  void keywordsTable(String cadena){
    /*Si la tabla no esta vacía y la categoría léxica es "PR" se
    guarda en la posicion siguiente de la tabla*/
    if (!keywordsHashtable.isEmpty()) {
      int count = keywordsHashtable.size();
      if(!keywordsHashtable.get(count).equals(cadena) && newMark.equals("PR")){
        count++;
        keywordsHashtable.put(count, cadena);
        tokenTable(cadena);
        AnalisisSintactico();
      }
    }else{
      /*Si la tabla esta vacía y la categoría léxica es "PR"
      se gaurda el valor en la posicion 1 de la tabla*/
      if(newMark.equals("PR")) keywordsHashtable.put(1, cadena);
      tokenTable(cadena);
      AnalisisSintactico();
    }
  }

  //Tabla de simbolos
  void symbolTable(String cadena){
    /*Si la tabla no esta vacía y la categoría léxica no es "DEL" se
    guarda en la posicion siguiente de la tabla*/
    if (!symbolHashTable.isEmpty()) {
      int count = symbolHashTable.size();
      if(!symbolHashTable.get(count).equals(cadena) && newMark != "DEL"){
        count++;
        symbolHashTable.put(count, cadena);
        tokenTable(cadena);
        AnalisisSintactico();
      }
    }else{
      /*Si la tabla esta vacía y la categoría léxica no es "DEL"
      se gaurda el valor en la posicion 1 de la tabla*/
      if(newMark != "DEL") symbolHashTable.put(1, cadena);
      tokenTable(cadena);
      AnalisisSintactico();
    }
  }

  void tokenTable(String cadena){
    if (!tokenHashtable.isEmpty()) {
      int count = tokenHashtable.size();
      count++;
      tokenHashtable.put(count, newMark+","+cadena);
    }else
      //Si la tabla esta vacía se gaurda el valor en la posicion 1 de la tabla
      tokenHashtable.put(1, newMark+","+cadena);
  }

  void AnalisisSintactico(){
    int size = tokenHashtable.size();
    String[] splitted = {};
    splitted = (tokenHashtable.get(size)).split(",");
    
    AnalizSint.data(splitted[1]);
    AnalizSint.resultado();
  }
}