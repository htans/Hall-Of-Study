# [level 0] n개 간격의 원소들

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181888)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int count_size = 0;
        ArrayListsd<Integer> count_value = new ArrayList<>();
        
        for(int i = 0; i < num_list.length; i = i + n) {
            count_value.add(num_list[i]);
            count_size++;
        }
        
        int[] answer = new int[count_size];
        for(int j = 0; j < answer.length; j ++ ){
            answer[j] = count_value.get(j);
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