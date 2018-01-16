/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.BE;

import java.io.File;
import java.util.concurrent.TimeUnit;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.Media;

/**
 *
 * @author atilk
 */
public class AllMedia
{   
    public final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty Title = new SimpleStringProperty();
    private final StringProperty Category = new SimpleStringProperty();
    private final StringProperty Path = new SimpleStringProperty();
    private Media media;
    public double time;
    private String timeString;
    private double RatingP;
    private double RatingIMDB;
    
  public AllMedia(int id, String Title, String Category, String Path,Media media, double time, double ratingP, double ratingIMDB)
  {
      this.id.set(id);
      this.Title.set(Title);
      this.Category.set(Category);
      this.Path.set(Path);
      this.media = media;
      this.time = time;
      this.RatingP = ratingP;
      this.RatingIMDB = ratingIMDB;
  }

    public AllMedia() 
    {
       
    }
  public String getTitle()
  {
      return Title.get();
  }
  public void setTitle(String value)
  {
      Title.set(value);
  }
  public String getPath()
  {
      return Path.get();
  }
  public void setPath(String value)
  {
      Path.set(value);
  }
  public String getCategory()
  {
      return Category.get();
  }
  public void setCategory(String value)
  {
      Category.set(value);
  }
  public int getID()
  {
     return id.get();
  }
  public void setID(int value)
  {
      id.set(value);
  }
  public double getTime()
  {
      return time;
  }
  public void setTime(double time)
  {
      this.time = time;
  }
  public double getRatingP()
  {
      return RatingP;
  }
  public void setRatingP(double ratingP)
  {
      this.RatingP = ratingP;
  }
   public double getRatingIMDB()
  {
      return RatingIMDB;
  }
  public void setRatingIMDB(double ratingIMDB)
  {
      this.RatingIMDB = ratingIMDB;
  }
  public Media getMedia()
  {
      return this.media;
  }
  public void setMedia(Media media)
  {
      this.media = media;
  }
  public String getTimeString()
  {
      long timeInLong = new Double(time).longValue();
      int day = (int) TimeUnit.SECONDS.toDays(timeInLong);
        long hours = TimeUnit.SECONDS.toHours(timeInLong) - (day * 24);
        long minute = TimeUnit.SECONDS.toMinutes(timeInLong) - (TimeUnit.SECONDS.toHours(timeInLong) * 60);
        long second = TimeUnit.SECONDS.toSeconds(timeInLong) - (TimeUnit.SECONDS.toMinutes(timeInLong) * 60);
        timeString = String.format("%02d:%02d:%02d", hours, minute, second);

        return timeString;
  }
  
  public void AddFromPath()
  {
      try 
      {
       File file = new File(Path.get());
       this.media = new Media(file.toURI().toString());
      } 
      catch (Exception ex) 
      {
          System.out.println(ex.getMessage());
      }
  }
  
  @Override
  public String toString()
  {
    return "Title: " + getTitle() + " Category: " + getCategory() + " Time: " + getTime() + "Pers. Rating: " + getRatingP() + "IMDB Rating" + getRatingIMDB();

  }
}



