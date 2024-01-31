# [level 0] 부분 문자열 이어 붙여 문자열 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181911)


### 실행문
```java
class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        
        for(int i = 0; i < my_strings.length; i++ ) {
            int[] partsin = parts[i];
            answer += my_strings[i].substring(partsin[0], partsin[1] + 1);
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