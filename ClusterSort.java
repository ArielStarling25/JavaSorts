import java.util.ArrayList;

//thinking about it, this is impractical
public class ClusterSort {
    public static int[] sort(int[] arr, int clusterSize){

        int min = arr[0], max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }

            if(min > arr[i]){
                min = arr[i];
            }
        }

        int beforeRange = (max - min);  
        int afterRange = arr.length-1;
        
        ArrayList<Integer>[] cluster = new ArrayList[arr.length];
        //ArrayList<Integer[]> clusterList = new ArrayList<Integer[]>();  

        for(int i = 0; i < arr.length; i++){
            float value = (((arr[i] - min) * afterRange) / beforeRange) + 0;
            int clusterIndex = Math.round(value);

        }

        return arr;
    }
}
