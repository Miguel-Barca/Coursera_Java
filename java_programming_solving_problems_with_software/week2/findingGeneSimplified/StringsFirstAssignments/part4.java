
/**
 * Write a description of part4 here.
 * 
 * @author Miguel Costa 
 * @version 25/02/2021
 */
import edu.duke.*;

public class part4 {
    URLResource ur = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
    
    public void findWebsite() {
        
            // process each line in turn
             for (String s : ur.lines()) {
                 // print or process s
                 for (String word : ur.words()) {
                     // process each word in turn
                     
                     if(word.toLowerCase().contains("www.youtube.com")) {
                         int firstOcurrence = word.indexOf("\"");
                         int lastOcurrence = word.indexOf("\"", firstOcurrence + 1);
                         
                         //System.out.println(word);
                         //System.out.println(firstOcurrence);
                         //System.out.println(lastOcurrence);
                         String youtubeUrl = word.substring(firstOcurrence + 1, lastOcurrence);
                         System.out.println(youtubeUrl);
                     }
                 };
             } 
        
    }
    
    
}
