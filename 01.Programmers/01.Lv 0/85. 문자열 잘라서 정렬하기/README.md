# [level 0] 문자열 잘라서 정렬하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181866#)


### 실행문
```java
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public String[] solution(String myString) {
        
        String[] strArray = myString.split("x");
        ArrayList<String> listArray = new ArrayList<>();
        
        Arrays.sort(strArray);
        
        for(int i = 0; i < strArray.length; i++ ) {
            if(strArray[i].trim().length() > 0) {
                listArray.add(strArray[i]);
            }    
        }
        
        String[] answer = new String[listArray.size()]; 
        for(int j = 0; j < listArray.size(); j++) {
            answer[j] = listArray.get(j);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
빈 문자열 처리 방법을 몰랐으면 오래 걸렸을 것 같습니다.
다행히 기억이 나서 잘 풀었는데, 이렇게 하는게 맞는지 항상 고민이 있네요 ㄷㄷ
``` 