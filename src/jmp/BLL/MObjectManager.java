
package jmp.BLL;

import java.util.ArrayList;
import java.util.List;
import jmp.BE.AllMedia;
import jmp.DAL.AccessManager;
import jmp.DAL.DAException;
import jmp.BLL.BLLException;

/**
 * @author atilk
 */
public class MObjectManager 
{
 private List<String> categories;
 private AccessManager Accessmanager;
 
 public MObjectManager (AccessManager dm)
 {
     this.Accessmanager = dm;
 }
 List<AllMedia> getMedia() throws BLLException
 {
     try 
     {
         List<AllMedia> uMediaList = Accessmanager.getAllMedia();
         return uMediaList;
         
     }
     catch (DAException ex)
     {
         throw new BLLException(ex);
     }
  
 }
 public List<String> getCategories() throws BLLException
 {
     if(categories == null)
     {
         throw new BLLException ("No Categories have been added");
     }
     return this.categories;
 }
 void addNew(AllMedia selectedMovie) throws BLLException
 {
     try 
     {
        Accessmanager.saveMedia(selectedMovie);
     }
     catch (DAException ex) 
     {
         throw new BLLException(ex);
     }
 }
 void delete (AllMedia selected) throws BLLException
 {
     try 
     {
        Accessmanager.deleteMedia(selected);
     } 
     catch (DAException ex) 
     {
         throw new BLLException(ex);
     }
 }
 void updateMedia(AllMedia selectedMovie) throws BLLException 
 {
        try 
        {
            Accessmanager.editMedia(selectedMovie);
        }
        catch (DAException ex) 
        {
            throw new BLLException(ex);
        }
 }
}
