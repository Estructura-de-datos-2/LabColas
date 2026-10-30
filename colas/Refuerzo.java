package colas;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// Ejercicios de refuerzo 3, 4 y 5
public class Refuerzo {

    // Ejercicio 3: invertir una cola con una pila
    public static <T> void invertir(Queue<T> cola) {
        Deque<T> pila = new ArrayDeque<>();
        while (!cola.isEmpty()) pila.push(cola.poll());
        while (!pila.isEmpty()) cola.offer(pila.pop());
    }

    // Ejercicio 4: cola hecha con dos pilas
    public static class ColaConDosPilas<T> {
        private final Deque<T> entrada = new ArrayDeque<>();
        private final Deque<T> salida = new ArrayDeque<>();

        public void encolar(T dato) { entrada.push(dato); }

        public T desencolar() {
            trasladar();
            if (salida.isEmpty()) throw new IllegalStateException("La cola está vacía");
            return salida.pop();
        }

        public T frente() {
            trasladar();
            if (salida.isEmpty()) throw new IllegalStateException("La cola está vacía");
            return salida.peek();
        }

        public boolean estaVacia() { return entrada.isEmpty() && salida.isEmpty(); }

        private void trasladar() {
            if (salida.isEmpty()) {
                while (!entrada.isEmpty()) salida.push(entrada.pop());
            }
        }
    }

    // Nodo de árbol para el ejercicio 5
    public static class NodoArbol {
        int valor;
        NodoArbol izq, der;
        NodoArbol(int valor) { this.valor = valor; }
    }

    // Ejercicio 5: recorrido por niveles (BFS) con una cola
    public static void recorrerPorNiveles(NodoArbol raiz) {
        if (raiz == null) return;
        Queue<NodoArbol> cola = new LinkedList<>();
        cola.offer(raiz);
        while (!cola.isEmpty()) {
            NodoArbol n = cola.poll();
            System.out.print(n.valor + " ");
            if (n.izq != null) cola.offer(n.izq);
            if (n.der != null) cola.offer(n.der);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 4; i++) q.offer(i);
        invertir(q);
        System.out.println("Invertida: " + q); // [4, 3, 2, 1]

        ColaConDosPilas<String> c2 = new ColaConDosPilas<>();
        c2.encolar("a"); c2.encolar("b"); c2.encolar("c");
        System.out.println("Dos pilas: " + c2.desencolar() + c2.desencolar() + c2.desencolar()); // abc

        NodoArbol r = new NodoArbol(1);
        r.izq = new NodoArbol(2); r.der = new NodoArbol(3);
        r.izq.izq = new NodoArbol(4); r.izq.der = new NodoArbol(5);
        System.out.print("BFS: ");
        recorrerPorNiveles(r); // 1 2 3 4 5
    }
}
