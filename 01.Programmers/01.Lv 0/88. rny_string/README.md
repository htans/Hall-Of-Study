# [level 0] rny_string

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181863)


### 실행문
```java
class Solution {
    public String solution(String rny_string) {
        
        String[] strArray = rny_string.split("");
        String answer = "";
        
        for(int i = 0; i < strArray.length; i++) {
            if(strArray[i].equals("m")) {
                answer += "rn";
            } else {
                answer += strArray[i];
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