# [level 2] 게임 맵 최단거리

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/1844)


### 실행문
```java
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        
        q.add(new int[] {0, 0, 1});
        v[0][0] = true;
        
        while( !q.isEmpty() ) {
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            
            // 1. 탈출 조건
            if( x == n-1 && y == m-1) {
                return d;
            }
            
            // 2. 동작 구현
            for(int i = 0; i<4; i++) {
                
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 벗어나지 않는지 체크
                if(
                    nx >= 0 &&
                    ny >= 0 &&
                    nx < n &&
                    ny < m
                ) {
                    // 실제 구현
                    if( !v[nx][ny] && maps[nx][ny] == 1) { 
                        q.add(new int[]{nx, ny, d+1});
                        v[nx][ny] = true;
                    }   
                }
            }
            
        }
        
        return -1;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 방향 벡터 (상, 하, 좌, 우)
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 (0,0), 거리=1
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            // 목표 도착
            if(x == n-1 && y == m-1) {
                return dist;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if( 
                    nx >= 0 && 
                    ny >= 0 && 
                    nx < n &&
                    ny < m
                ) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist+1});
                    }
                }
            }
        }
        
        return -1; // 도착 못함
    }
}
```

##### 참고사이트

### 느낀점
```
바로 직전 타겟넘버 문제가 DFS 방식의 포로토콜을 접근하는거였다면, 게임 맵 최단거리는 BFS 방식을 이용해서 푸는 거였네요.
솔직히 이제 문제들이 뭔가 ㅋㅋㅋ 이전에 풀었던 문제들보다 그림과 내용들이 상당히 많아지고, 복잡해지고 있어요..... ㅋㅋㅋㅋ
무튼 코어는 Boolean, Queue를 이용해서 하는 방식인데
걍 짧게

visited[][] 배열을 똑같이 만들고 거기에는 내가 방문 했는지 안했는지,
Queue에는 실제 네비게이션 처럼 갈곳을 넣는거고,

Qeuee는 int[] 배열인데, {0, 0, 1} 이렇게 세자리가 들어가고, 
첫번째는 x == 세로 값
두번째는 y == 가로 값
세번째는 d == 이동 값 
* 수학에는 x가 가로인데 뭔 환장이지? 하면서 생각해보니, 배열은 test[x][y]니까 소스상에선 x를 세로, y를 가로로 하는것이 건강에 좋다는걸 알아버렸습니다. 모르고싶었는데... ㅠ
처음에 0,0,1 처럼, 내가 길동이를 역에 내려주면서 '야!! 여기까지가 한 10분거리야!!' 해주는거고, 거기에서 4방향을 가보면서 실제 가도 되는길인지==1인지 확인하고, 맞으면 Queue에 넣을때 vistied배열에도 체크하고, dist+1 를 하기 때문에
다른 경로도 있는데, 그게 나오면 어떻게 하지? 생각했는데 이미 최단경로를 찾으면 return dist; 뽁 때리기때문에 걱정할 이유가 없었음
걍 그림자 분신 쓰고 황금 찾아! 찾았네? 펑 하고 다 사라지는거임

이번 문제도 너무 재미있었는데, 점점 더 어려워지고, 점점 더 ㅋㅋㅋ 머리가 아파오고 있네요.
하지만 진짜 그 이해했을때 짜릿함 ㅎㅎㅎㅎㅎㅎ 
``` 