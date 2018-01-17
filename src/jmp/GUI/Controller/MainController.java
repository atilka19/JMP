/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.media.MediaView;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jmp.BE.AllMedia;


/**
 * FXML Controller class
 *
 * @author atilk
 */
public class MainController implements Initializable 
{
    /*@FXML
    private TableView <AllMedia> AllMedia;
    @FXML
    private MediaView mv;*/
    @FXML
    public Canvas Canvas1;
    @FXML
    public AnchorPane Alap;
    @FXML
    public Pane Pn;
    @FXML
    public TextField Searchbar;
    @FXML
    public ListView searchList;
    @FXML
    private TableColumn<AllMedia, String> AllTitle;
    @FXML
    private TableColumn<AllMedia, String> AllCategories;
    @FXML
    private TableColumn<AllMedia, String> AllLenght;
    @FXML
    private TableColumn<AllMedia, String> AllRating;
    
    private boolean isSearchActive;
    //private MediaPlayerModel model;
    
    
    public void initialize(URL url, ResourceBundle rb) 
    {
      isSearchActive = false;
    }
// New Window Openings
    @FXML
    private void addMovieClicked(ActionEvent event)
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/View/NewMovie.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene (root1));
            stage.setTitle("Add a Movie");
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void searchClicked(MouseEvent event)
    {
        if (isSearchActive) 
        {
         Searchbar.setText("");   
        } 
        String searchString = Searchbar.getText();
        //searchForString(searchString);
    }
    
    /*private void searchForString(String searchString) 
    {
        if (!searchString.isEmpty()) 
        {
         model.searchString(searchString);
         isSearchActive = true;
        } 
        else 
        {
            model.searchString(searchString);
            isSearchActive = false;
        }
    }

    private void showAlert(IOException ex) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
}
/*@FXML
    private void searchClicked(MouseEvent event) 
 {
        if (isFilterActive)
        {
            searchField.setText("");
        }
        
        String searchString = searchField.getText();
        searchForString(searchString);
    }*/
