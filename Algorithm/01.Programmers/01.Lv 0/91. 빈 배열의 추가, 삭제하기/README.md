# [level 0] 빈 배열의 추가, 삭제하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181860)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        
        ArrayList<Integer> intArrayList = new ArrayList<>();
        int CalNum = 0;
        for(int i = 0; i < arr.length; i++) {    
            if(flag[i]) {
                CalNum = arr[i] * 2;         
                for(int x = 0; x < CalNum; x++) {
                    intArrayList.add(arr[i]);   
                }                
            } else {
                for(int y = 0; y < arr[i]; y++) {
                    intArrayList.remove(intArrayList.size() - 1);
                }
            }
        }
        
        int[] answer = new int[intArrayList.size()];
        for(int j = 0; j < intArrayList.size(); j++) {
            answer[j] = intArrayList.get(j);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
문제 이해하는데 10뷴 넘게 걸린 내 인생이 레전드다
``` 