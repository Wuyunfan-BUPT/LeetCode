public class Make_The_String_Great {

    public static void main(String[] args){
        String s1 = "RLlr";
        String s2 = "leEeetcode";
        String s3 = "abBAcC";
        String s4 = "s";

        String output = makeGood(s1);
        System.out.println(output);

    }
    public static String makeGood(String s) {
        String temp="";
        int flag = 1;//是否跳出循环

        while (flag != 0) {
            flag = 0;//置为0，如果该轮已经没有大小写关系字符，则会跳出循环
            //判断是否只剩下一个字符，如果只剩下一个字符，跳出循环
            if(s.length()==1){
                temp = s;
                break;
            }
            //如果还有两个以上的字符
            for (int i = 0; i < s.length(); i++) {
                if ((i + 1) < s.length()) //如果没有i+1越界，说明还剩至少2个字符，还能够继续比较
                {
                    if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 32)
                    {
                        temp = temp+s.charAt(i);//如果该字符和下一个字符不是大小写关系，则添加该字符
                    }
                    else
                    {
                        ++i;//忽略这两个字符，指向下下个字符（结合for自带的i++)
                        //判断s是否是只剩下两个字符，并且剩下的两个字符是大小写关系。如果是，则说明最终的结果是null
                        if (s.length() == 2)
                        {
                            temp = "";
                            flag = 0;
                            break;//直接跳出循环
                        }
                        //说明在该轮循环中还有重复的数字，则得到的删减后的数组仍然可能有重复的数字，因此需要继续while循环
                        flag++;
                    }

                }
                else {//如果只剩下一个字符，直接退出，并将该字符赋值给temp
                    temp = temp+s.charAt(i);
                    break;
                }
            }
            if(flag!=0){
                s = temp;//将删减后的数组赋给s
                temp = "";//将temp归null
            }
        }
        return temp;
    }
}
