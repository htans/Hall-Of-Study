# [level 0] 카운트 다운

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181899)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int start, int end_num) {
        
        ArrayList<Integer> answerList = new ArrayList<> ();
        
        for (int i = start; i >= end_num; i--) {
            answerList.add(i);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++ ) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ 
``` 