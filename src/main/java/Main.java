import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args)
    {

        String filename = "src/main/resources/input.txt";
        System.out.println(runDay9Code(filename));

    }

    public static int runDay9Code(String filename)
    {
        int rollingSum = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String inputData = myReader.nextLine();
                DifferenceStack differenceStack = new DifferenceStack(inputData);
                rollingSum += differenceStack.getNewValue();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return rollingSum;
    }
}
