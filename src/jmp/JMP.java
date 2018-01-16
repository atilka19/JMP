/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jmp.GUI.MainController;

/**
 *
 * @author atilk
 */
public class JMP extends Application {
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        
        Parent root = FXMLLoader.load(getClass().getResource("GUI/Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("JMP - Putting the VLC in Java");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
