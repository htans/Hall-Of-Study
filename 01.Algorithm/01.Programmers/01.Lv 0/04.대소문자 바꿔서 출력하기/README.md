# [level 0] 대소문자 바꿔서 출력하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181949) 


### 실행문

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String output = "";
        char temp;
        
        if(1 <= a.length() || a.length() <= 20) {
            for(int i=0; i<a.length(); i++ ) {

                temp = a.charAt(i);
                
                if( (65 <= temp) && (temp <= 90) ) { // 대문자인 경우
                    output += a.valueOf(temp).toLowerCase();
                } else if ( (97 <= temp) && (temp <= 122) ) { // 소문자인 경우
                    output += a.valueOf(temp).toUpperCase();
                } else { // 그 외의 경우
                    output += (char)temp;
                }
            }
        }
        
        System.out.println(output);
        
    }
}
```

##### 참고사이트
1. [참고 링크](https://pridiot.tistory.com/24)


### 느낀점

```
평소 업무에 접하지 못했던 메서드가 필요한 상황이다보니, 구글링과 생각만으로 해결하는 능력을 키워야할 것 같습니다.
앞으로는 컴파일 하는 방법에 익숙해지고, 주석처리를 간략하게 하면서 진행 해야할 것 같습니다.
``` 
