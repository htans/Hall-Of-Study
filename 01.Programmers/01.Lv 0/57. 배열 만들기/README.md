# [level 0] 배ㄹ 만들기 3

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181895)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> answerList = new ArrayList<>(); 
        
        for (int i = 0; i < intervals.length; i++) {
            for (int a = intervals[i][0]; a <= intervals[i][1]; a++) {
                answerList.add(arr[a]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
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