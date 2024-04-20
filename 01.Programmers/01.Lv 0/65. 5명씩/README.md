# [level 0] 5명씩

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181886)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] names) {
        
        ArrayList<String> stringList = new ArrayList<>();
        for(int i = 0; i < names.length; i = i + 5 ) {
            stringList.add(names[i]);
        }
        
        String[] answer = new String[stringList.size()];   
        for(int j = 0; j < answer.length; j++ ) {
            answer[j] = stringList.get(j);
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