
// == Pinball SortS==
// Date Completed: 12/12/2023
// By: Ariel Starling
// My own attempt at creating a sorting algorithm :))
// Current state: No problems as of now, the only reason it is quite sluggish, is due to its unoptimized nature (its a huge sorting program)
// Time complexity: 
// Best case: O(n + k) 
// - O(n + k) only when items have already been sorted, or when there are no duplicate values and they are evenly spaced out according to their array size like non-repeating numbers 1-10 in a size 10 array

// Average case: How to say that gradually becomes slower the more the sort progresses? O(n + k)? 
// - this is the most common case where the more the sort progresses, it will become slower due to more shuffling involved

// Worst case: O(n^3)
// - this case will only occur when there are many duplicate values and are in reverse order, this is because of a ridiculous amount of shuffling of values involved

public class PinBallSort {

    public static Integer[] sort(Integer[] arr, boolean visual){
        Integer[] result = new Integer[arr.length];

        int min = arr[0], max = arr[0];
        for(int i = 0; i < arr.length; i++){ 

            result[i] = null;

            if(max < arr[i]){
                max = arr[i];
            }

            if(min > arr[i]){
                min = arr[i];
            }
        }
        long beforeRange = (max - min);  
        long afterRange = arr.length-1;  
        long iterations = 0, shift = 0;

        for(int i = 0; i < arr.length; i++){
            boolean foundPlace = false;

            //Calculation formula 
            long value = ((((long)arr[i]-min)*afterRange)/beforeRange);
            //System.out.print("| Min: " + min + " | Max: " + max + " | BeforeRange: " + beforeRange + " | AfterRange: " + afterRange + " | ArrVal: "+ arr[i] + " | Value: " + value); //DEBUG
            int indexPlace = Math.round(value);
            //int indexPlace = (int)value;

            int forth = 0, back = 0;
            int direction = 1;
            while(!foundPlace){
                if(visual){
                    iterations++;
                }
                //System.out.println("Attemting to place: " + arr[i]); //DEBUG
                if(indexPlace >= arr.length){
                    //indexPlace = arr.length-1;
                    indexPlace--;
                }
                else if(indexPlace <= 0){
                    //indexPlace = 0;
                    indexPlace++;
                }

                if(result[indexPlace] == null){
                    if(indexPlace <= 0 || indexPlace >= (result.length-1)){ 
                        if(indexPlace <= 0){ // check on the right only
                            if(result[indexPlace + 1] != null){
                                if(result[indexPlace + 1] < arr[i]){ //if item on right is smaller than current value
                                    indexPlace++;
                                    forth++;
                                }
                                else{ //correct pos, place
                                    result[indexPlace] = arr[i];
                                    foundPlace = true;
                                    //System.out.println(" | PLACED"); //DEBUG
                                }
                            }
                            else{
                                result[indexPlace] = arr[i];
                                foundPlace = true;
                                //System.out.println(" | PLACED"); //DEBUG
                            }
                        }
                        else if(indexPlace >= (result.length-1)){ //check on the left only
                            if(result[indexPlace - 1] != null){
                                if(result[indexPlace - 1] > arr[i]){ //if item on left is larger than current value
                                    indexPlace--;
                                    back++;
                                }
                                else{ //correct pos, place
                                    result[indexPlace] = arr[i];
                                    foundPlace = true;
                                    //System.out.println(" | PLACED"); //DEBUG
                                }
                            }
                            else{
                                result[indexPlace] = arr[i];
                                foundPlace = true;
                                //System.out.println(" | PLACED"); //DEBUG
                            }
                        }
                    }
                    else{ // check both sides
                        if(result[indexPlace + 1] != null && result[indexPlace - 1] != null){
                            if(result[indexPlace - 1] <= arr[i] && result[indexPlace + 1] >= arr[i]){
                                result[indexPlace] = arr[i];
                                foundPlace = true;
                                //System.out.println("Placed: " + arr[i] + " at: " + indexPlace); //DEBUG
                                //System.out.println(" | PLACED"); //DEBUG
                            }
                            else{
                                if(result[indexPlace - 1] > arr[i]){
                                    direction = 1;
                                }
                                else if(result[indexPlace + 1] < arr[i]){
                                    direction = -1;
                                }

                                if(result[indexPlace + 1] > arr[i] && result[indexPlace - 1] > arr[i]){
                                    direction = -1;
                                }
                                else if(result[indexPlace + 1] < arr[i] && result[indexPlace - 1] < arr[i]){
                                    direction = 1;
                                }

                                if(indexPlace <= 0 || indexPlace >= (result.length-1)){
                                    //System.out.println("Attempting shifting for escaping from index: " + indexPlace); //DEBUG
                                    int check = checkEmpty(result, indexPlace);
                                    if(visual){
                                        shift++;
                                    }
                                    result = shifter(result, indexPlace, check);
                                    back = 0;
                                    forth = 0;
                                }
                                else{
                                    //System.out.println("Attempt escape from index: " + indexPlace); //DEBUG
                                    indexPlace = indexPlace + direction;
                                    if(direction > 0){
                                        forth++;
                                    }
                                    else{
                                        back++;
                                    }
                                }
                            }
                        }
                        else{
                            result[indexPlace] = arr[i];
                            foundPlace = true;
                            //System.out.println("| Placed: " + arr[i] + " at: " + indexPlace); //DEBUG
                            //System.out.println(" | PLACED"); //DEBUG
                        }
                    }
                }
                else{
                    int seeItem = result[indexPlace];
                    if(seeItem < arr[i]){ //look right
                        if(indexPlace != (arr.length-1)){
                            indexPlace++;   
                        } 
                        forth++;

                        if((indexPlace + 1) >= (arr.length-1)){ //check if ahead is blocked by array border
                            back++;
                        }
                    }   
                    else if(seeItem > arr[i]){ //look left
                        if(indexPlace != 0){
                            indexPlace--;   
                        }
                        back++;

                        if((indexPlace - 1) <= 0){ //check if behind is blocked by array border
                            forth++;
                        }
                    }
                    else if(seeItem == arr[i]){ //anywhere around
                        if(indexPlace >= arr.length-1){
                            direction = -1; 
                        }
                        else if(indexPlace <= 0){
                            direction = 1;
                        }

                        indexPlace = indexPlace + direction;

                        if(direction == -1){
                            back++;
                        }
                        else if(direction == 1){
                            forth++;
                        }
                    }

                    if(back >= 1 && forth >= 1){ //shift if got space
                        int check = checkEmpty(result, indexPlace);
                        if(visual){
                            shift++;
                        }
                        result = shifter(result, indexPlace, check);
                        back = 0;
                        forth = 0;
                    }
                }
                //printArr(result); //DEBUG
            }
            //printArr(result); //DEBUG
        }   

        if(visual){
            System.out.println(" ======= Results =======");
            System.out.println(" | Total Iterations: " + iterations); 
            System.out.println(" | Total Shifting: " + shift); 
            long resultant = iterations / (long)arr.length;
            System.out.println(" | Result of " + iterations + "/" + arr.length + " = "+ resultant);
            System.out.println(" | Time complexity: O(" + resultant + "n) for a array length of " + arr.length);
        }
        return result;
    }

    private static Integer[] shifter(Integer[] arr, int fromWhere, int whereEmpty){
        int index = fromWhere + whereEmpty;
        // System.out.println("Before"); //DEBUG
        // printArr(arr); //DEBUG
        if(whereEmpty > 0){ //to the right
            for(int i = 0; i < whereEmpty; i++){
                if(index >= 0){
                    arr[index] = arr[index - 1];
                    arr[index - 1] = null;
                    index--;
                }
            }
            // System.out.println("After Shift Right"); //DEBUG
            // printArr(arr); //DEBUG
        }
        else if(whereEmpty < 0){ //to the left
            for(int i = 0; i < (whereEmpty*-1); i++){
                if(index <= arr.length-1){
                    arr[index] = arr[index + 1];
                    arr[index + 1] = null;
                    index++;
                }
            }
            // System.out.println("After Shift left"); //DEBUG
            // printArr(arr); //DEBUG
        }
        return arr;
    }

    private static int checkEmpty(Integer[] arr, int fromWhere){
        //System.out.println("Checking nulls"); //DEBUG
        int leftLooker = fromWhere - 1, rightLooker = fromWhere + 1;
        boolean leftFailure = false, rightFailure = false;
        int found = 0;
        int leftCount = -1, rightCount = 1;
        while(found == 0){
            if(!leftFailure){
                if(leftLooker >= 0){
                    if(arr[leftLooker] != null){
                        leftLooker--;
                        leftCount--;
                        //System.out.println("leftLooker index: " + leftLooker); //DEBUG
                    }
                    else{
                        //System.out.println("Found on left"); //DEBUG
                        found = leftCount;
                        break;
                    }
                }
                else{
                    //System.out.println("Left Array border: " + leftLooker); //DEBUG
                    leftFailure = true;
                }
            }

            if(!rightFailure){
                if(rightLooker <= (arr.length-1)){
                    if(arr[rightLooker] != null){
                        rightLooker++;
                        rightCount++;
                        //System.out.println("rightLooker index: " + rightLooker); //DEBUG
                    }
                    else{
                        //System.out.println("Found on right"); //DEBUG
                        found = rightCount;
                        break;
                    }
                }
                else{
                    //System.out.println("Right Array border: " + rightLooker); //DEBUG
                    rightFailure = true;
                }
            }

            if(rightFailure && leftFailure){
                System.out.print("FAILED TO FIND NULL | fromWhereValue: " + fromWhere + " "); //DEBUG
                //printArr(arr);
            }
        }
        //System.out.println("Found: " + found + " From: " + fromWhere); //DEBUG
        return found;
    }

    public static void printArr(Integer[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null){
                System.out.print("N|");
            }
            else{
                System.out.print(arr[i] + "|");
            }
        }
        System.out.println("");
    }

    public static void visualRepArr(Integer[] arr){
        System.out.println();
        System.out.println("=======================================");
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null){
                System.out.println("|N");
            }
            else{
                System.out.print("|");
                for(int j = 0; j < arr[i]; j++){
                    System.out.print("#");
                }
                System.out.println("");
            }
        }
        System.out.println("========================================");
    }
}
