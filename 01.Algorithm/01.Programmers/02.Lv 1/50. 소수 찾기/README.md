# [level 1] 소수 찾기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12921)


### 실행문
```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            int limit = (int)Math.sqrt(i);
            
            for(int j = 2; j <= limit; j++ ) {
                if( i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime)answer++;
            
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            int limit = (int)Math.sqrt(i);
            
            for(int j = 2; j <= limit; j++ ) {
                if( i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime)answer++;
            
        }
        
        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
소수 찾는건 분명히 전에 해봤을텐데, 오랜만에 빡 나오니까 아무것도 생각이 안나더군요..
생각 나는대로 적다가 조금조금씩 수정한것 같네요.
항상 하는 생각이지만, 머리로는 잘 푸는데 ㅠㅠ 소스코드로 풀어내는게 너무 어려워요... ㅋㅋㅋ

하지만, 정말 재미있었습니다 ㅎㅎ 
굳굳굳굳
``` 

