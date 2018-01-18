/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import jmp.BE.AllMedia;
import jmp.model.PlayerModel;

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
    
    private PlayerModel model;
    private AllMedia workingMedia;
    private Modes mode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resources) 
    {
        try
        {
            model = PlayerModel.getInstance();
            if (model.getMediaMode() == jmp.GUI.Controller.Modes.EDIT) 
            {
             mode = Modes.EDIT;
             workingMedia = model.getSelectedMedia();
             //fillData();
            } else {
            }
        }
        catch (Exception e)
        {
            
        }
    }    /*
    private void fillData()
    {
        movieName.setText(workingMedia.getTitle().isEmpty() ? "Unkown" : workingMedia.getTitle());
        movieRating.set
        moviePRating
        moviePath
    } 
*/
}
