# [level 2] 프로세스

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42587)


### 실행문
```java
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++ ) {
            q.add(new int[] {i, priorities[i] });
        }
        
        int answer = 0;
        while( !q.isEmpty() ) {
            
            int[] cur = q.poll();
            int idx = cur[0];
            int value = cur[1];
            
            boolean hasBig = false;
            for(int[] doc : q) {
                if(doc[1] > value) {
                    hasBig = true;
                    break;
                }
            }
             
            if(hasBig) {
                q.add(cur);
            } else {
                answer++;
                if(idx == location ) return answer;
            }
            
        } 
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++ ) {
            q.add(new int[] {i, priorities[i] });
        }
        
        int answer = 0;
        while( !q.isEmpty() ) {
            
            int[] cur = q.poll();
            int idx = cur[0];
            int value = cur[1];
            
            boolean hasBig = false;
            for(int[] doc : q) {
                if(doc[1] > value) {
                    hasBig = true;
                    break;
                }
            }
             
            if(hasBig) {
                q.add(cur);
            } else {
                answer++;
                if(idx == location ) return answer;
            }
            
        } 
        
        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
큐/스택을 바로 직전에 풀어봐서 그런지 감은 제대로 잡혀있던것 같아요.
다만, 큐 스택도 이중배열로 저장가능한지는 처음 알았네요.
문제의 요는 큐에 <자릿수, 값> 으로 일단 다 밀어넣고, while로 큐가 아무것도 없을때까지 돌면서 큰게 있는지 체크하고,
poll() 로 이미 뺏는데, 큰게 있다! 라면 우선순위가 더 높은 큐가 있는거니까, 다시 add()로 큐에 뒤로 넣어주면 되네요.
idx 랑 요구한 location이랑 동일하면 그 큐를 물어본거였으니까, return answer를 넣어서 실제 몇번째로 실행되는지 반환하면 끝!!

확실히 문법이나 생각하는 방법이 처음에 0레벨 시작했을때보다 늘어난게 제가 느껴져요!!
하지만, 아직 배울게 많고 문법이나 메소드, while( q.isEmpty() ) { 이렇게 해놓고 어?? 왜 안들어가지?? 하고 시간 허비... ㅋㅋㅋㅋㅋ
이번 문제도 너무너무 재미있었습니다 ㅎㅎㅎㅎㅎ
``` 