# [level 0] n보다 커질 때까지 더하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181884)


### 실행문
```java
class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        
        for(int i = 0; i < numbers.length; i++) {
            if(n >= answer) {
                answer = answer + numbers[i];
            }
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ
``` 