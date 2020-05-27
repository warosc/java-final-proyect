
public class Pilas {

    private Nodo cima;
    public Pilas() {
        cima = null;
    }


    public boolean pilaVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    public void add(int elemento) {
        Nodo nuevo;
        nuevo = new Nodo(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        System.out.println("Elemento agregado");
    }

    public int delete() {
        if (pilaVacia()) {
            return -1;
        }
        int aux = cima.elemento;
        cima = cima.siguiente;
        System.out.println("Elemento eliminado: " + aux);
        return aux;
    }

    public void empty() {
        Nodo t;
        while (!pilaVacia()) {
            t = cima;
            cima = cima.siguiente;
            t.siguiente = null;
        }
    }

    public void list() {
        if (pilaVacia()) {
            System.out.println("La pila esta vacia");
        } else {
            Nodo t;
            t = cima;
            while (t != null) {
                System.out.println("Dato: " + t.elemento);
                t = t.siguiente;
            }
        }
    }

}