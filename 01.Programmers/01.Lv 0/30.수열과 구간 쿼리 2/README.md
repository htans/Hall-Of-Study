# [level 0] 수열과 구간 쿼리 2

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181923)


### 실행문
```java
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        
        for (int j = 0; j < queries.length; j++) {
            for (int i = queries[j][0]; i <= queries[j][1]; i++) {
                if (arr[i] > queries[j][2]) {
                    answer[j] = Math.min(answer[j], arr[i]);
                }
            }
            if (answer[j] == Integer.MAX_VALUE) answer[j] = -1;
        }
        return answer;
    }
}
```


##### 참고사이트
1. [참고 링크](https://velog.io/@zhyun/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%88%98%EC%97%B4%EA%B3%BC-%EA%B5%AC%EA%B0%84-%EC%BF%BC%EB%A6%AC-2) 


### 느낀점
```
문제가 이해하기 어렵고, 이해한것 같으면 프로토콜이 코딩으로 나오지 않아서 많이 답답했습니다.
3일정도 풀어보려고 노력했으니, 결국 하지 못했고, 성공하지 못해서 흥미가 떨어졌던것 같습니다.
이로인해, 문제를 2일동안 해결못했으면, 다른 사람들의 정말을 보고, 프로토콜을 이해하고 빠르게 넘어가야겠다는 생각을 했습니다.
문제도 어렵지만, 제 자신을 반성하는 기회가 되었습니다.
그리고 다음부터는 레벨 2인 문제를 풀어야 할 것 같습니다.
정답이든, 오답이든 올해부터터 부딪혀봐야지 뭐... ㅇㅅㅇ;
``` 