import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //entering integers, method 1
        ArrayList<Integer> array1=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter integers. When finished, type \"Quit\"");

        while (true) {
            try {
                String sInput = br.readLine();
                if (sInput.equals("quit")) {
                    break;
                }
                try {
                    Integer iInput = Integer.parseInt(sInput);
                    array1.add(iInput);
                }

                catch (NumberFormatException e) {
                    System.out.println("I said integers you dumbass");
                }
            }

            catch (IOException e) {
                System.out.println("Error reading input");
            }
        }

        //get the average value
        Double average=getAverage(array1);
        System.out.println("Average value:" + average);


        //entering string, method 2
        ArrayList<String> array2=new ArrayList<>();
        System.out.println("Enter strings. When finished, type \"quit\"");

        while (true) {
            try {
                String sInput = br.readLine();
                if (sInput.equals("quit")) {
                    break;
                }
                    array2.add(sInput);
            }

            catch (IOException e) {
                System.out.println("Error reading input");
            }
        }

        toUpperCase(array2);


        //entering integers, method 3
        ArrayList<Integer> array3=new ArrayList<>();
        System.out.println("Enter integers. When finished, type \"Quit\"");

        while (true) {
            try {
                String sInput = br.readLine();
                if (sInput.equals("quit")) {
                    break;
                }
                try {
                    Integer iInput = Integer.parseInt(sInput);
                    array3.add(iInput);
                }

                catch (NumberFormatException e) {
                    System.out.println("I said integers you dumbass");
                }
            }

            catch (IOException e) {
                System.out.println("Error reading input");
            }
        }

        getUniqueSquare(array3)
                .stream()
                .forEach(s-> System.out.println(s));
    }


    public static Double getAverage(ArrayList<Integer> arr) {
        return
                arr
                   .stream()
                   .mapToDouble(Integer::doubleValue)
                   .average()
                   .getAsDouble();
    }


    public static void toUpperCase(ArrayList<String> arr) {
        arr
            .stream()
            .map(s->s.toUpperCase())
            .forEach(s-> System.out.println(s));
    }


    public static ArrayList<Integer> getUniqueSquare (ArrayList<Integer> arr) {
        return arr
                .stream()
                .distinct()
                .map(integer -> Integer.valueOf(integer*integer))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
