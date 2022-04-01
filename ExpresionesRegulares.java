import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {
  //Se crean variables donde se guardarán la expresiones regulares
  String Letras, Digitos, Operador, Delimitador,Variable,constanteC, Expresion,
         iterador, incremento, condicion, escape, asignacion, biblio, princ,
         metodo, imprime, mark, palabrasRes, Cadena;
  //En el constructor se delcaran las expresiones regulares
  public ExpresionesRegulares(){
    //Se inicializan las variables con sus respectivas ER
    Letras = "[a-zA-Z]";
    Digitos = "[0-9]";
    Cadena = "\""+Letras+"*\"";
    Operador = "\\+\\+|--|\\*\\*|\\/\\/|%%|\\.-|\\.\\+|==|<=|>=|!=|->";
    Delimitador = "<|>|:|\\$|#|=|\"|\\{|\\}|\\(|\\)|'";
    Variable = "\\$"+Letras+"+"+Digitos+"*";
    constanteC = "#"+Letras+"+"+Digitos+"*";
    iterador = Variable+Operador+Digitos+"+";
    incremento = Variable+Operador;
    condicion =  Variable+"\\s*("+Operador+")\\s*[0-9]+\\s*|";
    condicion += Variable+"\\s*("+Operador+")\\s*"+Variable+"\\s*|";
    condicion += Digitos+"+\\s*("+Operador+")\\s*"+Digitos+"+";
    escape = "\\\\[ntrfb\'\"]";
    asignacion = "("+Variable+"|"+constanteC+")\\s*=\\s*[0-9]+|\\";
    asignacion += constanteC+"\\s*=\\s*'[a-zA-Z]?'";
    biblio = "Lib-"+Letras+"+\\.lib";
    imprime = "Imp\\s*->\"\\s*" + Letras + "*\\s*\"\\s*|";
    imprime += "Imp\\s*->\"\\s*" + Variable + "\\s*|Imp\\s*Imp\\s*->\"\\s*";
    imprime += constanteC + "\\s*";
    palabrasRes = "Imp|Lib-|.lib";

    metodo = "[a-zA-Z]+[0-9]*\\(\\)\\{("+Expresion+"\\})+";
  }
  /*Se crean métodos de tipo boolean para evaluar si la cadena coincide
  con la expresion regular*/
  boolean constCharER(String cadena){
    /* Si la ER coincide con la cadena ingresada por el usuario devuelve
    true, de otro modo devuelve false*/
    Pattern ccp = Pattern.compile(constanteC);
    Matcher ccm = ccp.matcher(cadena);
    if (ccm.matches()) {
      mark = "ID";
      return true;
    }
    return false;
  }
  //ER de las librerias
  boolean libER(String cadena) {
    Pattern lp = Pattern.compile(biblio);
    Matcher lm = lp.matcher(cadena);
    if (lm.matches()) {
      mark = "PR";
      return true;
    }
    return false;
  }
  // ER de las variables
  boolean varER(String cadena) {
    Pattern vp = Pattern.compile(Variable);
    Matcher vm = vp.matcher(cadena);
    if (vm.matches()) {
      mark = "ID";
      return true;
    }
    return false;
  }
  // ER de las condiciones
  boolean condicER(String cadena) {
    Pattern cp = Pattern.compile(condicion);
    Matcher cm = cp.matcher(cadena);
    if (cm.matches()) {
      mark = "ID";
      return true;
    }
    return false;
  }
  // ER de ciclo repetir(for)
  boolean repER(String cadena){
    String repPatron = "Repetir\\s*<\\s*"+Variable+"\\s*=\\s*[0-9]+";
    repPatron += "\\s*,\\s*"+Variable+"\\s*("+Operador+")\\s*[0-9]+\\s*";
    repPatron += ",\\s*"+Variable+"\\s*("+Operador;
    repPatron += ")\\s*>\\s*\\{\\s*[a-zA-Z]+\\}\\s*";
    Pattern rp = Pattern.compile(repPatron);
    Matcher rm = rp.matcher(cadena);
    if (rm.matches()) {
      mark = "PR";
      return true;
    }
    return false;
  }
  // ER de ciclo Mientras(While)
  boolean mientER(String cadena){
    String mienPatron = "Mientras\\s*<\\s*"+Variable+"\\s*("+Operador;
    mienPatron += ")\\s*[0-9]+\\s*>\\s*\\{\\s*[a-zA-Z]+\\}\\s*";
    Pattern mp = Pattern.compile(mienPatron);
    Matcher mm = mp.matcher(cadena);
    if (mm.matches()) {
      mark = "PR";
      return true;
    }
    return false;
  }
  // ER de ciclo haz-mientras (do-while)
  boolean hazER(String cadena) {
    String hazPatron = "Haz\\s*\\{\\s*[a-zA-Z]+\\s*\\}\\s*Mientras\\s*<\\s*";
    hazPatron += Variable+"\\s*("+Operador+")\\s*[0-9]+\\s*>\\s*";
    Pattern hp = Pattern.compile(hazPatron);
    Matcher hm = hp.matcher(cadena);
    if (hm.matches()) {
      mark = "PR";
      return true;
    }
    return false;
  }
  // ER de palabara reservada de impresion
  boolean impER(String cadena) {
    Pattern imp = Pattern.compile(imprime);
    Matcher imm = imp.matcher(cadena);
    if (imm.matches()) {
      mark = "PR";
      return true;
    }
    return false;
  }
  // ER para las secuencias de escape
  boolean escER(String cadena){
    Pattern ep = Pattern.compile(escape);
    Matcher em = ep.matcher(cadena);
    if (em.matches()) {
      mark = "ESC";
      return true;
    }
    return false;
  }
  // ER de las asignaciones
  boolean asigER(String cadena) {
    Pattern ap = Pattern.compile(asignacion);
    Matcher am = ap.matcher(cadena);
    if (am.matches()) {
      mark = "ID";
      return true;
    }
    return false;
  }
  // ER de los métodos
  boolean metodoER(String cadena) {
    Pattern mep = Pattern.compile(metodo);
    Matcher mem = mep.matcher(cadena);
    if (mem.matches()) {
      mark = "DEL";
      return true;
    }
    return false;
  }

  boolean delimitador(String cadena) {
    Pattern dp = Pattern.compile(Delimitador);
    Matcher dm = dp.matcher(cadena);
    if (dm.matches()) {
      mark = "DEL";
      return true;
    }
    return false;
  }

  boolean operador(String cadena) {
    Pattern op = Pattern.compile(Operador);
    Matcher om = op.matcher(cadena);
    if (om.matches()) {
      mark = "OP";
      return true;
    }
    return false;
  }

  boolean letras(String cadena) {
    Pattern lp = Pattern.compile(Letras+"*");
    Matcher lm = lp.matcher(cadena);
    if (lm.matches()) {
      mark = "ID";
      return true;
    }
    return false;
  }

  boolean numeros(String cadena) {
    Pattern np = Pattern.compile(Digitos+"*");
    Matcher nm = np.matcher(cadena);
    if (nm.matches()) {
      mark = "INT";
      return true;
    }
    return false;
  }

  boolean reservadas(String cadena){
    Pattern patronPR = Pattern.compile(palabrasRes);
    Matcher matcherPR = patronPR.matcher(cadena);
    if (matcherPR.matches()) {
      mark = "PR";
      return true;
    }
    return false;
  }

  boolean cadenas(String cadena) {
    Pattern patronCad = Pattern.compile(Cadena);
    Matcher matcherCad = patronCad.matcher(cadena);
    if (matcherCad.matches()) {
      mark = "ID";
      return true;
    }
    return false;
  }
}
