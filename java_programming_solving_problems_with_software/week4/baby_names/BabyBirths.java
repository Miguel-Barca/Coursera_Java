import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyBirths {
    public void printNames() {
        FileResource fr = new FileResource();
        
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <=100) {
           System.out.println("Name " + rec.get(0) + 
                              " Gender " + rec.get(1) +
                              " Num born " + rec.get(2));
                            }
        }
    }
    
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            } 
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
    }
    
    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource();
        
        int tempRank =0;
        int rank=0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(0).equals(name)) {
                if(rec.get(1).equals(gender)){
                tempRank = tempRank +1;
                if(rec.get(0).equals(name)){
                    rank = tempRank;
                    break;
                }
            }
            
            } 
            
            
        }
        if(rank == 0){
            return -1;
            }
        return rank;
    }
    
     public String getName(int year,int rank,String gender){
        String fileName = "data/yob"+year+ ".csv";
        FileResource fr = new FileResource();
        //CSVParser parser = fr.getCSVParser(false);
        
        int currentRank=0;
        String resultName ="No name";
        
        for(CSVRecord record: fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                currentRank = currentRank + 1;
                if(currentRank == rank){
                    resultName = record.get(0);
                    break;
                }
            }
        
        
        }
        return resultName;
    }
       public void testGetName(){
        String resultName1 = getName(1980,350,"F");
        System.out.println("In 1980,Females,Rank 350,name: "+ resultName1);
        
        String resultName2 = getName(1982,450,"M");
        System.out.println("In 1982,Males,Rank 450,name: "+ resultName2);
    
    }
    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public void testGetRank(){
        //int list[100] ; 
        
        System.out.println("Christine rank:");
        for(int i=1900;i<2001;i++){
            int rankResult =getRank(i,"Christine","F");
            System.out.println("In "+ i+":"+ rankResult);
        }
        
        System.out.println("Bryan rank:");
        for(int i=1900;i<2001;i++){
            int rankResult =getRank(i,"Bryan","M");
            System.out.println("In "+ i+":"+ rankResult);
        }
        
        
        // int rankResult= getRank(1966,"Tina","F");
        // System.out.println("Tina in female is ranked at "+ rankResult);
        //System.out.println("myList: "+ myList);

    }
}
