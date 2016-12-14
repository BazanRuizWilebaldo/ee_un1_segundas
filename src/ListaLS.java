/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WILY
 */
public class ListaLS {
    
    
       private NodoLS p =null;
    /**
     * Este método recorre la lista, imprimiendo cada
     * valor de la misma en la pantalla
     */
    public void mostrarLista(){
      //Variable auxiliar
      NodoLS  q = p;
      // Ciclo que recorra la lista
      while(q!=null){
          System.out.println(q.getDato());
          q=q.getSiguiente();
      }
    }
    
     public void insertaInicio(String dato){
        NodoLS ou= new NodoLS(dato);
        ou.setDato(dato);
        ou.setSiguiente(p);
        p=ou;
        
    }
     
    public void insertaFinal(String obj){
        //Variable auxiliar
      NodoLS q = p; // El nodo auxiliar para recorrer la lista
      NodoLS tl = new NodoLS(obj); // El nuevo nodo a insertar
      tl.setDato(obj);
      tl.setSiguiente(null);
      // Ciclo que recorra la lista
      if(p==null){
         p = tl; 
      }else{
          while (q.getSiguiente() != null) {
              q = q.getSiguiente();
          }
      q.setSiguiente(tl); // Asignamos a la liga del ultimo elemento, el nuevo elemento
      }
   
    } 
    
    
    
    
    
    
    
    public ListaLS invertirLista(){
      //Variable auxiliar
      ListaLS listaRetorno = new ListaLS();  
      NodoLS q = p;
      // Ciclo que recorra la lista
      while(q!=null){
          listaRetorno.insertaInicio(q.getDato());
          //System.out.println(q.getValor());
          q=q.getSiguiente();
      }
      
      return listaRetorno;
    }
    
    
     public boolean buscar(String dato){
      //Variable auxiliar
      boolean resultado = false;
      NodoLS q = p;
      // Ciclo que recorra la lista
      while(q!=null){
          if (q.getDato().equals(dato)){
              resultado = true;
          }
          q=q.getSiguiente();
      }
      
      return resultado;
    }
    
    
    
    
}

    
    
    
    
    
    
    

