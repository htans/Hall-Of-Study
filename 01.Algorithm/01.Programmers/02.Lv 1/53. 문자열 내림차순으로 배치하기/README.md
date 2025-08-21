# [level 1] 문자열 내림 차순으로 배치하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12917)


### 실행문
```java
import java.util.*;
// import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        char[] sch = s.toCharArray();
        Arrays.sort(sch);
        
        StringBuilder sb = new StringBuilder( new String(sch) );
        sb.reverse();
        
        String answer = new String(sb);
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public String solution(String s) {
        char[] sch = s.toCharArray();
        Arrays.sort(sch);  // 오름차순 정렬
        return new StringBuilder(new String(sch))
                    .reverse()
                    .toString(); // 내림차순 문자열 반환
    }
}
```

##### 참고사이트

### 느낀점
```
이번 문제는 생각보다 쉽게 해결할 수 있었어요.
대문자,소문자 조건이 들어가서 음음... 어떻게 하지 했는데,
다행히 유니코드는 대문자와 소문자가 아예 다른 영역이라 구분이 잘 되는것 같네요.
다른 방식으로 조건들이 나오면 전체를 toLowerCase(), toUpperCase() 같은 메소드로 변환해서 진행하면 되지 않을까 생각합니다.

챗형님이 짜주신걸 보니 확실히 짧고 간결하게 정리해주셨네요.
그나마 어깨가 올라가는건 큰 틀은 비슷한것 같아요!! ㅎㅎㅎㅎ

이번 문제도 너무 잼잼ㅎㅎㅎㅎ
``` 

