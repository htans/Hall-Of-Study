# [level 1] 명예의 전달 (1)

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/138477)


### 실행문
```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[ score.length ];
        ArrayList<Integer> topScore = new ArrayList<>();
        ArrayList<Integer> ckScore = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++ ) {
            if(topScore.size() < k) {
                topScore.add(score[i]);
                
                ckScore.add( Collections.min(topScore) );
            } else {
                
                topScore.sort( Collections.reverseOrder() );
                int maxValue = Collections.max(topScore);
                int minValue = Collections.min(topScore);
            
                if( minValue < score[i] ) {
                    // 기존값 제거
                    topScore.remove( Integer.valueOf(minValue) );
                    // 새로운값 추가
                    topScore.add( score[i] );
                    ckScore.add( Collections.min(topScore) );
                } else {
                    ckScore.add( Collections.min(topScore) );
                }
            }
        }
        
        for( int x = 0; x < ckScore.size(); x++ ) {
            answer[x] = ckScore.get(x);
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> topScore = new PriorityQueue<>(); // 최소 힙 (최소값이 항상 맨 앞)
        
        for (int i = 0; i < score.length; i++) {
            topScore.add(score[i]);

            // k개 이상이면 최소값 제거 (상위 k개만 유지)
            if (topScore.size() > k) {
                topScore.poll();
            }

            // 현재 저장된 k개의 점수 중 가장 작은 값 기록
            answer[i] = topScore.peek();
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
조금씩 자신감이 붙고 있는데, 코딩테스트를 풀면서 제가 생각해도 if문과 for문이 많아서 걱정이였습니다.
for문이 많을수록 속도에 영향을 주고, 리소스를 많이 잡아먹으니까요.
역시나 G지리는형에게 물어보니 PriorityQueue(우선순위 큐) 라는 메소드가 존재했고, 이를 이용해서 별도에 Sort 및 제거없이
한방에 처리가 가능하네요...
굳굳 넘나 유익한 시간이였습니다 ㅋㅋㅋ 분명 대학교때 배운거같은데.. 초면인 느낌이야...
``` 