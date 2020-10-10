import java.util.*;

public class Most_Visited_Sector_in_a_Circular_Track {
    public static void main(String[] args) {
        int n1 = 2;
        int[] rounds1 = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        int n2 = 7;
        int[] rounds2 = new int[]{1, 3, 5, 7};

        int n3 = 4;
        int[] rounds3 = new int[]{1, 3, 1, 2};
        List<Integer> list = mostVisited(n3, rounds3);
        for (Integer s : list) {
            System.out.println(s);
        }

    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        for (int i = rounds.length - 1; i > 0; i--) {
            if (rounds[i] < rounds[i - 1]) {
                flag++;
            }
        }
        if (flag == 0) {
            for (int i = rounds[0]; i <= rounds[rounds.length - 1]; i++) {
                list.add(i);
            }
        } else {
            if (rounds[rounds.length - 1] == rounds[0]) {
                list.add(rounds[0]);//如果最后一个数和第一个数重合，则该数出现次数最多
            } else if (rounds[rounds.length - 1] > rounds[0]) {
                for (int i = rounds[0]; i <= rounds[rounds.length - 1]; i++) {
                    list.add(i);
                }
            } else {
                for (int i = 1; i <= rounds[rounds.length - 1]; i++) {
                    list.add(i);
                }
                for (int i = rounds[0]; i <= n; i++) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
