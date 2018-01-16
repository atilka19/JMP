
package jmp.DAL;

/**
 *
 * @author atilk
 */
public class DAException extends Exception 
{
    public DAException(String message)
    {
        super(message);
    }
    
    public String getMassage()
    {
        return super.getMessage();
    }
}
