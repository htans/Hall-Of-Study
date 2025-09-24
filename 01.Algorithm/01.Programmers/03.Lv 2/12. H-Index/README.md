# [level 2] H-Index

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42747)


### 실행문
```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
       
        int n = citations.length;
        int h = 0;
        
        for(int i = 0; i < n; i++ ) {
            int c = Math.min( citations[i], n - i );
            h = Math.max( h, c );
        }
        
        return h;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
       
        int n = citations.length;
        int h = 0;
        
        for(int i = 0; i < n; i++ ) {
            int c = Math.min( citations[i], n - i );
            h = Math.max( h, c );
        }
        
        return h;
    }
}
```

##### 참고사이트

### 느낀점
```
=ㅁ=
``` 