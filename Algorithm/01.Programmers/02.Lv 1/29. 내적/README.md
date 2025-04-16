# [level 1] 내적

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/70128)


### 실행문
```java
class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++ ) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                        .map(i -> a[i] * b[i])
                        .sum();
    }
}
```

##### 참고사이트

### 느낀점
```
음...............?
``` 
