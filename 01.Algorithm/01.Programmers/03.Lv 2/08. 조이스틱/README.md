# [level 2] 조이스틱

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42860)


### 실행문
```java
class Solution {
    public int solution(String name) {
        
        int l = name.length();
        int answer = 0;
        
        // 1. 알파벳 계산
        for(int i = 0; i < l; i++ ) {
            char c = name.charAt(i);
            answer += Math.min( c - 'A', 'Z' - c + 1 );
        }
        
        // 2. 이동거리 계산
        int move = l - 1; // 전체 다 움직였을때 길이 == 초기값
        for(int i = 0; i < l; i++ ) {
            // 다음에 'A' 인지 체크
            int next = i + 1;
            while( next < l && name.charAt(next) == 'A' ) {
                next++;
            }
            // i 지점에서 방향을 바꾸는 경우
            move = Math.min (
                move,
                i + l - next + Math.min(i, l - next)
            );
        }
        
        return answer + move;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(String name) {
        
        int l = name.length();
        int answer = 0;
        
        // 1. 알파벳 계산
        for(int i = 0; i < l; i++ ) {
            char c = name.charAt(i);
            answer += Math.min( c - 'A', 'Z' - c + 1 );
        }
        
        // 2. 이동거리 계산
        int move = l - 1; // 전체 다 움직였을때 길이 == 초기값
        for(int i = 0; i < l; i++ ) {
            // 다음에 'A' 인지 체크
            int next = i + 1;
            while( next < l && name.charAt(next) == 'A' ) {
                next++;
            }
            // i 지점에서 방향을 바꾸는 경우
            move = Math.min (
                move,
                i + l - next + Math.min(i, l - next)
            );
        }
        
        return answer + move;
    }
}
```

##### 참고사이트

### 느낀점
```
조이스틱 ㄹㅇ 하ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
조이스틱 문제 만드신분 만나뵙고 싶다 ^ㅁ^*
일단, 다 이해는 했고, 머리에 들어갔는데, 내일 정신 말짱할때 다시 풀어보고 후기 달아야겠음.
``` 