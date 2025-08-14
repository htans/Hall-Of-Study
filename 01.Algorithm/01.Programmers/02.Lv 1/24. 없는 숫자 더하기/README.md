# [level 1] 없는 숫자 더하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86051)


### 실행문
```java
class Solution {
    public int solution(int[] numbers) {
        
        int answer = 45;
        
        for(int number : numbers ) {
            answer = answer - number;
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        // 0부터 9까지 다 더해놓고
        for (int i = 0; i <= 9; i++) {
            answer += i;
        }

        // 주어진 숫자들 빼기
        for (int num : numbers) {
            answer -= num;
        }

        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
음..?
``` 