// 주어진 arr 에 요소들을 주어진 정수 n 번째 글자를 기준으로 오름차순 정렬
// n 번째 글자가 같을 경우 사전순으로 정렬한다.

import java.util.*;

public class Main {
    public String[] solution(String[] arr, int n) {
        // 중복이 되었는지 안되었는지 판별하기 위한 플래그
        int flag = 0;

        // 기준 요소와 같으면 "" 빈 문자열로 초기화, 중복이 발견되었으니 flag = 1
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i].equals(arr[j])){
                    arr[j] = "";
                    flag = 1;
                }
            }
            // 기준이 되었던 요소도 빈 문자열로, flag 초기화
            if(flag == 1){
                arr[i] = "";
                flag = 0;
            }
        }

        // sort 를 쓰기 위해서 list 로 변경
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.removeAll(Arrays.asList(""));

        // 기본 sort 메서드는 기준을 커스텀하지 못하므로 오버라이드
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)){
                    return 1;
                }
                else if(o1.charAt(n) < o2.charAt(n)){
                    return -1;
                }
                // 비교 문자가 같을때 사전적인 순서로 비교
                else {
                    return o1.compareTo(o2);
                }
            }
        });

        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }

    public static void main(String[] args) {
        Main method = new Main();
        String[] arr = {"coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"};
        int n = 2;
        System.out.println(Arrays.toString(method.solution(arr, n)));
    }
}

