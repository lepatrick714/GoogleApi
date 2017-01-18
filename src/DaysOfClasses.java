import java.lang.*; 

public class DaysOfClasses { 
    private boolean [] classes; 
    
    public DaysOfClasses() { 
        classes = new boolean[] {false, false, false, false, false, false, false};
    }

    public DaysOfClasses(boolean [] classes) { 
        this.classes = classes; 
    }

    public void set_days(boolean [] classes) { 
        this.classes = classes; 
    }
    
    public String print_Classes() { 
        String output = ""; 
        
        if(classes[0])
            output += "M"; 
        if(classes[1]) 
            output += "T"; 
        if(classes[2]) 
            output += "W"; 
        if(classes[3]) 
            output += "R"; 
        if(classes[4]) 
            output += "F"; 
        if(classes[5]) 
            output += "S"; 
        if(classes[6]) 
            output += "U"; 
        
        return output;
    }
}
