# [level 0] 배열의 원소만큼 추가하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181861)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> strArray = new ArrayList<Integer>();  
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j <= arr[i]; j++) {
                strArray.add(arr[i]);
            }
        }
        
        int[] answer = new int[strArray.size()];
        for(int a = 0; a < strArray.size(); a++) {
            answer[a] = strArray.get(a);
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