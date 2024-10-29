# [level 0] 공백으로 구분하기 2

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181868)


### 실행문
```java
class Solution {
    public String[] solution(String my_string) {
        
        String[] strArray = my_string.split(" ");
        int ArraySize = 0;
        for(int i = 0; i < strArray.length; i++ ) {
            if(strArray[i].trim().length() > 0) {
                ArraySize++;
            }
        }
        
        String[] answer = new String[ArraySize];
        int ArrayNum = 0;
        for(int j = 0; j < strArray.length; j++ ) {
            if(strArray[j].trim().length() > 0) {
                answer[ArrayNum] = strArray[j];
                ArrayNum++;
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