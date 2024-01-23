# [level 0] 주사위 게임 3

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181916)


### 실행문
```java
import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        int[] dice = {a, b, c , d};
        Arrays.sort(dice);
        
        int answer = 0;
        if (dice[0] == dice[3]) {
            answer = 1111 * dice[0];
        } else if (dice[0] == dice[2] && dice[0] != dice[3]) {
            answer = (int) Math.pow((10 * dice[0] + dice[3]), 2);
        } else if (dice[3] == dice[1] && dice[1] != dice[0]) {
            answer = (int) Math.pow((10 * dice[1] + dice[0]), 2);
        } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
            answer = (dice[0] + dice[2]) * Math.abs(dice[0] - dice[2]);
        } else if (dice[0] == dice [1] && dice[2] != dice[3]) {
            answer = dice[2] * dice[3]; 
        } else if (dice[1] == dice [2] && dice[3] != dice[0]) {
            answer = dice[3] * dice[0]; 
        } else if (dice[2] == dice [3] && dice[0] != dice[1]) {
            answer = dice[0] * dice[1]; 
        } else {
            answer = dice[0];
        }
            
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
Math.abs는 처음 사용해보는것 같습니다.
아직 멀었지만, 처음 코딩테스트를 공부할때와 지금과 여전히 ㅈ밥이지만, 많이 배우고, 코딩테스트에 대한 재미를 조금은 안것 같습니다.
다른 문제들도 수두룩하고, 어려운 문제들과 많은 이슈들이 있겠지만, 어차피 인간이 한거라는 가벼운 마음으로 임해야 할 것 같습니다.
그리고 실제 업무와 코딩테스트는 전혀 무관하다고 생각했는데, 최근 이슈들을 처리하면서 코딩테스트에서 배운 기본 프로토콜을 가지고, 
어려운 문제지만, 간단하게 풀 수 있는 이슈도 있었고, 이슈를 정리하거나 검증을 통해 처리하는 방법도 실무에 굉장히 도움이 된 것 같습니다.
화이팅
``` 