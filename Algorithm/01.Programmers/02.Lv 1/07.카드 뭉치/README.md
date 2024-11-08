# [level 1] 카드 뭉치

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/159994?language=java)


### 실행문
```java
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int card1_num = 0;
        int card2_num = 0;
        
        for(int i = 0; i < goal.length; i++ ) {
            if ( goal[i].equals(cards1[card1_num]) ) {
                if(card1_num+1 < cards1.length ) {
                    card1_num++;     
                }
            } else if( goal[i].equals(cards2[card2_num]) ) {
                if(card2_num+1 < cards2.length ) {
                    card2_num++;     
                }
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1_num = 0, card2_num = 0;

        for (String g : goal) {
            if (card1_num < cards1.length && g.equals(cards1[card1_num])) {
                card1_num++;
            } else if (card2_num < cards2.length && g.equals(cards2[card2_num])) {
                card2_num++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}

```

##### 참고사이트


### 느낀점
```
확실히 코딩테스트를 조금 풀었다고 문제를 먼저 파악하고, 하나씩 천천히 프로토콜을 작성하는 방법을 배운것이 제 스스로도 느껴지기 시작했습니다.
그리고 개선되어야 할 부분이 보이기 시작했고, 일단 테스트를 통과하고, 제출을 하는게 제일 큰 목표니까
문제를 해결하는 프로토콜을 먼저 짜놓고, 개선할 부분을 천천히 건드는걸로 해야겠네요.

작성하면서 간결하고, 심플한 코드를 작성하는게 다들 원하고, 좋은 자세라고 생각하겠지만,
제 실력과 제 페이스상으로는 아직 많이 힘드네요.
제 페이스대로 천천히 해보는걸로 집중하겠습니다!

그리고 GPT형;; 짱이다;;
``` 