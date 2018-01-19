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
     try (Connection con = Cm.dbConnection()) 
     {
         PreparedStatement pstatement = con.prepareStatement("SELECT * FROM Movies");
         ResultSet result = pstatement.executeQuery();
         while (result.next())
         {
                AllMedia tempMedia = new AllMedia();
                tempMedia.setTitle(result.getString("name"));
                tempMedia.setRatingP(result.getDouble("rating"));
                tempMedia.setRatingP(result.getDouble("prating"));
                tempMedia.setPath(result.getString("path"));
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
     try(Connection con = Cm.dbConnection()) 
     {
         PreparedStatement pstatement = con.prepareStatement("Insert into movies(name,rating,prating,path) Values(?,?,?,?)", 
         Statement.RETURN_GENERATED_KEYS);
         pstatement.setString(1, media.getTitle());
         pstatement.setDouble(2, media.getRatingP());
         pstatement.setDouble(3, media.getRatingIMDB());
         pstatement.setString(4, media.getPath());
         int affected = pstatement.executeUpdate();
         if (affected < 1)
         {
          throw new DAException("Movie could not be added!");
         }
         ResultSet RS = pstatement.getGeneratedKeys();
     }
     catch (Exception e) 
     {
         throw new DAException(e.getMessage());
     }
 }
 public void edit(AllMedia media) throws DAException
 {
     try (Connection con = Cm.dbConnection())
     {
         PreparedStatement pstatement = con.prepareStatement("Update Movie SET: Title=?, Categories=?, time=?, path=?, Pers. Rating=?, IMDB Rating=?");
         pstatement.setString(1, media.getTitle());
         pstatement.setDouble(2, media.getRatingP());
         pstatement.setDouble(3, media.getRatingIMDB());
         pstatement.setString(4, media.getPath());
         int affected = pstatement.executeUpdate();
         if (affected < 1)
         {
             throw new DAException("Movie could not be edited");
         }
     } 
     catch (Exception e) 
     {
         throw new DAException (e.getMessage());
     }
 }
 public void delete (AllMedia media) throws DAException
 {
     try (Connection con = Cm.dbConnection())
     {
         PreparedStatement pstatement = con.prepareStatement("Delete from movie Library");
         int affected = pstatement.executeUpdate();
         if (affected < 1)
         {
             throw new DAException("Movie could not be deleted");
         }
     }
     catch (Exception e) 
     {
         throw new DAException(e.getMessage());
     }
 }
 
}
