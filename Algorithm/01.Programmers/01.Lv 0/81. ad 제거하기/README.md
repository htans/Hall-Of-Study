# [level 0] ad 제거하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181870)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        
        ArrayList<String> list = new ArrayList();
        for(int i = 0; i < strArr.length; i++ ) { 
            if(!strArr[i].contains("ad")) {
                list.add(strArr[i]);
            } 
        }
        
        String[] answer = new String[list.size()];
        for(int j = 0; j < answer.length; j++ ){
            answer[j] = list.get(j);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ArrayList 쓴지 얼마나 지났다고 선언문 잊어먹는 클라스;
``` 