# [level 1] 평균 구하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12944)


### 실행문
```java
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double total = 0;
        
        for(int i = 0; i < arr.length; i++ ) {
            total += arr[i];
        }
        
        answer = total / arr.length;
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public boolean solution(int x) {
        int sum = 0;
        String str = String.valueOf(x);

        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        return x % sum == 0;
    }
}
```

```java 
import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr)
                     .average()
                     .orElse(0);
    }
}
```

##### 참고사이트

### 느낀점
```
음...?
``` 

