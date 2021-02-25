
/**
 * Write a description of Part3 here.
 * 
 * @author Miguel Costa 
 * @version 25/02/2021
 */
public class Part3 {
    public boolean twoOcurrences(String stringa, String stringb) {
        int counter = 0;
        int finalIndex = stringa.length();
        
        for(int index = 0; index < stringb.length() - 1; index++) {
            if(index + finalIndex < stringb.length() + 1) {
                if((stringb.substring(index, index + finalIndex)).equals(stringa)) {
                    counter++;
                }
            }
        }
        
        if(counter >= 2) { 
            //System.out.println("counter: " + counter);
            return true;
        } else {
            //System.out.println("counter: " + counter);
            return false;
        }  
    }
    
    public String lastPart(String stringa, String stringb) {
        String result = stringb;
        
        if(!stringa.contains(stringa)) {
            return result;
        } else {
            int counter = 0;
            int finalIndex = stringa.length();
        
            for(int index = 0; index < stringb.length() - 1; index++) {
                if(index + finalIndex < stringb.length() + 1) {
                    if((stringb.substring(index, index + finalIndex)).equals(stringa)) {
                        counter++;
                    }
                    
                    if(counter == 1) {
                        result = stringb.substring(finalIndex);
                        return result;
                    }
                }
            }
        }
        
        return result;
    }
    
    public void testing() {
        System.out.println(twoOcurrences("by", "A story by Abby Long")); // output true
        System.out.println(twoOcurrences("a","banana")); //output true
        System.out.println(twoOcurrences("atg","ctgtatgta")); //output false
        System.out.println(twoOcurrences("atg","ctgtatgtatg")); // output true
        System.out.println(twoOcurrences("teste","testa")); // outut false
        
        
        System.out.println(lastPart("ana","Banana"));
        System.out.println(lastPart("zoo","forest"));
    }
}
