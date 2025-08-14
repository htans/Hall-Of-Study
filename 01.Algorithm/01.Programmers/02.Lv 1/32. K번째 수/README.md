# [level 1] K번째 수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42748)


### 실행문
```java
public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    
    for(int i = 0; i < commands.length; i++) {
        int[] a = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);    
        Arrays.sort(a);
        answer[i] = a[commands[i][2]-1];
    }
    
    return answer;
}
```

### ChatGPT
```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            final int start = commands[i][0] - 1;
            final int end = commands[i][1];
            final int k = commands[i][2] - 1;

            int[] sliced = Arrays.copyOfRange(array, start, end);
            Arrays.sort(sliced);
            answer[i] = sliced[k];
        }

        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
처음에는 문제를 읽고, 예제문을 보고 오! subString 으로 처리하면 되겠다! 했는데 쮓... int형 배열인것을 확인했습니다.
도저히 int형 관련된 메소드는 기억에 없어서 for문으로 돌릴까도 생각했는데, for문으로 돌리면 이중for문이 형성됨으로 문제가 이걸 원하는 것 같지 않아서
구글링으로 int형 subString 같은것을 찾는 도중 Arrays.copyOfRange() 라는 메소드를 알게 되었습니다.
subString은 숫자만 넣으면 되는데, 이건 아예 배열도 안에 넣고 거기서 몇번째 몇번째를 요구해주더라구요.
문제에도 첫번째, 1번째 이런식으로 많이 나오는데 배열에 자릿수가 정신차리고 안하면 헷갈릴때가 많더라구요 ㅋㅋㅋ
덕분에 문제에서 요구하는 배열에 몇번째, 1번째 등 속임수 아닌 속임수에 조금은 익숙해져서 잘 해쳐나갈 수 있고, Arrays.copyOfRange() 메서도도 제 머리속에 잘 기억에 남은것 같아서 너무 기분 좋은 문제 입니다.
쳇형님이 한걸 보니 저랑 크게 차이는 나지 않는것 같아서 ㅎㅎ 코딩테스트 공부하면서 처음이네요. 엣헴 ㅎㅎ ㅎㅎ ㅎ
이번 문제도 너무 재미있었습니다.
``` 