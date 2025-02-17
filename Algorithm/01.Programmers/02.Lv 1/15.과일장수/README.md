# [level 1] 과일장수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/135808)


### 실행문
```java
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // PriorityQueue 선언
        PriorityQueue<Integer> boxList = new PriorityQueue<>(Comparator.reverseOrder());
        
        for( int i = 0; i < score.length; i++ ) {
            boxList.offer(score[i]);
        }
        
        // 최하의 사과를 가져와야함
        int resetCnt = 1;
        while( !boxList.isEmpty() ) {
            if( resetCnt == m ) {
                answer += boxList.poll() * m;
                resetCnt = 1;
            } else {
                boxList.poll();
                resetCnt++;
            }
            
        }
        
        return answer;
    }
}

```

### ChatGPT
```java
import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // 배열을 내림차순 정렬
        Arrays.sort(score);
        
        int resetCnt = 1;
        for (int i = score.length - 1; i >= 0; i--) { // 큰 값부터 처리
            if (resetCnt == m) {
                answer += score[i] * m;
                resetCnt = 1;
            } else {
                resetCnt++;
            }
        }

        return answer;
    }
}

```

##### 참고사이트


### 느낀점
```
처음으로 레벨1문제 답게 푼것 같아요.
PriorityQueue 클래스를 분명 공부는 했지만, 이렇게 알고리즘에서 본건 처음이였네요.
연관되어 있는 poll(), add() 의 차이점도 있고, 매번 .size, .length 같은 메소드만 쓰다가 이번에 된통 당했네요.
Queue for문으로 이용하면 사이즈가 줄어들기 때문에 거기에서 한참 헤매고 찾아봤던 것 같네요.
다행히 차분히 찢어보니 문제부분을 알 수 있었고, 덕분에 처음써보는 클래스와 메소드로 가득 채운것 같아서 기분이 좋습니다.
쳇형님은 역시나 엄청난 솔루션을 보여주는데... ㅋㅋㅋ 개꿀잼이네용
``` 