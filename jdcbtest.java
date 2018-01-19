//Author Peter Adamson

public class jdbctest {
	
  public static void main(String args[]){
    try{
       Class.forName("org.postgresql.Driver");
       
       // connect to the database
       Connection   con  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbgeo", "bigdata", "");
       Statement stmt = con.createStatement();
       
       // TASK1: Write your query here
       // Query: for each semester in 2015 show the number of students who enrolled in a course, with the result sorted by the enrolment number.
       String query = "select DISTINCT semester,count(*) as cnt from enroll e WHERE semester LIKE '%2015' GROUP BY semester ORDER BY cnt";
       
    
       //TASK2: Execute query and print the result
	   ResultSet rs=stmt.executeQuery(query);
	   while(rs.next()){
		   System.out.println(rs.getString(1) + " " + rs.getInt(2));
	   }
	   
	   // close resources
	   rs.close();
	   stmt.close();
	   con.close();
	} catch(Exception e) {
	  System.err.println(e); 
	  }
    }  
