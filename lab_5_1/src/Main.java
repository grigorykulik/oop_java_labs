import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<Stack> arr=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        /**read user input, call reverseInteger method, receive a stack of characters, add them
         * to the arraylist of stacks
        */

        do {
            try {
                String input=br.readLine();
                if (input.equals("stop")) break;
                int nextInteger=Integer.parseInt(input);
                arr.add(reverseInteger(nextInteger));
            }

            catch (IOException | NumberFormatException e) {
                System.out.println("An error occured " +e.getMessage());
            }
        }

        while (true);

        for (int i=0; i<arr.size(); i++) {
            while (!arr.get(i).isEmpty()) {
                System.out.print(arr.get(i).pop());
            }
            System.out.println();
        }

    }

    //convert an int to a stack of characters
    public static Stack<Character> reverseInteger (int x) {
        Stack<Character> stack = new Stack<>();
            String sN=Integer.toString(x);
            char[] cN=sN.toCharArray();

            for (int i = 0; i < cN.length; i++) {
                    stack.push(cN[i]);
                }

            return stack;
    }
}