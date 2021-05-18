import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    public void triangle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the x1 coordinates of point A:");
        int x1 = Integer.parseInt(reader.readLine());
        System.out.print("Enter the y1 coordinates of point A:");
        int y1 = Integer.parseInt(reader.readLine());

        System.out.print("Enter the x2 coordinates of point B:");
        int x2 = Integer.parseInt(reader.readLine());
        System.out.print("Enter the y2 coordinates of point B:");
        int y2 = Integer.parseInt(reader.readLine());

        System.out.print("Enter the x3 coordinates of point C:");
        int x3 = Integer.parseInt(reader.readLine());
        System.out.print("Enter the y3 coordinates of point C:");
        int y3 = Integer.parseInt(reader.readLine());

        double a = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double b = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
        double c = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        if ((a + b > c) || (a + b > b) || (b + c > a)) {
            double p = (a + b + c) / 2.0;
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Square of a triangle: " + s); }
        else {
            System.out.println("Triangle does not exist!");
        }
    }
}
