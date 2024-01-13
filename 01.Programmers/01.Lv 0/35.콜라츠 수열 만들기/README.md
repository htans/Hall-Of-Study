# [level 0] 콜라츠 수열 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181919)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> resultList = new ArrayList<>();
         
        int x = n;
        
        for(;;) {
            
            resultList.add(x);
            
            if( x == 1) {
                break;
            }
            
            if(x % 2 == 0) {
                // 짝수
                x = x / 2;
                
            } else {
                // 홀수
                x = 3 * x + 1;
            }
            
        }
       
        int[] answer = new int[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
For문을 (;;)는 무한반복문 인것을 처음 알았습니다.
매일 i++ 이용해서 사용하는 방법에 익숙해서 그렇게만 사용했는데 코딩테스트를 풀어보면서 저는 ㅈ밥이라는것을 매일 깨닫는 하루 입니다.
마지막에 answer 배열에 넣는 방법도 다양한 방법이 있다는것을 알아가니 재미있습니다.
``` 