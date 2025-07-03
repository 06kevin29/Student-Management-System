import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    private static void printList(String header, List<?> list) {
        System.out.println(header + "\n============");
        if (list.isEmpty()) {
            System.out.println("No " + header + " registered.");
        } else {
            if (list.get(0) instanceof Student) {
                System.out.println("ID\tName\tEmail\tAge\tGrade");
            } else if (list.get(0) instanceof Teacher) {
                System.out.println("ID\tName\tEmail\tAge\tSubject");
            } else if (list.get(0) instanceof Course) {
                System.out.println("ID\tName");
            }
            for (Object o : list) {
                System.out.println(o);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome to Java Student Management System");
        do {
            System.out.println("Menu\n========");
            System.out.println("1. Add a Student");
            System.out.println("2. Add a Teacher");
            System.out.println("3. Add a Course");
            System.out.println("4. Assign Courses to Students");
            System.out.println("5. Assign Courses to Teachers");
            System.out.println("6. View Student by ID");
            System.out.println("7. View every Student and Teacher");
            System.out.println("8. View every Course");
            System.out.println("9. Update Student");
            System.out.println("10. Delete Student");
            System.out.println("11. Exit");

            System.out.print("\nEnter a number (1-11): ");

            int menuSelection;
            try {
                menuSelection = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                continue;
            }
            finally {
                System.out.println();
            }

            switch (menuSelection) {
                case 1:
                    try {
                        System.out.print("Enter Student name: ");
                        String name = input.nextLine().trim();
                        System.out.print("Enter Student age: ");
                        int age = Integer.parseInt(input.nextLine());
                        System.out.print("Enter Student email: ");
                        String email = input.nextLine();
                        System.out.print("Enter Student grade: ");
                        int grade = Integer.parseInt(input.nextLine());
                        students.add(new Student(name, age, email, grade, students.size() + 1));
                        System.out.printf("%s successfully added.", name.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    finally {
                        System.out.println();
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter Teacher name: ");
                        String name = input.nextLine().trim();
                        System.out.print("Enter Teacher age: ");
                        int age = Integer.parseInt(input.nextLine());
                        System.out.print("Enter Teacher email: ");
                        String email = input.nextLine();
                        System.out.print("Enter Teacher subject: ");
                        String subject = input.nextLine();
                        teachers.add(new Teacher(name, age, email,teachers.size() + 1, subject));
                        System.out.printf("%s successfully added.", name.trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    finally {
                        System.out.println();
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter Course name: ");
                        String name = input.nextLine().trim();
                        courses.add(new Course(name, courses.size() + 1));
                        System.out.printf("%s successfully added.", name.trim());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    finally {
                        System.out.println();
                    }
                    break;
                case 4:
                    try {
                        printList("Students", students);
                        System.out.print("Select a student by ID: ");
                        int studentId = Integer.parseInt(input.nextLine());
                        Student s = students.stream()
                                .filter(student -> student.getStudentId() == studentId)
                                .findFirst().get();
                        if (s == null) {
                            System.out.println("Student with this ID not found.");
                            continue;
                        }

                        printList("Courses", courses);
                        System.out.print("Select a Course by ID: ");
                        int courseId = Integer.parseInt(input.nextLine());
                        Course c = courses.stream()
                                .filter(course -> course.getCourseId() == courseId)
                                .findFirst().get();
                        if (c == null) {
                            System.out.println("Course with this ID not found.");
                            continue;
                        }

                        s.addCourse(c);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } finally {
                        System.out.println();
                    }
                    break;
                case 5:
                    try {
                        printList("Teachers", teachers);
                        System.out.print("Select a teacher by ID: ");
                        int teacherId = Integer.parseInt(input.nextLine());
                        Teacher t = teachers.stream()
                                .filter(teacher -> teacher.getTeacherId() == teacherId)
                                .findFirst().get();
                        if (t == null) {
                            System.out.println("Student with this ID not found.");
                            continue;
                        }

                        printList("Courses", courses);
                        System.out.print("Select a Course by ID: ");
                        int courseId = Integer.parseInt(input.nextLine());
                        Course c = courses.stream()
                                .filter(course -> course.getCourseId() == courseId)
                                .findFirst().get();
                        if (c == null) {
                            System.out.println("Course with this ID not found.");
                            continue;
                        }

                        t.addCourse(c);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } finally {
                        System.out.println();
                    }
                    break;
                case 6:
                    try {
                        System.out.print("Enter a student ID: ");
                        int studentId = Integer.parseInt(input.nextLine());

                        Student s = students.stream()
                                .filter(student -> student.getStudentId() == studentId)
                                .findFirst().get();
                        if (s == null) {
                            System.out.println("Student with this ID not found.");
                            continue;
                        }
                        System.out.println(s);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    } finally {
                        System.out.println();
                    }
                    break;
                case 7:
                    printList("Students", students);
                    printList("Teachers", teachers);
                    break;
                case 8:
                    printList("Courses", courses);
                    break;
                case 9:
                    try {
                        System.out.print("Enter a student ID: ");
                        int studentId = Integer.parseInt(input.nextLine());

                        Student s = students.stream()
                                .filter(student -> student.getStudentId() == studentId)
                                .findFirst().get();
                        if (s == null) {
                            System.out.println("Student with this ID not found.");
                            continue;
                        }

                        System.out.print("Enter Student name: ");
                        String name = input.nextLine().trim();
                        if (!name.isEmpty())
                            s.setName(name);
                        System.out.print("Enter Student age: ");
                        String ageString = input.nextLine().trim();
                        if (!ageString.isEmpty()) {
                            int age = Integer.parseInt(ageString);
                            s.setAge(age);
                        }
                        System.out.print("Enter Student email: ");
                        String email = input.nextLine();
                        if (!email.isEmpty())
                            s.setEmail(email);
                        System.out.print("Enter Student grade: ");
                        String gradeString = input.nextLine().trim();
                        if (!gradeString.isEmpty()) {
                            int grade = Integer.parseInt(gradeString);
                            s.setGrade(grade);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } finally {
                        System.out.println();
                    }
                    break;
                case 10:
                    try {
                        System.out.print("Enter a student ID: ");
                        int studentId = Integer.parseInt(input.nextLine());

                        Student s = students.stream()
                                .filter(student -> student.getStudentId() == studentId)
                                .findFirst().get();
                        if (s == null) {
                            System.out.println("Student with this ID not found.");
                            continue;
                        }
                        students.remove(s);
                        System.out.println("Student deleted.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                    break;
                case 11:
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a valid menu option (1-11).");
                    System.out.println();
            }
        } while (!exit);

        System.out.println("Goodbye!");
        input.close();
    }
}
