package colas;

/*
*clase ColaArreglo 
*@autor José Emmanuel Arredondo Escalante
*@date 30 de octubre 2026
*/
public class ColaArreglo {

    private int[] datos;   // aqui se guardan los elementos
    private int inicio;    // posicion del frente
    private int fin;       // posición del último elemento
    private int tamanio;   // cuántos elementos hay
    private int capacidad; // maximo de elementos

    // Crea una cola vacia con la capacidad indicada
    public ColaArreglo(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.inicio = 0;
        this.fin = -1;
        this.tamanio = 0;
    }

    // Dice si la cola no tiene elementos
    public boolean estaVacia() {
        return tamanio == 0;
    }

    // Dice si la cola ya no tiene espacio
    public boolean estaLlena() {
        return tamanio == capacidad;
    }

    // Devuelve cuántos elementos hay
    public int tamanio() {
        return tamanio;
    }

    // Agrega un elemento al final
    public void encolar(int valor) {
        if (estaLlena()) {
            throw new IllegalStateException("La cola está llena");
        }
        fin = (fin + 1) % capacidad; // el % hace que dé la vuelta
        datos[fin] = valor;
        tamanio++;
    }

    // Quita y devuelve el elemento del frente
    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        int valor = datos[inicio];
        inicio = (inicio + 1) % capacidad;
        tamanio--;
        return valor;
    }

    // Devuelve el elemento del frente sin quitarlo
    public int frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return datos[inicio];
    }
}
