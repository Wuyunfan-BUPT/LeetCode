import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rearrange_Words_in_a_Sentence {
    public static void main(String[] args) {
        String text = "Keep calm and code on";
        String s = arrangeWords1(text);
        System.out.print(s);

    }

    public static String arrangeWords(String text) {
        List<Integer> list = new ArrayList<>();
        int cout = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != 32) {
                cout++;
            } else {
                list.add(cout);
                cout = 0;
            }
        }
        if (text.charAt(text.length() - 1) != 32) {
            list.add(cout);//如果text字符串不是以空格结尾的话，需要在最后把最后一个字符串加进去
        }
        int temp = list.get(0);
        int index = 0;//记录最大字符串对应的空格(index-1)
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > temp) {
                temp = list.get(i);
                index = i;
            }
        }
        String result = "";
        if (index == 0) {
            for (int i = 0; i < text.length(); i++) {
                if(text.charAt(i)!=32) {
                    result += text.charAt(i);
                }else{
                    break;
                }
            }
        } else {
            int num = 0;
            int j;

            for (j = 0; j < text.length(); j++) {
                if (num < index - 1) {
                    if (text.charAt(j) == 32) {
                        num++;
                    } else {
                        break;
                    }
                }
            }

            for (int t = j + 1; ; t++) {
                if (text.charAt(t) != 32) {
                    result += text.charAt(t);
                } else {
                    break;
                }
            }
        }
        return result;
    }


    public static String arrangeWords1(String text) {
        int head = 0;
        int tail = 0;
        String first = text.substring(0,1);
        String after = text.substring(1);
        first = first.toLowerCase();
        text = first+after;
        //分别记录每一个子串在数组中的起始位置head和终止位置tail
        List<Integer> list_head = new ArrayList<>();
        List<Integer> list_tail = new ArrayList<>();
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==32){
                tail = i-1;
                list_head.add(head);
                list_tail.add(tail);
                head = i+1;
            }
            if(i+1 == text.length()){
                list_head.add(head);
                list_tail.add(i);
            }
        }
        //计算每个子列的长度,compare_length[][0]记录长度,compare_length[][1]记录它在list_head的位置
        int[][] compare_length = new int[list_head.size()][2];
         for(int i = 0;i<list_head.size();i++){
            compare_length[i][0] = list_tail.get(i)-list_head.get(i)+1;
            compare_length[i][1] = list_head.get(i);
        }


         //只存储长度大小
         int[] value = new int[list_head.size()];
        for(int i =0;i<list_head.size();i++){
            value[i] = compare_length[i][0];
        }
        //对长度进行排序
        Arrays.sort(value);

        String result = "";
        for(int i=0;i<value.length;i++){
            for(int j=0;j<compare_length.length;j++){
                if(compare_length[j][0]==value[i]){
                    int index = 0;//获取该长度对应的起始位置数组的下标值
                    for(int s = 0;s<list_head.size();s++){
                        if(list_head.get(s)==compare_length[j][1]){
                            index =s;
                        }
                    }
                    for(int start=compare_length[j][1];start<=list_tail.get(index);start++){
                        result+=text.charAt(start);
                    }
                    //如果不是最后一个字符的话，需要加完该子串后再加一个空格
                    if(i!=value.length-1){
                        result+=" ";
                    }
                    //加完该子串后，再下一轮比较中将不考虑该子串，该将其长度置为-1
                    compare_length[j][0]=-1;
                    break;
                }
            }
        }
        if(result.charAt(result.length()-1)==32){
            System.out.println("error");
        }
        String first1 = result.substring(0,1);
        String after1 = result.substring(1);
        first1 = first1.toUpperCase();
        result = first1+after1;
        return result;
    }

    public static String arrangeWords2(String text) {
        String[] res = text.toLowerCase().split(" ");
        Arrays.sort(res, (a, b) -> a.length() - b.length());
        String ans = String.join(" ", res);
        return Character.toUpperCase(ans.charAt(0)) + ans.substring(1);
    }
}
