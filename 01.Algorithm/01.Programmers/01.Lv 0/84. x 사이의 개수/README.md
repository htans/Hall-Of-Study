# [level 0] x 사이의 개수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181867


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(String myString) {
        
        ArrayList<Integer> arrList = new ArrayList<>();
        String[] strArray = myString.split("x", -1);
        for(int i = 0; i < strArray.length; i++) {
            arrList.add(strArray[i].length());
        }

        int[] answer = new int[arrList.size()];
        for(int j = 0; j < arrList.size(); j++ ) {
            System.out.println(arrList.get(j));
            answer[j] = arrList.get(j);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
split( "", -1 ) 부분은 처음 봅니다.
세상에  
``` 