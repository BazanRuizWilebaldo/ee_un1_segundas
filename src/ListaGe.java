/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILY
 */
public class ListaGe<T extends Comparable<T>> {

    public NodoGe<T> getInicio() {
        return inicio;
    }

    public void setInicio(NodoGe<T> inicio) {
        this.inicio = inicio;
    }

    NodoGe<T> inicio;

    public ListaGe() {

    }

    // Crear un elemento cuando inicie la lista
    public ListaGe(T inicio) {
        this.inicio = new NodoGe<T>(inicio);
    }

    /**
     * Metodo que permite insertar un elemento al inicio de la lista
     *
     * @param dato
     */
    public void inserta_inicio(T dato) {
        NodoGe<T> newDato = new NodoGe<T>(dato);
        newDato.setSiguiente(inicio);
        inicio = newDato;
    }

    /**
     * Insertar al final de la lista
     *
     * @param dato
     */
    public void inserta_final(T dato) {
        NodoGe<T> temporal, newDato = new NodoGe<T>(dato);
        temporal = inicio;
        if (temporal == null) { // lista vacia
            inicio = newDato;
        } else {
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(newDato);
        }
    }

    public int numDele() {
        NodoGe<T> aux;
        int numEleme = 0;
        aux = inicio;
        while (aux != null) {
            numEleme++;
            aux = aux.getSiguiente();

        }
        return numEleme;

    }

    public T devolerXposi(int pos) {
        NodoGe<T> aux = inicio;
        int contador = 0;
        T dato = null;
        if (pos < 0 || pos >= numDele()) {
            System.out.println("la posicion de elemento no existe");
        } else {
            while (aux != null) {
                if (pos == contador) {

                    dato = aux.getDato();

                }
                aux = aux.getSiguiente();

                contador++;

            }

        }
        return dato;

    }

    /**
     * Metodo que recorre la lista de forma recursiva para imprimir todos los
     * elementos de la misma
     *
     * @param p el inicio de la lista
     * @return Un String con los elementos de la misma
     */
    public String recorreRecursivo(NodoGe<T> p) {
        if (p != null) {
            return p.toString() + recorreRecursivo(p.getSiguiente());
        } else {
            return "null";
        }

    }

    /**
     * Metodo que recorre la lista de manera iterativa
     *
     * @return el String con la lista
     */
    public String recorreIterativo() {
        String resultado = "";
        NodoGe<T> temporal = inicio;
        while (temporal != null) {
            resultado += temporal.getDato();
            temporal = temporal.getSiguiente();
        }

        return resultado;
    }

    /**
     * Permite insertar un nodo antes de otro dado como referencia, el algoritmo
     * recorre la lista hasta encontrar al nodo o llegar al final de la misma.
     *
     * @param dato
     * @param referencia
     */
    public void inserta_antes_de(T dato, T referencia) {
        NodoGe<T> temporal, nodo_encontrado = null, newDato = new NodoGe<T>(dato);
        Boolean band = true;
        temporal = inicio;
        if (inicio != null) {

            while (!temporal.getDato().equals(referencia) && band) {
                if (temporal.getSiguiente() != null) {
                    nodo_encontrado = temporal;
                    temporal = temporal.getSiguiente();
                } else {
                    band = false;
                }
            }
            if (band) {
                if (temporal == inicio) {
                    newDato.setSiguiente(inicio);
                    inicio = newDato;
                } else {
                    nodo_encontrado.setSiguiente(newDato);
                    newDato.setSiguiente(temporal);
                }
            }
        } else {
            System.out.println("Lista vacía");
        }

    }

    /**
     * Inserta un elemento despues de otro dado como referencia
     *
     * @param dato
     * @param referencia
     */
    public void inserta_despues_de(T dato, T referencia) {
        if (inicio != null) {
            NodoGe<T> temporal, newDato = new NodoGe<T>(dato);
            temporal = inicio;
            Boolean band = true;
            while (!temporal.getDato().equals(referencia) && band) {
                if (temporal.getSiguiente() != null) {
                    temporal = temporal.getSiguiente();
                } else {
                    band = false;
                }
            }
            if (band) {
                newDato.setSiguiente(temporal.getSiguiente());
                temporal.setSiguiente(newDato);

            }

        } else {
            System.out.println("Lista vacía");
        }
    }

    /**
     * Este método elimina el peimer elemento de la lista
     */
    public void elimina_primero() {
        NodoGe<T> temporal = inicio;
        if (temporal.getSiguiente() != null) {
            inicio = temporal.getSiguiente();
        } else {
            inicio = null;
        }
    }

    /**
     * Este método elimina el ultimo elemento de la lista
     *
     */
    public void elimina_ultimo() {
        NodoGe<T> temporal = inicio, anterior = null;
        if (temporal.getSiguiente() == null) {
            inicio = null;
        } else {
            while (temporal.getSiguiente() != null) {
                anterior = temporal;
                temporal = temporal.getSiguiente();
            }
            anterior.setSiguiente(null);
        }
    }

    /**
     * Este método elimina el elemento dato como referencia de una lista ligada.
     *
     * @param dato
     */
    public void elimina_elemento(T dato) {
        NodoGe<T> temporal, anterior = null;
        temporal = inicio;
        Boolean band = true;
        while (!temporal.getDato().equals(dato) && band) {
            if (temporal.getSiguiente() != null) {
                anterior = temporal;
                temporal = temporal.getSiguiente();
            } else {
                band = false;
            }
        }
        if (!band) {
            System.out.println("No se encuentra el elemento");
        } else {
            if (temporal == inicio) {
                inicio = temporal.getSiguiente();
            } else {
                anterior.setSiguiente(temporal.getSiguiente());
            }
        }
    }

    /**
     * Este método elimina un elemento antes de otro dado como referencia
     *
     * @param dato
     */
    public void elimina_antes(T dato) {
        NodoGe<T> temporal = inicio, auxiliar = null, auxiliar2 = null;
        Boolean band = null;
        if (temporal.getDato().equals(dato)) {
            System.out.println("No hay nodo que preceda al dato.");
        } else {
            auxiliar = inicio;
            band = false;
            while (!temporal.getDato().equals(dato) && !band) {
                if (temporal.getSiguiente() != null) {
                    auxiliar2 = auxiliar;
                    auxiliar = temporal;
                    temporal = temporal.getSiguiente();
                } else {
                    band = true;
                }
            }
            if (band) {
                System.out.println("El elemento no fué encontrado");
            } else {
                if (inicio.getSiguiente() == temporal) { // El elemento a eliminar el el primero
                    inicio = temporal;
                } else {
                    auxiliar2.setSiguiente(temporal);
                }
            }
        }
    }

    /**
     * Busca un elemento en una lista desordenada
     *
     * @param dato
     */
    public void busca_desordenado(T dato) {
        NodoGe<T> temporal = inicio;
        Boolean band = true;

        while (!temporal.getSiguiente().equals(dato) && band) {
            if (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            } else {
                band = false;
            }
        }
        if (!band) {
            System.out.println("No se encontró el elemento");
        } else {
            System.out.println("El elemento está en la lista");
        }
    }

    /**
     * Busca un elemento de manera recursiva en la lista
     *
     * @param p
     * @param dato
     */
    public void busca_rescursivo(NodoGe<T> p, T dato) {
        if (p.getDato().equals(dato)) {
            System.out.println("El elemento esta en la lista.");
        } else {
            if (p.getSiguiente() != null) {
                busca_rescursivo(p.getSiguiente(), dato);
            } else {
                System.out.println("No se encuenta el elemento");
            }
        }
    }

    public void imprime_en_reversa(NodoGe<T> p) {
        if (p != null) {
            imprime_en_reversa(p.getSiguiente());
            System.out.print(p.toString());
        } else {
            System.out.print("Null-->");
        }

    }

    public void revertir_lista_ligada() {
        NodoGe<T> p = null;
        while (inicio != null) {
            // Eliminamos el primer elemento.
            NodoGe<T> temporal = inicio, nodoAEliminar = null;
            if (temporal.getSiguiente() != null) {
                nodoAEliminar = temporal;
                inicio = temporal.getSiguiente();
            } else {
                nodoAEliminar = inicio;
                inicio = null;
            }
            nodoAEliminar.setSiguiente(p);
            p = nodoAEliminar;
        }
        inicio = p;
    }

    public T obtenDatoEnPosicion(Integer posicion) {
        NodoGe<T> temporal = inicio;
        Integer pos = 0;
        while (temporal != null && posicion < pos) {
            temporal = temporal.getSiguiente();
            pos++;
        }
        if (temporal != null) {
            return temporal.getDato();
        } else {
            return null;
        }
    }

    public void inserta_ordenado(T dato) {
        NodoGe<T> temporal, nodo_encontrado = null, newDato = new NodoGe<T>(dato);
        Boolean band = true;
        temporal = inicio;
        if (inicio != null) {

            while (temporal.getDato().compareTo(dato) == -1 && band) {
                if (temporal.getSiguiente() != null) {
                    nodo_encontrado = temporal;
                    temporal = temporal.getSiguiente();
                } else {
                    band = false;
                }
            }
            if (band) {
                if (temporal == inicio) {
                    newDato.setSiguiente(inicio);
                    inicio = newDato;
                } else {
                    nodo_encontrado.setSiguiente(newDato);
                    newDato.setSiguiente(temporal);
                }
            } else {
                inserta_final(dato);
            }
        } else {
            inserta_inicio(dato);
        }
    }

    /**
     * Sobreescritura del metodo toString
     */
    @Override
    public String toString() {
        //return "("+recorreRecursivo(inicio)+")";
        //return recorreIterativo();
        NodoGe<T> aux = inicio;
        String resultado = "inicio -->";
        while (aux != null) {
            resultado = resultado + aux.getDato() + "-->";
            aux = aux.getSiguiente();
        }
        resultado = resultado + "null";
        return resultado;
    }

    public Integer longitud() {
        NodoGe<T> temporal = inicio;
        Integer resultado = 0;
        while (temporal != null) {
            resultado += 1;
            temporal = temporal.getSiguiente();
        }

        return resultado;
    }

    public NodoGe<T> obten_ultimo() {
        NodoGe<T> temporal = inicio, anterior = null;
        if (temporal.getSiguiente() == null) {
            return inicio;
        } else {
            while (temporal.getSiguiente() != null) {
                //anterior = temporal;
                temporal = temporal.getSiguiente();
            }
            return temporal;
        }
    }

    public void imprimir() {
        NodoGe<T> aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();

        }

    }

    NodoGe crearlista(String lista) {

        NodoGe inicio = null, nuevo = null, aux = null;

        for (String ele : lista.split(",")) {
            nuevo = new NodoGe();
            nuevo.setDato(Integer.valueOf(ele));
            if (inicio == null) {
                inicio = nuevo;
            } else {

                aux = inicio;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();

                }
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(null);

            }

        }
        return inicio;

    }
//metodo  que une 2 listas ligadas

    void crearde(ListaGe<T> lista) {

        NodoGe<T> actual = inicio;
        NodoGe<T> qatual = lista.inicio;

        NodoGe<T> acsigui, qtualsig;

        while (actual != null && qatual != null) {

            acsigui = actual.getSiguiente();
            qtualsig = qatual.getSiguiente();

            qatual.setSiguiente(acsigui);
            actual.setSiguiente(qatual);

            actual = acsigui;
            qatual = qtualsig;

        }
        lista.inicio = qatual;

    }

    boolean DetectaXloop(NodoGe<T> in) {
        boolean bandera = true;

        if (in == null) {
            bandera = false;

        }
        NodoGe<T> aux = inicio;
        NodoGe<T> has = inicio;

        while (aux != null && aux.getSiguiente() != null) {

            aux = aux.getSiguiente();
            has = aux.getSiguiente();

            if (has == null || aux == null) {

                bandera = false;

            }
            if (has == aux) {
                bandera = true;

            }

        }
        return bandera;

    }
boolean tieneciclo (NodoGe<T> cabeza){
          if(cabeza == null){
             return false;
             
          
          }
          if(cabeza.getSiguiente() == cabeza){
             return true;
          }
          
          NodoGe aux = cabeza;
          NodoGe lo = cabeza.getSiguiente();
          
          while(aux != null && lo.getSiguiente() !=null){
          aux = aux.getSiguiente();
          lo =aux.getSiguiente();
          
                  if(aux == lo){
                         return true;
                  }
          }
          return false;

}
    public static void main(String[] args) {
        ListaGe<Integer> anexa = new ListaGe<Integer>();
        anexa.inserta_inicio(6);
        anexa.inserta_final(5);

        ListaGe<Integer> lista = new ListaGe();
        lista.inserta_inicio(1);
        lista.inserta_final(2);
        
        

        //System.out.println(lista.DetectaXloop(lista.getInicio()));

        
       System.out.println(lista.tieneciclo(lista.getInicio()));
    }

}
