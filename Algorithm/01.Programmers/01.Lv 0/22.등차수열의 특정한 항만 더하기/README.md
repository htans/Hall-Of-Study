# [level 0] 등차수열의 특정한 항만 더하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181931)


### 실행문

```java
class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        for(int i = 0; i < included.length; i++ ) {
            if(included[i]) {
                answer = answer + (a + (d * i)); 
            }
        }
        
        return answer;
    }
}
```


### 느낀점
```
ㅋ
``` 