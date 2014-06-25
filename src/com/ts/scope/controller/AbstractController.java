/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.scope.controller;

import com.ts.common.AbstractBean;
import com.ts.scope.core.Controller;
import com.ts.scope.core.View;
import java.util.LinkedList;
import java.util.List;

/**
 * Class AbstractController
 *
 * @author daibheid
 */
public abstract class AbstractController<M, V extends View> extends AbstractBean implements Controller<M, V> {

    private AbstractController parent;
    
    private LinkedList<Controller> children = new LinkedList<Controller>();
    
    private M model;
    
    private V view;
    
    public final List<Controller> getChildren() {
        return children;
    }
    
    public final Controller getParent() {
        return parent;
    }
    
    public final Controller getTopParent() {
        Controller result = this;
        while(result.getParent() != null)
            result = result.getParent();
        return result;
    }
    
    public final M getModel() {
        return model;
    }
    
    public final void setModel(M value) {
        firePropertyChange("model", this.model, this.model = value);
    }
    
    public final V getView() {
        return view;
    }
    
    public final void setView(V value) {
        if(view != null) {
            hideView();
            firePropertyChange("view", view, null);
            view.setController(null);
        }
        view = value;
        if(view != null) {
            firePropertyChange("view", null, view);
            view.setController(this);
        }
    }
    
    public final void setModelAndView(M mValue, V vValue) {
        setModel(null);
        setModel(mValue);
        setView(vValue);
    }
    
    public void execute(Controller value) {
        if(value instanceof AbstractController) {
            AbstractController ac = (AbstractController)value;
            ac.setParent(this);
        }
        execute();
    }
    
    public void halt() {
        AbstractController[] c = (AbstractController[])getChildren().toArray(new AbstractController[0]);
        for(int i = 0; i < c.length; ++i)
            c[i].halt();
        hideView();
        setParent(null);
    }
    
    protected final void setParent(AbstractController value) {
        if(parent != null) {
            parent.getChildren().remove(this);
            firePropertyChange("parent", parent, null);
        }
        
        parent = value;
        
        if(parent != null) {
            parent.getChildren().add(this);
            firePropertyChange("parent", null, parent);
        }
    }
    
    protected final void hideView() {
        hideView(getView());
    }
    
    protected final void hideView(View value) {
        
    }
    
    protected final void showView() {
        showView(getView());
    }
    
    protected final void showView(View value) {
        
    }
} 

