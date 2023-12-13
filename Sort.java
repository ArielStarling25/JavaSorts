public class Sort {
    public static void main(String args[]){
        //testSmallDataSet();
        // testLargeDataSet();
        // testMassiveDataSet();
        testGiganticDataSet();
        //testDuplicatesDataSet();
        //testReverseOrder();
    }

    public static void testGiganticDataSet(){
        System.out.println("== Gigantic data set ==");
        System.out.println("");

        int size = 200000; //ArraySize
        int low = 10; //min value
        int high = 10000; //max value

        int[] bigBoiArray = new int[size];
        randomlyFillArray(bigBoiArray, low, high);
        int[] bigBoiArray2 = new int[size];
        int[] bigBoiArray3 = new int[size];
        int[] bigBoiArray4 = new int[size];
        int[] bigBoiArray5 = new int[size];
        Integer[] bigBoiArray6 = new Integer[size];
        int[] bigBoiArray7 = new int[size];

        for(int i = 0; i < size; i++){
            bigBoiArray2[i] = bigBoiArray[i];
            bigBoiArray3[i] = bigBoiArray[i];
            bigBoiArray4[i] = bigBoiArray[i];
            bigBoiArray5[i] = bigBoiArray[i];
            bigBoiArray6[i] = bigBoiArray[i];
            bigBoiArray7[i] = bigBoiArray[i];
        }

        System.out.println("Begin Sorting...");

        long timeStart = System.currentTimeMillis();
        bigBoiArray2 = OtherSorts.quickSort(bigBoiArray2, 0, bigBoiArray2.length-1);
        long timeStop = System.currentTimeMillis();
        long timeTaken = timeStop - timeStart;
        printArray(bigBoiArray2, timeTaken, "Quick Sort");

        timeStart = System.currentTimeMillis();
        bigBoiArray6 = PinBallSort.sort(bigBoiArray6, false);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray6, timeTaken, "Pinball Sort");

        timeStart = System.currentTimeMillis();
        bigBoiArray3 = OtherSorts.insertionSort(bigBoiArray3);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray3, timeTaken, "Insertion Sort");

        timeStart = System.currentTimeMillis();
        bigBoiArray4 = OtherSorts.insertionSort(bigBoiArray4);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray4, timeTaken, "Selection Sort");

        timeStart = System.currentTimeMillis();
        bigBoiArray5 = OtherSorts.mergeSort(bigBoiArray5, 0, bigBoiArray5.length-1);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray5, timeTaken, "Merge Sort");

        timeStart = System.currentTimeMillis();
        bigBoiArray7 = OtherSorts.bucketSort(bigBoiArray7);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray7, timeTaken, "Bucket Sort");

        System.out.println("");
    }
    
    public static void testSmallDataSet(){
        System.out.println("== Small data set ==");
        System.out.println("");

        int size = 20; //ArraySize
        int low = 10; //min value
        int high = 50; //max value

        int[] bigBoiArray = new int[size];
        randomlyFillArray(bigBoiArray, low, high);
        int[] bigBoiArray2 = new int[size];
        int[] bigBoiArray3 = new int[size];
        int[] bigBoiArray4 = new int[size];
        int[] bigBoiArray5 = new int[size];
        Integer[] bigBoiArray6 = new Integer[size];

        for(int i = 0; i < size; i++){
            bigBoiArray2[i] = bigBoiArray[i];
            bigBoiArray3[i] = bigBoiArray[i];
            bigBoiArray4[i] = bigBoiArray[i];
            bigBoiArray5[i] = bigBoiArray[i];
            bigBoiArray6[i] = bigBoiArray[i];
        }

        long timeStart = System.currentTimeMillis();
        bigBoiArray2 = OtherSorts.bubbleSort(bigBoiArray2);
        long timeStop = System.currentTimeMillis();
        long timeTaken = timeStop - timeStart;
        printArray(bigBoiArray2, timeTaken, "BubbleSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray6 = PinBallSort.sort(bigBoiArray6, false);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray6, timeTaken, "PinBallSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray3 = OtherSorts.insertionSort(bigBoiArray3);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray3, timeTaken, "InsertionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray4 = OtherSorts.insertionSort(bigBoiArray4);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray4, timeTaken, "SelectionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray5 = OtherSorts.mergeSort(bigBoiArray5, 0, bigBoiArray5.length-1);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray5, timeTaken, "MergeSort");

        System.out.println("");
    }

    public static void testLargeDataSet(){
        System.out.println("== Large data set ==");
        System.out.println("");

        int size = 20000; //ArraySize
        int low = 10; //min value
        int high = 5000; //max value

        int[] bigBoiArray = new int[size];
        randomlyFillArray(bigBoiArray, low, high);
        int[] bigBoiArray2 = new int[size];
        int[] bigBoiArray3 = new int[size];
        int[] bigBoiArray4 = new int[size];
        int[] bigBoiArray5 = new int[size];
        Integer[] bigBoiArray6 = new Integer[size];

        for(int i = 0; i < size; i++){
            bigBoiArray2[i] = bigBoiArray[i];
            bigBoiArray3[i] = bigBoiArray[i];
            bigBoiArray4[i] = bigBoiArray[i];
            bigBoiArray5[i] = bigBoiArray[i];
            bigBoiArray6[i] = bigBoiArray[i];
        }

        long timeStart = System.currentTimeMillis();
        bigBoiArray2 = OtherSorts.bubbleSort(bigBoiArray2);
        long timeStop = System.currentTimeMillis();
        long timeTaken = timeStop - timeStart;
        printArray(bigBoiArray2, timeTaken, "BubbleSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray6 = PinBallSort.sort(bigBoiArray6, false);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray6, timeTaken, "PinBallSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray3 = OtherSorts.insertionSort(bigBoiArray3);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray3, timeTaken, "InsertionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray4 = OtherSorts.insertionSort(bigBoiArray4);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray4, timeTaken, "SelectionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray5 = OtherSorts.mergeSort(bigBoiArray5, 0, bigBoiArray5.length-1);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray5, timeTaken, "MergeSort");

        System.out.println("");
    }

    public static void testMassiveDataSet(){
        System.out.println("== Massive data set ==");
        System.out.println("");

        int size = 100000; //ArraySize
        int low = 10; //min value
        int high = 10000; //max value

        int[] bigBoiArray = new int[size];
        randomlyFillArray(bigBoiArray, low, high);
        int[] bigBoiArray2 = new int[size];
        int[] bigBoiArray3 = new int[size];
        int[] bigBoiArray4 = new int[size];
        int[] bigBoiArray5 = new int[size];
        Integer[] bigBoiArray6 = new Integer[size];

        for(int i = 0; i < size; i++){
            bigBoiArray2[i] = bigBoiArray[i];
            bigBoiArray3[i] = bigBoiArray[i];
            bigBoiArray4[i] = bigBoiArray[i];
            bigBoiArray5[i] = bigBoiArray[i];
            bigBoiArray6[i] = bigBoiArray[i];
        }

        long timeStart = System.currentTimeMillis();
        bigBoiArray2 = OtherSorts.bubbleSort(bigBoiArray2);
        long timeStop = System.currentTimeMillis();
        long timeTaken = timeStop - timeStart;
        printArray(bigBoiArray2, timeTaken, "BubbleSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray6 = PinBallSort.sort(bigBoiArray6, false);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray6, timeTaken, "PinBallSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray3 = OtherSorts.insertionSort(bigBoiArray3);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray3, timeTaken, "InsertionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray4 = OtherSorts.insertionSort(bigBoiArray4);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray4, timeTaken, "SelectionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray5 = OtherSorts.mergeSort(bigBoiArray5, 0, bigBoiArray5.length-1);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray5, timeTaken, "MergeSort");

        System.out.println("");
    }

    public static void testDuplicatesDataSet(){
        System.out.println("== Duplicate values data set ==");
        System.out.println("");

        int size = 10000; //ArraySize
        int low = 10; //min value
        int high = 20; //max value

        int[] bigBoiArray = new int[size];
        randomlyFillArray(bigBoiArray, low, high);
        int[] bigBoiArray2 = new int[size];
        int[] bigBoiArray3 = new int[size];
        int[] bigBoiArray4 = new int[size];
        int[] bigBoiArray5 = new int[size];
        Integer[] bigBoiArray6 = new Integer[size];

        for(int i = 0; i < size; i++){
            bigBoiArray2[i] = bigBoiArray[i];
            bigBoiArray3[i] = bigBoiArray[i];
            bigBoiArray4[i] = bigBoiArray[i];
            bigBoiArray5[i] = bigBoiArray[i];
            bigBoiArray6[i] = bigBoiArray[i];
        }

        long timeStart = System.currentTimeMillis();
        bigBoiArray2 = OtherSorts.bubbleSort(bigBoiArray2);
        long timeStop = System.currentTimeMillis();
        long timeTaken = timeStop - timeStart;
        printArray(bigBoiArray2, timeTaken, "BubbleSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray6 = PinBallSort.sort(bigBoiArray6, false);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray6, timeTaken, "PinBallSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray3 = OtherSorts.insertionSort(bigBoiArray3);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray3, timeTaken, "InsertionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray4 = OtherSorts.insertionSort(bigBoiArray4);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray4, timeTaken, "SelectionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray5 = OtherSorts.mergeSort(bigBoiArray5, 0, bigBoiArray5.length-1);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray5, timeTaken, "MergeSort");

        System.out.println("");
    }

    public static void testReverseOrder(){
        System.out.println("== Reverse order data set ==");
        System.out.println("");

        int size = 50; //ArraySize
        int low = 10; //min value
        int high = 500; //max value

        int[] bigBoiArray = new int[size];
        randomlyFillArray(bigBoiArray, low, high);
        bigBoiArray = OtherSorts.mergeSort(bigBoiArray, 0, bigBoiArray.length-1);

        int[] bigBoiArray2 = new int[size];
        int[] bigBoiArray3 = new int[size];
        int[] bigBoiArray4 = new int[size];
        int[] bigBoiArray5 = new int[size];
        Integer[] bigBoiArray6 = new Integer[size];

        for(int i = 0; i < size; i++){
            bigBoiArray2[size-1-i] = bigBoiArray[i];
            bigBoiArray3[size-1-i] = bigBoiArray[i];
            bigBoiArray4[size-1-i] = bigBoiArray[i];
            bigBoiArray5[size-1-i] = bigBoiArray[i];
            bigBoiArray6[size-1-i] = bigBoiArray[i];
        }

        long timeStart = System.currentTimeMillis();
        bigBoiArray2 = OtherSorts.bubbleSort(bigBoiArray2);
        long timeStop = System.currentTimeMillis();
        long timeTaken = timeStop - timeStart;
        printArray(bigBoiArray2, timeTaken, "BubbleSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray6 = PinBallSort.sort(bigBoiArray6, false);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray6, timeTaken, "PinBallSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray3 = OtherSorts.insertionSort(bigBoiArray3);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray3, timeTaken, "InsertionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray4 = OtherSorts.insertionSort(bigBoiArray4);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray4, timeTaken, "SelectionSort");

        timeStart = System.currentTimeMillis();
        bigBoiArray5 = OtherSorts.mergeSort(bigBoiArray5, 0, bigBoiArray5.length-1);
        timeStop = System.currentTimeMillis();
        timeTaken = timeStop - timeStart;
        printArray(bigBoiArray5, timeTaken, "MergeSort");

        System.out.println("");
    }

    public static void pinBallSortTest(){
        //reverse order
        Integer[] array1 = {10,9,8,7,6,5,4,3,2,1};
        //small range difference
        Integer[] array2 = {6,7,5,4,8,3,9,10,1,2,12};
        //larger range difference of numbers
        Integer[] array3 = {1,6,4,9,23,45,12,24,76,5,25};
        //duplicates
        Integer[] array4 = {1,5,4,65,34,26,10,5,4};
        //large dataset
        Integer[] array5 = {45,23,12,65,76,45,34,76,1,2,6,9,23,74,5,9,4,7,45,26,20,12,23,7,8,10,14,16,29,30,40,1,1,34,54,76,99,34,23,99,100};

        printArray(PinBallSort.sort(array1, false));
        printArray(PinBallSort.sort(array2, false));
        printArray(PinBallSort.sort(array3, false));
        printArray(PinBallSort.sort(array4, false));
        printArray(PinBallSort.sort(array5, false));
    }

    public static int randomInt(int a, int b) {
        return (int) ((b - a + 1) * Math.random() + a);
    
    }

    public static void randomlyFillArray(int[] array, int a, int b) {
        for (int i = 0; i < array.length; i++) {
            array[i] = randomInt(a, b);
        }
    }

    public static void printArray(Integer[] arr, long timeTaken, String sortName){
        System.out.println("");
        System.out.println("== Final for " + sortName + " == : ");
        if(arr.length > 1000){
            System.out.println("--Too Chonky--");
        }
        else{
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + "|");
            }
        }
        System.out.println("");
        System.out.println("Time Taken: " + timeTaken);
    }

    public static void printArray(int[] arr, long timeTaken, String sortName){
        System.out.println("");
        System.out.println("== Final for " + sortName + " == : ");
        if(arr.length > 1000){
            System.out.println("--Too Chonky--");
        }
        else{
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + "|");
            }
        }
        System.out.println("");
        System.out.println("Time Taken: " + timeTaken);
    }

    public static void printArray(Integer[] arr){
        System.out.println("");
        System.out.println("== Final == : ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "|");
        }
        System.out.println("");
    }
}
