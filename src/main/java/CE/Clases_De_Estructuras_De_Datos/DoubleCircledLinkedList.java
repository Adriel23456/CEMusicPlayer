package CE.Clases_De_Estructuras_De_Datos;

import CE.Clases_Principales.Song;

/**
 * Esta es la clase de lista doblemente enlazada circular, la cual, nos permitirá guardar las instancias de un objeto por posición en una lista, y, tener un movimiento continuo en esta.
 * @param <T>
 * @author Adriel
 */
public class DoubleCircledLinkedList<T>{
    private Node<T> head;
    private int numberOfElements;

    /**
     * Aquí se establecen los valores predeterminados de la lista circular.
     */
    public DoubleCircledLinkedList() {
        this.head = null;
        this.numberOfElements = 0;
    }

    /**
     * Este método nos permite indicar que la lista circular actual está vacía.
     * @return Vuelve el atributo de la clase Node a null.
     */
    public boolean isEmpty(){
        return this.head == null;
    }

    /**
     * Este método nos permite obtener la cantidad de elementos que hay en la lista circular actual.
     * @return Retorna un int con la cantidad de elementos.
     */
    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    /**
     * Este método nos permite añadir un valor al final de la lista circular.
     * @param data Se establece que requiere de una información "T" para añadirla a la lista actual.
     */
    public void addCircled(T data){
        //En el caso que la lista este vacía, generara un nuevo Nodo y lo establecerá como el primero:
        if(isEmpty()){
            this.head = new Node<T>(this.head, this.head, data);
        }
        //En el caso que la lista no este vacía, va a recorrer toda la lista hasta llegar al último elemento, y,
        // generara el nuevo Nodo:
        else{
            Node<T> temporal = new Node<T>(this.head, this.head.getPrevious(), data);
            temporal.getPrevious().setNext(temporal);
            this.head.setPrevious(temporal);
        }
        this.numberOfElements++;
    }

    /**
     * Este método nos permite eliminar, utilizando la posición del elemento, un Nodo de la lista circular.
     * @param position Se establece la posición del elemento que se desea eliminar
     */
    public void remove(int position){
        if (this.getNumberOfElements() > position){
            Node<T> temporal = this.head;
            for (int i = 0; i < position - 1; i++){
                temporal = temporal.getNext();
            }
            //Aquí se indica que, si el nodo a eliminar es el primer elemento, entonces simplemente cambia el valor al siguiente Node y, se le indica al último elemento
            if (getNumberOfElements() != 1) {
                temporal.getPrevious().setNext(temporal.getNext());
                temporal.getNext().setPrevious(temporal.getPrevious());
            }
            else{
                this.head = null;
            }
            this.numberOfElements--;
        }
        else{System.out.println("Index out of range");}
    }

    /**
     * Este método nos permite obtener un elemento utilizando la posición que le indiquemos al programa.
     * @param position Se establece la posición en la lista que se desea buscar.
     * @return Este método puede retornar null si la posición indicada está fuera del rango, o, retorna la información del Nodo indicado en la lista actual.
     */
    public T getElement(int position){
        if(this.numberOfElements > position){
            Node<T> temporal = this.head;
            //Aquí recorre la lista hasta que encuentre a la posición correcta y retorna la data "T" del Node
            for (int i = 0; i < position; i++){
                temporal = temporal.getNext();
            }
            return temporal.getData();
        }
        System.out.println("Index out of range");
        return null;
    }


    /**
     * Este método nos permite obtener un elemento utilizando la posición que le indiquemos al programa.
     * @param position Se establece la posición en la lista que se desea buscar.
     * @return Este método puede retornar null si la posición indicada está fuera del rango, o, retorna la información del Nodo indicado en la lista actual.
     */
    public T setElement_Song(int position){
        if(this.numberOfElements > position){
            Node<T> temporal = this.head;
            //Aquí recorre la lista hasta que encuentre a la posición correcta y retorna la data "T" del Node
            for (int i = 0; i < position; i++){
                temporal = temporal.getNext();
            }
            return temporal.getData();
        }
        System.out.println("Index out of range");
        return null;
    }

    /**
     * Este método nos permite obtener todas las informaciones de los nodos en la lista circular, los representa como un "string" y, los introduce en un variable.
     * @return Este método nos retorna la información de los nodos de la lista actual, los cuales fueron guardados en la variable "s", junto con un salto de línea.
     */
    public String toString(){
        String s = "{ ";
        Node<T> node = this.head;
        if (node == null)
            return s + " }";
        while (node.getNext() != null){
            s += String.valueOf(node.getData())+" \n-> ";
            node = node.getNext();
        }
        s += String.valueOf(node.getData());
        return s + "\n}";
    }
}