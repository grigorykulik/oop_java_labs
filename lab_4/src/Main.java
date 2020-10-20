import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws ImpossibleTriangularException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter coordinates for point A: ");
            String sX1 = br.readLine();
            Double dX1 = Double.parseDouble(sX1);
            String sY1 = br.readLine();
            Double dY1 = Double.parseDouble(sY1);
            Point pointA = new Point(dX1, dY1);

            System.out.println("Enter coordinates for point B: ");
            String sX2 = br.readLine();
            Double dX2 = Double.parseDouble(sX2);
            String sY2 = br.readLine();
            Double dY2 = Double.parseDouble(sY2);
            Point pointB = new Point(dX2, dY2);

            System.out.println("Enter coordinates for point C: ");
            String sX3 = br.readLine();
            Double dX3 = Double.parseDouble(sX3);
            String sY3 = br.readLine();
            Double dY3 = Double.parseDouble(sY3);
            Point pointC = new Point(dX3, dY3);

            try {
                Triangular t=new Triangular(pointA, pointB, pointC);

                System.out.println("Perimeter: "+t.getPerimeter());
                System.out.println("Area: "+t.getArea());
                System.out.println("Median intersection point is: X=" + t.getMIP().getX() + ", Y=" + t.getMIP().getY());


            }

            catch (ImpossibleTriangularException e)
            {
                System.out.println("This triangular is impossible.");
            }
        }

        catch (IOException e) {
            System.out.println("Could not read coordinates.");
        }

    }
}