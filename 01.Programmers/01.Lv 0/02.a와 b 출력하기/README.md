# [level 0] a와 b 출력하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181951) 


### 실행문

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(-100000 <= a && 100000 >= a && -100000 <= b && 100000 >= b) {
            System.out.println("a = " + a + "\nb = " + b);    
        }
    }
}
```

### 느낀점
```
코드 실행을 하고 '테스트를 통과하였습니다.' 라는 문구가 나오고, 채첨결과도 100점이 나와서 종료하려고 했지만.
제한사항을 뒤늦게 보고 코딩을 수정 하였습니다.

당연하게 문제를 제한시간안에 프로토콜을 찾고, 코딩을 하는것도 중요하지만, 문제의 요구사항과 제한사항을 체크해야 한다는 교훈을 얻을 수 있었습니다.
``` 
