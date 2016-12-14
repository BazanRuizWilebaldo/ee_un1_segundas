/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILY
 */
public class NodoGe<T extends Comparable<T>> {

    private T dato;
    private NodoGe<T> siguiente;

    public NodoGe() {

    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoGe<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGe<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoGe(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public String toString() {
        return dato.toString() + "-->";
    }

}
