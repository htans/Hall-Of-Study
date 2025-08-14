# [level 0] 주사위 게임 2

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181930)


### 실행문

```java
class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        double result = 0;
        
        if(a != b && b != c && c != a) {
            result = a + b + c;
        } else if(a == b && b == c && c == a) {
            result = (a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
        } else {
            result = (a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        }
        
        answer = (int) Math.ceil(result);
    
        return answer;
    }
}
```


### 느낀점
```
형변환은 여러가지가 있지만, 웹 브라우저에서 호환하는것을 잘 메모하고, 적용하는것이 중요한것 같습니다.
다른분들처럼 최적화된, 짧은 코딩을 하고 싶지만, 문제에 맞는 프로토콜을 생각하고, 필요한 메소드를 적용하는 기초적인 기본부터 배우고 있습니다.
언젠간 나도... 다른분들처럼... 
``` 