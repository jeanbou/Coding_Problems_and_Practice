package hackerRank_Java30DaysOfCode;

import java.util.*;

public class Day012_Class_Inherited_Person {

		protected String firstName;
		protected String lastName;
		protected int idNumber;
		
		// Constructor
		Day012_Class_Inherited_Person(String firstName, String lastName, int identification){
			this.firstName = firstName;
			this.lastName = lastName;
			this.idNumber = identification;
		}
		
		// Print person data
		public void printPerson(){
			 System.out.println(
					"Name: " + lastName + ", " + firstName 
				+ 	"\nID: " + idNumber); 
		}		 
}

class Student extends Day012_Class_Inherited_Person {
	private int[] testScores;

    private double averageScore = -1.0; // indicator that grade has not been calculated
    private String gradeString = null;
    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    
    // Subclass constructor:
    Student(String firstName, String lastName, int ID, int[] scores){ 
        // Explicit call to superclass constructor:
        super(firstName,lastName,ID);
        this.testScores = scores;
        this.setAverageScore(-1.0);
        this.setGrade(null);
    }
    
    public void setGrade(String aGrade) {
        this.gradeString = aGrade;
    }
    
    public String getGrade() {
        return gradeString;
    }
    
    public void setAverageScore(double aScore) {
        this.averageScore = aScore;
    }
    
    public double getAverageScore() {
        return averageScore;
    }
    
    /*	
    *   Method Name: gradeStudent
    *   @return A character denoting the grade.
    */
    private void gradeStudent() {
        
        String studentGrade = null;
        
        // Protective if
        if (getAverageScore() < 0) { // Average score has never been calculated
            setAverageScore(calculateAverageScroreValue());            
        }
        
        // Grading according to the table
        double aGrade = getAverageScore();
        if ( aGrade <= 100 && aGrade >= 90) {
            studentGrade = "O";
        } else if ( aGrade < 90 && aGrade >= 80) {
            studentGrade = "E";
        } else if ( aGrade < 80 && aGrade >= 70) {
            studentGrade = "A";
        } else if ( aGrade < 70 && aGrade >= 55) {
            studentGrade = "P";
        } else if ( aGrade < 55 && aGrade >= 40) {
            studentGrade = "D";
        } else {
            studentGrade = "T";
        }
        
        this.setGrade(studentGrade);
    } 
    
    
    private double calculateAverageScroreValue() {
        double sum = 0.0;
        for (int aScore : this.testScores) {
            sum += aScore;
        }
        return (sum/testScores.length);
    }
    

    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    public String calculate() {
        // calculate / re-calculate grade
        setAverageScore(calculateAverageScroreValue());        
        this.gradeStudent();
        return getGrade();
    }
    
} // the end of class student

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}

