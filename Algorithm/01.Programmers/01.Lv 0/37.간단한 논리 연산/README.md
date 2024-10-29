# [level 0] 간단한 논리 연산

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181917)


### 실행문
```java
class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        boolean a1 = true;
        boolean a2 = true;
        
        if((x1 == true) || (x2 == true)) {
            a1 = true;
        } else {
            a1 = false;
        }
        
        if((x3 == true) || (x4 == true)) {
            a2 = true;
        } else {
            a2 = false;
        }

        if((a1 == true) && (a2 == true)) {
            answer = true;
        } else {
            answer= false;
        }
         
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
세상에... (x1 ∨ x2) ∧ (x3 ∨ x4) 이런 기호는 처음보고, 당황했습니다...
아주 기초적인 문제 같지만, 기호도 모르는 저를 보고 반성합니다..
소스도 분명하게 더 줄일 방법도 있고, 좋은 프로토콜이 있겠지만, 지금은 문제 푸는것에 집중하겠습니다.
``` 