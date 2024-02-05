# [level 0] 접미사 배열

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181909)


### 실행문
```java
import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        
        String[] answer = new String[my_string.length()];
        
        for(int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(i);    
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ
``` 