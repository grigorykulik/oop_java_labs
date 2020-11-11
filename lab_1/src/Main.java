import java.util.Arrays;
import java.util.Random;

public class Main {
    static int randomIndexToSwap;
    static final int[] originalArray = { 1, 2, 3, 4, 5, 6, 7 };
    static int[] shuffledArray = Arrays.copyOf(originalArray, originalArray.length);


    public static void main(String[] args) {

        //print the original array
        System.out.println("Original array");
        System.out.println(Arrays.toString(originalArray));

        //shuffle until there is no element in the shuffled array whose position is the same as in the original array
        while (isSameAsOriginal()) {
            shuffle();
        }

        //print the shuffled array
        System.out.println("Shuffled array");
        System.out.println(Arrays.toString(shuffledArray));
    }

    //compare elements in the shuffled array with those in the original element
    //break the loop if there is at least one element whose position has not changed
    public static boolean isSameAsOriginal() {
        boolean isSame=false;

        for (int i=0; i<originalArray.length; i++) {
            if (originalArray[i]==shuffledArray[i]) {
                isSame=true;
                break;
            }
        }

        return isSame;
    }

    //shuffle the mutable array
    public static void shuffle() {
        Random rand = new Random();

        for (int i = 0; i < shuffledArray.length; i++) {
            do {
                randomIndexToSwap = rand.nextInt(shuffledArray.length);
            }
            while (randomIndexToSwap==i);

            int temp = shuffledArray[randomIndexToSwap];
            shuffledArray[randomIndexToSwap] = shuffledArray[i];
            shuffledArray[i] = temp;
        }
    }

}
