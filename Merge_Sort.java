public class Merge_Sort {
    public static void main (String [] args)
    {
        int [] list = { 1,5,6,3,2,5,2};
        mergeSort(list);

        for(int i =0; i<list.length; i++)
            System.out.print(" " + list[i]);


    }

    public static void mergeSort( int[] list )
    {
        if(list.length > 1 )
        {
            int[] firsthalf = new int[list.length/2];
            System.arraycopy(list, 0, firsthalf, 0, (list.length)/2);
            mergeSort(firsthalf);

            ///////////////////////////////

            int[] secondhalf = new int[list.length  - (list.length/2)];
            System.arraycopy(list, (list.length/2), secondhalf, 0, list.length-(list.length/2));
            mergeSort(secondhalf);

            merge(firsthalf, secondhalf, list);

        }
    }

    public static void merge(int[] first, int[] second, int[] list)
    {
        int firstIndex =0;
        int secondIndex = 0;
        int listIndex = 0;

        //make sure indexes are within the array
        // prevent out of bound error
        while( firstIndex < first.length && secondIndex< second.length)
        {
            // element in first array is smaller than the one in second array
            // add it to list
            // move to next element in 'list'
            // move to next element in 'first array'
            if (first[firstIndex] < second[secondIndex])
            {
                list[listIndex] = first[firstIndex];
                listIndex++;
                firstIndex++;
            }

            //element in second array is smaller than the one in first array
            // add it to list
            // move to next element in 'list'
            // move to next element in 'second array'
            else {
                list[listIndex] = second[secondIndex];
                listIndex++;
                secondIndex++;
            }
        }
        // at the end of while loop, 'listIndex' will stop right in front of at least one empty array
        // there are at least one empty slot in 'list' because at least one element from first and/or second array

        //
        // this method adds remaining elements in first array to 'list'
        while(firstIndex < first.length)
        {
            list[listIndex] = first[firstIndex];
            listIndex++;
            firstIndex++;
        }

        // this method adds remaining elements in second array to 'list'
        while(secondIndex < second.length )
        {
            list[listIndex] = second[secondIndex];
            listIndex++;
            secondIndex++;
        }


    }

}
