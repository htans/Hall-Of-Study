# [level 0] [PCCE 기출문제] 4번 / 저축

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250130?language=java)


### 실행문
```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int before = sc.nextInt();
        int after = sc.nextInt();

        int money = start;
        int month = 1;
        while (money < 70) {
            money += before ;
            month++;
        }
        while (money < 100) {            
            money += after;
            month++;
        }

        System.out.println(month);
    }
}

```


### ChatGPT
```java
```


##### 참고사이트


### 느낀점
```
이해력이 딸려서 버버벅버버벅 햄버거 먹고싶네요.
``` 