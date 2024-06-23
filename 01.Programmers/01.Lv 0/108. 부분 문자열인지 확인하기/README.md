# [level 0] 부분 문자열인지 확인하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181843)


### 실행문
```java
class Solution {
    public int solution(String my_string, String target) {
        
        int answer = 0;
        
        if( my_string.contains(target) ) {
            answer = 1;
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
equals() 메소드와 헷갈린 내가 레전드
``` 