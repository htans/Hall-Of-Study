# [level 0] 홀짝 구분하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181944)


### 실행문

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n % 2 == 0) {
            System.out.println( n + " is even");
        } else {
            System.out.println( n + " is odd");
        }
        
    }
}
```

### 느낀점

```
'0' 으로 했던 나를 반성합니다.
``` 
