# [level 0] 문자열 반복해서 출력하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181950) 


### 실행문

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str2 = "";
        int n = sc.nextInt();
        
        if( 1 <= n && n <= 5) {
            for(int i=1; i<=n; i++ ) {
                str2 += str;
            }    
        }
        
        System.out.println(str2);
        
    }
}
```


### 느낀점

```
문제풀이를 문제에서 요구하는 프로토콜을 구현하고, 제한사항을 요구사항으로 생각하고 구현하는것이 저한테는 제일 좋은 방법인것 같습니다.
문제와 제한사항을 동시에 구현하려고 하니, 생각도 제대로 되지 않았고 메서드 또한 공부해야 된다는 것을 배웠습니다.

'repeat' 이라는 메서드 하나로 모든 구현이 가능하다니... 쮓...
``` 


### 참고 풀이

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        System.out.println(str.repeat(n));
    }
}
```