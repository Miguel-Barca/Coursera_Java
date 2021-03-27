
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author Miguel Costa 
 * @version 27/03/2021
 */

import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExport {
    CSVParser parser = tester();
    
    
    public void listExporters(CSVParser parser, String exportOfInterest) {
        for(CSVRecord record : parser) {
            String export = record.get("Exports"); //this methods gets the column name
            
            if(export.contains(exportOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);
            
            }
        }
 
    }
    
    //let's test it with coffe
    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");

    }
    
       public CSVParser tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        return parser;
    }
    
    public String countryInfo(String country) {
                
        	for(CSVRecord record : parser) {
			String myCountry = record.get("Country");
			if(myCountry.contains(country)) {
				String exports = record.get("Exports");
				String value = record.get("Value (dollars)");
				String info = myCountry + ": " + exports + ": " + value;
				return info;
			}
		}

		return "NOT FOUND";
    }
    
    
}
