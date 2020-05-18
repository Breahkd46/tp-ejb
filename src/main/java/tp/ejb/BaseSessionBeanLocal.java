/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.ejb;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author valo
 */
@Local
public interface BaseSessionBeanLocal {
    String getText();
    void setText(String text);
    Date getDate();
}
