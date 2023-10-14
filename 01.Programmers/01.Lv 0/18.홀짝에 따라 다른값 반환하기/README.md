# [level 0] 홀짝에 따라 다른값 반환하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181935)


### 실행문

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n % 2 == 0) {
            for(int i = 2; i <= n; i+= 2) {
                answer += i * i;
            }
        } else {
            for(int i = 1; i <= n; i+= 2){
                answer += i;
            }
        }
        
        return answer;
    }
}
```


### 느낀점

```
처음에는 문제를 읽고, 막막했었습니다.
제곱이라는 표현도 익숙하지 않았고, 문장도 요목조목 길어서 막막함이 먼저 밀려왔던 것 같습니다.
하나씩 풀어보자는 생각으로 전체적인 프로토콜과 입출력 예시를 보면서 해보니, 어려운 문제가 아니였었습니다.
문제를 많이 풀어보고 문제에 성격이나 문장 그리고 막막함 보다는 할 수 있는것을 컴파일 해보면서 진전해보는것이 중요한것 같습니다.
익숙하지 않고, 못하는것이 당연한데... 가끔 제 자신이 실망스럽네요.
앞으로 더 노력해야 할 것 같습니다.
``` 
