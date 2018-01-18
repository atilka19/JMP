package jmp.BE;

import java.io.File;
import java.util.concurrent.TimeUnit;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.Media;

/**
 * @author atilk
 */
public class AllMedia
{   
    private final StringProperty Name = new SimpleStringProperty();
    private final StringProperty Path = new SimpleStringProperty();;
    private double prating;
    private double rating;
    private Media media;
    
  public AllMedia(String Name, String Path, double rating, double prating)
  {
      this.Name.set(Name);
      this.Path.set(Path);
      this.rating = prating;
      this.prating = rating;
      this.media = media;
  }
  public void createMediaFromPath() throws Exception
  {
      try 
      {
          File f = new File(Path.get());
          this.media = new Media(f.toURI().toString());
      }
      catch (Exception ex) 
      {
          System.out.println(ex.getMessage());
      }
  }

    public AllMedia() 
    {
       
    }
  public String getTitle()
  {
      return Name.get();
  }
  public void setTitle(String value)
  {
      Name.set(value);
  }
  public String getPath()
  {
      return Path.get();
  }
  public void setPath(String value)
  {
      Path.set(value);
  }
  public double getRatingP()
  {
      return prating;
  }
  public void setRatingP(double ratingP)
  {
      this.prating = prating;
  }
   public double getRatingIMDB()
  {
      return rating;
  }
  public void setRatingIMDB(double ratingIMDB)
  {
      this.rating = rating;
  }

  @Override
  public String toString()
  {
    return "Name: " + getTitle() + "Pers. Rating: " + getRatingP() + "IMDB Rating" + getRatingIMDB();

  }
}



