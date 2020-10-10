public class Kth_Missing_Positive_Number {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 11};
        int k = 5;
        int[] arr1 = new int[]{2, 3, 4, 7, 11, 17, 31, 35};
        int k1 = 6;
        int[] arr2 = new int[]{2};
        int k2 = 1;
        int[] arr3 = new int[]{3,10};
        int k3 = 2;
        System.out.print(findKthPositive(arr3, k3));
    }

    public static int findKthPositive(int[] arr, int k) {
        int object = 0;
        //arr[arr.length-1]-arr.length:看他缺几个
        if (k > (arr[arr.length - 1] - arr.length)) {
            object = (arr[arr.length - 1] + k - (arr[arr.length - 1] - arr.length));
        } else {
            int temp = 0;
            int interval = arr[0] - 1;
            for (int i = 0; i < arr.length; i++) {
                if (interval < k) {
                    temp = arr[i + 1] - arr[i] - 1;
                    interval += arr[i + 1] - arr[i] - 1;//计数到i为止缺多少数，减去1是因为如2到3本身就是1的差值
                } else {
                    if (i==0) {
                        object = k;
                        break;
                    } else {
                        object = (arr[i - 1] + k - interval + temp);
                        break;
                    }
                }
            }
        }
        return object;
    }
}
