
package jmp.BLL;

import java.util.List;
import javafx.beans.property.BooleanProperty;
import jmp.BE.AllMedia;
import jmp.DAL.AccessManager;

/**
 * @author atilk
 */
public class LogicManager 
{
 private AllMedia selectedMedia;
 private AccessManager DataManager = new AccessManager();
 private MObjectManager MediaManager = new MObjectManager(DataManager);
 
public List<AllMedia> loadMedia() throws BLLException
{
    return MediaManager.getMedia();
}
public List<String> getCategories() throws BLLException
{
    return MediaManager.getCategories();
}
 public void addNewMedia (AllMedia NewMedia) throws BLLException
 {
     try 
     {
         MediaManager.addNew(NewMedia);
     }
     catch (BLLException ex)
     {
         throw new BLLException(ex);
     }
 }
 public void updateMedia (AllMedia selectedMedia) throws BLLException
 {
     if (selectedMedia == null)
         throw new BLLException("No Selection!");
 }
 public void deleteMedia (AllMedia selectedMedia) throws BLLException
 {
     if (selectedMedia == null)
     {
         throw new BLLException ("No Selection!");
     }
     MediaManager.delete(selectedMedia);
 }
 public void setSelectedMedia (AllMedia selected) throws BLLException
 {
     if (selected == null)
     {
         throw new BLLException("No selection!");
     }
     this.selectedMedia = selected;
 }
 public AllMedia getSelectedMedia() throws BLLException 
 {
     if (selectedMedia == null)
     {
         throw new BLLException("No Selection!");
     }
     return this.selectedMedia;
     

 }

}
