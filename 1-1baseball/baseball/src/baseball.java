import java.util.Random;
import java.util.Scanner;

public class baseball {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int com[] = new int[3];
        String input;
        String[] human;
        int flag = 0;

        int count = 1;
        int s = 0;
        int b = 0;

        for (int i = 0; i < 3; i++) {
            com[i] = random.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (com[i] == com[j]) i--;
            }
        }

         // 랜덤 수 확인
        for(int i = 0; i < 3; i++){
            System.out.println(com[i]);
        }

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while(true){
            System.out.print(count+"번쨰 시도 : ");
            input = sc.next();
            human = input.split("");

            for(int j = 0; j < 3; j++){
                if(com[j] == Integer.parseInt(human[j])){
                    s++;
                    if(s == 3){
                        System.out.println(s+"S");
                        System.out.println(count+"번만에 맞히셨습니다.");
                        System.out.println("게임을 종료합니다.");
                        break;
                    }
                }
                else {
                    for (int k = 0; k < 3; k++) {
                        if (com[j] == Integer.parseInt(human[k])) b++;
                    }
                }
            }
            if(s == 3) break;

            if(b == 3) System.out.println(b+"B");
            else System.out.println(b+"B"+s+"S");
            s = 0;
            b = 0;
            count++;
        }
    }
}
