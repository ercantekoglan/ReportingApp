

public class Main {

	public static void main(String[] args) {

		// first solution - this one saves the file apmth.csv / compSci.csv / stat.csv
		// this process first read the file then sort it according to the "grade". Then
		// writes the sorted data with using if - else blocks.
		// I coded all bymyself but for the first solution I get support from previous
		// exercise to build "Student[] fileReader() method inside the FileOperations
		// class."

		new FileOperations().fileReader();
		new FileOperations().writeFile();

		// second solution - this one saves the file apmth1.csv / compSci1.csv / stat1.csv
		// when I started to solve the problem first I though on this solution.After
		// finished the first one try to build this one. Because, as logical design it
		// seems more sensible.
		// First read the file, then group them inside the different object array then
		// sort and write it.
		//BTW I am going to fix the braches inside the this week.
		new FileWriter2().processFile();

	}

}
