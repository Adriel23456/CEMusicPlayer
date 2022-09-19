package Clases_De_Estructuras_De_Datos;


public class DoubleLinkedList<T>{
    //Atributos de la clase
    private Node<T> head;
    private int numberOfElements;


    //Valores predeterminados de la clase de la lista
    public DoubleLinkedList() {
        this.head = null;
        this.numberOfElements = 0;
    }


    //---------------------EMPTY LIST---------------------
    //Si la funcion isEmpty() se cumple porque el siguiente valor de la lista es "null"
    public boolean isEmpty(){
        return this.head == null;
    }



    //---------------------HOW MANY ELEMENTS---------------------
    //una funcion para saber la cantidad de elementos que pose la lista
    public int numberOfElements() {
        return this.numberOfElements;
    }



    //---------------------ADD---------------------
    //Una funciona para añadir valores, al principio o al final de la lista
    public void add(T data){
        //Se va a preguntar si la lista esta vacia y, si lo esta, entonces agrega asi la informacion:
        if(isEmpty()){
            this.head = new Node<T>(null, null, data);
        }
        //Se va a preguntar si la lista no esta vacia y, si no lo esta, entonces agrega asi la informacion:
        else{
            Node<T> temporal = this.head;
            for(; temporal.getNext() != null; temporal = temporal.getNext());
            temporal.setNext(new Node(null, temporal, data));
        }
        this.numberOfElements++;
    }


    //---------------------REMOVE---------------------
    //Una funciona para remover valores en base a la posicion del elemento de la lista
    public void remove(int position){
        if (this.numberOfElements > position){
            Node<T> temporal = this.head;
            for (int i = 0; i < position; i++){
                temporal = temporal.getNext();
            }
            if(temporal == this.head){
                this.head = temporal.getNext();
            }
            else{
                temporal.getPrevious().setNext(temporal.getNext());
                if (temporal.getNext() != null) {
                    temporal.getNext().setPrevious(temporal.getPrevious());
                }
            }
            this.numberOfElements--;
        }
        else{System.out.println("Index out of range");}
    }




    //------------------------GET ELEMENT------------------------
    //Funcion para obtener un elemento en base a la posicion que le indiquemos al programa
    public T getElement(int position){
        if(this.numberOfElements > position){
            Node<T> temporal = this.head;

            for (int i = 0; i < position; i++){
                temporal = temporal.getNext();
            }
            return temporal.getData();
        }
        System.out.println("Index out of range");
        return null;
    }




    //---------------------NUMBER OF ELEMENTS---------------------
    //Funcion para obtener el numero de elementos que hay en la lista
    public int getNumberOfElements(){
        return this.numberOfElements;
    }



    //---------------------PRINT LIST---------------------
    //Funcion para imprimir todos los valores de la lista (Como String's) en orden, sirve para repasar la lista
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