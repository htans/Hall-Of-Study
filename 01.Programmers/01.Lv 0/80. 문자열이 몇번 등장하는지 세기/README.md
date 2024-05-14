# [level 0] 문자열이 몇번 등장하는지 세기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181871)


### 실행문
```java
class Solution {
    public int solution(String myString, String pat) {
        
        int answer = 0;
        
        for(int i = myString.length()-1; i>=0; i--){
            String subStr = myString.substring(0, i+1);
            if(subStr.endsWith(pat)){
                answer++;
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