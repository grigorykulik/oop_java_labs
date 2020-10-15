import java.util.Arrays;
import java.util.Random;

public class Main {
    static int randomIndexToSwap;

    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Original array");
        System.out.println(Arrays.toString(array));

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            do {
                randomIndexToSwap = rand.nextInt(array.length);
            }
            while (randomIndexToSwap==i);

                int temp = array[randomIndexToSwap];
                array[randomIndexToSwap] = array[i];
                array[i] = temp;

        }
        System.out.println("Shuffled array");
        System.out.println(Arrays.toString(array));
    }

}
