/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.scope.core;

/**
 *
 * @author daibheid
 */
public interface View<M, C extends Controller>
{
    public C getController();
    public void setController(C value);
    
    public M getBoundModel();
    public void setBoundModel(M value);
}
