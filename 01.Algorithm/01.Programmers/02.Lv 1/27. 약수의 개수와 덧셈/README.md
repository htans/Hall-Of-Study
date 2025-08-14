# [level 1] 약수의 개수와 덧셈

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/77884?language=java)


### 실행문
```java
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++ ) {
            int count = 0;
            
            for(int a = 1; a <= i; a++ ) {
                if(i % a == 0) {
                    count++;
                }
            }
            
            if(count % 2 == 0) {
                answer = answer + i;
            } else {
                answer = answer - i;
            }
            
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            // 제곱수인지 확인
            if (isPerfectSquare(i)) {
                answer -= i;  // 약수 개수 홀수 → 빼기
            } else {
                answer += i;  // 약수 개수 짝수 → 더하기
            }
        }

        return answer;
    }

    // 제곱수 판별 함수
    private boolean isPerfectSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
```

##### 참고사이트

### 느낀점
```
이번 문제도 코딩테스트를 푸는 저만의 방식으로 무리없이 잘 풀었네요.
챗형님이 해준 리팩토링을 보니 제가 푼 소스가 아주 하찮게 느껴지긴 하지만,
제곱수를 이용해서 푸는 저 sqrt * sqrt == n 이게 제일 핵심로직이고,
True 면 약수 갯수가 홀수니까 더하고, False면 약수 갯수가 짝수니까 더하고... 크흐
역시 아직 갈길이 멀었습니다 ㅎㅎ 
``` 
