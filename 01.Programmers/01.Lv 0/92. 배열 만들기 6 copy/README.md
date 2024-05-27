# [level 0] 무작위로 K개의 수 뽑기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181858)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int k) {
        
        ArrayList<Integer> ary = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++ ) {
            if(!ary.contains(arr[i])) {
                ary.add(arr[i]);
            } 
        }
        
        int[] answer = new int[k];
        for(int j = 0; j < answer.length; j++ ) {
            if( j < ary.size() ) {
                answer[j] = ary.get(j);
            } else {
                answer[j] = -1;
            }
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