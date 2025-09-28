# [level 3] 디스크 컨트롤러

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42627)


### 실행문
```java
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort( jobs, (a, b) -> a[0] - b[0] );
        
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> {
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );
        
        int n = jobs.length;
        int idx = 0;
        int curTime = 0;
        int totalTime = 0;
        
        while( idx < n || !q.isEmpty() ) {
            while( idx < n && jobs[idx][0] <= curTime) {
                q.add(jobs[idx]);
                idx++;
            }

            if( q.isEmpty()) {
                curTime = jobs[idx][0];
            } else {
                int[] job = q.poll();
                curTime += job[1];
                totalTime += curTime - job[0];
            }
        }
        
        return totalTime / n;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // 1. 요청 시각 기준 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 2. 우선순위 큐 (소요시간 → 요청시각 → 번호 순)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );
        
        int n = jobs.length;
        int idx = 0;       // 아직 큐에 안 넣은 작업 index
        int curTime = 0;   // 현재 시간
        int total = 0;     // 전체 응답시간 합
        
        // 3. 모든 작업이 끝날 때까지 반복
        while (idx < n || !pq.isEmpty()) {
            
            // 현재 시간까지 들어온 작업들 큐에 삽입
            while (idx < n && jobs[idx][0] <= curTime) {
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (pq.isEmpty()) {
                // 실행할 작업이 없으면 시간 점프
                curTime = jobs[idx][0];
            } else {
                // 실행할 작업 꺼내기
                int[] job = pq.poll();
                curTime += job[1];  // 작업 수행
                total += curTime - job[0]; // 응답시간 = 완료시각 - 요청시각
            }
        }
        
        return total / n; // 평균 응답시간
    }
}
```

##### 참고사이트

### 느낀점
```
오우 우선순위 큐가 한번 더 나와서 너무 반가웠어요.
한번 삽질을 해봐서 그런지, 이해하는데 큰 도움이 되었습니다.

문제는 결국 평균 작업시간을 반환해라! 이건데, 우선 정렬로 소요시간, 요청시간을 체크해서 미리 정렬을 해놓고,
while 로 돌리면서 나오는 작업들을 q에 밀어넣고, 꺼내면서 작업수행시간, 전체시간을 계속 누적해가면서 일들을 처리하는게 포인트네요.
특히, while ( idx < n && jobs[idx][0] <= curTime) 이 포인트가 제일 중요한것 같네요.
curTime 변수는 작업이 끝난 시간을 나타내고 있기 때문에, 요청시간 기준으로 끝난 작업인지 아닌지, 큐에 태워야할애인지 아닌지 알 수 있으니까요.

문제만 보면 여러 그림과 헷갈리는 함정들이 많은데, 오히려 포인트를 정리하고 소스로 빼놓으니 생각보다는?? 간단한 문제이지 않을까 생각합니다 ㅋㅋㅋ
그리고 너무 재미있는데... 매번 새로운것들이 튀어나와서 너무 존경.. ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
``` 