import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SortCompare SortCompare = new SortCompare();

        Scanner selectFile = new Scanner(System.in); //scanner for file to read
        System.out.print("Enter file to read\n[1]random100.txt\n[2]random25000\n[3]random50000" + 
        "\n[4]random75000\n[5]random100000\n[6]totallyreversed\n[7]almostsorted"); //prompt
        System.out.print("\nEnter choice from 1 - 7: ");
        int fileChosen = selectFile.nextInt(); //scanner for file (will put choices here)
        
        int setSize = 0;
        String fileName = "";
        switch(fileChosen){
            case 1:
                fileName = "random100.txt";
                setSize = 100;
                SortCompare.chooseSort(setSize, fileName);
                break;
            case 2:
                fileName = "random25000.txt";
                setSize = 25000;
                SortCompare.chooseSort(setSize, fileName);
                break;
            case 3:
                fileName = "random50000.txt";
                setSize = 50000;
                SortCompare.chooseSort(setSize, fileName);
                break;
            case 4:
                fileName = "random75000.txt";
                setSize = 75000;
                SortCompare.chooseSort(setSize, fileName);
                break;
            case 5:
                fileName = "random100000.txt";
                setSize = 100000;
                SortCompare.chooseSort(setSize, fileName);
                break;
            case 6:
                fileName = "totallyreversed.txt";
                setSize = 100000;
                SortCompare.chooseSort(setSize, fileName);
                break;
            case 7:
                fileName = "almostsorted.txt";
                setSize = 100000;
                SortCompare.chooseSort(setSize, fileName);
                break;
        }
        selectFile.close();
        System.out.println("Program Terminated Successfully");
    }

}
