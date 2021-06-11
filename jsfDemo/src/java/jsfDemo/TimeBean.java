/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfDemo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mbrothen
 */
@Named(value = "timeBean")
@RequestScoped
public class TimeBean {

    public TimeBean() {
    }
    public String getTime() {
        return new java.util.Date().toString();
    }
}
