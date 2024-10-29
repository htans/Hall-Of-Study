# [level 0] 특정한 문자를 대문자로 바꾸기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181873)


### 실행문
```java
class Solution {
    public String solution(String my_string, String alp) {
        
        String[] strArray = my_string.split("");
        String answer = "";
        
        for(int i = 0; i < strArray.length; i++ ){
            if(strArray[i].equals(alp)) {
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