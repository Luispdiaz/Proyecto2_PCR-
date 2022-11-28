
package proyecto2_pcr;

/**
 *
 @author Caicedo, Frank; Pernia, Luis; Rodriguez, Sebastian.
 */
//Creación de la clase de los Nodos apuntadores (NodoPila) a los Nodos del Árbol Binario, para manipular las Pilas.
public class NodoPila {
    private NodoArbol apuntadorArbol;
    private NodoPila pNext;

    public NodoPila(NodoArbol informacion) {
        this.apuntadorArbol = informacion;
        this.pNext = null;
    }

    public NodoArbol getApuntadorArbol() {
        return apuntadorArbol;
    }

    public void setApuntadorArbol(NodoArbol apuntadorArbol) {
        this.apuntadorArbol = apuntadorArbol;
    }

    public NodoPila getpNext() {
        return pNext;
    }

    public void setpNext(NodoPila pNext) {
        this.pNext = pNext;
    }
    
}
