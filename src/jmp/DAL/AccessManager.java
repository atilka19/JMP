
package jmp.DAL;

import java.util.List;
import jmp.BE.AllMedia;

/**
 *
 * @author atilk
 */
public class AccessManager 
{
 private MediaManager mediaM = new MediaManager();
 public List<AllMedia> getAllMedia() throws DAException
 {
    List<AllMedia> mediaList = mediaM.getAll();
    return mediaList;
 }
 public void saveMedia (AllMedia media) throws DAException
 {
    mediaM.save(media);
 }
 public void editMedia (AllMedia media) throws DAException
 {
    mediaM.edit(media);
 }
 public void deleteMedia (AllMedia media) throws DAException
 {
    mediaM.delete(media);
 }
 
 
}
