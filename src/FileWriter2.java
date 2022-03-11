

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileWriter2 {

	public void processFile() {

		FileOperations fileOperation = new FileOperations();

		Student[] students = fileOperation.fileReader();
		Student[] csStudents = fileOperation.fileReader();
		Student[] mathStudents = fileOperation.fileReader();
		Student[] statStudents = fileOperation.fileReader();

		int csStudentsIndex = 0;
		int mathStudentsIndex = 0;
		int statStudentsIndex = 0;

		{

			for (int i = 0; i < 101; i++) {
				if (students[i].getCourseName().contains("COMPSCI")) {
					csStudents[csStudentsIndex++] = students[i];
				}

				if (students[i].getCourseName().contains("APMTH")) {
					mathStudents[mathStudentsIndex++] = students[i];
				}
				if (students[i].getCourseName().contains("STAT")) {
					statStudents[statStudentsIndex++] = students[i];
				}
			}

			Arrays.sort(csStudents, new FileSort());
			Arrays.sort(mathStudents, new FileSort());
			Arrays.sort(statStudents, new FileSort());

			BufferedWriter csStudentWriter = null;
			BufferedWriter mathStudentWriter = null;
			BufferedWriter statStudentWriter = null;

			try {
				csStudentWriter = new BufferedWriter(new FileWriter("compSci1.csv"));
				mathStudentWriter = new BufferedWriter(new FileWriter("math1.csv"));
				statStudentWriter = new BufferedWriter(new FileWriter("stat1.csv"));
				for (int i = 0; i < csStudentsIndex; i++) {

					try {
						csStudentWriter.write(csStudents[i].getId() + " " + csStudents[i].getName() + " "
								+ csStudents[i].getCourseName() + " " + csStudents[i].getGrade() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				for (int i = 0; i < mathStudentsIndex; i++) {

					try {
						mathStudentWriter.write(mathStudents[i].getId() + " " + mathStudents[i].getName() + " "
								+ mathStudents[i].getCourseName() + " " + mathStudents[i].getGrade() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				for (int i = 0; i < statStudentsIndex; i++) {

					try {
						csStudentWriter.write(statStudents[i].getId() + " " + statStudents[i].getName() + " "
								+ statStudents[i].getCourseName() + " " + statStudents[i].getGrade() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {

				if (csStudentWriter != null) {
					try {
						csStudentWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (mathStudentWriter != null) {
					try {
						mathStudentWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (statStudentWriter != null) {
					try {
						statStudentWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}