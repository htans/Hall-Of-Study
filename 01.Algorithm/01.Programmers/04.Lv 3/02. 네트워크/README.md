# [level 3] 네트워크

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43162)


### 실행문
```java
class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++ ) {
            if( !visited[i] ) {
                dfs(i, visited, computers, n);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int node, boolean[] visited, int[][] computers, int n) {
        
        visited[node] = true;
        
        for(int j = 0; j < n; j++ ) {
            if(computers[node][j] == 1 && !visited[j]) {
                dfs(j, visited, computers, n);
            }
        }
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int n, int[][] computers) {
        
        // 각 컴퓨터 방문 여부 체크 배열
        boolean[] visited = new boolean[n];
        
        // 네트워크 개수 (최종 답)
        int count = 0;
        
        // 모든 컴퓨터를 순회
        for(int i = 0; i < n; i++ ) {
            
            // i번째 컴퓨터를 아직 방문하지 않았다면 → 새로운 네트워크 시작점
            if( !visited[i] ) {
                
                // 해당 컴퓨터와 연결된 모든 컴퓨터 방문 처리 (DFS 탐색)
                dfs(i, visited, computers, n);
                
                // 네트워크 하나 완성 → 개수 증가
                count++;
            }
        }
        
        // 네트워크 총 개수 반환
        return count;
    }
    
    // 깊이 우선 탐색 (DFS)
    private void dfs(int node, boolean[] visited, int[][] computers, int n) {
        
        // 현재 노드 방문 처리
        visited[node] = true;
        
        // 현재 컴퓨터(node)와 연결된 다른 컴퓨터(j) 탐색
        for(int j = 0; j < n; j++ ) {
            
            // 1. 연결되어 있고
            // 2. 아직 방문하지 않은 컴퓨터라면
            if(computers[node][j] == 1 && !visited[j]) {
                
                // j번 컴퓨터도 DFS로 탐색
                dfs(j, visited, computers, n);
            }
        }
    }
}
```

##### 참고사이트
1. [참고 링크](https://www.youtube.com/watch?v=cfB61zGu_Y8&t=419s)

### 느낀점
```
재귀함수라니!!@#!@$!$
확실히 처음 사용할때보다는 어떤식으로 사용해야할지 감도오고, 이해도 쏙쏙 됩니다.
처음에는 이해하는데 3시간 정도 걸렸는데, 이번에는 쏙쏙 이해했어요!

문제는 결국에 연결된 네트워크 범위를 반환하는 문제인데, 각 열이 컴퓨터에 연결된 숫자 네요.
처음에는 이상하게 이해하고, 이상한게 이해한걸로 예제도 풀리길래 어어?? 뭐지?? 했는데, 설명 듣고다니 식겁했어요.

n = 3
computers = [
 [1, 1, 0],
 [1, 1, 0],
 [0, 0, 1]
]
이렇게 보면 결국에 첫번째 컴퓨터는 자기자신, 두번째랑 연결되어있고, 3번째는 연결안된거네요. 
진짜 문제 자체가 낯선것도 있지만, 문제가 어려워질수록 설명이나 여러 함정이 있을 수 있다는 생각을 조금 했어요. 물론 내 문제겠지... 

결론은 DFS에 관한 문제였고, DFS는 재귀함수로 연결되기 때문에 처음 재귀함수를 사용했을때보다는 익숙해서 이해할 수 있었습니다.
걍 방문안한 컴퓨터를 하나 탐색해서 방문안한거네?? ㅇㅇ 그러면 네트워크 추가! 하고 음.. ㄱㄷㄱㄷ 너랑 연결된 컴퓨터 다 찾아와 썅(재귀함수) 찾으면 방문처리하고! 
쭉 돌다보면 방문안한 컴퓨터가 또 있네? == 네트워크 발견 이네요.
진짜... 존경... 재밌... ㅋㅋㅋ
이번 문제도 너무 좋아용
``` 