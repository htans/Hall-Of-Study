# [level 1] 정수 내림차순을 배치하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12933)


### 실행문
```java
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        
        String str = String.valueOf(n);
        
        String[] strSp = str.split("");
        Arrays.sort(strSp, Collections.reverseOrder());
        
        String temp = String.join("", strSp);
        long answer = Long.parseLong(temp);
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        
        String str = String.valueOf(n);
        
        String[] strSp = str.split("");
        Arrays.sort(strSp, Collections.reverseOrder());
        
        String temp = String.join("", strSp);
        long answer = Long.parseLong(temp);
        
        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
ㅇㅁㅇ!
``` 

