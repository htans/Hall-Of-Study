# [level 0] 정수 찾기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181840)


### 실행문
```java
class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        
        for(int i = 0; i < num_list.length; i++) {
            if( num_list[i] == n ) {
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
오;; contains으로 하려고 했는데, contains은 String형이랑 List형만 가능하다는것을 배움; 매움;
``` 