# [level 0] 세로 읽기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181904)


### 실행문
```java
class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        Integer num = 0;
        
        for(int i = m; i <= my_string.length(); i = i + m) {
            String test = my_string.substring(num, i);
            answer += test.substring(c-1,c);
            
            if( num <= my_string.length() ) {
                num = num + m;  
            }  
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