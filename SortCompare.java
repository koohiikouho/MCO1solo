import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class SortCompare {
    SortingAlgorithms SortingAlgorithms = new SortingAlgorithms();
    FileReader FileReader = new FileReader();
    Scanner select = new Scanner(System.in);
    

    public void chooseSort(int setSize, String fileName){
        
        System.out.println("Reading " + fileName + "...\n");

        System.out.println("Select sorting algorithm:\n[1]Selection Sort\n[2]Insertion Sort\n[3]Merge Sort\n[4]Shell's Sort");
        System.out.print("Select a number from 1 - 4: ");
        int sortAlgo = select.nextInt();
        Record[] writeArr  = new Record[setSize];
        switch(sortAlgo){
            case 1:
                writeArr = selectionSort(setSize, fileName);
                break;
            case 2:
                writeArr = insertionSort(setSize, fileName);
                break;
            case 3:
                writeArr = mergeSort(setSize, fileName);
                break;
            case 4:
                writeArr = shellsSort(setSize, fileName);
                break;
        }

        System.out.println("Would you like visually confirm the array is sorted?\n[1]Yes\n[2]No");
        int printyn = select.nextInt();

        if(printyn == 1){
        try{

        
        FileWriter arrWrite = new FileWriter("arrOut.txt");
            for(int i = 0; i < setSize; ++i){
                String toFile = writeArr[i].getIdNumber() + "\t" + writeArr[i].getName();
                arrWrite.write(toFile + "\n");
            }
        arrWrite.close();

        }catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }

    }


    private Record[] selectionSort(int setSize,String fileName){
        Record[] returnArr = new Record[setSize];

        for( int i = 0; i < 30; ++i){
            //grabs it from file specified
           Record result[] = FileReader.readFile("/home/kohiko/Documents/Projects/Github/MCO1-Java/starter_code_java/data/" + fileName);
           //this ^^ is in here to reset the array for every iteration
           long startTime = System.currentTimeMillis(); //start timer
           SortingAlgorithms.selectionSort(result, setSize);
           long endTime = System.currentTimeMillis(); //end timer
           long executionTime = endTime - startTime; //compute time
           System.out.println(executionTime + " ms"); //display time
           returnArr = result;
           }
        return returnArr;
    }

    private Record[] insertionSort(int setSize,String fileName){
        Record[] returnArr = new Record[setSize];

        for( int i = 0; i < 30; ++i){
            //grabs it from file specified
           Record result[] = FileReader.readFile("/home/kohiko/Documents/Projects/Github/MCO1-Java/starter_code_java/data/" + fileName);
           //this ^^ is in here to reset the array for every iteration
           long startTime = System.currentTimeMillis(); //start timer
           SortingAlgorithms.insertionSort(result, setSize);
           long endTime = System.currentTimeMillis(); //end timer
           long executionTime = endTime - startTime; //compute time
           System.out.println(executionTime + " ms"); //display time
           returnArr = result;
           }
        return returnArr;
    }

    private Record[] mergeSort(int setSize,String fileName){
        Record[] returnArr = new Record[setSize];

        for( int i = 0; i < 30; ++i){
            //grabs it from file specified
           Record result[] = FileReader.readFile("/home/kohiko/Documents/Projects/Github/MCO1-Java/starter_code_java/data/" + fileName);
           //this ^^ is in here to reset the array for every iteration
           long startTime = System.currentTimeMillis(); //start timer
           SortingAlgorithms.mergeSort(result, 0, setSize);
           long endTime = System.currentTimeMillis(); //end timer
           long executionTime = endTime - startTime; //compute time
           System.out.println(executionTime + " ms"); //display time
           returnArr = result;
           }
        return returnArr;
    }

    private Record[] shellsSort(int setSize,String fileName){
        Record[] returnArr = new Record[setSize];
        for( int i = 0; i < 30; ++i){
            //grabs it from file specified
           Record result[] = FileReader.readFile("/home/kohiko/Documents/Projects/Github/MCO1-Java/starter_code_java/data/" + fileName);
           //this ^^ is in here to reset the array for every iteration
           long startTime = System.currentTimeMillis(); //start timer
           SortingAlgorithms.shellsSort(result, setSize);
           long endTime = System.currentTimeMillis(); //end timer
           long executionTime = endTime - startTime; //compute time
           System.out.println(executionTime + " ms"); //display time
           returnArr = result;
           }
        return returnArr;
    }
    
}
