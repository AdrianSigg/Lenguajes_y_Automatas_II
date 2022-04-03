import java.util.Enumeration;
import java.util.Hashtable;

public class TablaSimbolos {
  Hashtable<Integer, String> tokenHashTable = new Hashtable<Integer, String>();
  Hashtable<Integer, String> symbolHashTable = new Hashtable<Integer, String>();

  /*Se utilizan Enum's para representar las tablas generadas de una manera
  mas clara*/
  Enumeration<String> enumerationToken;
  Enumeration<String> enumerationSymbol;

  String tipo = "", tipoLexema = "", valor;

  public TablaSimbolos(Hashtable tokenHashTable, String tipo, String tipoLexema, String valor, String indice){
    this.tokenHashTable = tokenHashTable;
    this.tipo = tipo;
    this.tipoLexema = tipoLexema;
    this.valor = valor;
    
  }

  void symbolTable(){
      int count = symbolHashTable.size();
    //Se crea la tabla de simbolos
      int repeticiones = 1;
      //String cadena para guardar el lexema
      String cad = "";
      //Se crea variable para la linea
      int linea = 1;
      //Se crea arreglo donde 
      String[] splitted = {};

      //For donde se lee la tabla de tokens y se separan sus datos
      for (int i = 0; i < tokenHashTable.size(); i++) {
        
        //Se separan sus valores con split y se guardan en distintas variables
        //para posteriormente almacenarlas en la tabla de simbolos
        splitted = tokenHashTable.get(i).split(",");
        cad = splitted[0];
        tipoLexema = splitted[1];
        tipo = splitted[2];
        valor = splitted[3];

        //Se construye una cadena para usar en la hashtable
        String aux = cad+","+tipoLexema+","+tipo+","+valor+","+linea+",";
        
        //si la tabla ya tiene al menos un dato se guarda  en la siguiente posicion
        if (!symbolHashTable.isEmpty() && !symbolHashTable.contains(aux)) {
          //Se crea variable para conocer el tamaño de la tabla
          
          // Se apunta a la siguiente posicion
          count++;
          //Se ingresan los datos
          symbolHashTable.put(count, aux+repeticiones);
          repeticiones = 1;
        }if(symbolHashTable.contains(aux)){
          symbolHashTable.replace(count, aux+1, aux+2);
          repeticiones = 1;
        }
        else
          /*
           * Si la tabla esta vacía
           * se gaurda el valor en la posicion 1 de la tabla
           */
          if (!symbolHashTable.contains(aux)) symbolHashTable.put(1, aux);
          
      }
  }

  void enumerations(){
    /*Se utilizan Enum's para representar las tablas generadas de una manera
    mas clara*/
    enumerationSymbol = symbolHashTable.elements();
  }

  void resultado(){
    System.out.println(symbolHashTable.keySet().iterator().next());
    System.out.println("\nTabla de símbolos");
    enumerations();
      // Si la tabla no esta vacia, muestrra su contenido
      if (!symbolHashTable.isEmpty()) {
        while (enumerationSymbol.hasMoreElements())
          System.out.println(enumerationSymbol.nextElement());
      }
  }
}
