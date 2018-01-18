/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import jmp.BE.AllMedia;
import jmp.BLL.BLLException;
import jmp.BLL.LogicManager;
import jmp.GUI.Controller.Modes;

/**
 *
 * @author atilk
 */
public class PlayerModel 
{
  private ObservableList<AllMedia> AllMedia = FXCollections.observableArrayList();
  private ObservableList<AllMedia> SearchList = FXCollections.observableArrayList();
  private ObservableList<String> Categories = FXCollections.observableArrayList();
  private final LogicManager LogicManager = new LogicManager();
  private static PlayerModel instance;
  
  private Modes mediaMode;
  public PlayerModel()
    {
        AllMedia.addListener(new ListChangeListener<AllMedia>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends AllMedia> c)
            {
                SearchList.clear();
                SearchList.addAll(AllMedia);
            }
        });
    }
  public static PlayerModel getInstance()
  {
      if (instance == null)
      {
          instance = new PlayerModel();
      }
      return instance;
  }
  public void LoadData() throws ModelException
  {
      try 
      {
          AllMedia.addAll(LogicManager.loadMedia());
          Categories.addAll(LogicManager.getCategories());
      }
      catch (BLLException ex) 
      {
         throw new ModelException(ex); 
      }
  }
  public void addNewCategory (String category) throws ModelException
  {
      category = category.trim();
      if (category.isEmpty())
      {
          throw new ModelException("Nothing to Add");
      }
      if (Categories.contains(category))
      {
          throw new ModelException("Cateegory already exists!");
      }
      Categories.add(category);
  }
  public void addNewMedia (AllMedia selectedMovie) throws ModelException, BLLException
  {
      try 
      {
          LogicManager.addNewMedia(selectedMovie);
          AllMedia.add(selectedMovie);
      }
      catch (BLLException ex)
      {
          throw new ModelException(ex);
      }
  }
  public void updateMedia(AllMedia editmedia) throws ModelException
  {
      try 
      {
          LogicManager.updateMedia(editmedia);
      }
      catch (BLLException ex) 
      {
          throw new ModelException(ex);
      }
  }
  public void removeMedia(AllMedia selected) throws ModelException
  {
      try 
      {
          LogicManager.deleteMedia(selected);
      }
      catch (BLLException ex) 
      {
          throw new ModelException(ex);
      }
      AllMedia.remove(selected);
  }
  public ObservableList<AllMedia> getMedia()
  {
      return this.SearchList;
  }
  public ObservableList<String> getCategories()
  {
      return this.Categories;
  }
  public Modes getMediaMode()
  {
      return mediaMode;
  }
  public void setMediaMode (Modes mediaMode)
  {
      this.mediaMode = mediaMode;
  }
  public void setSelectedMedia (AllMedia selected) throws BLLException
  {
      try 
      {
          LogicManager.setSelectedMedia(selected);
      }
      catch (Exception e)
      {
          
      }
  }
  public AllMedia getSelectedMedia() throws ModelException
  {
      try 
      {
          return LogicManager.getSelectedMedia();
      }
      catch (BLLException ex)
      {
          throw new ModelException(ex);
      }
  }
  public BooleanProperty isPlaying()
  {
      return LogicManager.isPlaying();
  }
  public void searchString (String search)
  {
      SearchList.clear();
      if (search.isEmpty())
      {
          SearchList.addAll(AllMedia);
          return;
      }
      search = search.toLowerCase();
      for (AllMedia AllMedia : AllMedia)
      {
          if (AllMedia.getTitle().toLowerCase().contains(search))
          {
              SearchList.add(AllMedia);
          }
      }
  }
  public void playMedia() throws ModelException
  {
      try 
      {
          LogicManager.playMedia();
      }
      catch (BLLException ex) 
      {
          throw new ModelException(ex);
      }
  }
  public void setMedia (AllMedia media) throws ModelException
  {
      try 
      {
          LogicManager.setMedia(media);
      }
      catch (BLLException ex)
      {
          throw new ModelException(ex);
      }
  }
  
}
