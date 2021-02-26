
/**
 * Write a description of Part1 here.
 * 
 * @author Miguel Costa 
 * @version 25/02/2021
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("atg");
	if (start == -1) {
	    return "";
	}
	
	int stop = dna.indexOf("taa", start+3);
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
        
        System.out.println("result: " + findSimpleGene(noStartCodon));
        System.out.println("result: " + findSimpleGene(noStopCodon));
        System.out.println("result: " + findSimpleGene(neitherCodon));
        System.out.println("result: " + findSimpleGene(multipleOfThree));
        System.out.println("result: " + findSimpleGene(notMultipleOfThree));
    }
}
