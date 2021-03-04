
/**
 * Write a description of Part1 here.
 * 
 * @author Miguel Barca 
 * @version 03/03/2021
 */
public class Part1 {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex);
        while(currIndex != -1) {
            int diff = currIndex - startIndex;
            if(diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.Str.length();
    }
   
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        
        if(minIndex == dna.length()) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }
    public void testing() {
        System.out.println(twoOcurrences("by", "A story by Abby Long")); // output true
        System.out.println(twoOcurrences("a","banana")); //output true
        System.out.println(twoOcurrences("atg","ctgtatgta")); //output false
        System.out.println(twoOcurrences("atg","ctgtatgtatg")); // output true
        System.out.println(twoOcurrences("teste","testa")); // outut false
       
    }
}
