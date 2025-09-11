# [level 1] 완주하지 못한 선수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java)


### 실행문
```java
import java.util.HashMap; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String p : participant) {
            map.put( p, map.getOrDefault(p, 0) + 1 );
        }
        
        for(String c : completion) {
            map.put( c, map.get(c) -1 );
        }
        
        String answer = "";
        for(String m : map.keySet()) {
            if( map.get(m) != 0 ) {
                answer = m;
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        for (var entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return ""; // 이 줄은 사실 실행 안 됨 (문제 보장상 항상 한 명 존재)
    }
}
```

##### 참고사이트

### 느낀점
```
전에 풀었던 문제가 HashSet()으로 처리한 문제라서, 이문제도 처음에는 HashSet()으로 시작하였습니다.
테스트 3번에 분명 중첩이 있을때도 걸러야했는데, 너무 나중에 알았네요.. 시간을 15분 정도 흘렸는데, 이 부분은 굉장히 중요한 부분인것 같아요.
실제 면접 코딩테스트나 현업의 중요한 이슈때문에 업데이트를 빠르게 해야되는 상황이라고 생각하면 중요한 포인트를 놓치고, 작업을 해버리고 다 패치한 다음에 문제점을 깨달은거니까요.
다행히 지금은 혼자 연습하는거고, 테스트 3번에 있는 중첩을 보니 HashSet() 으로 하면 절대 안되는 문제더라구요.
HashMap() 해야겠다 라고 생각은 했는데, 중첩부분을 한번도 생각해본적이 없어서 조금 더 찾아보니 Key 별로는 중첩이 이루워질수 없다는걸 솔직히 처음 알았습니다.
항상 Key 별로 put(), get() 을 하다보니 왜 이런 부분을 몰랐을까 할정도로 기초적인 부분인데, 지금까지 모를정도로 무뇌로 개발했나 반성했습니다 ㅋㅋㅋ
getOrDefault(), keySet() 같은 메소드도 이번에 처음 본것 같고, 좋은 공부가 된것 같아서 너무 좋습니다 ㅎㅎ

하지만, 아까 위에 말한대로 문제를 정확하게 분석하고, 조건들을 정확하게 확인해야하는데 그 부분을 놓치고 진행했다는 부분
그리고 현업에서 이런일이 벌어지면 큰 일이니 그런 부분은 경력자로써 제 자신한테 크게 실망한 부분 이네요.
재미있었고, 조금 더 경각심을 갖게 하는 문제 였습니다! ㅎㅎ
``` 