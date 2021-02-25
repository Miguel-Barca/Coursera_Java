
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        int start = dna.indexOf(startCodon);
        
        if(dna.indexOf(startCodon.toLowerCase()) == -1 && dna.indexOf(startCodon.toUpperCase()) == -1) {
            return "";
        }
   
        int stop = dna.indexOf(stopCodon , start + 3);
        if(dna.indexOf(stopCodon.toLowerCase()) == -1 && dna.indexOf(stopCodon.toUpperCase()) == -1) {
            return "";
        }
        
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop + 3);
        } else {
            return "";
        }   
    }
    
    public void testSimpleGene() {
        String noStartCodon = "cccttggggtaa";
        String noStopCodon = "atgttggggtag";
        String neitherCodon = "cccttggggtag";
        String multipleOfThree = "atggggtttatatagtagtaa";
        String notMultipleOfThree = "atgttgggagtaa";
        
        System.out.println(noStartCodon);
        System.out.println(noStopCodon);
        System.out.println(neitherCodon);
        System.out.println(multipleOfThree);
        System.out.println(notMultipleOfThree);
        
        System.out.println("result: " + findSimpleGene(noStartCodon, "atg", "taa"));
        System.out.println("result: " + findSimpleGene(noStopCodon, "atg", "taa"));
        System.out.println("result: " + findSimpleGene(neitherCodon, "atg", "taa"));
        System.out.println("result: " + findSimpleGene(multipleOfThree, "atg", "taa"));
        System.out.println("result: " + findSimpleGene(multipleOfThree.toUpperCase(), "ATG", "TAA"));
        System.out.println("result: " + findSimpleGene(notMultipleOfThree, "atg", "taa"));
    }
}
