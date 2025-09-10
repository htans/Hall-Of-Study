# [level 1] [PCCP 기출문제] 10번 - 공원

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/340198)


### 실행문
```java
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        int n = park.length;
        int m = park[0].length;
        
        int[][] dp = new int[n][m];
        int maxNum = 0;
        
        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < m; j++) {
                if (park[i][j].equals("-1")) {
                    if( i == 0 || j == 0 ) {
                          dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(
                            // 정사각형 체크
                            Math.min(dp[i-1][j], dp[i][j-1]),
                            dp[i-1][j-1]
                        );
                    }   
                    
                    maxNum = Math.max(maxNum, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        int answer = -1;
        for(int size : mats) {
            if(size <= maxNum) {
                answer = Math.max(answer, size);
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;

        int[][] dp = new int[n][m];
        int maxSquare = 0;

        // DP 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isEmpty(park[i][j])) {
                    dp[i][j] = (i == 0 || j == 0) 
                        ? 1 
                        : 1 + Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]
                          );

                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }

        // 지민이가 가진 돗자리 중에서 선택
        int answer = -1;
        for (int size : mats) {
            if (size <= maxSquare) {
                answer = Math.max(answer, size);
            }
        }

        return answer;
    }

    // 헬퍼 메서드: 빈칸인지 체크
    private boolean isEmpty(String cell) {
        return "-1".equals(cell);
    }
}
```

##### 참고사이트

### 느낀점
```
이번 문제는 도형으로 문제가 나와있고, 정말 처음 보는 유형의 문제라서 너무 어려웠습니다.
처음에는 for문으로 하나씩 "-1"==빈자리 이면 정사각형 모양을 다 체크해야되나?? 아닌데 그러면 리소스가 많이 돌아서 분명 시간이 오래걸리고, 그건 리소스 낭비로 이어지니까 이건 아니야! 라는 생각으로
이런저런걸 많이 풀어봤지만, 전혀 몰라서 이번에도 역시 30분 정도 고민하다가 구글링과 챗형님의 힘을 빌렸습니다.

일단, 제가 처음에 생각한 방식은 브루트포스 방식이라고 하고, 시간이 오래걸리기 때문에 적합한 방법이 아니라고 하네요.
그럼 어디에 적합한지 궁금해서 찾아봤는데 입력 크기가 아주 작을때, 최대 크기를 찾는게 아니라 특정 크기를 찾을때, 최적화가 필요없을때 라고 하네요.
새로 찾은 방식은 DP 방식이였고, 새로운 DP배열을 똑같이 선언해서 거기에 정사각형을 체크하여 숫자를 증가시키는 형식이였네요.
글로는 간단해보이지만, 생각보다 이해하는데 오래 걸렸습니다.
거두절미하고 핵심로직은 dp[i][j] = 1 + Math.min( Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] ); 인데, 말그대로 해당 기준을 오른쪽 가장밑으로 해놓고, 정사각형의 해당하는 부분을 불러와서
Math.min() 을 이용해서 체크하는 방식이였습니다....
크흐... 진짜 이런생각을 하시는 분들 대단.... ㅋㅋㅋㅋㅋ
처음에는 아아아 뭐영뭐여 했는데, 이해하고 나니 너무나도 신기하고 재미있습니다.
늘 그렇지만, 이해한다음 전부 초기화 하고 프로세스를 생각하면서 다시 짜는데 min()을 넣을자리에 max() 넣고 이렇고저렇고 ㅋㅋㅋ 난리였네요.

누군가에게는 간단한 문제겠지만, 뿌듯함이 많이 남는 문제였습니다.
``` 