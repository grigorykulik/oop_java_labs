import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<File> fl=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        //request user input, break the loop if the user types quit
        while (true) {
            System.out.println("Enter your command");
            try {
                //read the command
                String command = br.readLine();

                if (command.equals("quit")) break;

                switch (command) {
                    //list files
                    case "ls":
                        System.out.println("Enter the path to the directory you want to explore");
                        String path=br.readLine();
                        //call the method to list all the files and directories
                        try {
                            listf(path);
                        }

                        //catch the exception that arises if there is no such file
                        catch (NullPointerException e) {
                            System.out.println("Directory not found");
                            }
                        finally {
                            break;
                        }

                    //create a file
                    case "touch":
                        try {
                            System.out.println("Enter the filename you want to create");
                            path = br.readLine();
                            createFile(path);
                        }

                        catch (IOException e) {
                            System.out.println("Could not create file");
                        }

                        finally {
                            break;
                        }
                    //remove a file
                    case "rm":
                        System.out.println("Enter the file name you want to delete");
                        path = br.readLine();
                        deleteFile(path);
                        break;

                    case "append":
                        try {
                            System.out.println("Enter the file name you want to append to. If the file does not exist, it will be created");
                            path = br.readLine();
                            appendToFile(path, true);
                        }

                        catch (IOException e) {
                            System.out.println("Could not write to a file");
                        }
                        break;

                    case "rewrite":
                        try {
                            System.out.println("Enter the file name you want to rewrite. If the file does not exist, it will be created");
                            path = br.readLine();
                            appendToFile(path, false);
                        }

                        catch (IOException e) {
                            System.out.println("Could not write to a file");
                        }

                        finally {
                            break;
                        }


                    default:
                        System.out.println("No such command");
                        break;
                }
            }

            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void listf(String path) {
        File directory = new File(path);
        List<File> resultList = new ArrayList<>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            System.out.println(file);
        }
    }

    public static void createFile(String path) throws IOException {
        File newFile=new File(path);
        if (newFile.createNewFile()) {
            System.out.println("File successfully created");
        }

        else {
            System.out.println("File already exists");
        }

    }

    public static void deleteFile(String path) {
        File file = new File(path);

        if(file.delete()) {
            System.out.println("File deleted successfully");
        }

        else {
            System.out.println("No such file");
        }
    }

    public static void appendToFile(String path, boolean apNeeded) throws IOException {
        FileWriter fr=new FileWriter(path, apNeeded);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a string to append to the file");
        try {
            String stringToAppend = br.readLine();
            fr.write(stringToAppend.toCharArray());
            fr.close();
        }

        catch (IOException e) {
            System.out.println("Could not read the line");
        }

    }



}

