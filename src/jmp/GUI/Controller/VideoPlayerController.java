/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.GUI.Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import jmp.model.PlayerModel;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class VideoPlayerController implements Initializable {

    @FXML
    private MediaView mv;
    MediaPlayer player;
    private PlayerModel user;
    public String path;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(path+" video initialize");
        

    }    
    
    private void play(){
        

    }
    
    public void setPath(String inPath) {
                System.out.println(inPath+" video player");

        this.path = inPath;
        Media media = new Media(new File(path).toURI().toString());
        //  Media media = new Media(new File(path).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        final DoubleProperty width = mv.fitWidthProperty();
        final DoubleProperty height = mv.fitHeightProperty();
        width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
        mv.setPreserveRatio(true);
        mv.setMediaPlayer(player);
        player.play();
    }
    
}
