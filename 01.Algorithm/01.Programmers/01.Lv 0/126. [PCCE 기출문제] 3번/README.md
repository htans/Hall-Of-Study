# [level 0] [PCCE 기출문제] 3번 / 나이 계산

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250131)


### 실행문
```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        String age_type = sc.next();
        int answer = 0;

        if (age_type.equals("Korea")) {
            answer = 2030 - year + 1;
        }
        else if (age_type.equals("Year")) {
            answer = 2030 - year;
        }

        System.out.println(answer);
    }
}
```


### ChatGPT
```java
```


##### 참고사이트


### 느낀점
```
슬슬 레벨 단계를 바꿔야할때가 다가온 것 같습니다! 
``` 