import java.io.*;

public class SintaxMain {
  String cadena = "", split[]= {}, archivo = "program.txt"; 

  void info() {
  String mensaje = "";
    mensaje = "\nPrograma que permite validar un lenguaje en\n";
    mensaje += "con ayuda de un analizador sintactico\n";
    System.out.println(mensaje);
  }

  void datos() throws FileNotFoundException, IOException{
    //Se lee de un archivo la cadena a evaluar en el analizador sintactico
    File arch = new File(archivo);
    BufferedReader buffer = new BufferedReader (new FileReader (arch));
    while ((cadena = buffer.readLine ()) != null) {    
      split = cadena.split(" ");
      llamaAs(cadena);
    }
    buffer.close();
  }

  //Se llama al analizador lexico que a su vez llama al analizador sintactico
  void llamaAs(String cadena){
    Tablas al = new Tablas(cadena, split);

    al.automata();
    al.AnalisisSintactico();
    al.tablaSimbolos();
  }

  public static void main(String[] args) throws FileNotFoundException, 
                                                IOException{
   SintaxMain ax = new SintaxMain();

   ax.info();
   ax.datos();
  }
}
