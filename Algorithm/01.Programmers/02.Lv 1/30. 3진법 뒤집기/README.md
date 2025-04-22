# [level 1] 3진법 뒤집기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/68935)


### 실행문
```java
class Solution {
    public int solution(int n) {
        int answer = 0;
            
        String a = Integer.toString(n, 3);
        String b = "";
        
        for(int i = a.length(); i >= 0; i-- ) {
            if(i > 0) {
                b += a.substring(i-1, i);
            } else {
                b += a.substring(0, i);
            }
        }
        
        answer = Integer.parseInt(b, 3);
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int n) {
        String reversedTernary = new StringBuilder(Integer.toString(n, 3)).reverse().toString();
        return Integer.parseInt(reversedTernary, 3);
    }
}
```

##### 참고사이트

### 느낀점
```
와 진법 변환 방법을 완전히 잊고 있었네요.
뒤집기도 reverse() 라는 메소드를 통해 가능했는데, 도통 떠오르지 않아서 for문으로 해버렸습니다.
메소드 하나로 간단히 할 수 있는건데, for문 사용한게 너무 한심합니다만, 이로인해서 reverse() 메소드를 잘 기억했으니 다음에 꼭 써먹어봐야겠어요.
역시 챗 형님은 3진법까지 한번에 처리하여 다시 10진수로 return 으로 바로 보내버리네요.
이해는 하겠는데, 아직은 제가 짜지는 못하겠습니다.. ㅠ 
그래도 너무 재미있는 문제 였어요 ㅎㅎ
``` 