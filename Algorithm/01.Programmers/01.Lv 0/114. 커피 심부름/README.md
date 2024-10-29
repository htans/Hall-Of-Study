# [level 0] 커피 심부름

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181837)


### 실행문
```java
class Solution {
    public int solution(String[] order) {
        int answer = 0;

        for(int i = 0; i < order.length; i++ ) {
            if(order[i].contains("cafelatte")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
ㅇㅁㅇ?
``` 