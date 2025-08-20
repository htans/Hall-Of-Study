# [level 1] 문자열 다루기 기본

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12918#)


### 실행문
```java
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        try {
            
            if( s.length() != 4 && s.length() != 6) { 
                return false;
            } 
                
            int test = Integer.parseInt(s);
            
        } catch(Exception e1) {
            return false; 
        };
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) 
            && s.chars().allMatch(Character::isDigit);
    }
}
```

##### 참고사이트

### 느낀점
```
처음에는 굉장히 쉬운 문제인줄 알고 오오오오 하고 풀었는데, 
문제에 조건인 글자수는 s.length()를 바로 떠올렸는데, 숫자만인지 체크한것에서는 타입변환 밖에 안떠오르더라구요.
타입변환을 해서 오류가나면 바로 뻗어버리니, 떠오르는건 Try-Catch 이였는데, 코딩테스트에서는 처음써보는 것 같더라구요.
평소에도 굉장히 많이 쓰지만, 아예 백지장에 쓸려고 하니 어색어색멍청멍청 했던거같습니다 ㅋㅋㅋ
그리고 생각보다 조건문이 헷갈려서 많이 놀랬어요.
처음에는 || 를 이용해서 써야지 했는데 정확도가 떨어져서, 테스트 케이스를 더 늘려서 테스트해보니 생각대로 안나오더라구요.
10분정도 헤매다가 종이에 써서 차근히 따라가보니 && 가 문제였던것을 알 수 있었습니다.
4, 6 이면 false 가 걸려서 && 로 하면 둘다 true 일때만 로직안으로 들어와서 return flase 를 넘기는데
|| 를 사용해서 한쪽이 true 로 넘어와서 로직안으로 들어가 계속 return flase 를 뱉었네요.
생각보다 경력이 있어서 흥! 이정도쯤은! ㅋ! 이랬는데, 기본적인 조건문도 헷갈려해서... 반성을 많이 하네요...

챗형님은 반환 자체를 boolean 으로 바꿔서 s.chars() 메소드에 allMatch() 메소드를 이용해서 바로 유니코드로 비교하네요.
역시.. 
반성을 많이 하게 되는 문제였습니다!
``` 

