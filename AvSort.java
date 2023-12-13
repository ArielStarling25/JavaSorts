import java.util.*;

class AvSort {

    public AvSort(){

    }

    private int[] splitAndSwap(int[] array){
        int pos = array.length/2;
        int b[] = new int[pos];
        int c[] = new int[array.length - pos];
        int sumB = 0, sumC = 0;
        double avgB, avgC;
        int[] result = new int[array.length];

        // split
        for (int i = 0; i < array.length; i++) {
            if (i < pos){
                b[i] = array[i];
            }
            else{
                c[i - pos] = array[i];
            }
        }

        for(int i = 0; i < b.length; i++){
            sumB += b[i];
        }
        avgB = sumB / b.length; 

        for(int i = 0; i < c.length; i++){
            sumC += c[i];
        }
        avgC = sumC / c.length;
        
        if(avgB > avgC){
            System.arraycopy(c, 0, result ,0, c.length); //put at the front
            System.arraycopy(b, 0, result, c.length, b.length);
        }
        else if(avgB < avgC){
            System.arraycopy(b, 0, result ,0, b.length); //put at the front
            System.arraycopy(c, 0, result, b.length, c.length);
        }
        else{ //if theyre equal
            result = array;
        }

        return result;
    }

    public static int[] sort(int[] array){
        
        return array;
    }
}
