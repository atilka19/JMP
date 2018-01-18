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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author atilk
 */
public class NewMovieController implements Initializable {

    @FXML
    private TextField movieName;
    @FXML
    private TextField movieRating;
    @FXML
    private TextField moviePRating;
    @FXML
    private TextField moviePath;

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
            String name = movieName.getText();
            String rating = movieRating.getText();
            String prating = moviePRating.getText();
            String path = moviePath.getText();
            
            workingUserMedia.setArtist(name);
            workingUserMedia.setTitle(rating);
            workingUserMedia.setCategory(prating);
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
            Logger.getLogger(NewMovieController.class.getName()).log(Level.SEVERE, null, ex);
            showAlert(ex);
        }
    }*/
    
}
