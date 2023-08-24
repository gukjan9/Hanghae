import java.util.Arrays;

public class Main {
    public static int[][] solution(int[][] arr1, int[][] arr2, boolean[][] signs) {
        int rowCount = signs.length;
        int colCount = signs[0].length;
        int[][] answer = new int[rowCount][colCount];

        for(int i = 0; i < rowCount; i++){
            for(int j=0; j < colCount; j++){
                if(signs[i][j] == true){
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
                else{
                    answer[i][j] = -1 * (arr1[i][j] + arr2[i][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        int[][] arr1 = {{5,7,1},{2,3,5}};
        int[][] arr2 = {{5,1,6},{7,5,6}};
        boolean[][] signs={{true,true,false},{false,true,false}};

        System.out.println(Arrays.deepToString(method.solution(arr1, arr2, signs)));
    }
}