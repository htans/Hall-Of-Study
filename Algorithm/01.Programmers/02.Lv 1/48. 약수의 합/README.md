# [level 1] 약수의 합

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12928)


### 실행문
```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++ ) {
            if(n % i == 0 ) {
                answer += i;
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int n) {
        int sum = 0;
        int sqrt = (int) Math.sqrt(n);
        
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) { // i가 n의 제곱근이 아닐 때만
                    sum += n / i;
                }
            }
        }
        
        return sum;
    }
}
```

##### 참고사이트

### 느낀점
```
음..?
``` 

