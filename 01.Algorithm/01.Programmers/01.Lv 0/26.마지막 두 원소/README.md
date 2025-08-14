# [level 0] 마지막 두 원소

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181927)


### 실행문

```java
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        
        for(int i = 0; i < num_list.length; i++) {
            answer[i] += num_list[i];

            if(num_list.length - 1 == i) {
                if(num_list[i-1] < num_list[i]) {
                    answer[i+1] = num_list[i] - num_list[i-1];
                } else {
                    answer[i+1] = num_list[i] * 2;
                }   
            } 
            
        }
        
        return answer;
    }
}
```


### 느낀점
```
여러 가지 회사일이 겹쳐서 하기 싫은 핑계가 늘어난것 같습니다.
게임은 재밌네요... 정신차려야합니다. 
``` 