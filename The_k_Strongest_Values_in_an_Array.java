import java.util.Arrays;

public class The_k_Strongest_Values_in_an_Array {
    public static void main(String[] args){

    }
    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int medium = arr[(arr.length-1)/2];//求出中位数
        int head =0; //数组头部指针
        int tail=arr.length-1;//数组尾部指针
        int[] result = new int[k];
        //由于数组已经排序，最大最小值一定在数组头部或者尾部
        for(int i =0;i<k;i++){
            if(Math.abs(arr[tail]-medium)>=Math.abs(arr[head]-medium)){
                result[i] = arr[tail];
                tail--;
            }else{
                result[i] = arr[head];
                head++;
            }
        }
        return result;
    }
}
