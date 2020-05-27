public class Colas {

    private Nodo raiz, cima;

    public Colas() {
        raiz = null;
        cima = null;
    }

    public boolean colaVacia (){
        if (raiz == null)
            return true;
        else
            return false;
    }

    public void add (int dato)
    {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = null;
        if (colaVacia ()) {
            raiz = nuevo;
            cima = nuevo;
        } else {
            cima.siguiente = nuevo;
            cima = nuevo;
        }
    }

    public int delete(){
        if (colaVacia()) {
            System.out.println("La cola esta vacia");
            return -1;
        }
        int aux = raiz.elemento;
        if (raiz == cima){
            raiz = null;
            cima = null;
        } else {
            raiz = raiz.siguiente;
        }
        System.out.println("Dato eliminado: " + aux);
        return aux;
    }

    public void list() {
        Nodo t = raiz;
        while (t != null) {
            System.out.println("Dato: " + t.elemento);
            t = t.siguiente;
        }
    }

    public void empty() {
        while (!colaVacia()) {
            raiz = raiz.siguiente;
        }
    }

}