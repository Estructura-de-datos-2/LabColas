package colas;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) {
        System.out.println("Entorno listo\n");
        parte1();
	parte2();
	parte3();
	parte4();
    }

    // Parte 1: prueba el arreglo circular
    static void parte1() {
        System.out.println("\nparte 1 Cola Arreglo \n");
        ColaArreglo cola = new ColaArreglo(3);
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        System.out.println("Sale: " + cola.desencolar()); // 10
        cola.encolar(40);                                  // aquí el arreglo da la vuelta
        System.out.println("Frente: " + cola.frente());    // 20
        System.out.println("Tamaño: " + cola.tamanio());   // 3
        System.out.println("¿Llena? " + cola.estaLlena()); // true
    }
	
	// Parte 2: prueba el arreglo enlazado
    static void parte2() {
        System.out.println("\nparte 2 Cola Enlazada\n");
	ColaEnlazada<String> nombres = new ColaEnlazada<>(); 
	nombres.encolar("Ana");
	nombres.encolar("Luis"); 
	nombres.encolar("María");
	System.out.println(nombres.desencolar());	 // Ana 
	System.out.println(nombres.frente());	// Luis 
	System.out.println(nombres.tamanio());	 // 2 

    }
	

	static void parte3() {
    	Queue<String> cola = new LinkedList<>();
	System.out.println("\n Parte3 La interfas Queue de Java ");
    	cola.offer("A");
    	cola.offer("B");
    	cola.offer("C");
    	System.out.println("peek: " + cola.peek());   // A
    	System.out.println("poll: " + cola.poll());   // A
    	System.out.println("size: " + cola.size());   // 2
	

	System.out.println("\n Parte3.2 ");
    	// Paso 3.2: con la cola vacía
    	Queue<String> vacia = new LinkedList<>();
    	try { vacia.remove(); } catch (Exception e) { System.out.println("remove() -> " + e.getClass().getSimpleName()); }
    	System.out.println("poll() -> " + vacia.poll());
    	try { vacia.element(); } catch (Exception e) { System.out.println("element() -> " + e.getClass().getSimpleName()); }
    	System.out.println("peek() -> " + vacia.peek());	
	
	}

	// Parte 4:banmco
static void parte4() {
	System.out.println("\n Parte 4: banco ");
    	ColaEnlazada<String> fila = new ColaEnlazada<>();
    	Scanner sc = new Scanner(System.in);
    	int opcion = 0;

    do {
        System.out.println("\n1. Llega un cliente");
        System.out.println("2. Atender al siguiente cliente");
        System.out.println("3. Ver quién sigue");
        System.out.println("4. Ver cantidad en espera");
        System.out.println("5. Salir");
        System.out.print("Opción: ");

        try {
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            opcion = 0;
        }
        sc.nextLine(); // limpia el Enter

        switch (opcion) {
            case 1:
                System.out.print("Nombre del cliente: ");
                String nombre = sc.nextLine().trim();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                } else {
                    fila.encolar(nombre);
                    System.out.println(nombre + " se formó en la fila.");
                }
                break;
            case 2:
                if (fila.estaVacia()) {
                    System.out.println("No hay clientes en espera");
                } else {
                    System.out.println("Atendiendo a: " + fila.desencolar());
                }
                break;
            case 3:
                if (fila.estaVacia()) {
                    System.out.println("No hay clientes en espera");
                } else {
                    System.out.println("Sigue: " + fila.frente());
                }
                break;
            case 4:
                System.out.println("Clientes en espera: " + fila.tamanio());
                break;
            case 5:
                System.out.println("Fin de la simulación.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    } while (opcion != 5);
    sc.close();
}
	
}
