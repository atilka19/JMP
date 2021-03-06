/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.GUI.Controller;

import java.io.IOException;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jmp.BE.MovieList;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import jmp.BE.AllMedia;
import jmp.model.PlayerModel;


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
    public Canvas Canvas1;
    public AnchorPane Alap;
    public Pane Pn;
    public TextField Searchbar;
    public ListView searchList;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList<MovieList> data;
    final ObservableList categories = FXCollections.observableArrayList();
    private boolean isSearchActive;
    @FXML
    private TableColumn<?, ?> cName;
    @FXML
    private TableColumn<?, ?> cRating;
    @FXML
    private TableColumn<?, ?> cPRating;
    @FXML
    private TableColumn<?, ?> cPath;
    @FXML
    private TextField SearchBar;
    @FXML
    private TableView<MovieList> tableMovies;
    public String path;
    private PlayerModel model;
    private AllMedia currentMedia;
    
    //private PlayerModel model;
    @FXML
    private Button addCategoryButton;
    @FXML
    private ComboBox<?> categoryChoose;
    
    
    public void initialize(URL url, ResourceBundle rb) 
    {
      tableMovies.getSelectionModel().selectedItemProperty().addListener((obs,oldItem,newItem) -> {
      this.path = newItem.getPath();
      });
        
      data = FXCollections.observableArrayList();
      con = jmp.DAL.ConnectionManager.dbConnection();
      isSearchActive = false;
      fillCategory();
      setCellTable();
      loadDataFromDB();
      setListenersAndEventHandlers();
      model = PlayerModel.getInstance();
    }
        private void setCellTable() {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        cPRating.setCellValueFactory(new PropertyValueFactory<>("prating"));
        cPath.setCellValueFactory(new PropertyValueFactory<>("path"));
    }
// New Window Openings
    @FXML
    private void addMovieClicked(ActionEvent event)
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/jmp/GUI/View/NewMovie.fxml"));
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
    private void addCategoryClicked (ActionEvent event)
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/jmp/GUI/View/NewCategory.fxml"));
        
        Parent root1 = (Parent) fxmlLoader.load();
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Add a New Category");
        stage.show();
            
        }
        catch (IOException ex) 
        {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void fillCategory() {
        
        try {
        String sql = "select name from category";
        pst=con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
        categories.add(rs.getString("name"));
        categoryChoose.setItems(categories);
        
        } 
        
        }catch (Exception e){
                
                JOptionPane.showMessageDialog(null, e);
                }
      
    }
    @FXML
    private void addMovieToCategoryClicked (ActionEvent event)
    {
        try 
        {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/jmp/GUI/View/AddMovietoCategory.fxml"));
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
    
    private void searchClicked(MouseEvent event)
    {
        if (isSearchActive) 
        {
         Searchbar.setText("");   
        } 
        String searchString = Searchbar.getText();
        searchForString(searchString);
    }
    

    private void loadDataFromDB() {
        data.clear();
        try {
            pst = con.prepareStatement("SELECT * FROM Movies");
            rs = pst.executeQuery();
            while(rs.next()){
                data.add(new MovieList(rs.getString(2), ""+rs.getDouble(3), ""+rs.getDouble(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableMovies.setItems(data);
    }
    private void setListenersAndEventHandlers()
    {
        SearchBar.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
         @Override
         public void handle(KeyEvent event)
         {
             if (event.getCode() == KeyCode.ENTER)
             {
                 String searchString = SearchBar.getText();
                 searchForString(searchString);
             }
         }
        });
    }
    
    @FXML
    private void onClick_PLAY(ActionEvent event) {
                try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/jmp/GUI/View/VideoPlayer.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            VideoPlayerController videoPlayer = (VideoPlayerController) fxmlLoader.getController();
            
               videoPlayer.setPath(this.path);
            
            Stage stage = new Stage();
            stage.setFullScreen(true);
            stage.setScene(new Scene (root1));
            stage.setTitle("Enjoy!");
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    private void searchForString(String searchString) 
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
    }

    @FXML
    private void searchClicked(ActionEvent event) {
    }

    @FXML
    private void filterSelected(ActionEvent event) {
        String filter = categoryChoose.getSelectionModel().getSelectedItem().toString();
        System.out.println(filter);
        data.clear();
        try {
            pst = con.prepareStatement("Select movies.name, movies.rating, movies.prating, movies.path from movies, category, catmovies where movies.id = catmovies.movieid AND category.id = catmovies.categoryid AND category.name = ?");
            pst.setString(1, filter);
            rs = pst.executeQuery();
            while(rs.next()){
                data.add(new MovieList(rs.getString(1), ""+rs.getFloat(2), ""+rs.getFloat(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableMovies.setItems(data);
    }

    @FXML
    private void clearFilter(ActionEvent event) {
        data.clear();
        loadDataFromDB();
    }

    @FXML
    private void clickDelete(ActionEvent event) {
        String selected = tableMovies.getSelectionModel().getSelectedItem().getName();
        System.out.println(selected);
        String delete = "delete from movies where name = ?";
        try {
            pst = con.prepareStatement(delete);
            pst.setString(1, selected);
            
            int i = pst.executeUpdate();
            if(i == 1)
                System.out.println("Deleted");
            
            data.clear();
            loadDataFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

