import java.io.*;
import java.util.*; 

public class Student { 
    private String student_name; 
    private int class_level; 
    private String college_name; 
    private String major; 
    private String department; 
    private String quarter_type; 
    private Courses [] list_of_courses; 

    //Start of Public Constructors
    public Student() { }
    public Student(String student_name) { this.student_Name = student_name; }
    //End of Public Constructors 
    
    //Start of Mutator Functions
    public void set_student_name(String student_name) { this.student_name = student_name; } 
    public void set_class_level(int class_level) { this.class_level = class_level; }
    public void set_college_name(String college_name) { this.college_name = college_name; }
    public void set_major(String major) { this.major = major; }
    public void set_department(String department) { this.department = department; }
    public void set_quarter_type(String quarter_type) { this.quarter_type = quarter_type; }
    public void set_courses(Courses [] list_of_courses) { this.list_of_courses = list_of_courses; }
    //End of Mutator Functions

    //Start of Assessors Functions
    public String get_student_name() { return this.student_name; }
    public int get_class_level() { return this.class_level; } 
    public String get_college_name() { return this.college_name; }
    public String get_major_name() { return this.major; }
    public String get_department() { return this.department; }
    public String get_quarter_type() { return this.quarter_type; } 
    public Courses [] get_list_of_courses() { return this.list_of_courses.; }
    //End of Assessors Functions 
    
    //Testing Functions 
    public String print_all() { 
        String output = "Student's name: " + student_name + "\n"; 
        output += "Class Level: " + class_level + "\n"; 
        output += "College: " + college_name + "\n"; 
        output += "Major: " + major_name + "\n"; 
        output += "Department: " + department + "\n"; 
        output += "Quarter: " + quarter_type + "\n"; 
        output += "List of Courses below: " + "\n";

        for(int i=0; i<list_of_courses.length; i++) {
            output += list_of_courses[i].print_all() + "\n"; 
        }
        output += "\n"; 
        return output; 
    }
    //End of Testing Functions
}
