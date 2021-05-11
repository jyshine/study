package solution.programmers;

public class 음양더하기 {

    public static void main(String[] args) {
        int[] absolutes = {1,2,3};
        boolean[] signs = {false,false,true};
        solution(absolutes,signs);
    }

    private static int solution(int[] absolutes, boolean[] signs) {
        /**
         * 1.숫자 반복 연산
         * 2.조건 true + , flase -
         */
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                sum = sum + absolutes[i];
            } else {
                sum = sum - absolutes[i];
            }
        }
        return sum;
    }

    public static int solution2(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i<signs.length; i++)
            answer += absolutes[i] * (signs[i]? 1: -1);
        return answer;
    }
}
