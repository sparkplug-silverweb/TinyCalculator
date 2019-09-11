/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boilingpoint.tinycalculator;

//import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
//import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ext_lesters
 */
@Named(value = "tinyCalculator")
@RequestScoped
public class TinyCalculator 
{

    /**
     * Creates a new instance of TinyCalculator
     */
    public TinyCalculator()
    {
        LOGGER .log(Level.INFO, "ctor TinyCalculator");
    }
    
    private double _param1;
    private double _param2;
    private double _result;
    
    private static final Logger LOGGER = Logger.getLogger("TinyCalculator");

    public double getParam1()
    {
        return _param1;
    }

    public void setParam1(double _param1)
    {
        this._param1 = _param1;
    }

    public double getParam2()
    {
        return _param2;
    }

    public void setParam2(double _param2)
    {
        this._param2 = _param2;
    }

    public double getResult()
    {
        return _result;
    }

    public void setResult(double _result)
    {
        this._result = _result;
    }
    
    public String add(){
        _result = _param1 + _param2;
        return "";
    }
    
    public String subtract(){
        _result = _param1 - _param2;
        return "";
    }

    public String multiply(){
        _result = _param1 * _param2;
        return "";
    }   

    public String divide(){
        _result = _param1 / _param2;
        return "";
    }
    
    public String printTree() {
        UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
        printTree(root,0);
        return "";
    }
    
    private void printTree(UIComponent element, int level){
        logElement(level,element);
        for(UIComponent child: element.getChildren()){
            printTree(child, level + 1);
        }
    }
    
    
    private void logElement(int level, UIComponent element){
        String out ="";
        for(int i=0; i <level; i++){
            out +="----";
        }
        out+= element.getClass().getSimpleName() + " - " + element.getFamily() + " - " + element.getRendererType();
        LOGGER .log(Level.INFO, out);
        
    }
    
}
