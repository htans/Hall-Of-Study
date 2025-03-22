# [level 1] 옹알이 (2)

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/133499)


### 실행문
```java
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String babb : babbling) {
            if (check(babb)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(String babb) {
        String[] chkList = {"aya", "ye", "woo", "ma"};
        
        String prev = "";
        
        while (!babb.isEmpty()) {
            boolean matched = false;

            for (String word : chkList) {
                if (babb.startsWith(word)) {
                    if (word.equals(prev)) {
                        return false;
                    }
                    babb = babb.substring(word.length());
                    prev = word;
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                return false;
            }
        }

        return true;
    }
}
```

### 느낀점
```
레벨 1은 생각보다 프로토콜 개념만 이해하면 쉬운 문제들이 많은 것 같아요.
조금씩 제 소스가 버전업이 되는 것도 느껴지고, 따로 펑션을 구현해서 하는것이 이슈체크하기도 좋고, 디버깅 하기 좋은것 같네요.
조금씩 실력 향상이 되는게 느껴지고, 이제는 시간을 제한하고 임하기 때문에 쓸때없는 생각과 시간낭비 행동보다는 간결하고 정확하게 가는게 제일 좋은것 같아요.
이직을 최근에 생각하면서 코딩테스트를 임하는 자세도 조금 달라지네요.. ㅋㅋ
``` 