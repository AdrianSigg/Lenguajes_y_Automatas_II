import java.util.Enumeration;
import java.util.Hashtable;

public class Comprobacion {
    Hashtable<Integer, String> symbolTable = new Hashtable<Integer, String>();
    Hashtable<Integer, String> auxiliar = new Hashtable<Integer, String>();

    Enumeration<String> enumerationSymbol;

    String tipo = "", tipoLexema1 = "", valor= "", cad = "", var1="", 
           var2="", var3="", aux = "";
    String [] splitted = {};

    public Comprobacion(Hashtable symbol){
      symbolTable = symbol;
    }

    void verificarTipo(){
      enumerationSymbol = symbolTable.elements();

      System.out.println("\nEjecuta comprobacion");

      //Se recorre la tabla de simbolos para conocer el tipo de la variable
      while (enumerationSymbol.hasMoreElements()) {
        if (enumerationSymbol.nextElement().contains("$") 
            && enumerationSymbol.hasMoreElements())
          if ((enumerationSymbol.nextElement().contains("a") ||
              enumerationSymbol.nextElement().contains("b") ||
              enumerationSymbol.nextElement().contains("c")) 
              && enumerationSymbol.hasMoreElements())
            if ((enumerationSymbol.nextElement().contains("1") ||
                enumerationSymbol.nextElement().contains("2") ||
                enumerationSymbol.nextElement().contains("3")) 
                && enumerationSymbol.hasMoreElements())
              tipoLexema1 = "Entero";
      }

      //Se extrae la cadena
      cad = symbolTable.get(2);
      System.out.println(cad);
      //Se quita de la tabla de simbolos
      symbolTable.remove(2, cad);

      splitted = cad.split(",");

      //Se arma la nueva cadena con el tipo de dato actualizado
      aux = splitted[0]+","+tipoLexema1+","+ splitted[2]+","+ splitted[3]+","+ splitted[4]+","+ splitted[5];
      System.out.println(aux);
      //Se ingresa nuevamente en la tabla de simbolos
      symbolTable.putIfAbsent(2, aux);

      //Se arma la variable 1
      var1 = splitted[0];
      splitted = (cad = symbolTable.get(3)).split(",");
      var1 += splitted[0];
      System.out.println(var1);

      
    }

    void comprobar(){
      
    }
}
