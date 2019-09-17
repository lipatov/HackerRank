package DataStructure.JavaPriorityQueue;

import java.util.*;

class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {

    List<Student> getStudents(List<String> events) {
        Comparator<Student> comparator = new StringLengthComparator();
        Queue<Student> q = new PriorityQueue<>(comparator);
        for (String str : events) {
            if (str.startsWith("ENTER")) {
                String[] ss = str.substring(6).split(" ");
                Student student = new Student(Integer.parseInt(ss[2]), ss[0], Double.parseDouble(ss[1]));
                q.add(student);
            }
            if (str.startsWith("SERVED")) {
                q.poll();
            }
        }
        List<Student> ls = new ArrayList<>(q);
        Collections.sort(ls, comparator);
        return ls;
    }

    static class StringLengthComparator implements Comparator<Student> {
        @Override
        public int compare(Student x, Student y) {
            if (Double.compare(y.getCgpa(), x.getCgpa()) != 0)
                return Double.compare(y.getCgpa(), x.getCgpa());
            if (Double.compare(y.getCgpa(), x.getCgpa()) == 0 && y.getName().compareTo(x.getName()) != 0) {
                return x.getName().compareTo(y.getName());
            }
            return Integer.compare(y.getId(), x.getId());
        }
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}