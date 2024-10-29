# [level 0] 전국 대회 선발 고사

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181851)


### 실행문
```java
import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        Map<Integer, Integer> attendMap = new HashMap<>();
        for(int i = 0; i < attendance.length; i++) {
            if(attendance[i] == true) {
                attendMap.put(rank[i], i);
            }
        }
        List<Integer> keySet = new ArrayList<>(attendMap.keySet());
        Collections.sort(keySet);
        int[] inThird = keySet.stream().mapToInt(Integer::intValue).toArray();

        int a = attendMap.get(inThird[0]);
        int b = attendMap.get(inThird[1]);
        int c = attendMap.get(inThird[2]);

        answer = (10000 * a) + (100 * b) + c;
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
ㅇㅁㅇ?????
``` 