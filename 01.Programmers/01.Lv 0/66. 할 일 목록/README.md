# [level 0] 할 일 목록

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181885)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        
        ArrayList<String> Array_todo_list = new ArrayList<>(); 
        
        for(int i = 0; i < finished.length; i++ ) {
            if(finished[i] == false ) {
                Array_todo_list.add(todo_list[i]);
            }
        }
        
        String[] answer = new String[Array_todo_list.size()];
        for(int j = 0; j < answer.length; j++) {
            answer[j] = Array_todo_list.get(j);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ
``` 