/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import jmp.BE.AllMedia;
import java.util.ArrayList;

/**
 *
 * @author atilk
 */
public class MediaManager 
{
 private ConnectionManager Cm = new ConnectionManager();
 
 public List<AllMedia> getAll() throws DAException 
 {
     List<AllMedia> mediaList = new ArrayList();
     try (Connection con = Cm.getConnection()) 
     {
         PreparedStatement pstatement = con.prepareStatement("SELECT * FROM Movies");
         ResultSet result = pstatement.executeQuery();
         while (result.next())
         {
                AllMedia tempMedia = new AllMedia();
                tempMedia.setID(result.getInt("id"));
                tempMedia.setTitle(result.getString("title"));
                tempMedia.setCategory(result.getString("category"));
                tempMedia.setTime(result.getInt("time"));
                tempMedia.setRatingP(result.getDouble("RatingP"));
                tempMedia.setRatingP(result.getDouble("RatingIMDB"));
                tempMedia.setPath(result.getString("path"));
                tempMedia.AddFromPath();
                mediaList.add(tempMedia);
         }    
         } 
         catch (Exception e) 
         {
             throw new DAException(e.getMessage());
         }
     return mediaList;
 }
 public void save(AllMedia media) throws DAException
 {
     try(Connection con = Cm.getConnection()) 
     {
         PreparedStatement pstatement = con.prepareStatement(" INSERT INTO Movies (title, categories, lenght, path, rating)"
          + "VALUES (?, ?, ?, ?, ?,)", Statement.RETURN_GENERATED_KEYS);
         pstatement.setString(1, media.getTitle());
         pstatement.setString(2, media.getCategory());
         pstatement.setDouble(3, media.getTime());
         pstatement.setDouble(6, media.getRatingP());
         pstatement.setDouble(6, media.getRatingIMDB());
         pstatement.setString(4, media.getPath());
         int affected = pstatement.executeUpdate();
         if (affected < 1)
         {
          throw new DAException("Movie could not be added!");
         }
         ResultSet RS = pstatement.getGeneratedKeys();
         if(RS.next())
         {
             media.setID(RS.getInt(1));
         }
     }
      
     catch (Exception e) {
     }
 }
}
