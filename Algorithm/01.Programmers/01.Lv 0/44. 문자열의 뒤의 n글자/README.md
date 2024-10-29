# [level 0] 문자열의 뒤의 n글자

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181910)


### 실행문
```java
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";

        int num = my_string.length() - n;
        answer = my_string.substring(num);
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ
``` 