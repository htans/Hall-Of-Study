# [level 0] 문자열 묶기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181855)


### 실행문
```java
class Solution {
    public int solution(String[] strArr) {
        
        int answer = 0;
        int[] countArr = new int[30];
        for(int i = 0; i < strArr.length; i++) {
            countArr[strArr[i].length()-1]++;
        }
        
        int Max_num = 0;
        for(int max : countArr) {
            if(Max_num < max) {
                Max_num = max;
            }
        }
        
        answer = Max_num;
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
아이고 두야...
``` 