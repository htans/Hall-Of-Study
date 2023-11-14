# [level 0] 수열과 구간 쿼리 3

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181924)


### 실행문
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < queries.length; i++) {
            int[] inQueries = queries[i];

            int temp = answer[inQueries[0]];
            answer[inQueries[0]] = answer[inQueries[1]];
            answer[inQueries[1]] = temp;
        }

        return answer;
    }
}
```


##### 참고사이트
1. [참고 링크](https://www.appletong.com/entry/) 


### 느낀점
```
코딩테스트를 시작 후 처음으로 정말 오래 걸린것 같습니다.
다 적어놓고 보니 20줄도 안되는 소스지만, '이런 간단한것도 못하는건가?' 하면서 자책을 많이 했던것 같습니다.
회사 핑계로 밀거나, 해외 여행으로 밀어버리는 저의 모습을 다시 반성하면서 항상 배움의 자세로 해야된다는것을 이번 기회에 깨달았습니다.
코딩테스느는 이제 시작이니까, 못해도 된다는 생각으로 가볍게 시작하니 조금조금씩 프로토콜을 생각할 수 있었습니다.
처음에는 answer 배열에 {1, 2, 3, 4}를 넣어놓고 했지만, 단일 테스트문제는 합격이지만,
결과 제출시에 테스트 케이스에서 전부 런타임에러를 볼 수 있었습니다.
당연한 결과이지만 배우는 것이 굉장히 많은 문제 였습니다. 
반성하고 반성하는 시간입니다 ㅎ
``` 