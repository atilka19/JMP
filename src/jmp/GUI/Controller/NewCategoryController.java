
package jmp.GUI.Controller;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
      model = PlayerModel.getInstance();
    }
@FXML
private void SaveClick(ActionEvent event)
{
    String Category = txtField.getText();
    try
    {
        model.addNewCategory(Category);
    }
    catch (ModelException ex)
    {
        Logger.getLogger(NewCategoryController.class.getName()).log(Level.SEVERE, null, ex);
            showAlert(ex);
    }
    closeWindow();
    
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
