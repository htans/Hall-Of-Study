# [level 0] 조건 문자열

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181934)


### 실행문

```java
class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        if(eq.equals("=")) {
            if(ineq.equals("<")) {
                if(n <= m) {
                    answer = 1;
                } else {
                    answer = 0;
                }
            } else {
                if(n >= m) {
                    answer = 1;
                } else {
                    answer = 0;
                }
            }
                
        } else {
            if(ineq.equals("<")) {
                if(n < m) {
                    answer = 1;
                } else {
                    answer = 0;
                }
            } else {
                if(n > m) {
                    answer = 1;
                } else {
                    answer = 0;
                }
            }
        }
        
        return answer;
    }
}
```


### 느낀점

```
== 로 필터링 될거라는 생각을 했던 저를 반성합니다...
eq.equals 도 매번 사용하는건데... 핑계는 하지 않겠습니다.

if 문이 너무 많이 들어가서 다른분들은 어떻게 했는지 참고 했는데.. 
역시 쩌는 형님들은 너무 많습니다.
문제를 풀어내는것도 중요하지만, 어떻게 풀었냐는것을 조금은 알 수 있었습니다.
``` 


### 참고 풀이

```java
import java.util.Map;
import java.util.function.BiFunction;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        Map<String, BiFunction<Integer, Integer, Boolean>> functions = Map.of(
                ">=", (a, b) -> a >= b,
                "<=", (a, b) -> a <= b,
                ">!", (a, b) -> a > b,
                "<!", (a, b) -> a < b
        );

        return functions.get(ineq + eq).apply(n, m) ? 1 : 0;
    }
}
```