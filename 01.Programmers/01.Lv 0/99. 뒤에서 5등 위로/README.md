# [level 0] 뒤에서 5등 위로

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181852)


### 실행문
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        
        int[] answer = new int[num_list.length - 5];
        int ans_num = 0;
        
        Arrays.sort(num_list);
        
        for(int i = 5; i < num_list.length; i++) {
            answer[ans_num] = num_list[i];
            ans_num++;
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
ㅇㅁㅇ??
``` 