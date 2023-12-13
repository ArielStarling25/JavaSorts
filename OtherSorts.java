public class OtherSorts {
    public static int[] SelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    // ... Exchange elements
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int i, j, temp;
        for (i = 1; i < array.length; i++) {
            temp = array[i];
            j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        boolean swapped = true;
        int j = 0;
        int temp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return array;
    }

    public static int[] merge(int arr[], int left, int middle, int right)
    {
        int low = middle - left + 1;                    //size of the left subarray
        int high = right - middle;                      //size of the right subarray
 
        int L[] = new int[low];                             //create the left and right subarray
        int R[] = new int[high];

        int i = 0, j = 0;
 
        for (i = 0; i < low; i++)                               //copy elements into left subarray
        {
            L[i] = arr[left + i];
        }
        for (j = 0; j < high; j++)                              //copy elements into right subarray
        {
            R[j] = arr[middle + 1 + j];
        }
        
        int k = left;                                           //get starting index for sort
        i = 0;                                             //reset loop variables before performing merge
        j = 0;

        while (i < low && j < high)                     //merge the left and right subarrays
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            }
            else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < low)                             //merge the remaining elements from the left subarray
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < high)                           //merge the remaining elements from right subarray
        {
            arr[k] = R[j];
            j++;
            k++;
        }

        return arr;
    }
 
    public static int[] mergeSort(int arr[], int left, int right)       //helper function that creates the sub cases for sorting
    {
        int middle;
        if (left < right) {                             //sort only if the left index is lesser than the right index (meaning that sorting is done)
            middle = (left + right) / 2;
 
            mergeSort(arr, left, middle);                    //left subarray
            mergeSort(arr, middle + 1, right);               //right subarray
 
            merge(arr, left, middle, right);                //merge the two subarrays
        }
        return arr;
    }

    public static int getMax(int a[]) // function to get maximum element from the given array 
    {  
        int n = a.length;  
        int max = a[0];  
        for (int i = 1; i < n; i++)  
            if (a[i] > max)  
                max = a[i];  
        return max;  
    }  

    public static int[] bucketSort(int a[]) // function to implement bucket sort  
    {  
        int n = a.length;  
        int max = getMax(a); //max is the maximum element of array  
        int bucket[] = new int[max+1];   
        for (int i = 0; i <= max; i++)  
        {  
            bucket[i] = 0;  
        }  
        for (int i = 0; i < n; i++)  
        {  
            bucket[a[i]]++;  
            
        }  
        for (int i = 0, j = 0; i <= max; i++)  
        {  
            while (bucket[i] > 0)  
            {  
                a[j++] = i;  
                bucket[i]--;  
            }  
        }  
        return a;
    }  

    public static int partition (int a[], int start, int end)  
    {  
        int pivot = a[end]; // pivot element  
        int i = (start - 1);  
    
        for (int j = start; j <= end - 1; j++)  
        {  
            // If current element is smaller than the pivot  
            if (a[j] < pivot)  
            {  
                i++; // increment index of smaller element  
                int t = a[i];  
                a[i] = a[j];  
                a[j] = t;  
            }  
        }  
        int t = a[i+1];  
        a[i+1] = a[end];  
        a[end] = t;  
        return (i + 1);  
    }  
    
    /* function to implement quick sort */  
    public static int[] quickSort(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */  
    {  
        if (start < end)  
        {  
            int p = partition(a, start, end);  //p is partitioning index  
            quickSort(a, start, p - 1);  
            quickSort(a, p + 1, end);  
        }  
        return a;
    }  
}
