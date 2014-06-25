/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.scope.controller;

import com.ts.scope.core.View;
import java.util.HashMap;
import java.util.Map;

/**
 * Class ViewContext
 *
 * @author daibheid
 */
public abstract class ViewContext {

    private static ViewContext globalContext;
    
    private static ThreadLocal localContext = new ThreadLocal();
    
    private Map properties = new HashMap();
    
    public static ViewContext getViewContext() {
        ViewContext context = (ViewContext) localContext.get();
        if(context != null)
            return context;
        
        return globalContext;
    }
    
    public static void setGlobalContext(ViewContext value) {
        globalContext = value;
    }
    
    public static void setThreadContext(ViewContext value) {
        if(value == null) {
            throw new IllegalArgumentException("can't set a null ViewContext for a thrad - see clearThreadContext");
        }
        
        localContext.set(value);
    }
    
    public static void clearThreadContext() {
        localContext.set(null);
    }
    
    public Object getProperty(String key) {
        return properties.get(key);
    }
    
    public abstract void showView(View view);
    
    public abstract void hideView(View view);
    
    public abstract void showError(String errorTitle, String errorMessage);
    
    public abstract void exit();
    
    public abstract void startProgress();
    
    public abstract void stopProgress();
    
    public void addProperty(String key, Object value) {
        if(key == null)
            throw new IllegalArgumentException("can't use a null key.");
        properties.put(key, value);
    }
    
    public Object removeProperty(String key) {
        return properties.remove(key);
    }
    
    public void clearProperties() {
        properties.clear();
    }
} 

