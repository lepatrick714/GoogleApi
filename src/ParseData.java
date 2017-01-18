import java.io.*; 
import java.util.*; 

public class ParseData { 
    private static void write_to_simpified_file(File user_file_name, String to_be_written) { 
        try { 
            FileWriter writer = new FileWriter(user_file_name, true); 
            writer.write(to_be_written + "\n"); 
            writer.close();
        } catch(Exception e) { 
            System.err.format("Error when writing to <user_name>_simplified.txt"); 
            e.printStackTrace();
        }
    }
    
    private static File grab_user_data(BufferedReader reader) { 
        try {
            for(int i=0; i<9; i++) {
                reader.readLine(); 
            }
            
            //Should have <User> <Quarter Season> <Year> Schedule
            String [] user_title = reader.readLine().split(" ");
            String user_file_name = "";
            String user_name = ""; 

            for(int i=0; i<user_title.length-3; i++) {
                    user_file_name += user_title[i] + "_"; 
                    user_name += user_title[i] + " "; 
            }
            String user_date = user_title[user_title.length-3] + " " +
                                user_title[user_title.length-2] + " " + 
                                user_title[user_title.length-1]; 
            
            user_file_name += "simplified.txt";

            //Creation of User's simplified file
            File file = new File("../data/simplified/" + user_file_name); 
            file.createNewFile(); 
            
            //Writing user_data 
            write_to_simpified_file(file, user_name); 
            write_to_simpified_file(file, user_date); 

            return file;
        } catch(Exception e) { 
            System.err.format("Error when reading in grab_user_data(reader)"); 
            e.printStackTrace(); 
            return null;
        }
    }

    private static String skip_till_start_courses(BufferedReader reader) { 
        try { 
            String str1 = reader.readLine(); 
            while(!str1.equals("Units CRN"))
                str1 = reader.readLine();
            
            reader.readLine(); 
            str1 = reader.readLine(); 
            if(str1.equals("Meeting Times")) {
                reader.readLine(); 
                str1 = reader.readLine();
            }
            return str1; 
        }
        catch(Exception e) { 
            System.err.format("Exception occurred trying to read in skip_till_start_courses.");
            e.printStackTrace();
            return null;
        }
    }

    private static void grab_course_details(File file, BufferedReader reader) { 
        try { 
            //Course Name
            reader.readLine(); 
            String str = reader.readLine(); 
            write_to_simpified_file(file, str.substring(0, str.length()-3));
            write_to_simpified_file(file, str.substring(str.length()-3));
            
            //Unit CTR
            reader.readLine(); 
            write_to_simpified_file(file, reader.readLine()); 

            //Course ID
            reader.readLine(); 
            String [] str1 = reader.readLine().split(" "); 
            write_to_simpified_file(file, str1[0]); 
            

            //Active Days - NOTE NOT AVIABLE FOR ONLINE COURSES
            str1 = reader.readLine().split(", ");
            if(!str1[0].equals("Riverside")) {
                str = "";
                for(int i=0; i<str1.length; i++) { str += str1[i] + " "; }
                write_to_simpified_file(file, str);

                //Time - NOTE NOTE AVIABLE FOR ONLINE COURSES
                str = reader.readLine(); 
                write_to_simpified_file(file, str); 
            }

            //Location 
            str1 = reader.readLine().split(", "); 
            str = ""; 
            for(int i=0; i<str1.length; i++) { str += str1[i] + " "; }
            write_to_simpified_file(file, str); 

            String temp = reader.readLine(); 
            while(temp.length() > 0) { 
                str1 = temp.split(", ");
                str = ""; 
                for(int i=0; i<str1.length; i++) { str += str1[i] + " "; } 
                write_to_simpified_file(file, str); 
                temp = reader.readLine(); 
            }
        }
        catch(Exception e) { 
            System.err.format("Exception occurred at grab_course_details."); 
            e.printStackTrace();
        }
    }

    private static void init(String filename) { 
        try { 
            BufferedReader reader = new BufferedReader(new FileReader(filename)); 
          
            //Grabbing file location and Writing user's full name and schedule name
            File file = grab_user_data(reader); 
            String [] temp = reader.readLine().split(" "); 
            write_to_simpified_file(file, temp[3] + " " + temp[1]); 
            temp = reader.readLine().split(" ");
            
            //Grabbing user's College and Major 
            String user_college = "", user_major = ""; 
            int index = Arrays.asList(temp).indexOf("Major:");  
            for(int i=1; i<index; i++) { user_college += temp[i] + " "; }
            for(int i=index+1; i<temp.length; i++) { user_major += temp[i] + " "; }
            
            //Writing user's College and Major
            write_to_simpified_file(file, user_college + "\n" + user_major); 
            temp = null; 

            //Grabbing user's Department and Writing it 
            String user_department = reader.readLine().substring(11);
            write_to_simpified_file(file, user_department + "\n"); 
           
            //Skipping till the first Course Name then write it. 
            String startCourse = skip_till_start_courses(reader);
            write_to_simpified_file(file, startCourse); 
            
            //Grabbing the Course Details <DOES NOT GRAB COURSE DESCRIPTIONS> 
            grab_course_details(file, reader); 
            write_to_simpified_file(file, "");
            
            String str = reader.readLine(); 
            
            while(!str.contains("Total Units")) { 
                write_to_simpified_file(file, str); 
                grab_course_details(file, reader); 
                write_to_simpified_file(file, ""); 
                str = reader.readLine();
            }
        }
        catch(Exception e) { 
            System.err.format("Exception occurred trying to read '%s'.", filename); 
            e.printStackTrace(); 
        }
    }
   
    //Main 
    public static void main(String argv[]) { 
        init(argv[0]); 
    }
}
