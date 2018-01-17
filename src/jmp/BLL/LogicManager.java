
package jmp.BLL;

import java.util.List;
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

 
 
}
