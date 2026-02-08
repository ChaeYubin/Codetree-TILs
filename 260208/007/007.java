import java.util.Scanner;

public class Main {
    public static class Secret {
        private String secretCode;
        private char meetingPoint;
        private int time;

        public Secret(String secretCode, char meetingPoint, int time) {
            this.secretCode = secretCode;
            this.meetingPoint = meetingPoint;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode = sc.next();
        char mPoint = sc.next().charAt(0);
        int time = sc.nextInt();

        Secret sec = new Secret(sCode, mPoint, time);

        System.out.println("secret code : " + sec.secretCode);
        System.out.println("meeting point : " + sec.meetingPoint);
        System.out.println("time : " + sec.time);
    }
}