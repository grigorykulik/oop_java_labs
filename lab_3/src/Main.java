import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s="Searches the specified array of bytes";

        List<String> splitString=splitTo3Characters(s);
        System.out.println(splitString);

        List<String> modifiedString=replaceMiddleCharacter(splitString);
        System.out.println(modifiedString);

        Collections.sort(modifiedString);
        System.out.println(modifiedString);
    }

    private static List<String> splitTo3Characters (String s) {
        List<String> parts=new ArrayList<>();

        int length=s.length();

        for (int i=0; i<length; i+=3) {
            parts.add(s.substring(i, Math.min(length, i+3)));
        }

        return parts;
    }

    private static List<String> replaceMiddleCharacter (List<String> s) {
        int newCharCode;
        Random r=new Random();
        int max=127;
        int min=26;


        for (int i=0; i<s.size(); i++) {
            if (s.get(i).length()==3) {
                char oldChar = s.get(i).charAt(1);

                do {
                    newCharCode = r.nextInt(max - min) + min;
                }
                while (newCharCode==(int)oldChar);

                char newChar = (char) newCharCode;
                String newPart = s.get(i).replace(oldChar, newChar);
                s.set(i, newPart);
            }
        }

        return s;
    }
}
