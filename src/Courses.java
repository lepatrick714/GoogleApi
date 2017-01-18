import java.util.*; 

public class Courses { 
    private String course_name; 
    private String course_description; 
    private int section_number; 
    private int unit_ctr; 
    private int course_Id;
    private DaysOfClasses active_days; 
    private String times; 
    private String location; 
    private String professor_name;

    //Start of Public Constructors 
    public Courses() { }
    public Courses(String course_name, int section_number, int unit_ctr, int course_Id, String course_description,
                    DaysOfClasses active_days, String times, String location, String professor_name) { 
        this.course_name = course_name;
        this.course_description = course_description; 
        this.section_number = section_number; 
        this.unit_ctr = unit_ctr; 
        this.course_Id = course_Id; 
        this.active_days = active_days; 
        this.times = times; 
        this.location = location; 
        this.professor_name = professor_name; 
    }
    //End of Public Constructors 
    
    //Start of public Mutators 
    public void set_course_name(String course_name) { this.course_name = course_name; }
    public void set_course_description(String course_description) { this.course_description = course_description; }
    public void set_section_number(int section_number) { this.section_number = section_number; }
    public void set_unit_ctr(int unit_ctr) { this.unit_ctr = unit_ctr; }
    public void set_course_id(int course_Id) { this.course_Id = course_Id; }
    public void set active_days(DaysOfClasses active_days) { this.active_days = active_days; } 
    public void set_times(String times) { this.times = times; } 
    public void set_location(String location) { this.location = location; } 
    public void set_professor_name(String professor_name) { this.professor_name = professor_name; }
    //End of Public Mutators 
    
    //Start of public Assessors 
    public String get_course_name() { return this.course_name; } 
    public String get_course_description() { return course_description; }
    public int get_section_number() { return this.section_number; } 
    public int get_unit_ctr() { return this.unit_ctr; } 
    public int get_course_id() { return this.course_Id; } 
    public DaysOfClasses get_days_of_classes() { return this.active_days; } 
    public String get_times() { return this.time; } 
    public String get_location() { return this.location } 
    public String get_professor_name() { return professor_name; }
    //End of public Asessors 

    //Testing Functions 
    public String print_all() { 
        String output = "Course's Name: " + course_name + "\n"; 
        output += "Course's Description: " + course_description + "\n"; 
        output += "Section Number: " + section_number + "\n"; 
        output += "Total Units: " + unit_ctr + "\n"; 
        output += "Course's ID: " + course_Id + "\n"; 
        output += "Active Days: " + active_days.print() + "\n"; 
        output += "Times: " + time + "\n"; 
        output += "Location: " + location + "\n"; 
        output += "Professor's Name: " + professor_name + "\n"; 
        return output;
    }
    //End of Testing Functions
}
