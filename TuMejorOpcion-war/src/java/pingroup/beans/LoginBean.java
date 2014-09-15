/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.beans;

import com.icesoft.faces.component.ext.HtmlInputText;
import java.io.Serializable;

/**
 *
 * @author Banana
 */
public class LoginBean implements Serializable{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    private HtmlInputText usrToken;
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public LoginBean()
    {
        usrToken = new HtmlInputText();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
   
    
    public HtmlInputText getUsrToken(){
        return usrToken;
    }
    
    public void setUsrToken(HtmlInputText usr)
    {
        this.usrToken = usr;
    }
    
    public String hayUserBean ()
    {
        if (usrToken.getValue() == "NoHayId")
            return "No";
        else 
            return "login"; 
    }
    
}
