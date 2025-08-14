# [level 1] 정수 제곱근 판별

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12934)


### 실행문
```java
class Solution {
    public long solution(long n) {
        double x = Math.sqrt(n);
        
        if( x == (long)x ) {
            return (long)((x + 1) * (x + 1));
        } else {
            return -1;
        }
        
    }
}
```

### ChatGPT
```java
class Solution {
    public long solution(long n) {
        double x = Math.sqrt(n);
        
        if( x == (long)x ) {
            return (long)((x + 1) * (x + 1));
        } else {
            return -1;
        }
        
    }
}
```

##### 참고사이트

### 느낀점
```
제곱 관련된 문제가 기억이 흐릿하다보니 혼자서 정한 30분이 넘어버렸습니다.
Math.sqrt() 같은 메소드와 타입 별로의 변환도 따로 메모해놔야겠네요.
꾸준하게 코딩테스트를 풀때는 아무생각없이 이렇게 쓰면 되징 룰루 ㅎㅎ 이랬는데, 
불과 두달정도 지나니 상당히 기초적인 부분도 기억못하는 제가 보였네요..
차근차근히 다시 해야겠다는 생각이 듭니다.
천천히 하는게 제일 빠르다 라는 말이 각인 되네요!
이번 문제도 너무 재미있었습니다!

타입변환으로만 정수인지, 실수인지 판단하다니.. 크흐...
``` 

