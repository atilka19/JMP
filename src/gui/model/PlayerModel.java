/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jmp.BE.AllMedia;
import jmp.BLL.LogicManager;

/**
 *
 * @author atilk
 */
public class PlayerModel 
{
  private ObservableList<AllMedia> AllMedia = FXCollections.observableArrayList();
  private ObservableList<AllMedia> SearchList = FXCollections.observableArrayList();
  private ObservableList<String> Categories = FXCollections.observableArrayList();
  private final LogicManager bllManager = new LogicManager();
  
  
}
