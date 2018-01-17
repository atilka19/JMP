
package jmp.BLL;

import java.io.File;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import jmp.BE.AllMedia;
import java.awt.Desktop;

/**
 *
 * @author atilk
 */
public class Player 
{
    private final BooleanProperty isPlaying = new SimpleBooleanProperty();
    private AllMedia currentMedia;
    
    public void setMedia (AllMedia media) throws BLLException
    {
        try 
        {
          currentMedia = media;   
        }
        catch (NullPointerException ex) 
        {
            throw new BLLException("You're trying to open a non-existant Media!");
        }

    }
        public void open() throws BLLException
        {
            try
            {
               Desktop desktop = null;
               if (Desktop.isDesktopSupported())
               {
                   desktop = Desktop.getDesktop();
               }
               //desktop.open();
            }
            catch (Exception ex)
            {
                
            }
        }
}
