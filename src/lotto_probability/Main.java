package lotto_probability;
public class Main {

    public static void main(String[] args) {

        solution(
                new int[]{44, 1, 0, 0, 31, 25},
                new int[]{31, 10, 45, 1, 6, 19}
        );

    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        int total_cnt = 0;
        int zero_cnt = 0;

        for(int i : lottos) {
            if (i == 0) {
                zero_cnt++;
                continue;

            } else {

                for (int j : win_nums) {
                    if (i == j) {
                        // 로또 맞음
                        total_cnt++;
                    }
                }
            }
        }

        return new int[]{numberChanger(total_cnt + zero_cnt), numberChanger(total_cnt)};
    }

    private static int numberChanger(int correct_cnt){

        return switch (correct_cnt) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
