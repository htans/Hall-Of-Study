# [level 2] 네트워크

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43162)


### 실행문
```java
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            
            Word cur = q.poll();
            
            if(cur.str.equals(target)) {
                return cur.cnt;
            }
            
            for(int i = 0; i < words.length; i++ ) {
                if( !visited[i] && conConver(cur.str, words[i]) ) {
                    visited[i] = true;
                    q.add(new Word (words[i], cur.cnt+1));
                }
            }
        }
        return 0;
    }
    
    
    private boolean conConver (String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++ ) {
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
    
    
    class Word {
        String str;
        int cnt; 
        Word(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // BFS 탐색을 위한 큐 (단어와 변환 횟수를 함께 저장)
        Queue<Word> q = new LinkedList<>();
        
        // words 배열에서 각 단어가 방문되었는지 체크하는 배열
        boolean[] visited = new boolean[words.length];
        
        // 시작 단어(begin)와 단계(0단계)를 큐에 삽입
        q.add(new Word(begin, 0));
        
        // BFS 탐색 시작
        while(!q.isEmpty()) {
            
            // 큐에서 현재 단어 꺼냄
            Word cur = q.poll();
            
            // 현재 단어가 target이면 변환 횟수를 리턴
            if(cur.str.equals(target)) {
                return cur.cnt;
            }
            
            // 아직 방문하지 않은 단어들 중에서
            // 현재 단어와 한 글자 차이 나는 단어를 큐에 추가
            for(int i = 0; i < words.length; i++ ) {
                if( !visited[i] && conConver(cur.str, words[i]) ) {
                    visited[i] = true;  // 방문 처리
                    q.add(new Word (words[i], cur.cnt+1));  // 변환 횟수 +1 해서 큐에 삽입
                }
            }
        }
        
        // target에 도달할 수 없는 경우
        return 0;
    }
    
    // 두 단어가 한 글자만 다른지 확인하는 메소드
    private boolean conConver (String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++ ) {
            if(a.charAt(i) != b.charAt(i)) diff++;  // 글자가 다르면 diff 증가
            if(diff > 1) return false;  // 두 글자 이상 다르면 변환 불가
        }
        return diff == 1;  // 정확히 한 글자만 다를 때 true
    }
    
    // BFS에서 사용할 단어와 변환 단계 저장용 클래스
    class Word {
        String str;  // 단어
        int cnt;     // 지금까지의 변환 횟수
        Word(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
```

##### 참고사이트
1. [참고 링크](https://www.youtube.com/watch?v=cfB61zGu_Y8&t=419s)

### 느낀점
```
오오!! 아직 정말 처음인 역분석 단계지만, 이제 어느정도 감이 잡히고 있습니다.
레벨3을 처음 역분석할때는 딱 소스가 사라지면 머리가 멍 했는데, 이제는 문제의 포인트는 무엇인지, 큐로 왜 구성했는지, BFS 방식을 왜 해야하는지, 큐를 구현할때 어떤식으로 해야할지
테두리가 조금씩 나오고 있는것 같아요.
레벨 3문제를 처음 역분석할때는 이게 뭐지?뭐지? 하면서 3 ~ 5시간 걸렸는데, 지금은 그런것들이 그래도 경험치가 쌓이고, 문법이 조금은 익숙해져서 인지는 모르겠지만, 30 ~ 40분만에 이해한것 같네요.
아직은 매우 느리고, 제 생각대로 문제를 빡 보면 이건 어떤 방식을 써서 구현해야하고, 구현하는 방식에는 뭐 장단점이 있는데, 이것때문에 이걸 써야하고 막 이런식으로 ㅋㅋㅋ 하고싶은데
지금은 많이 풀어보지도 않았고, 조금씩 익숙해져가는게 느껴지니까 재미있어요 ㅎㅎㅎ
마음 편하게 그냥 쭉쭉 해보면 좋을 것 같아요 ㅋㅋㅋ 굳굳 ㄹㅇ 꿀잼
``` 