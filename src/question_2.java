import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dart Score : ");
        String inputValue = scanner.nextLine();

        int length = inputValue.length(); //입력된 값의 길이
        int step = 1;                     //1:점수,2:보너스,3:옵션
        int lengthPosition = 0;           //입력된 값의 좌표
        int[] score = new int[3];         //점수
        int scorePosition = 0;            //점수의 좌표

        //1. 입력된 길이만큼 반복 분석
        while(lengthPosition < length) {
            String target = inputValue.substring(lengthPosition, lengthPosition + 1);
            if(step == 1) {
                try {
                    //1.1 1단계 점수 처리(숫자만 올 수 있다)
                    score[scorePosition] = Integer.parseInt(target);
                    step++;
                }
                catch (Exception e){
                    if("*".equals(target)) {
                        //1.3.1 스타상
                        score[scorePosition - 1] = score[scorePosition - 1] * 2;
                        if(scorePosition > 1) {
                            score[scorePosition - 2] = score[scorePosition - 2] * 2;
                        }
                    }
                    else if("#".equals(target)) {
                        //1.3.2 아차상
                        score[scorePosition - 1] = score[scorePosition - 1] * (-1);
                        if(scorePosition > 1) {
                            score[scorePosition - 2] = score[scorePosition - 2] * (-1);
                        }
                    }
                    else {
                        System.out.println("유효한 다트 점수가 아닙니다.");
                        return;
                    }
                }
            }
            else if(step == 2) {
                //1.2 2단계 영역처리
                if("S".equals(target)) {
                    //1.2.1 Single
                    score[scorePosition] = (int)Math.pow(score[scorePosition], 1);
                }
                else if("D".equals(target)) {
                    //1.2.2 Double
                    score[scorePosition] = (int)Math.pow(score[scorePosition], 2);

                }
                else if("T".equals(target)) {
                    //1.2.3 Triple
                    score[scorePosition] = (int)Math.pow(score[scorePosition], 3);

                }
                else if("0".equals(target)) {
                    //1.1.1 score 10
                    if(score[scorePosition] == 1){
                        score[scorePosition] = 10;
                        //2단계 처리를 다시 하기 위해 값을 조절
                        scorePosition--;
                        step++;
                    }
                }
                else {
                    System.out.println("유효한 다트 점수가 아닙니다.");
                    return;
                }
                scorePosition++;
                step--;
            }
            //다음 문자 처리
            lengthPosition++;
        }
        System.out.println(score[0] + score[1] + score[2]);
    }
}
