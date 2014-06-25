/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.scope.core;

/**
 *
 * @author daibheid
 */
public interface Controller<M, V extends View>
{
    public Controller getParent();
    
    public M getModel();
    
    public void setModel(M value);
    
    public V getView();
    
    public void setView(V value);
    
    public Controller getTopParent();
    
    public void execute();
}
