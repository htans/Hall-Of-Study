# [level 0] A 강조하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181874)


### 실행문
```java
class Solution {
    public String solution(String myString) {
        
        String strArray[] = new String[myString.length()];
        String answer = "";
        
        strArray = myString.split("");
        
        for(int i = 0; i < strArray.length; i++) {
            
            if(strArray[i].equals("a") || strArray[i].equals("A")) {
                answer += strArray[i].toUpperCase();
            } else {
                answer += strArray[i].toLowerCase();
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