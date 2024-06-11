# [level 0] 문자열 정수의 합

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181849)


### 실행문
```java
class Solution {
    public int solution(String num_str) {
        
        String[] num_arr = num_str.split("");
        int answer = 0;
        
        for(int i = 0; i < num_arr.length; i++) {
            answer += Integer.parseInt(num_arr[i]);;
        }       
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
ㅇㅁㅇ??
``` 