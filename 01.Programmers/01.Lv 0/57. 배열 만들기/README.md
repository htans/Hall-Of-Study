# [level 0] 배열 만들기 3

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
문제를 해결하는것보다 문제를 이해하는것이 더 어려운 문제 였습니다.
질문하기 항목을 통해 다양한 질문을 보면서 간신하 이해 했었고,
생각보다 간단한 문제라서 당황 했습니다.
문제를 많이 풀어보는 방법 밖에는 없는것 같습니다.
``` 