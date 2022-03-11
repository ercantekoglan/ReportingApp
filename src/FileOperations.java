

import java.io.*;
import java.util.Arrays;

public class FileOperations {

	public Student[] fileReader() {

		BufferedReader br = null;
		Student[] students = new Student[101];

		try {
			int i = 0;
			String line = null;

			br = new BufferedReader(new FileReader("student.csv"));

			while ((line = br.readLine()) != null) {
				String[] rows = line.split(",");
				Student student = new Student(rows[0], rows[1], rows[2], rows[3]);
				students[i] = student;
				i++;
			}
			return students;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public void writeFile() {
		// Basically, I call the student objects array and sort them the write them.
		// I feel that this one might have problem in the bigger scenarios.
		FileOperations fileOperation = new FileOperations();
		Student[] student = fileOperation.fileReader();

		Arrays.sort(student, new FileSort());

		BufferedWriter writerApm = null;
		BufferedWriter writerCompsci = null;
		BufferedWriter writerStat = null;

		try {

			writerApm = new BufferedWriter(new FileWriter("apmth.csv"));
			writerCompsci = new BufferedWriter(new FileWriter("compSci.csv"));
			writerStat = new BufferedWriter(new FileWriter("stat.csv"));
			for (Student s : student) {

				if (s.getCourseName().contains("APMTH")) {
					writerApm
							.write(s.getId() + " " + s.getName() + " " + s.getCourseName() + " " + s.getGrade() + "\n");
				} else if (s.getCourseName().contains("COMPSCI")) {
					writerCompsci
							.write(s.getId() + " " + s.getName() + " " + s.getCourseName() + " " + s.getGrade() + "\n");
				} else if (s.getCourseName().contains("STAT")) {
					writerStat
							.write(s.getId() + " " + s.getName() + " " + s.getCourseName() + " " + s.getGrade() + "\n");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writerApm != null) {
				try {
					writerApm.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (writerCompsci != null) {
				try {
					writerCompsci.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (writerStat != null) {
				try {
					writerStat.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
