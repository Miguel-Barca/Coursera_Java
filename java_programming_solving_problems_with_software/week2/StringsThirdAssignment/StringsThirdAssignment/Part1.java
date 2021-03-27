
/**
 * Write a description of Part1 here.
 * 
 * @author Miguel Barca 
 * @version 12/03/2021
 */
import edu.duke.*;

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
        return dnaStr.length();
    }
   
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = 0;
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        
        if(minIndex == dna.length()) {
            return "";
        } else {
            minIndex = taaIndex;
        }
        
        if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) {
            minIndex = tagIndex;
        }
        
        if(minIndex == -1) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }
    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        
        int startIndex = 0;
        
        while(true) {
            String currentGene = findGene(dna, startIndex);
            
            if(currentGene.isEmpty()) {
                break;
            }
            
            geneList.add(currentGene); //using storage resource
            
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        
        return geneList;
    }
    public void testing() {
        
       
    }
    public void testOn(String dna) {
        System.out.println("Testing get allGenes() on " + dna);
        StorageResource genes = getAllGenes(dna);
        for(String g : genes.data()) {
            System.out.println(g);
        }
    }
}

