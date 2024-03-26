# [level 0] 2의 영역

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181894)


### 실행문
```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> answerList = new ArrayList<>(); 
        ArrayList<Integer> answer = new ArrayList<>(); 
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2 ) {
                answerList.add(i);
            }
        }
        
        if (!answerList.isEmpty()) {
            int min = Collections.min(answerList);
            int max = Collections.max(answerList);
            
            for(int j = min; j <= max; j++) {
                answer.add(arr[j]);
            }
            
            return answer.stream().mapToInt(Integer::intValue).toArray();
            
        } else {
            
            return new int[]{-1};
        }
    }
}

```


##### 참고사이트


### 느낀점
```
배열이 아직 익숙지가 않습니다.
return 할때가 제일 걱정이였는데, 검색해보니 많은 방법이 나오네요...
읽어도 읽지 않은 느낌이지만, 더 다양한 배열, 변환을 알아볼 수 있었습니다.
배열 만든 사람 얼굴점;
``` 