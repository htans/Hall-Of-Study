# [level 1] 콜라 문제

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/132267?language=java)


### 실행문
```java
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        boolean chkFlag = false;
        int totalCnt = n;
    
        while(!chkFlag) {
            
            if(totalCnt < a) {
                chkFlag = true;
            } else {
                int exch = (totalCnt / a) * b;
            
                answer += exch;
                totalCnt = (totalCnt % a) + exch;
            }
            
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int totalCnt = n;

        while (totalCnt >= a) {
            int exchanged = (totalCnt / a) * b; // 교환해서 받는 콜라 수
            answer += exchanged;
            totalCnt = (totalCnt % a) + exchanged; // 남은 병 + 새로 받은 병
        }

        return answer;
    }
}

```

### 느낀점
```
제가 작성하는 소스와 챗형 소스를 보면가독성과 필요없는 부분이 많이 들어가있다고 생각되네요.
챗형이 해준 소스를 공부하면서 이제는 문제 풀이와 정확도도 중요하지만,
줄일 수 있는 부분이 있는지, 필요없는 로직은 넣었는지 체크도 해봐야하지 않을까 생각됩니다. 역시.. ㅋㅋ
그래도 이번 문제도 너무나도 재미있었네요.
교환해서 받은 b. 교환 받는 갯수를 생각못해서 머리 터질뻔 ㅎㅎ
``` 