# [level 2] 주식가격

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42584)


### 실행문
```java
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < n; i++ ) {
            while( !s.isEmpty() && prices[s.peek()] > prices[i] ) {
                int idx = s.pop();
                answer[idx] = i - idx;
            }
            s.push(i);
        }
        
        while( !s.isEmpty() ) {
            int idx = s.pop();
            answer[idx] = n-1 - idx; 
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < n; i++ ) {
            while( !s.isEmpty() && prices[s.peek()] > prices[i] ) {
                int idx = s.pop();
                answer[idx] = i - idx;
            }
            s.push(i);
        }
        
        while( !s.isEmpty() ) {
            int idx = s.pop();
            answer[idx] = n-1 - idx; 
        }
        
        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
문제를 읽어보고, 결국에 이중for문을 돌려서 하면 해결될 문제가 아닌가? 했습니다만.
카테고리가 큐/스택 이고 이중for문은 딱 생각해도 숫자가 많아지고, 배열이 많아지면 리소스에 부담이 되고, 시간이 오래 걸릴게 뻔하니까 
그걸 해결하는 방법으로 큐/스택을 이용해서 하는걸 알려줄게! 라는 의도가 보였습니다.

미리 answer에 대한 배열을 선언해두고, stack 배열에서 peek() 메소드를 사용하여 직전 값과 비교하여 작아지면 stack배열에서 바로 pop() 해서
answer 배열에 i - idx; 를 반환하여 여기서 초라고 얘기하는 자리수 만큼 answer에 바로 뿍뿍 놓는거네요.

그리고 계산이 끝나면 다시 stack 배열이 없어질때까지 돌아서 '아까 계산했는데, 아직 남은 자리분들 이리오세염' 하면서 다 끌어와서
answer[idx] = n-1 - idx; 를 하여 (전체길이 - 자기번호) 하면 빠지지 못한 배열들까지 구할 수 있는거네요.

항상 코딩테스트에는 바로 계산하여, answer 배열을 생성해서 넣어주거나, 바로 return 해버리는 경우가 많았는데
이번 문제는 미리 answer 배열을 선언해놓고, 하나씩 하나씩 교체하는게 재미있는 문제 였습니다.
이런 문제들을 생각하시는 분들은 머리가 얼마나 좋은걸까... 크흐... 존경띠
``` 