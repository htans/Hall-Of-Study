# [level 0] 주사위 게임 1 

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181839)


### 실행문
```java
class Solution {
    public int solution(int a, int b) {
        int num_type = 0;
        
        if(a % 2 == 0) {
            num_type ++;
        }
        if(b % 2 == 0) {
            num_type ++;
        }
        
        int answer = 0;
        if(num_type == 0) {
            answer = ((int)Math.pow(a, 2)) + ((int)Math.pow(b, 2));
        } else if (num_type == 1 ) {
            answer = 2 * ( a + b );
        } else if (num_type == 2) {
            answer = Math.abs( a - b);
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
Math.abs 첨봄 ㅇㅁㅇ 
``` 