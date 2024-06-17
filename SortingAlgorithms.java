/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

    public void insertionSort(Record[] arr, int n) {
        // DONE
        int i, j;
        Record key;
        for(i = 1; i < n; ++i){
            key = arr[i];
            j = i - 1;
            while(j >= 0 && arr[j].getIdNumber() > key.getIdNumber()){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void selectionSort(Record[] arr, int n) {
        // DONE
      // mainly just implemented how we did insertion sort back in C
      int i, j, min; //var declarations
      Record tempRecord; //instantiate temporary record object

      for(i = 0; i < n; i++){ //first for loop
          min = i; //second for loop

          for(j = i + 1; j < n; ++j)
              if( arr[min].getIdNumber() > arr[j].getIdNumber() ) //comparison i.e if the supposed minimum is larger than j
                  min = j; //get their array index
          
          if( i != min ){ //then swap it here if I and min are not the same (runtime reasons)
              tempRecord = arr[i]; 
              arr[i] = arr[min];
              arr[min] = tempRecord;
          }
      }
    }

    public void mergeSort(Record[] arr, int p, int r) {
        // DONE
            mergeSortRecursion(arr, p, r - 1); //only need to call this method to sort the array
    }
    
    private void mergeSortRecursion(Record[] arr, int left, int right){
        if (left < right){ //stops until right becomes 0, right is the one that is decremented
            int middle = left + (right - left) / 2;
            mergeSortRecursion(arr, left, middle); //left division
            mergeSortRecursion(arr, middle + 1, right); //right divsion
            mergeSortSortArray(arr, left, middle, right); //does the sorting
        }
    }

    private void mergeSortSortArray(Record[] arr, int left, int middle, int right){
        int lenLeftArr = middle - left + 1;
        int lenRightArr = right - middle;
        Record[] tempLeftArr = new Record[lenLeftArr];
        Record[] tempRightArr = new Record[lenRightArr];

        for(int i = 0; i < lenLeftArr; ++i)
            tempLeftArr[i] = arr[left + i]; //copies what's the left of the array into a temporary one until the middle part
        for(int i = 0; i < lenRightArr; ++i)
            tempRightArr[i] = arr[middle + 1 + i]; //copies the middle part of the array until the right one into a temporary array

        for(int i = 0, j = 0, k = left; k <= right; ++k){
            
            if( (i < lenLeftArr) && //if left array counter is less than the length of the length of the left array
                (j >= lenRightArr || tempLeftArr[i].getIdNumber() <= tempRightArr[j].getIdNumber())  //j is more than the length of the right array
            ){                      //or arr[j]'s id number is more than i's id number
                arr[k] = tempLeftArr[i]; //store the contents of a sorted temporary array into k
                i++; //increment left array counter
            }
            else{
                arr[k] = tempRightArr[j]; //store the contents of a sorted temporary array into k
                j++; //increment right array counter
            } 
        }
    }

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */
    public void shellsSort(Record[] arr, int arrLen){
        
        for(int gap = arrLen/2; gap > 0; gap /= 2){ //gap is the gap between two comparisons, every iteration it gets smaller
            for(int i = gap; i < arrLen; ++i){

                Record tempArr = arr[i];
                int j;
                for(j = i; j >= gap && arr[j - gap].getIdNumber() > tempArr.getIdNumber(); j-= gap)
                    arr[j] = arr[j - gap];
                arr[j] = tempArr;
            }
        }
    }
}