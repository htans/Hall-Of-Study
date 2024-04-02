# [level 0] 배열 조각하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181893)


### 실행문
```java
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        for(int i =0; i<query.length; i++) {
            if(i % 2 == 0) {
                arr = Arrays.copyOfRange(arr, 0, query[i]+1);
            }else {
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }
        return arr;
    }
}
```


##### 참고사이트


### 느낀점
```
문제 이해력 ㄷㄷ;;; 전 아직 ㄷㄷ;; 
``` 