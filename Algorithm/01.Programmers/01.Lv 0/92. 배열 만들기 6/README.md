# [level 0] 배열 만들기 6

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181859)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> stk = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(stk.size() <= 0) {
                stk.add(arr[i]);
            } else {
                if(stk.get(stk.size() - 1) == arr[i]) {
                    stk.remove(stk.size() - 1);
                } else {
                    stk.add(arr[i]);
                }
            } 
        }
        
        if(stk.size() == 0) {
            stk.add(-1);
        }
        
        int[] answer = new int[stk.size()];
        for(int j = 0; j < answer.length; j++) {
            answer[j] = stk.get(j);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
테스트 문제를 전부 다 해결 했는데, 계속 결과에서는 오류가 나와서 고민이였습니다.
천천히 확인해보니, 조건이 다른게 있었고, 왜 그렇게 했는지 빡대가리 인것을 다시 한번 느꼈습니다.
역시 차분한 마음으로 하는것이 제일 중요한것 같습니다.
``` 