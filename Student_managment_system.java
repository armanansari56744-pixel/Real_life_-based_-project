import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;

    }

    public int getid() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setcourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + " , name : " + name + ", Age: " + age + ", course: " + course;
    }
}

class StudentManagment {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added sucessfully: ");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student found: ");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void searchStudent(int id) {
        for (Student s : students) {
            if (s.getid() == id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found: ");
    }

    public void deleteStudent(int id) {
        Student student = null;
        for (Student s : students) {
            if (s.getid() == id) {
                student = s;
                break;
            }
        }
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully: ");
        } else {
            System.out.println("tudent not found: ");
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        for (Student s : students) {
            if (s.getid() == id) {
                s.setName(name);
                s.setAge(age);
                s.setcourse(course);
                System.out.println("Student updated successfully: ");
                return;
            }
        }
        System.out.println("Student not found: ");
    }
}

public class Student_managment_system {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagment sm = new StudentManagment();
        while (true) {
            System.out.println("====Student Managment System: ====");
            System.out.println("1. Add Student: ");
            System.out.println("2. view Student: ");
            System.out.println("3. Search Student: ");
            System.out.println("4 . Update student: ");
            System.out.println("5. Delete student: ");
            System.out.println("6. Exit: ");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter course: ");
                    String course = sc.nextLine();

                    sm.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    sm.displayStudents();
                    break;

                case 3:
                    System.out.println("Enter Student ID: ");
                    sm.searchStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.println("Enter Student ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter new name: ");
                    name = sc.nextLine();

                    System.out.println("Enter New age:  ");
                    age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter New Course: ");
                    course = sc.nextLine();

                    sm.updateStudent(id, name, age, course);
                    break;

                case 5:
                    System.out.println("Enter Student ID: ");
                    sm.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Thank you: ");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice: ");
                    break;
            }
        }
    }
}
