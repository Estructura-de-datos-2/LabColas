package colas;

public class ColaEnlazada<T> {

    // Cada nodo guarda un dato y apunta al siguiente
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    private Nodo<T> frente; // primer nodo (de aquí se saca)
    private Nodo<T> fin;    // último nodo (aquí se agrega)
    private int tamanio;    // cuántos elementos hay

    // Dice si la cola no tiene elementos
    public boolean estaVacia() {
        return frente == null;
    }

    // Devuelve cuántos elementos hay
    public int tamanio() {
        return tamanio;
    }

    // Agrega un elemento al final
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevo;        // cola vacía: es el primero y el último
        } else {
            fin.siguiente = nuevo; // se enlaza después del último
        }
        fin = nuevo;
        tamanio++;
    }

    // Quita y devuelve el elemento del frente
    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null; // la cola quedó vacía
        }
        tamanio--;
        return dato;
    }

    // Devuelve el elemento del frente sin quitarlo
    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return frente.dato;
    }

    // Muestra los elementos del frente al final sin borrarlos
    public void imprimirCola() {
        Nodo<T> actual = frente;
        StringBuilder sb = new StringBuilder("[");
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        System.out.println(sb.append("]"));
    }

    // Deja la cola sin elementos
    public void vaciar() {
        frente = null;
        fin = null;
        tamanio = 0;
    }
}
