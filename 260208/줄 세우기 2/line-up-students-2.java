import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static class Student implements Comparable<Student> {
        private int height;
        private int weight;
        private int number;

        public Student(int height, int weight, int number) {
            this.height = height;
            this.weight = weight;
            this.number = number;
        }

        @Override
        public int compareTo(Student s) {
            if (this.height == s.height) {
                return s.weight - this.weight;
            }

            return this.height - s.height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student(sc.nextInt(), sc.nextInt(), i + 1);
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].number);
        }
    }
}