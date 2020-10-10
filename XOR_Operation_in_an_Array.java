public class XOR_Operation_in_an_Array {
    public static void main(String[] args){
       int n1 = 5 , strat =0;
       System.out.print(xorOperation(n1,strat));
    }
    public static int xorOperation(int n, int start) {
        int[] array = new int[n];
        int result = 0;
        array[0] =start;
       for(int i = 1;i<n;i++){
           array[i] = array[i-1]+2;
       }

       for(int j = 0;j<n;j++){
           result ^=array[j];
       }
       return result;
    }
}
