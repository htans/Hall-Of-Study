# [level 0] 홀수 vs 짝수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181887)


### 실행문
```java
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sum1 = 0;
        int sum2 = 0; 
        
        for (int i = 0; i < num_list.length; i ++) {
            
            if ( i % 2 == 0 ){
                // 짝수
                sum1 = sum1 + num_list[i];
                
            } else {
                // 홀수
                sum2 = sum2 + num_list[i];
            }
            
        }
        
        if (sum1 > sum2 ) {
            answer = sum1;
        } else {
            answer = sum2;
        }
        
        return answer;
    }
}
```


### 느낀점
```
ㅋ 솔직히 for문 반대로 써놓고 왜이러는거지.. 함 ㅋ;;
``` 