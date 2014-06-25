/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ts.scope.view.swing;

import com.ts.scope.controller.ViewContext;
import com.ts.scope.controller.swing.SwingContext;
import com.ts.scope.core.Controller;
import com.ts.scope.core.View;
import java.awt.Rectangle;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * Class PanelView
 *
 * @author daibheid
 */
public class SwingView<M, C extends Controller> extends JPanel implements View<M, C> {

    public static final int PRIMARY_WINDOW = 0;
    public static final int MODAL_DIALOG = 1;
    public static final int MODELESS_DIALOG = 2;
    
    public static final Rectangle CENTERED = new Rectangle();
    
    private Rectangle viewBounds;
    
    private int displayMode = PRIMARY_WINDOW;
    
    private String title = "Untitled";
    
    private JMenuBar menuBar;
    
    private boolean resizable;
    
    private C controller;
    
    public SwingView() {
        if(ViewContext.getViewContext() == null) {
            ViewContext.setGlobalContext(new SwingContext());
        }
    }
    
    public final Rectangle getViewBounds() {
        return viewBounds;
    }
    
    public final Rectangle getLastShownBounds() {
        return getViewBounds();
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getDisplayMode() {
        return displayMode;
    }
    
    public boolean isResizable() {
        return true;
    }
    
    public JMenuBar getMenuBar() {
        return menuBar;
    }
    
    public C getController() {
        return controller;
    }
    
    public void setController(C value) {
        firePropertyChange("controller", this.controller, this.controller = value);
    }
    
    public M getBoundModel() {
        return (M)getController().getModel();
    }
    
    public void setBoundModel(M value) {
        throw new UnsupportedOperationException("Should not be setting the model from the view...");
    }
    
    public void setDisplayMode(int value) {
        firePropertyChange("displayMode", this.displayMode, displayMode = value);
    }
    
    public void setTitle(String value) {
        firePropertyChange("title", title, title = value);
    }
    
    public void setViewBounds(Rectangle value) {
        firePropertyChange("viewBounds", viewBounds, viewBounds = value);
    }
    
    public void setLastShownBounds(Rectangle value) {
        setViewBounds(value);
    }
    
    public void setMenuBar(JMenuBar value) {
        firePropertyChange("menuBar", menuBar, menuBar = value);
    }
} 

