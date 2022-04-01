public class IdentificaER {
    ExpresionesRegulares exre = new ExpresionesRegulares();
    String[] split;

    public IdentificaER(String[] split){
      this.split = split;
    }


    void imprimeER(){
    System.out.println("============Expresiones Regulares================");
    for (int i = 0; i < split.length; i++) {
      if (exre.letras(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Letras");
        System.out.println("Expresión Regular: "+exre.Letras);
        System.out.println("---------------------------------------------");
      }
      if (exre.numeros(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Digitos");
        System.out.println("Expresión Regular: " + exre.Digitos);
        System.out.println("---------------------------------------------");
      }
      if (exre.libER(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Definición de biblioteca");
        System.out.println("Expresión Regular: " + exre.biblio);
        System.out.println("---------------------------------------------");
      }
      if (exre.varER(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Variables");
        System.out.println("Expresion Regular: " + exre.Variable);
        System.out.println("---------------------------------------------");
      }
      if (exre.constCharER(split[i])) {
        System.out.println("Palabra: "+split[i]);
        System.out.println("Clasificación: Constante de caracter");
        System.out.println("Expresión Regular: "+exre.constanteC);
        System.out.println("---------------------------------------------");
      }
      if (exre.asigER(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Asignación");
        System.out.println("Expresión Regular: " + exre.asignacion);
        System.out.println("---------------------------------------------");
      }
      if (exre.metodoER(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Declaración de un método");
        System.out.println("Expresión Regular: " + exre.metodo);
        System.out.println("---------------------------------------------");
      }
      if (exre.repER(split[i])) {
        String repString = "Repetir<iterador,condicion,incremento>{expresion}";
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Ciclo Repetir");
        System.out.println("Expresión Regular: " + repString);
        System.out.println("---------------------------------------------");
      }
      if (exre.mientER(split[i])) {
        String mienString = "Mientras<Condición>{Expresión}";
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Ciclo Mientras");
        System.out.println("Expresión Regular:" + mienString);
        System.out.println("---------------------------------------------");
      }
      if (exre.hazER(split[i])) {
        String hazString = "Haz {Expresión} Mientras <Condición>";
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Ciclo Haz-Mientras");
        System.out.println("Expresión Regular: " + hazString);
        System.out.println("---------------------------------------------");
      }
      if (exre.condicER(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Condicionales");
        System.out.println("Expresión Regular: "+exre.condicion);
        System.out.println("---------------------------------------------");
      }
      if (exre.impER(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Palabra Reservada");
        System.out.println("Expresión Regular: "+exre.imprime);
        System.out.println("---------------------------------------------");
      }
      if (exre.escER(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: Secuencia de escape");
        System.out.println("Expresión Regular: "+exre.escape);
        System.out.println("---------------------------------------------");
      }
      if (exre.cadenas(split[i])) {
        System.out.println("Palabra: " + split[i]);
        System.out.println("Clasificación: cadena");
        System.out.println("Expresión Regular: " + exre.Cadena);
        System.out.println("---------------------------------------------");
      }
    }
  }
}
