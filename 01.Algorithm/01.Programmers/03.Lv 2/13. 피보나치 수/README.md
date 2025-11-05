# [level 2] 피보나치 수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12945)


### 실행문
```java
class Solution {
    public int solution(int n) {
        
        long[] fib = new long[n+1];
        
        fib[0] = 0;
        fib[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % 1234567;
        }
        
        return (int) fib[n];
    }
}
```

### ChatGPT
```java
}

```

##### 참고사이트

### 느낀점
```
피보나치는 솔직히 처음 들어봐요 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
세상 이런 수가 있었다니.. 여러 이직활동으로 프로젝트나 이력서 최신화 할게 많아서 간간히 리마인드나 특정된 문제들 풀기 정신없었네요.
이제 다시 꾸준히 해봐야겠어요.

그리고 잡다에 코딩테스트를 이용하면 실전 긴장감이나 실전 환경도 경험할 수 있을 것 같아서 좋을 것 같아요. 흥미
``` 