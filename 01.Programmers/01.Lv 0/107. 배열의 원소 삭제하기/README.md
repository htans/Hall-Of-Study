# [level 0] 배열의 원소 삭제하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181844)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        ArrayList<Integer> result_List = new ArrayList<>();
        for(int i = 0; i < arr.length; i++ ) {
            
            boolean del_flag = false;
            
            for(int j = 0; j < delete_list.length; j++ ) {
                if(arr[i] == delete_list[j]) {
                    del_flag = true;
                    break;
                }                
            }
            
            if(!del_flag) {
                result_List.add(arr[i]);
            }
        }
        
        int[] answer = new int[result_List.size()];
        for(int x = 0; x < answer.length; x++) {
            answer[x] = result_List.get(x);
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
편안
``` 