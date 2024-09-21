# [level 1] 달리는 경주

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/178871)


### 실행문
```java
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> playerIndexHashmap = new HashMap <>();
        for (int i = 0; i < players.length; i++) {
            playerIndexHashmap.put(players[i], i);
        }
        
        for (String calling : callings) {
            
            // 교환할 선수에 index 번호를 가져옴
            int cur_Index = playerIndexHashmap.get(calling);
            
            // 1등이면 교환 할 선수가 없음
            if (cur_Index == 0 ) continue;
            
            // 교환할 선수의 번호
            int pre_Index = cur_Index -1;
            
            // temp박스를 사용해서 위치 교환
            String temp = players[pre_Index];
            players[pre_Index] = players[cur_Index];
            players[cur_Index] = temp;
            
            // Hash에도 업데이트 처리
            playerIndexHashmap.put(players[pre_Index], pre_Index);
            playerIndexHashmap.put(players[cur_Index], cur_Index);
            
        }
        
        return players;
    }
}


class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        String[] answer = new String[players.length];
        String temp = "";
        int num = 0;
        
        for(int i = 0; i < callings.length; i++) {
            for(int j = 0; j < players.length; j++) {
                
                num = j - 1;
                
                if(players[j].equals(callings[i])) {
                    temp = players[num];
                    players[num] = players[j];
                    players[j] = temp;
                }
                
            }
        }
        
        for(int x = 0; x < players.length; x++) {
            answer[x] = players[x];
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
for 문은 어느곳에서든 시간 이슈가 있는 것 같네요.
현업에서도 HashMap을 이용하여 이슈를 해결한적이 있어서 쉬울 것 같았는데, 숨질뻔..
그래도 레벨 1문제를 처음 풀고, 이해를 한다는게 재밌어용
``` 