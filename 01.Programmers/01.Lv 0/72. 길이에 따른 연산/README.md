# [level 0] 길이에 따른 연산

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181879)


### 실행문
```java
class Solution {
    public int solution(int[] num_list) {
        
        int answer = 0;
        
        for(int i = 0; i < num_list.length; i++) {
            if(num_list.length > 10) {
                answer += num_list[i];
            } else {
                if(i == 0) {
                    answer = num_list[i];    
                } else {
                    answer = answer * num_list[i];    
                }
            }
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ
``` 