/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.ejb;

import java.util.Date;
import javax.ejb.Stateful;

/**
 *
 * @author valo
 */
@Stateful
public class BaseSessionBean implements BaseSessionBeanLocal {
    
    public String text;
    public Date date;
    
    public BaseSessionBean() {
        this.date = null;
        this.text = null;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.date = new Date();
        this.text = text;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
