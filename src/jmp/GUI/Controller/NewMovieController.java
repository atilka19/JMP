/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.GUI.Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import jmp.BE.AllMedia;
import jmp.BLL.BLLException;
import jmp.model.ModelException;
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
    @FXML
    private Button cancelButton;
    @FXML
    private Button AddButton;
    @FXML
    private Button ChooseButton;
    
    private PlayerModel model;
    private AllMedia workingMedia;
    private Modes mode;
    public String path;

    @Override
    public void initialize(URL url, ResourceBundle resources) 
    {
         try {
            model = PlayerModel.getInstance();
            if (model.getMediaMode() == jmp.GUI.Controller.Modes.EDIT) 
            {
           
                mode = Modes.EDIT;
                workingMedia = model.getSelectedMedia();
            }
            else 
            {
                mode = Modes.NEW;
                workingMedia = new AllMedia();
            }
            
         }
         catch (ModelException ex) {
                Logger.getLogger(NewMovieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }    
    @FXML
    private void saveClicked (ActionEvent event)
    {
        saveFromTextFields();
        closeWindow();
    }
    @FXML
    private void cancelClicked (ActionEvent event)
    {
        closeWindow();
    }
    @FXML
    private void chooseFileClicked(ActionEvent event)
    {
        Stage stage = new Stage(); 
        FileChooser fc = new FileChooser();
     fc.getExtensionFilters().addAll(
         new ExtensionFilter("mp4", "*.mp4"),
         new ExtensionFilter("mpeg4", "*mpeg4"));
     File selectedFile = fc.showOpenDialog(stage);
     this.path = selectedFile.getAbsolutePath();
     this.path = (workingMedia.getPath());
         
        
        
    }
    private void fillData()
    {
        movieName.setText(workingMedia.getTitle().isEmpty() ? "Unkown" : workingMedia.getTitle());
        movieRating.setText(workingMedia.getRatingString());
        moviePRating.setText(workingMedia.getPRatingString());
        moviePath.setText(workingMedia.getPath());
    }
    private void closeWindow()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    private void showAlert(Exception ex)
    {
        Alert a = new Alert(Alert.AlertType.ERROR, "An error occured: " + ex.getMessage(), ButtonType.OK);
        a.show();
    }
    private void saveFromTextFields()
    {
        String name;
        String rating;
        String prating;
        String path;
        try
        {
            name = movieName.getText();
            rating = movieRating.getText();
            prating = moviePRating.getText();
            path = moviePath.getText();
            
            workingMedia.setTitle(name);
            workingMedia.setRatingIMDBS(rating);
            workingMedia.setPRatingS(prating);
            workingMedia.setPath(path);
            if (mode == Modes.NEW)
            {
                model.addNewMedia(workingMedia);
            }
            else
            {
                model.updateMedia(workingMedia);
            }
        }
        catch (ModelException ex)
        {
            Logger.getLogger(NewMovieController.class.getName()).log(Level.SEVERE, null, ex);
            showAlert(ex);
        } catch (BLLException ex) {
            Logger.getLogger(NewMovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
