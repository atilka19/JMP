
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
 List <AllMedia> getMedia() throws BLLException
 {
     try 
     {
       List< AllMedia> nMediaList = Accessmanager.getAllMedia();
       categories = new ArrayList<>();
       for (AllMedia allMedia : nMediaList)
       {
           if(!categories.contains(allMedia.getCategory()))
           {
               categories.add(allMedia.getCategory());
           }
       }
       return nMediaList;
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
}
