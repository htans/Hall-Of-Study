# [level 0] 배열 만들기 5

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181912)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < intStrs.length; i++) {
            
            String result = intStrs[i].substring(s, s + l );    
            int intresult = Integer.parseInt(result);
            
            if(intresult > k ) {
                answer.add(intresult);
            }
            
        }
        
        // ArrayList를 배열로 변환
        int[] resultArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            resultArray[i] = answer.get(i);
        }

        return resultArray;
    }
}
```


##### 참고사이트


### 느낀점
```
변환 아직도 어렵... 하지만, 아주 조금 감히 잡힘...
``` 