public class PilaA {
    private Nodo ultimoDato;

    public PilaA(){
        ultimoDato = null;
    }

    //Método insertar
    public void insert(String valor){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.dato = valor;

        if (ultimoDato == null) {
            nuevoNodo.siguiente = null;
            ultimoDato = nuevoNodo;
        }else{
            nuevoNodo.siguiente = ultimoDato;
            ultimoDato = nuevoNodo;
        }
    }

    //Metodo extraer
    public String extract(){
        if (ultimoDato != null) {
            String info = ultimoDato.dato;
            ultimoDato = ultimoDato.siguiente;
            return info;
        }else return "";
    }

    public boolean empty(){
        return ultimoDato == null;
    }
}
