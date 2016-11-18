import java.util.Arrays;

/**
 * Created by ulysses on 10/18/16.
 *
 *This is an implentation of Merge Sort that recursively sorts the both halves 
 *of the array without splitting the arrays into two temporary arrays.
 *The program uses indices to sort the array into a temporary array that is then copied
 *over the original array.
 * 
 **/
public class Merge_Sort {
    public static void main(String[] args) {
        int list[] = {10, 9, 2, 1, 6, 8, 12, 18};
        System.out.println(Arrays.toString(list));
        MergeSort(list);
        System.out.println(Arrays.toString(list));
    }
    private static void MergeSort(int[] list){
        int beginning_index = 0;
        int end_index = list.length - 1;
        MergeSortHelper(list, beginning_index, end_index);
        }

    private static void MergeSortHelper(int[] list, int beginning, int end){
        int array_length = end - beginning + 1;
        if (array_length <= 1 || list.length <= 1) return;
        else{
            //Index the first half of the list:
            int first_half_length = (int)Math.floor((beginning + end) / 2);
            MergeSortHelper(list, beginning, first_half_length);

            //Index the second half of the list:
            MergeSortHelper(list, first_half_length + 1, end);

            //Sort both halves of the list:
            SortList(list, array_length, beginning, end);
        }
    }

    private static void SortList(int[] list, int array_length, int beginning, int end) {
        int first_index_counter = beginning;
     
        int second_index = (int)Math.floor((beginning + end) / 2) + 1;

        int second_index_counter = second_index;

        int[] temp = new int[array_length];
        int temp_index = 0;

     
        while (first_index_counter < second_index && second_index_counter <= end){
            if (list[first_index_counter] <= list[second_index_counter])
                temp[temp_index++] = list[first_index_counter++];
            else temp[temp_index++] = list[second_index_counter++];
        }
	    
	//Adds the contents of either half that did not break the above while loop into the temporary array.
        while (first_index_counter < second_index && second_index_counter > end)
            temp[temp_index++] = list[first_index_counter++];

        while (second_index_counter <= end && first_index_counter == second_index)
            temp[temp_index++] = list[second_index_counter++];

        //Copy temporary array into the original list.
        System.arraycopy(temp, 0, list, beginning, array_length);
    }
}
