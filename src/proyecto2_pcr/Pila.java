
package proyecto2_pcr;

/**
 *
 @author Caicedo, Frank; Pernia, Luis; Rodriguez, Sebastian.
 */
//Creación de la clase de la Pila.
public class Pila {
    
    private NodoPila pCima;
    private int cantidad;

    public Pila() {
        this.pCima = null;
        this.cantidad = 0;
    }

    public NodoPila getpCima() {
        return pCima;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setpCima(NodoPila pCima) {
        this.pCima = pCima;
    }
    
    public boolean esVacia(){
        return pCima == null;
    }
    
    public void apilar(NodoArbol valor){
        NodoPila nuevo = new NodoPila(valor);
        if (esVacia()) {
            pCima = nuevo;
            cantidad += 1;
        }
        // Caso contrario agrega el nuevo nodo al inicio de la pila.
        else{
            nuevo.setpNext(pCima);
            pCima = nuevo;
            cantidad += 1;
        }
    } 
    
    public NodoPila desapilar(){
        if (!esVacia()) {
            NodoPila aux = pCima;
            pCima = pCima.getpNext();
            cantidad -= 1;
            return aux;
        }
        return null;
    }
    
}
