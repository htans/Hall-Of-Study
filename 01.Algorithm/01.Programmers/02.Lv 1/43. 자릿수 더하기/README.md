# [level 1] 자릿수 더하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12931)


### 실행문
```java
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String StrN = Integer.toString(n);
        String splitN[] = StrN.split("");
        
        for(int i = 0; i < splitN.length; i++ ) {
            answer += Integer.parseInt(splitN[i]);
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;  // 마지막 자리 더하기
            n /= 10;           // 마지막 자리 제거
        }

        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
자신감 있게 아! 이렇게 하면 되겠다! 해서 멋지게 완료 했는데,
챗형님 풀이를 보니 헐...
String -> split -> Integer 과정도 필요없이 
% 10을 이용해서 마지막 자리수만 빼서 answer에 더하고, /= 10을 해서 마지막 자리를 제거하고 하면 
아무런 변환없이 풀이가 가능하네요...
세상에.. 이런 방법이 있었다니 ㅋㅋㅋ 처음에는 오! 생각보다 나 잘푸는데! 했는데 
역시 멀고도 멀었습니다 ㅋㅋ
``` 

