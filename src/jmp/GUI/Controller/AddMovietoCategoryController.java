/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.GUI.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;
import jmp.BE.MovieList;

/**
 * FXML Controller class
 *
 * @author atilk
 */
public class AddMovietoCategoryController implements Initializable {

    @FXML
    private ComboBox<?> movieBox;
    @FXML
    private ComboBox<?> categoryBox;
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    final ObservableList categories = FXCollections.observableArrayList();
    final ObservableList movies = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = jmp.DAL.ConnectionManager.dbConnection();
        fillCategory();
        fillMovies();
    }    

    @FXML
    private void addMovieToCategory(ActionEvent event) {
        String moviename = movieBox.getSelectionModel().getSelectedItem().toString();
        System.out.println(moviename);
        String categoryname = categoryBox.getSelectionModel().getSelectedItem().toString();
        System.out.println(categoryname);
        String merge = "INSERT INTO catmovies (movieid, categoryid) SELECT movies.id, category.id FROM movies INNER JOIN category ON movies.name = ? AND category.name = ?";
        try {
            pst = conn.prepareStatement(merge);
            pst.setString(1, moviename);
            pst.setString(2, categoryname);
            
            int i = pst.executeUpdate();
            if(i == 1)
                System.out.println("Done.");
        } catch (SQLException ex) {
            Logger.getLogger(AddMovietoCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void fillCategory() {
        
        try {
        String sql = "select name from category";
        pst=conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
        categories.add(rs.getString("name"));
        categoryBox.setItems(categories);
        
        } 
        
        }catch (Exception e){
                
                JOptionPane.showMessageDialog(null, e);
                }
      
    }
    private void fillMovies() {
        
        try {
        String sql = "select name from movies";
        pst=conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
        movies.add(rs.getString("name"));
        movieBox.setItems(movies);
        } 
        
        }catch (Exception e){
                
                JOptionPane.showMessageDialog(null, e);
                }
      
    }
    
}
