# [level 0] 더 크게 합치기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181939)


### 실행문

```java
class Solution {
    public int solution(int a, int b) {
        int answer = 0;
            
        String total1 = ""+a+""+b;
        String total2 = ""+b+""+a;
    
        int num_total1 = Integer.parseInt(total1);
        int num_total2 = Integer.parseInt(total2);
        
        if(num_total1 < num_total2 ) {
            answer = num_total2;
        } else {
            answer = num_total1;
        }
        
        return answer;
    }
}
```


### 느낀점

```
ㅋ
``` 
