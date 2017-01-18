/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.*;
/**
 *
 * @author Fernando
 */
public class Conjunto2<T> {
    private ArrayList<T> a;
    private int cardinalidad=0;
    
    
    
    public Conjunto2(){
        a= new ArrayList<T>(); 
        
    }
    
    public ArrayList<T> getLista(){
        return a; 
    }
    
    
    public void agrega(T elemento){
       a.add(elemento);
       cardinalidad++;  
    }
    
    
    public String toString(){
        StringBuilder cad= new StringBuilder();
        Iterator<T> iterator= a.iterator(); 
       
        while (iterator.hasNext())
            cad.append(iterator.next()+ " ");
        return cad.toString();
    }
    public int getCardinalidad(){
        return cardinalidad;
    }
    //contiene y expand se tienen que programar
    
    
    public boolean estaVacia(){
        boolean res=false; 
        if (a.isEmpty())
            res=true; 
        
        return res; 
    }
    
    public T sacaAlgo(){
        T res=null; 
        if(!estaVacia()){
        res= a.get(0);
        }
        return res;
    }
    
    public boolean remove(T object){
        return a.remove(object);
    }
    public boolean contiene(T elemento) {
        boolean resp=false; 
        if(a.contains(elemento)){
            resp=true; 
        }
        
        return resp; 
    }
    
    public Conjunto2 union(Conjunto2 otro){
         Iterator<T> iterator1= a.iterator(); 
          
         Iterator<T> iterator2= otro.a.iterator(); 
        
        Conjunto2 nuevo= new Conjunto2 ();
        
        while(iterator1.hasNext()){
            nuevo.agrega(iterator1.next());
        }    
        while(iterator2.hasNext()){
            nuevo.agrega(iterator2.next());
        }
        return nuevo;
    }
    
    public Conjunto2 interseccion(Conjunto2 otro){
        Conjunto2 <T> nuevo= new Conjunto2 <T> ();
        Iterator<T> it1= a.iterator();
        T x;
        
        while(it1.hasNext()){
            x=it1.next();
            if(otro.contiene(x))
                nuevo.agrega(x);
        }
        return nuevo;
        
    }
    
    
    public Conjunto2 diferenciaAB (Conjunto2 otro){
        Conjunto2 <T> nuevo= new Conjunto2 <T> ();
        Iterator<T> it1= a.iterator();
        T x;
        
        while(it1.hasNext()){
            x= it1.next();
            if(!otro.contiene(x))
                nuevo.agrega(x);
        }
        return nuevo;
    
    } 
    
}
