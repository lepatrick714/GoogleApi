import java.io.*; 
import java.util.*; 

public class ParseData { 
    
    //At the moment, this just reads and stores strings in a List
    private static List<String> readFile(String filename) { 
        List<String> records = new ArrayList<String>(); 

        try { 
            BufferedReader reader = new BufferedReader(new FileReader(filename)); 
            String line; 
            while((line = reader.readLine()) != null) { 
                records.add(line); 
            }
            reader.close(); 
            return records; 
        }
        catch(Exception e) { 
            System.err.format("Exception occurred trying to read '%s'.", filename); 
            e.printStackTrace(); 
            return null;
        }
    }
   
    //Main 
    public static void main(String argv[]) { 
        List<String> data;        
        
        data = readFile(argv[0]);
    
    
    }
}
