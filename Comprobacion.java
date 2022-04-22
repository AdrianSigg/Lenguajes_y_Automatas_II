import java.util.Enumeration;
import java.util.Hashtable;

public class Comprobacion {
    Hashtable<Integer, String> symbolTable = new Hashtable<Integer, String>();
    Hashtable<Integer, String> auxiliarTable = new Hashtable<Integer, String>();

    Enumeration<String> enumerationSymbol;

    String tipo = "", tipoLexema1 = "", tipoLexema2 = "", valor= "", cad = "", cad2 = "", cad3 = "",
           cad4 ="", var1="", var2="", var3="", aux = "", cadArm = "", op = "",
           tipoOperacion = "";
    int cont = 0;
    String [] splitted = {};

    public Comprobacion(Hashtable symbol){
      symbolTable = symbol;
    }

    void verificarTipo(){
      enumerationSymbol = symbolTable.elements();

      /*Se recorre la tabla de simbolos para conocer el tipo 
      de la variable si es que fue declarada*/
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
        else if (enumerationSymbol.nextElement().charAt(0) == '"'
            && enumerationSymbol.hasMoreElements())
               tipoLexema1 = "Cadena";
        else {
          System.err.println("Tipo no válido");
          System.exit(0);
        }
      }

      //Se extrae la cadena
      cad = symbolTable.get(2);

      //Se quita de la tabla de simbolos
      symbolTable.remove(2, cad);

      splitted = cad.split(",");

      //Se arma la nueva cadena con el tipo de dato actualizado
      aux = splitted[0]+","+tipoLexema1+","+ splitted[2]+","+ splitted[3]+","+ splitted[4]+","+ splitted[5];

      //Se ingresa nuevamente en la tabla de simbolos
      symbolTable.putIfAbsent(2, aux);

      //Se arma la variable 1
      var1 = splitted[0];
      splitted = (cad = symbolTable.get(3)).split(",");
      var1 += splitted[0];

      //Se arma la variable 2
      cad2 = symbolTable.get(10);
      splitted = cad2.split(",");
      var2 = splitted[0];
      splitted = (cad = symbolTable.get(5)).split(",");
      var2 += splitted[0];

      //Se obtiene el operador de la expresion
      splitted = symbolTable.get(11).split(",");
      op = splitted[0];

      //Se arman las cadenas en la tabla auxiliar para guardar sus propiedades
      cadArm = var1+","+tipoLexema1;
      auxiliarTable.put(cont++, cadArm);
      cadArm = var2;
      auxiliarTable.put(cont++, cadArm);
      cadArm = op;
      auxiliarTable.put(cont++, cadArm);

      comprobar();
    }

    void comprobar(){
      //Se asigna el tipo de dato de la operacion
      switch (op) {
        case "==": 
          if(tipoLexema1.equals("Entero"))
            tipoOperacion = "Entero";
          else if (tipoLexema1.equals("Real"))
            tipoOperacion = "Real";
          else System.out.println("Error semántico");
        break;
        case "**": 
          if (tipoLexema1.equals("Entero") && tipoLexema2.equals("Entero"))
            tipoOperacion = "Entero";
          else if (tipoLexema1.equals("Real") && tipoLexema2.equals("Real"))
            tipoOperacion = "Real";
          else System.out.println("Error semántico");
        break;
      
        case "--": 
          if (tipoLexema1.equals("Entero") && tipoLexema2.equals("Entero"))
            tipoOperacion = "Entero";
          else if (tipoLexema1.equals("Real") && tipoLexema2.equals("Real"))
            tipoOperacion = "Real";
          else System.out.println("Error semántico");
        break;

        case "++": 
          if (tipoLexema1.equals("Entero") && tipoLexema2.equals("Entero"))
            tipoOperacion = "Entero";
          else if (tipoLexema1.equals("Real") && tipoLexema2.equals("Real"))
            tipoOperacion = "Real";
          else System.out.println("Error semántico");
        break;
        default:
          break;
      }

      symbolActualizada();
    }

    void symbolActualizada(){
      //Se extrae la cadena
      cad = symbolTable.get(2);

      //Se quita de la tabla de simbolos
      symbolTable.remove(2, cad);


      splitted = cad.split(",");

      //Se arma la nueva cadena con el tipo de dato actualizado
      aux = splitted[0]+","+tipoOperacion+","+ splitted[2]+","+ splitted[3]+","+ splitted[5];

      symbolTable.putIfAbsent(2, aux);

      //Para ingresar la variable 2
      cad3 = symbolTable.get(10);

      symbolTable.remove(10, cad3);


      splitted = cad3.split(",");

      // Se arma la nueva cadena con el tipo de dato actualizado
      aux = splitted[0] + "," + tipoOperacion + "," + splitted[2] + "," + splitted[3] + "," + splitted[5];
      
      symbolTable.putIfAbsent(10, aux);
      
      resultado();
    }

    void resultado(){
      enumerationSymbol = symbolTable.elements();
      System.out.println("\nTabla simbolos actualizada");
      // Si la tabla no esta vacia, muestrra su contenido
      if (!symbolTable.isEmpty()) {
        while (enumerationSymbol.hasMoreElements())
          System.out.println(enumerationSymbol.nextElement());
      }
    }
}
