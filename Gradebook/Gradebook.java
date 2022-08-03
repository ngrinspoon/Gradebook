//import ...
import java.util.*;
import java.io.*;

/**
 * A helper class for your gradebook
 * Some of these methods may be useful for your program
 * You can remove methods you do not need
 * If you do not wish to use a Gradebook object, don't
 */
public class Gradebook {
  private List<Student> students;
  private List<Assignment> assignments;
  private Map<Student, Map<Assignment, Integer>> gradebook;

  /* Read a Gradebook from a file */
  public Gradebook(String filename) {
    // just call gradebookadd
    this();

    // Read from file
  }

  /* Create a new gradebook */
  public Gradebook() {
    students = new ArrayList<Student>();
    assignments = new ArrayList<Assignment>();
    gradebook = new HashMap<Student, Map<Assignment, Integer>>();
    //gradebook.put(some student, new HashMap<Assignment, Integer>())
  }

  /* return the size of the gradebook */
  public int size() {
    return students.size();
  }

  /* Adds a student to the gradebook */
  public void addStudent(String first, String last) {
    Student stud = new Student(first, last);
    students.add(stud);
    gradebook.put(stud, new HashMap<Assignment, Integer>());
  }

  /* Adds an assinment to the gradebook */
  public void addAssignment(String name, int points, double weight) {
    assignments.add(new Assignment(name, points, weight));
  }

  /* Adds a grade to the gradebook */
  public void addGrade(String assignmentName, String firstName, String lastName, int grade) {
    Student student = getStudent(firstName, lastName) ;
    Assignment assignment = getAssignment(assignmentName);

    // Ensure that student and assignment exist
    if (student != null && assignment != null) {
      Map<Assignment, Integer> grades = gradebook.get(student);
      grades.put(assignment, grade);
      gradebook.put(student, grades);
    } else {
      System.out.println("Student or Assignment not found in addGrade");
    }

  }

  private Student getStudent(String firstName, String lastName) {
    for (Student s : students) {
      if (s.matchStudent(firstName, lastName)){
        return s;
      }
    }

    return null;
  }

  private Assignment getAssignment(String assignmentName) {
    for (Assignment a : assignments) {
      if (a.getName().equals(assignmentName)) {
        return a;
      }
    }

    return null;
  }

  private double getPointsAssignment(Student student, Assignment assignment) {
    return gradebook.get(student).get(assignment);
  }

  private double getGradeStudent(Student student) {
    Map<Assignment, Integer> assignmentMap = gradebook.get(student);
    Set<Assignment> assignmentSet = assignmentMap.keySet();
    double total = 0;
    int numAssignments = assignmentSet.size();
    for (Assignment a : assignmentSet) {
      total += (((double)assignmentMap.get(a)) / a.getPoints()) * (a.getWeight()))
    }

    return total / numAssignments;
  }

  public String toString() {
    String ret = "";
    for (Map.Entry<Student, Map<Assignment, Integer>> entry : gradebook.entrySet())
      ret += "(" + entry.getKey().getLast() + ", " + entry.getKey().getFirst() + ", " + getGrade(entry.getKey()) + ")\n";

    return ret;
  }

  /* Inner classes */
  public class Assignment {
    private String name;
    private int points;
    private double weight;

    public Assignment(String name, int points, double weight) {
      this.name = name;
      this.points = points;
      this.weight = weight;
    }

    public String getName() {
      return name;
    }

    public int getPoints() {
      return points;
    }

    public int getWeight() {
      return weight;
    }
  }

  public class Student {
    private String firstName;
    private String lastName;
    //calculate grade at end

    public Student(String first, String last) {
      this.firstName = first;
      this.lastName = last;
    }

    public String getFirst() {
      return firstName;
    }

    public String getLast() {
      return lastName;
    }

    public boolean matchStudent(String fn, String ln){
      return fn.equals(firstName) && ln.equals(lastName);
    }
  }
}
