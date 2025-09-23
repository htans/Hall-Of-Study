# [level 2] 큰 수 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42883)


### 실행문
```java
class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        int remain = len - k;
        int start = 0;
        
        for(int i = 0; i < remain; i++ ) {
            char max = '0';
            for(int j = start; j <= i+k; j++ ) {
                if( number.charAt(j) > max ) {
                    max = number.charAt(j);
                    start = j+1;
                }
            }
            sb.append(max);    
        }
        
        return sb.toString();
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // 아직 제거할 게 남았다면 뒤에서 제거
        while (k-- > 0) stack.pop();
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        
        return sb.toString();
    }
}
```

##### 참고사이트

### 느낀점
```
처음 문제를 읽었을때는 sort() 메소드를 이용해서 람다식 정렬을 제일 먼저 생각했습니다.
근데 또 생각해보니 람다식 정렬은 전체 정렬할때는 좋은데, 이 문제는 부분적으로 잘라서 비교를 하고 큰 애를 찾아서 똭 가져다줘야하니...

찾아보니 해당 문제는 그리드 방식의 대표적인 문제 였습니다.
큰 틀은 remain 즉, 전체 길이에서 삭제할 문자수를 빼면 반환해야할 문자 길이가 나오니, 
그 길이만큼 일단 for문을 반복하면서 이중 for문을 돌면서!! Char 타입으로 max로 비교해가면서! 큰수를 빡빡 가져다 주는거네요.

string 변수는 큰 숫자를 뽑으면 다시 나오면 곤란하니까 빠로 빼고, 해당 문자를 찾을때는 i+k == '비교할 수' 만큼 for문을 돌면서 max를 빼주고
뺀걸 다시 가져가면 안되니까 start에 j+1; 인데 흠흠... 꿀잼

아직은 레벨2 라는 문제에 쪼는것도 있지만, 많은 문제를 접해보고, 10분정도 생각해보고 어떤 식으로 풀이가 되고, 어떤 기법으로 접근을 해야하는지 
그걸 파악하는게 제일 중요한것 같아요.
마음 같아서는 하나부터 열까지 다 쏶쏵 풀고싶은데, 전 ㅋㅋㅋ 그럴 레벨이 아니니까 ㅋㅋ 천천히...
덕분에 흥미도 생기고, 역분석을 하니까 더 재미있는 것 같네요 ㅋㅋㅋ 이번문제도 꿀잼이였습니다 ㅎㅎㅎ

* 추가로 궁금한점이 있었는데, number = "842159" k = 2 로 하면 "8459" 가 나오는데 어?! 9845가 나와야 하는거 아닌가? 했습니다.
문제를 보면 규칙없이 무작위로 큰수만 뽑아야해! 인줄 알았는데, 범위 단위로만 자를 수 있는거였네요.
1234 면, 연결된 범위만 자를 수 있기 때문이였네요. 
굳굳
``` 