
package proyecto2_pcr;

/**
 *
 * @author Caicedo, Frank; Pernia, Luis; Rodriguez, Sebastian.
 */

//Creación de la clase del Arbol Binario.
public class ArbolBinario {

    private NodoArbol pRoot;

    public ArbolBinario() {
        this.pRoot = null;
    }

    public NodoArbol getpRoot() {
        return pRoot;
    }

    public void setpRoot(NodoArbol pRoot) {
        this.pRoot = pRoot;
    }
    
    public boolean EsVacio(NodoArbol n){
            return n==null;
        }
    //Método para insertar Nodos en el Arbol Binario.
    public NodoArbol Insertar(NodoArbol Padre, String info) {      
        if (this.EsVacio(pRoot)) {
            NodoArbol nuevo = new NodoArbol(info);
            this.pRoot = nuevo;
            return nuevo;
        } 
        else if(Padre==null){
        return null;
        }
        else if (Padre.getpHijoIzquierdo() == null) {
            NodoArbol nuevo = new NodoArbol(info);
            Padre.setpHijoIzquierdo(nuevo);
            nuevo.setpPadre(Padre);
            return nuevo;
        } else if (Padre.getpHijoDerecho() == null) {
            NodoArbol nuevo = new NodoArbol(info);
            Padre.setpHijoDerecho(nuevo);
            nuevo.setpPadre(Padre);
            return nuevo;
        } 
        else {
            NodoArbol aux = Insertar(Padre.getpPadre(),info);
            return aux;
        }
    }
    //Método para imprimir la expresión prefija en la Interfaz mediante el recorrido en Preorden del Arbol Binario.
    public void ImprimirPreorden(NodoArbol padre, InterfazOrdenes ventanaOrdenes) {
        ventanaOrdenes.getPrefija().setText(ventanaOrdenes.getPrefija().getText() + padre.getInfo());
        if (padre.getpHijoIzquierdo() != null) {
            ImprimirPreorden(padre.getpHijoIzquierdo(),ventanaOrdenes);
        }
        if (padre.getpHijoDerecho() != null) {
            ImprimirPreorden(padre.getpHijoDerecho(),ventanaOrdenes);
        }
    }
    //Método para imprimir la expresión infija en la Interfaz mediante el recorrido en Inorden del Arbol Binario.
    public void ImprimirInorden(NodoArbol padre, InterfazOrdenes ventanaOrdenes) {
        if (padre.getpHijoIzquierdo() != null) {
            ImprimirInorden(padre.getpHijoIzquierdo(), ventanaOrdenes);
        }
        ventanaOrdenes.getInfija().setText(ventanaOrdenes.getInfija().getText() + padre.getInfo());
        if (padre.getpHijoDerecho() != null) {
            ImprimirInorden(padre.getpHijoDerecho(), ventanaOrdenes);
        }
    }
    //Método para imprimir la expresión posfija en la Interfaz mediante el recorrido en Posorden del Arbol Binario.
    public void ImprimirPosorden(NodoArbol padre, InterfazOrdenes ventanaOrdenes) {
        if (padre.getpHijoIzquierdo() != null) {
            ImprimirPosorden(padre.getpHijoIzquierdo(), ventanaOrdenes);
            if (padre.getpHijoDerecho() != null) {
                ImprimirPosorden(padre.getpHijoDerecho(), ventanaOrdenes);
            }
        }
        ventanaOrdenes.getPosfija().setText(ventanaOrdenes.getPosfija().getText() + padre.getInfo());
    }
    //Método para crear el Árbol Binario mediante la expresiones posfijas.
    public void ConvertirPosfijoArbol(String[] expresion) {
        Pila PilaConversion = new Pila();
        for (int i = 0; i != expresion.length; i++) {
            if ("+".equals(expresion[i]) || "/".equals(expresion[i]) || "*".equals(expresion[i]) || "-".equals(expresion[i]) || "^".equals(expresion[i])) {
                NodoPila aux1 = PilaConversion.desapilar();
                NodoPila aux2 = PilaConversion.desapilar();
                NodoArbol aux3 = new NodoArbol(expresion[i]);
                aux3.setpHijoIzquierdo(aux2.getApuntadorArbol());
                aux3.setpHijoDerecho(aux1.getApuntadorArbol());
                PilaConversion.apilar(aux3);
            } else {
                NodoArbol nuevo = new NodoArbol(expresion[i]);
                PilaConversion.apilar(nuevo);
            }
        }
        if("+".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())||"-".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())||"/".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())||"*".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())||"^".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())){
        NodoPila raiz = PilaConversion.desapilar();
        this.pRoot = raiz.getApuntadorArbol();
        }
    }
    //Método para comprobar si la expresion es posfija, en caso de solo tener numeros en la expresión.
    public boolean ComprobacionExpresionesPostfija(String[] expresion) {
        try{
        Pila PilaConversion = new Pila();
        for (int i = 0; i != expresion.length; i++) {
            if ("+".equals(expresion[i]) || "/".equals(expresion[i]) || "*".equals(expresion[i]) || "-".equals(expresion[i]) || "^".equals(expresion[i])) {
                NodoPila aux1 = PilaConversion.desapilar();
                NodoPila aux2 = PilaConversion.desapilar();
                if ("+".equals(expresion[i])) {
                    int aux3 = Integer.parseInt(aux1.getApuntadorArbol().getInfo()) + Integer.parseInt(aux2.getApuntadorArbol().getInfo());
                    NodoArbol nuevo = new NodoArbol(Integer.toString(aux3));
                    PilaConversion.apilar(nuevo);
                } else if ("-".equals(expresion[i])) {
                    int aux3 = Integer.parseInt(aux1.getApuntadorArbol().getInfo()) - Integer.parseInt(aux2.getApuntadorArbol().getInfo());
                    NodoArbol nuevo = new NodoArbol(Integer.toString(aux3));
                    PilaConversion.apilar(nuevo);
                } else if ("*".equals(expresion[i])) {
                    int aux3 = Integer.parseInt(aux1.getApuntadorArbol().getInfo()) * Integer.parseInt(aux2.getApuntadorArbol().getInfo());
                    NodoArbol nuevo = new NodoArbol(Integer.toString(aux3));
                    PilaConversion.apilar(nuevo);
                } else if ("/".equals(expresion[i])) {
                    int aux3 = Integer.parseInt(aux1.getApuntadorArbol().getInfo()) / Integer.parseInt(aux2.getApuntadorArbol().getInfo());
                    NodoArbol nuevo = new NodoArbol(Integer.toString(aux3));
                    PilaConversion.apilar(nuevo);
                } else if ("^".equals(expresion[i])) {
                    int aux3 = Integer.parseInt(aux2.getApuntadorArbol().getInfo());
                    for (int j = 0; j != Integer.parseInt(aux1.getApuntadorArbol().getInfo()); j++) {
                        aux3 = aux3 * Integer.parseInt(aux2.getApuntadorArbol().getInfo());
                    }
                    NodoArbol nuevo = new NodoArbol(Integer.toString(aux3));
                    PilaConversion.apilar(nuevo);
                } 
            }else {
                    NodoArbol nuevo = new NodoArbol(expresion[i]);
                    PilaConversion.apilar(nuevo);
                }
        }
        return PilaConversion.getCantidad() == 1;
        }
        catch(Exception e){
                return false;
        }
    }
    //Método para convertir expresiones infijas a posfijas.
    public String[] ConversionInfijaPostfija(String[] expresion) {
        Pila PilaConversion = new Pila();
        int tamano = 0;
        for (int p = 0; p != expresion.length; p++) {
            if("(".equals(expresion[p])||")".equals(expresion[p])){
            tamano+=1;
            }
        }
        String[] salida;
        salida = new String[expresion.length-tamano];
        for (int k = 0; k != expresion.length-tamano; k++) {
            salida[k] = "0";
        }
        for (int i = 0; i != expresion.length; i++) {
            if ("(".equals(expresion[i])) {
                NodoArbol nuevo = new NodoArbol("(");
                PilaConversion.apilar(nuevo);
            } else if ("+".equals(expresion[i])) {
                if(!PilaConversion.esVacia()){
                for (int j = 0; j != expresion.length; j++) {
                    
                    if ("*".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo()) || "/".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo()) || "^".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "+".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "-".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())) {
                        NodoPila aux1 = PilaConversion.desapilar();
                        for (int h = 0; h != expresion.length; h++) {
                            if ("0".equals(salida[h])) {
                                salida[h] = aux1.getApuntadorArbol().getInfo();
                                break;
                            }
                        }
                    } 
                    }
                }
                NodoArbol nuevo = new NodoArbol("+");
                PilaConversion.apilar(nuevo);
                
            } else if ("-".equals(expresion[i])) {
                if(!PilaConversion.esVacia()){
                for (int j = 0; j != expresion.length; j++) {
                    if ("*".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo()) || "/".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo()) || "^".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "+".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "-".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())) {
                        NodoPila aux2 = PilaConversion.desapilar();
                        for (int h = 0; h != expresion.length; h++) {
                            if ("0".equals(salida[h])) {
                                salida[h] = aux2.getApuntadorArbol().getInfo();
                                break;
                            }
                        }
                    } 
                }
                }
                NodoArbol nuevo = new NodoArbol("-");
                PilaConversion.apilar(nuevo);
            } else if ("*".equals(expresion[i])) {
                if(!PilaConversion.esVacia()){
                for (int j = 0; j != expresion.length; j++) {
                    if ("^".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "/".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "*".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())) {
                        NodoPila aux3 = PilaConversion.desapilar();
                        for (int h = 0; h != expresion.length; h++) {
                            if ("0".equals(salida[h])) {
                                salida[h] = aux3.getApuntadorArbol().getInfo();
                                break;
                            }
                        }
                    }   
                }
                }
                NodoArbol nuevo = new NodoArbol("*");
                PilaConversion.apilar(nuevo);
            } else if ("/".equals(expresion[i])) {
                if(!PilaConversion.esVacia()){
                for (int j = 0; j != expresion.length; j++) {
                    if ("^".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "/".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())|| "*".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())) {
                        NodoPila aux4 = PilaConversion.desapilar();
                        for (int h = 0; h != expresion.length; h++) {
                            if ("0".equals(salida[h])) {
                                salida[h] = aux4.getApuntadorArbol().getInfo();
                                break;
                            }
                        }
                    } 
                }
                }
                NodoArbol nuevo = new NodoArbol("/");
                PilaConversion.apilar(nuevo);
            } else if ("^".equals(expresion[i])) {
                NodoArbol nuevo = new NodoArbol("^");
                PilaConversion.apilar(nuevo);
                
            } else if (")".equals(expresion[i])) {
                for (int j = 0; j != expresion.length; j++) {
                    if (!"(".equals(PilaConversion.getpCima().getApuntadorArbol().getInfo())) {
                        NodoPila aux5 = PilaConversion.desapilar();
                        for (int h = 0; h != expresion.length; h++) {
                            if ("0".equals(salida[h])) {
                                salida[h] = aux5.getApuntadorArbol().getInfo();
                                break;
                            }
                        }
                    } else {
                        PilaConversion.desapilar();
                        break;
                    }
                }
            }
            else{          
            for (int h = 0; h != expresion.length; h++) {
                if ("0".equals(salida[h])) {
                    salida[h] = expresion[i];
                    break;
            }
            }
            }
        }

        for (int w = 0; w != PilaConversion.getCantidad(); w++) {
            if(!PilaConversion.esVacia()){
            NodoPila aux6 = PilaConversion.desapilar();
            for (int h = 0; h != expresion.length; h++) {
                if ("0".equals(salida[h])) {
                    salida[h] = aux6.getApuntadorArbol().getInfo();
                    break;
                }
            }
            }
            else{
            break;
            }
        }
        return salida;
    }
    //Método para crear el Árbol Binario mediante expresiones prefijas.
    public void ConvertirPrefijaArbol(NodoArbol padre, String[] expresion, int cont) {
        NodoArbol aux = this.Insertar(padre, expresion[cont]);
        if(cont!=expresion.length-1){
            if(aux!=null){
        if ("+".equals(aux.getInfo())||"/".equals(aux.getInfo()) ||"*".equals(aux.getInfo()) ||"-".equals(aux.getInfo()) ||"^".equals(aux.getInfo())) {
            ConvertirPrefijaArbol(aux,expresion,cont+=1);
        }
        aux = aux.getpPadre();
        ConvertirPrefijaArbol(aux,expresion,cont+=1);
        }
        }
    }
}
