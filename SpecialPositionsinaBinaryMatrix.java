public class SpecialPositionsinaBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat0 = new int [][]{
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}};
        System.out.println("五位数组："+numSpecial(mat0));
       int[][] mat1 =new int[][] {{0,0,0,1},
               {1,0,0,0},
               {0,1,1,0},
               {0,0,0,0}};
        System.out.println("四维数组："+numSpecial(mat1));

        int[][] mat2 =new int[][] {{1,0,0},
                {0,1,0},
                {0,0,1}};
        System.out.println("三维数组："+numSpecial(mat2));

        int[][] mat3 =new int[][] {{1,0,0},
                {0,0,1},
                {1,0,0}};
        System.out.println("三维数组："+numSpecial(mat3));



    }

    public static int numSpecial(int[][] mat) {
        int num = 0;//record the num of special
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    int col_count=0;
                    int row_count=0;
                    for(int o =0;o<mat.length;o++){
                        if(mat[o][j]==1){
                            col_count+=1;
                        }
                    }
                    for(int p=0;p<mat[i].length;p++){
                        if(mat[i][p]==1){
                            row_count+=1;
                        }
                    }
                    if(col_count==1&&row_count==1){
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
