import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class Longest_Subarray_of_one_seconds_After_Deleting_One_Element {
    public static void main(String[] args){
        /*
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(8);
        list.add(6);
        */

        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        int[] nums1 = new int[]{1,1,0,1};
        int[] nums2 = new int[]{1,1,0,0,1,1,1,0,1};
        int[] nums3 = new int[]{0,1,1,1,0,1,1,0,1};
        int[] nums4 = new int[]{0,0,0};
        int result = longestSubarray(nums4);
        //Collections.sort(list);
        System.out.print(result);
    }
    public static int longestSubarray(int[] nums) {
        /**
         * 先创建一个新的数组，存储未删除前各最长子列信息，如：[0111001011101010]，则存为[0,3,-4,-5,1,-7,3,-11,1,-13,1,-15]
         * 也就是存储最长子列以及0的标记(取为其索引的负数，这样我们可以通过这个查看在哪里删除一个数可以使子列变大(如果需要删除的话))
         */

        List<Integer> list = new ArrayList<>();
        int temp = 0;
        //获取新数组的值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
                if(i+1== nums.length){
                    list.add(temp);
                }
            } else {
                if (temp != 0) {
                    list.add(temp);
                }
                list.add(-i);
                temp = 0;
            }
        }

        List<Integer> list1 = new ArrayList<>();
        //如果该数组全是1的话，那么list里面只有一个数，且里面是1的个数，这时的子列应该是1的总数-1
        //但是如果是全0，则不用考虑，在下面的过程会处理
        if(list.size()==1&&list.get(0)>0){
            return list.get(0)-1;
        }

        for(int j =0;j<list.size();j++){
            int temp_value=list.get(j);
            if(temp_value>=0){
                //查看其下两个数，看看能不能去掉一个0相加得到更大的子列
                if(j+2<list.size()){
                    //该数大于0，如果下一个数小于0但是下下个数大于0，说明两数可以相加
                    if(list.get(j+1)<0&&list.get(j+2)>0){
                        list1.add(list.get(j)+list.get(j+2));
                        list1.add(-(j+1));//记录相加的位置
                        j++;//指向下一个正数
                    }else{
                        //如果第一个数等于0，则不执行j=j+2,
                        if(temp_value!=0){
                            list1.add(temp_value);
                            //如果下两个数都是负数，那么直接指向第三个数
                            j+=2;
                        }
                    }

                }else{
                    //如果j+2>=list.size()的话，说明差不多在最后了。由于当前数大于0，下一个数必小于0，因此可以结束循环了
                    list1.add(temp_value);
                    j++;
                }
            }
        }

        Collections.sort(list1);
        if(list1.size()==0){
            return 0;
        }
        return list1.get(list1.size()-1);
    }
    public static int longestSubarray1(int[] nums) {
        int index1=0;
        int index2=0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
        }
        return index1;
    }
}

