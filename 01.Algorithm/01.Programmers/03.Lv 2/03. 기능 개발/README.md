# [level 2] 기능 개발

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42586)


### 실행문
```java
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 큐 배열 선언
        Queue<Integer> q = new LinkedList<>();
        
        // 남은 일수 큐 배열에 넣기
        for(int i = 0; i < progresses.length; i++ ) {
            int remain = 100 - progresses[i];
            int days = (remain + speeds[i] - 1) / speeds[i];
            q.add(days);
        }
        
        // 남은 일 수로 계산해서 List에 일단 넣어
        List<Integer> resume = new ArrayList<>();
        
        while( !q.isEmpty() ) {
            int cur = q.poll();
            int count = 1;
            
            while ( !q.isEmpty() && q.peek() <= cur ) {
                q.poll();
                count++;
            }
            resume.add(count);
        }
        
        return resume.stream().mapToInt(i -> i).toArray();
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        // 1. 각 작업의 배포까지 필요한 일수 계산 후 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (remain + speeds[i] - 1) / speeds[i]; // 올림 처리
            q.add(days);
        }
        
        // 2. 큐 순회하면서 배포 묶음 만들기
        List<Integer> result = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int cur = q.poll();   // 현재 기준
            int count = 1;        // 최소 1개는 배포됨
            
            while (!q.isEmpty() && q.peek() <= cur) {
                q.poll();
                count++;
            }
            
            result.add(count);
        }
        
        // 3. List → int[] 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
```

##### 참고사이트

### 느낀점
```
큐/스택은 솔직히 대학교에서 아 이런 수업이 있었지?? 오오 신기하네 파이프로 생각하면 좀 편하겠네? 라는 생각밖에는 없습니다 ㅋㅋㅋㅋㅋㅋㅋ
현업에서도 큐/스택 구조를 이용해서 어떤 기능을 개발하거나 제 스킬이 부족해서 그 구조를 생각하면서 개발에 이어진 경험이 없었습니다.
Queue<Integer> q = new LinkedList<>)(); 같은 선언문도 솔직히 이번 코딩테스트를 통해서 처음 본것 같아요....
이번 문제의 흐름은 결국에 작업에 순서에 따라 뒷 작업도 배포일정에 포함인지 아닌지 판별하고, 배포되는 카운트값을 주는건데
큐 배열을 하나 만들어서 거기에 남은 일수를 넣어놓고, 그걸 while 로 돌면서 뒷 부분을 체크해서 카운팅하고, 그걸 뱉어주는 형식이였습니다.
당연히 어렵지만, 어쩌면 어려운건 당연하거고, 이런식으로 큐/스택 구조를 활용해서 개발이 되고, 어떤 원하는 값을 얻어낼 수 있다는것이 신기하고 재미있었네요!!
아직 문법이나 여라가지면에서는 어색하지만, 꾸준히 하다보면 익숙해지지 않을까 생각해봅니다 ㅎㅎㅎ

이번 문제도 너무 재미있었어요 ㅎㅎㅎㅎ 굳굳
``` 