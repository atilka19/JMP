
package jmp.GUI.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.stage.Stage;
import jmp.model.ModelException;
import jmp.model.PlayerModel;

/**
 * FXML Controller class
 * @author atilk
 */
public class NewCategoryController implements Initializable 
{
    private PlayerModel model;
    @FXML
    private TextField txtField;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnSave;
    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement pst = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = jmp.DAL.ConnectionManager.dbConnection();
    }
@FXML
private void SaveClick(ActionEvent event)
{
    String Category = txtField.getText();
    System.out.println(Category);
    
    String addCat = "insert into category (name) VALUES(?)";
        try {
            pst = conn.prepareStatement(addCat);
            pst.setString(1, Category);
            
            int i = pst.executeUpdate();
            if(i == 1)
                System.out.println("New category added.");
        } catch (SQLException ex) {
            Logger.getLogger(NewCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
}
@FXML
private void CancelClick(ActionEvent event)
{
    closeWindow();
}
private void closeWindow()
{
    Stage stage = (Stage) btnCancel.getScene().getWindow();
    stage.close();
}
private void showAlert(ModelException ex)
    {
        Alert a = new Alert(Alert.AlertType.ERROR, "An error occured: " + ex.getMessage(), ButtonType.OK);
        a.show();
    }
    
}
