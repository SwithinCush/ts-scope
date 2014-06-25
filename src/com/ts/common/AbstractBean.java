/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Class AbstractModel
 *
 * @author daibheid
 */
public class AbstractBean {
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(listener);
    }

    public PropertyChangeListener[] getPropertyChangeListeners()
    {
        return pcs.getPropertyChangeListeners();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public PropertyChangeListener[] getPropertyChangeListeners(String propertyName)
    {
        return pcs.getPropertyChangeListeners(propertyName);
    }

    public void firePropertyChange(String propertyName, Object oldValue, Object newValue)
    {
        pcs.firePropertyChange(propertyName, oldValue, newValue);
    }

    public void firePropertyChange(String propertyName, int oldValue, int newValue)
    {
        pcs.firePropertyChange(propertyName, oldValue, newValue);
    }

    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue)
    {
        pcs.firePropertyChange(propertyName, oldValue, newValue);
    }

    public void firePropertyChange(PropertyChangeEvent event)
    {
        pcs.firePropertyChange(event);
    }

    public void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue)
    {
        pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
    }

    public void fireIndexedPropertyChange(String propertyName, int index, int oldValue, int newValue)
    {
        pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
    }

    public void fireIndexedPropertyChange(String propertyName, int index, boolean oldValue, boolean newValue)
    {
        pcs.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
    }

    public boolean hasListeners(String propertyName)
    {
        return pcs.hasListeners(propertyName);
    }
    
    
} 

