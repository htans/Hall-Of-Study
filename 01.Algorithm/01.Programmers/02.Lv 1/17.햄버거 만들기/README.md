# [level 1] 햄버거 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/133502)


### 실행문
```java
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder str = new StringBuilder();
        String target = "123";
        
        for(int i = 0; i < ingredient.length; i++ ) {
            str.append(ingredient[i]);
        }
        
        answer = str.toString().split(target, -1).length -1;
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int count = 0;  // 포장된 햄버거 개수
        Stack<Integer> stack = new Stack<>();

        for (int num : ingredient) {
            stack.push(num);  // 재료 추가
            
            // 스택에 햄버거 패턴이 있는지 확인 (뒤에서 4개가 [1,2,3,1]인지)
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 1) == 1) {
                    
                    // 햄버거 패턴 발견 → 4개 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    count++;  // 포장된 햄버거 개수 증가
                }
            }
        }
        
        return count;
    }
}
```

##### 참고사이트
1. [참고 링크](https://velog.io/@hyhy9501/3-1.-%EC%8A%A4%ED%83%9DStack)

### 느낀점
```
처음에는 Split() 으로 해당 배열에서 햄버거배열이 속한 갯수만 뽑으면 되는건줄 알았습니다.
그런데 채점을 하니 정확도가 33%가 나와서 어떤것이 문제인지 처음부터 다시 이해하고 시작하느라 시간이 생각보다 오래 걸렸네요.
현업에서도 Stack 과 Queue를 쓰긴하지만, 정해진 틀 안에서만 사용하고 이용하던대로만 이용하니 사용하면서도 정확하게 모르고, 정확하게 모르니 활용도 못하는 제 자신이 부끄럽네요.
쳇형님을 통해서 Stack를 이용해서 푸는것이 더 좋은 방법이라는것을 깨달았고 처음부터 다시 공부하면서 이해하니 조금은 이해가 되었습니다.
세상은 넓고, 전 왜 바보일까요? ㅋㅋㅋㅋㅋㅋ 굳
``` 