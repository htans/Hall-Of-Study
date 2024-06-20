# [level 0] 두 수의 합

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181846)


### 실행문
```java
import java.math.BigInteger; 

class Solution {
    public String solution(String a, String b) {
        
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);
        
        BigInteger bigSum = bigA.add(bigB);
        
        String answer = bigSum.toString();
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
오; BigInteger 라는걸 처음 써봄; 덩치 큰 빼빼로 형
``` 