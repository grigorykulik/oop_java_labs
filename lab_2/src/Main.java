import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Matrix mx=new Matrix("/home/greg/input.txt");

        MatrixModifier mm=new MatrixModifier(mx);

        System.out.println("Original matrix");
        for (int i=0; i<mm.getM().rows; i++) {
            for (int j=0; j<mm.getM().columns; j++) {
                System.out.printf("%5d", mm.getM().mtrx[i][j].getValue());
            }
            System.out.println();
        }

        mm.getMiniMax();


    }
}
