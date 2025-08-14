# [level 0] 날짜 비교하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181838)


### 실행문
```java
import java.time.LocalDate;

class Solution {
    public int solution(int[] date1, int[] date2) {
        
        LocalDate date1_obj = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate date2_obj = LocalDate.of(date2[0], date2[1], date2[2]);
        
        int answer = date1_obj.compareTo(date2_obj);
        if(answer < 0) {
            answer = 1;
        } else {
            answer = 0;
        }
            
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
compareTo 도 처음보고, LocalDate 도 처음보는데 뭔가 익숙하면서 신기
``` 