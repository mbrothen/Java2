/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mbrothen, generates a table of numbers 0-10 and their factorials
 */
@Named(value = "factorial")
@RequestScoped
public class factorial {

    /**
     * Creates a new instance of factorial
     */
    public factorial() {
    }
    public String getTable(){
        String output = "<table> <tr><th>Number</th><th>Factorial</th></tr>";
        String tr = "<tr><td>";
        String midRow = "</td><td>";
        String endTr = "</td></tr>";
        for (int i = 0; i<=10; i++){
            int currentFactorial = i;
            for (int j = 1; j < i; j++){
                currentFactorial = currentFactorial * j;
            }
            output+= tr + i + midRow + currentFactorial +  endTr;
        }
        output += "</table>";
        
        return output;
    }
    
}
