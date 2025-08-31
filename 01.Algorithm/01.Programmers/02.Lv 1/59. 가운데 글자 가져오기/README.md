# [level 1] 가운데 숫자 가져오기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12903)


### 실행문
```java
class Solution {
    public String solution(String s) {
        String answer = "";
        int subP = 0;
        
        if(s.length() % 2 == 0) {
            subP = s.length() / 2;
            answer = s.substring( subP-1, subP+1 );
        } else {
            subP = s.length() / 2;
            answer = s.substring( subP, subP+1 );
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(String s) {
        int len = s.length();
        int mid = len / 2;
        // 길이가 짝수면 mid-1 ~ mid+1, 홀수면 mid ~ mid+1
        return (len % 2 == 0) ? s.substring(mid - 1, mid + 1) : s.substring(mid, mid + 1);
    }
}
```

##### 참고사이트

### 느낀점
```
...ㅇㅅㅇ?
``` 

