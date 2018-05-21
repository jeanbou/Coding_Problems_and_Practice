package hackerRank_Java30DaysOfCode;

public class Day004_Class_and_Instance {

	public class Person {		
	
	    private int age;	
	  
		public Person(int initialAge) {
			if (initialAge < 0) {
				this.setAge(0);
				System.out.println("Age is not valid, setting age to 0.");
			}
			else {
				this.setAge(initialAge);
			}
		}

		public void amIOld() {
	  		if (this.getAge() < 13) {
	  			System.out.println("You are young.");
	  		}
	  		else if (this.getAge() < 18) {
	  			System.out.println("You are a teenager.");
	  		}
	  		else {
	  			System.out.println("You are old.");	  			
	  		}
		}

		public void yearPasses() {
			this.setAge(this.getAge()+1);
	    }
		
		public void setAge(int anAge) {
			this.age = anAge;
		}
		
		public int getAge() {
			return age;
		}
		
	} // The end of Person Class
	
};
