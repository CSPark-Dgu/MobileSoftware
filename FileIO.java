import java.io.*;

public class FileIO {
    public static void main(String[] args) {
        try {
            FileInputStream firstInput = new FileInputStream("first.txt");
            FileInputStream secondInput = new FileInputStream("second.txt");
            FileOutputStream output = new FileOutputStream("third.txt");

            byte[] firstBytes = new byte[firstInput.available()];
            byte[] secondBytes = new byte[secondInput.available()];

            firstInput.read(firstBytes);
            secondInput.read(secondBytes);

            String firstContent = new String(firstBytes);
            String secondContent = new String(secondBytes);

            String[] firstNumbers = firstContent.split(" ");
            String[] secondNumbers = secondContent.split(" ");

            for (String num1 : firstNumbers) {
                for (String num2 : secondNumbers) {
                    if (num1.equals(num2)) {
                        output.write((num1 + " ").getBytes());
                        break;
                    }
                }
            }
            firstInput.close();
            secondInput.close();
            output.close();
            FileInputStream finalInput = new FileInputStream("third.txt");
            byte[] finalBytes = new byte[finalInput.available()];
            finalInput.read(finalBytes);
            String finalContent = new String(finalBytes);
            String[] finalNumbers  = finalContent.split(" ");
            for(String num : finalNumbers){
                System.out.println(num);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
                System.out.println("Successfully created text file!");
            }
        }
    }

