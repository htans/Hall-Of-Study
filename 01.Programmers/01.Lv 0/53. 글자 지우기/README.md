# [level 0] 글자 지우기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181900)


### 실행문
```java
import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] tmp = my_string.split("");
        
        for (int i = 0; i < indices.length; i++) {
            tmp[indices[i]] = "";
        }

        for (String x : tmp) {
            answer += x;
        }
        return answer;
    }
}
```


##### 참고사이트
1. [참고 링크](https://developer-talk.tistory.com/708) 
2. [참고 링크](https://velog.io/@shin75492/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4JAVA-%EA%B8%80%EC%9E%90-%EC%A7%80%EC%9A%B0%EA%B8%B0) 


### 느낀점
```
처음에는 my_string 문자열을 ArrayList 로 변환해서 해당 자리수를 제거 하고 이어 붙을려고 했는데,
다 하고, 생각해보니 맞지 않는 방법인것 같아서 구글링을 조금 했습니다.
확실히 다른분들은 간단하고, 어렵지 않은 방법으로 구현을 해놓으셨더군요.
실제 코딩을 해보니, 해결인지, 아닌지가 제일 중요하지만, 차후에 유지보수를 위해 간단한 프로토콜 방식과 표현방식이 중요하다는것을 느껴서 그런것 같습니다.
저는 컴퓨터가 아니니까, 제가 한 작업도 제대로 기억 못할때가 많아서 다시 분석한다던가, 프로토콜이 어려우면 오류 검출하기도 어렵더라구요.
뭐... 다 떠나서 제가 ㅈ밥이라는거겠죠
``` 