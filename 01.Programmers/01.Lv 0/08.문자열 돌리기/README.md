# [level 0] 문자열 돌리기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181945) 


### 실행문

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] list = a.split("");
        
        for(int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        
    }
}
```

### 느낀점

```
문제 설명만 읽었을때는 어떻게 출력해야할지 몰랐지만, 출력 예시문을 보고 이해하였습니다.
많은 문제을 읽어보고, 풀이를 통해 문제설명 과 풀이과정 둘 다 공부하는것이 맞는 것 같네요.
처음에는 Sitnrg 에 변수를 length 를 실행하니, 오류가 나서 컴파일러 때문인가? 했는데,
제가 멍청한거였네요. 
``` 
