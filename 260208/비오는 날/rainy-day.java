import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static class WeatherForecast {
        String date;
        String day;
        String weather;

        public WeatherForecast(String date, String day, String weather) {
            this.date = date;
            this.day = day;
            this.weather = weather;
        }

        @Override
        public String toString() {
            return this.date + " " + this.day + " " + this.weather;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<WeatherForecast> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();

            if (weather.equals("Rain")) {
                list.add(new WeatherForecast(date, day, weather));
            }
        }

        Collections.sort(list, (o1, o2) -> o1.date.compareTo(o2.date));

        System.out.println(list.get(0));
    }
}