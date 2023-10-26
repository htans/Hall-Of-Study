# [level 0] 수 조작하기 1 

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181925)


### 실행문
```java
class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int a = 0;

            for(int i = 0; i < numLog.length; i++) {
                if(i != 0) {
                    
                    a = numLog[i] - numLog[i-1];    
                    
                    if(a == 1) {
                        answer += "w";
                    } else if(a == -1) {
                        answer += "s";
                    } else if(a == 10) {
                        answer += "d";
                    } else if(a == -10) {
                        answer += "a";
                    }
                    
                }
            }
        
        return answer;
    }
}
```


### 느낀점
```
생각보다 문제를 이해하는데 오래 걸렸습니다.
풀어보니 간단하지만, 프로토콜을 생각하는데 엄청 오래 걸렸습니다.
분명. 직전에 풀었던 문제를 반대로 해석할 뿐인데, 프로토콜을 제대로 생각 못하는 제 모습을 보면서 반성을 많이 했습니다.
별것도 아닌것 같은데.... 역시 아직 멀었네요.
``` 