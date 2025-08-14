# [level 0] n 번째 원소부터

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181892)


### 실행문
```java
class Solution {
    public int[] solution(int[] num_list, int n) {
              
        var list_length = num_list.length - n; 
        int[] answer = new int[list_length + 1];
        
        for(int i = 0; i <= list_length; i++) {
            answer[i] = num_list[n-1];
            n++;
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ 이정도 문제로 날 쓰러트릴 수 있다.
``` 