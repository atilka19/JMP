/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import jmp.BE.AllMedia;
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
          //AllMedia.addAll(LogicManager.loadMedia());
      }
      catch (Exception e) 
      {
          
      }
  }
  
  
}
