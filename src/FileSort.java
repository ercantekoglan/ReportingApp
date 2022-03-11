

import java.util.Comparator;

public class FileSort implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {

		return student2.getGrade().compareTo(student1.getGrade());
	}

}
