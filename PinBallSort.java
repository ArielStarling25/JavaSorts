
// == TrickleSort ==
// Date Completed: 12/12/2023
// By: Ariel Starling
// My own attempt at creating a sorting algorithm :))
// Current state: Its really good at making partially sorted arrays :)))

public class PinBallSort {

    public static Integer[] sort(Integer[] arr){
        Integer[] result = new Integer[arr.length];
        //int[] returnArr = new int[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = null;
        }

        int min = arr[0], max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }

            if(min > arr[i]){
                min = arr[i];
            }
        }

        for(int i = 0; i < arr.length; i++){
            boolean foundPlace = false;

            int beforeRange = (max - min);  
            int afterRange = arr.length-1;  
            float value = (((arr[i] - min) * afterRange) / beforeRange) + 0;
            int indexPlace = Math.round(value);

            int forth = 0, back = 0;
            int direction = 1;
            while(!foundPlace){
                System.out.println("Attemting to place: " + arr[i]);
                if(indexPlace >= arr.length){
                    indexPlace--;
                }
                else if(indexPlace <= 0){
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
                                }
                            }
                            else{
                                result[indexPlace] = arr[i];
                                foundPlace = true;
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
                                }
                            }
                            else{
                                result[indexPlace] = arr[i];
                                foundPlace = true;
                            }
                        }
                    }
                    else{ // check both sides
                        if(result[indexPlace + 1] != null && result[indexPlace - 1] != null){
                            if(result[indexPlace - 1] < arr[i] && result[indexPlace + 1] > arr[i]){
                                result[indexPlace] = arr[i];
                                foundPlace = true;
                                System.out.println("Placed: " + arr[i] + " at: " + indexPlace);
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
                                    System.out.println("Attempting shifting for escaping from index: " + indexPlace);
                                    int check = checkEmpty(result, indexPlace);
                                    result = shifter(result, indexPlace, check);
                                }
                                else{
                                    System.out.println("Attempt escape from index: " + indexPlace);
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
                            System.out.println("Placed: " + arr[i] + " at: " + indexPlace);
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
                        result = shifter(result, indexPlace, check);
                        back = 0;
                        forth = 0;
                    }
                }

                printArr(result);
            }
            //printArr(result);
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
        System.out.println("Checking nulls");
        int leftLooker = fromWhere - 1, rightLooker = fromWhere + 1;
        int found = 0;
        int leftCount = -1, rightCount = 1;
        while(found == 0){
            if(leftLooker >= 0){
                if(arr[leftLooker] != null){
                    leftLooker--;
                    leftCount--;
                    //System.out.println("leftLooker"); //DEBUG
                }
                else{
                    //System.out.println("Found on left"); //DEBUG
                    found = leftCount;
                    break;
                }
            }
            else{
                //System.out.println("Left Array border: " + leftLooker); //DEBUG
            }

            if(rightLooker <= (arr.length-1)){
                if(arr[rightLooker] != null){
                    rightLooker++;
                    rightCount++;
                    //System.out.println("rightLooker"); //DEBUG
                }
                else{
                    //System.out.println("Found on right"); //DEBUG
                    found = rightCount;
                    break;
                }
            }
            else{
                //System.out.println("Right Array border: " + rightLooker); //DEBUG
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
}
