# [level 0] 배열 만들기 1 

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181901)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int n, int k) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int i = k; i <= n; i = i + k ) {
            answer.add(i);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
기존에 선언되어 있던 answer[] 배열에 넣고 싶어서 여러가지를 시도 해봤는데, 
배열의 크기를 구하기 위해서 한번 돌고, 거기에 값을 넣어야해서
answer를 ArrayList로 선언하여, 동적으로 들어가게 구성하였습니다.
분명... 고정된 배열에 넣는 방법이 있을텐데... ㅇㅅㅇ...
``` 