# [level 0] 두 수의 연산값 비교하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181938)


### 실행문

```java
class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String str_case_1 = a+""+b;
        int num_case_1 = Integer.parseInt(str_case_1); 
        int num_case_2 = 2 * a * b;
        
        if(num_case_1 < num_case_2) {
            answer = num_case_2;
        } else if(num_case_1 == num_case_2) {
            answer = num_case_1;
        } else {
            answer = num_case_1;   
        }
        
        return answer;
    }
}
```


### 느낀점

```
변환하는 메소드를 잘 정리해야 할 것 같습니다.
그리고 다른분들 풀이를 보면서, 변수 선언과 다양한 프로토콜도 구경해봐야겠어요!
``` 
