/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author atilk
 */
public class NewMovieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /*private void saveDataFromTextFields()
    {
        try
        {
            String artist = songArtistField.getText();
            String title = titleOfSongField.getText();
            String path = songPathField.getText();
            String category = chooseCategoryComboBox.getValue();
            
            workingUserMedia.setArtist(artist);
            workingUserMedia.setTitle(title);
            workingUserMedia.setCategory(category);
            workingUserMedia.setPath(path);
            
            if (mode == Mode.NEW)
            {
                model.addNewMedia(workingUserMedia);
            }
            else
            {
                model.updateMedia(workingUserMedia);
            }
        } 
        catch (ModelException ex)
        {
            Logger.getLogger(NewSongController.class.getName()).log(Level.SEVERE, null, ex);
            showAlert(ex);
        }
    }*/
    
}
