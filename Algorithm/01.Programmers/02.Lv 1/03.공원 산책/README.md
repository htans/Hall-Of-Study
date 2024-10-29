# [level 1] 공원 산책

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/172928#)


### 실행문
```java
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int x = 0;
        int y = 0; 
        
        // 시작점 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        } 
        
        // 명령에 따른 이동 처리
        for (int r = 0; r < routes.length; r++) {
            String[] parts = routes[r].split(" ");
            String dir = parts[0];                 // 방향
            int dir2 = Integer.parseInt(parts[1]); // 거리
            
            // 이동 전 현재 좌표를 임시 저장
            int tempX = x;
            int tempY = y;
            
            // 각 명령에 따른 이동 처리
            boolean isValid = true; // 명령이 유효한지 여부
            
            for (int d = 0; d < dir2; d++) {
                int newx = tempX; 
                int newy = tempY;
                
                // 방향에 따른 좌표 이동
                if (dir.equals("E")) {
                    newy++;
                } else if (dir.equals("S")) {
                    newx++;
                } else if (dir.equals("W")) {
                    newy--;
                } else if (dir.equals("N")) {
                    newx--;
                }
                
                // 경계를 벗어나거나 장애물을 만나는 경우
                if (newx < 0 || newx >= park.length || newy < 0 || newy >= park[0].length() || park[newx].charAt(newy) == 'X') {
                    isValid = false; // 명령이 유효하지 않음
                    break;
                }
                
                // 유효하면 좌표를 임시로 업데이트
                tempX = newx;
                tempY = newy;
            }
            
            // 명령이 유효한 경우에만 좌표를 실제로 업데이트
            if (isValid) {
                x = tempX;
                y = tempY;
            }
        }
        
        // 최종 좌표 반환
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
염병 문제 이해하는데만 시간이 꽤 걸렸습니다.
그래프로 문제가 되어 있으니 더 헷갈리네요.
최대한 천천히 프로포콜을 만들면서 했지만, 2시간 이상 걸렸고 처음보는 프로토콜은 아니지만,
문제나 그림으로 이해하려고 하니 너무 어려운것 같네요.
최대한 생각을 단순화 시키고 접근하는 방법을 더 배워야해요.
하지만, 개꿀잼 ㅋ
``` 