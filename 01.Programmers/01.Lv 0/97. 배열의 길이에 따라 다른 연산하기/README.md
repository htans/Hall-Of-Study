# [level 0] 배열의 길이에 따라 다른 연산하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181854)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int n) {
        
        boolean Num_Flag = true;
        if( arr.length % 2 == 0) {
            Num_Flag = false;
        } 
        
        ArrayList<Integer> intarr = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(Num_Flag) {
                if( i % 2 == 0) {
                    intarr.add(arr[i] + n);
                } else {
                    intarr.add(arr[i]);
                }
            } else { 
                if( i % 2 == 1 ) {
                    intarr.add(arr[i] + n);   
                } else {
                    intarr.add(arr[i]);
                }
            }
        }
        
        int[] answer = new int[intarr.size()];
        for(int j = 0; j < answer.length; j++ ) {
            answer[j] = intarr.get(j);
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