# [level 0] 뒤에서 5등까지

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181853)


### 실행문
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        
        Arrays.sort(num_list);
        
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++) {
            answer[i] = num_list[i];
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
ㅇㅅㅇ?
``` 