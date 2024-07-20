# [level 0] 특별한 이차원 배열 1

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181833)


### 실행문
```java
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        if( n == 0 ) {
            answer[n][n] = 1;
        } else {
            for( int j = 0; j < n; j++ ) {
                for( int i = 0; i < n; i++ ) {
                    if( j == i ) {        
                        answer[j][i] = 1;
                    } else {
                        answer[j][i] = 0;
                    }
                }   
            }    
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
이차원 배열을 문제로 풀려니 머리 터지겠네요.
근데 이게 1점이라니... 다들 다 코딩을 잘하는구나... 나만 못행...
``` 