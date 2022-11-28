
package proyecto2_pcr;

/**
 *
 * @author Caicedo, Frank; Pernia, Luis; Rodriguez, Sebastian.
 */
//Creación de la clase de los Nodos para el Árbol Binario.
public class NodoArbol {
    private String info;
    private NodoArbol pHijoIzquierdo;
    private NodoArbol pHijoDerecho;
    private NodoArbol pPadre;

    public NodoArbol(String info) {
        this.info = info;
        this.pHijoIzquierdo = null;
        this.pHijoDerecho = null;
        this.pPadre = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public NodoArbol getpHijoIzquierdo() {
        return pHijoIzquierdo;
    }

    public void setpHijoIzquierdo(NodoArbol pHijoIzquierdo) {
        this.pHijoIzquierdo = pHijoIzquierdo;
    }

    public NodoArbol getpHijoDerecho() {
        return pHijoDerecho;
    }

    public void setpHijoDerecho(NodoArbol pHijoDerecho) {
        this.pHijoDerecho = pHijoDerecho;
    }

    public NodoArbol getpPadre() {
        return pPadre;
    }

    public void setpPadre(NodoArbol pPadre) {
        this.pPadre = pPadre;
    }
    
    public boolean Eshoja(){
    return this.getpHijoIzquierdo() == null;
    }
    
}
