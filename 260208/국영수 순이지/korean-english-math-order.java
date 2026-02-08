import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student student) {
            if (this.korean == student.korean) {
                if (this.english == student.english) {
                    return student.math - this.math;
                }

                return student.english - this.english;
            }

            return student.korean - this.korean;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name + " " + students[i].korean + " " + students[i].english + " " + students[i].math);
        }
    }
}