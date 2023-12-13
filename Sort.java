public class Sort {
    public static void main(String args[]){

        int size = 50;
        int[] bigBoiArray = new int[size];
        randomlyFillArray(bigBoiArray, 10, 500);
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
        bigBoiArray6 = PinBallSort.sort(bigBoiArray6);
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

        //pinBallSortTest();
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

        printArray(PinBallSort.sort(array1));
        printArray(PinBallSort.sort(array2));
        printArray(PinBallSort.sort(array3));
        printArray(PinBallSort.sort(array4));
        printArray(PinBallSort.sort(array5));
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