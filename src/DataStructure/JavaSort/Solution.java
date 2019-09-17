package DataStructure.JavaSort;

import java.util.*;

class Student {

    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort((c1, c2) -> {
            if (Double.compare(c2.getCgpa(), c1.getCgpa()) != 0)
                return Double.compare(c2.getCgpa(), c1.getCgpa());
            else if (Double.compare(c2.getCgpa(), c1.getCgpa()) == 0 && c2.getFname().compareTo(c1.getFname()) != 0)
                return c1.getFname().compareTo(c2.getFname());
            return Integer.compare(c2.getId(), c1.getId());
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
