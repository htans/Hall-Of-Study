# [level 0] l로 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181834)


### 실행문
```java
import java.util.Arrays;

class Solution {
    public String solution(String myString) {
        String answer = "";        
        String myString_arr [] = myString.split("");
        Integer cutNum = getNumPoint('l');
        
        for(int i = 0; i < myString_arr.length; i++ ) {
            char c = myString_arr[i].charAt(0);
            
            if(cutNum > getNumPoint(c) ) {
                answer += "l";
            } else {
                answer += myString_arr[i];
            }
        }
        
        return answer;
    }
    
    public int getNumPoint(char c) {
        c = Character.toLowerCase(c);
        return c - 'a' + 1 ;
    }
    
}
```

##### 참고사이트


### 느낀점
```
어떻게 할지 보이긴하지만, 코드로 뽑아내는게 문제인 나
``` 