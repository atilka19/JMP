/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.BLL;

import java.io.File;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import javafx.scene.layout.AnchorPane;
import jmp.GUI.Controller.MainController;
import jmp.JMP;

public class vlcUtil 
{
    public static boolean isVlcInstalled() {
        String vlc = getVLCPathW();
        if (vlc != null) {
            File libDir = new File(vlc);
            if (libDir.exists())
                return true;
        }
        return false;
    }
    public static String getVLCPathW() {
        String arch = System.getProperty("os.arch");

        if (arch.indexOf("64") >= 0) {
            return "C://Program Files//VideoLAN//VLC";
        }

        return "C://Program Files (x86)//VideoLAN//VLC";
    }
    private Canvas Canvas1 = new Canvas();
    private Pane Pane = new Pane();
    private AnchorPane Alap = new AnchorPane();
    
    MediaPlayerFactory mpf = new MediaPlayerFactory ();
    
    /*EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(Stage));
    emp.setVideoSurface(mpf.newVideoSurface(Canvas1))
    
    
    nativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:\\Program Files\\VideoLAN\\VLC")*/
}
