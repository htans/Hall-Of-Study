# [level 1] 음양 더하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/76501)


### 실행문
```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < signs.length; i++ ) {
            if(signs[i]){
                answer = answer + absolutes[i];
            } else {
                answer = answer - absolutes[i];
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
음...?
``` 
