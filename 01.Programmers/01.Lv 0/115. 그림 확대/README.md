# [level 0] 그림 확대

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181836)


### 실행문
```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> solution(String[] picture, int k) {
        
        List<String> enlargedPicture = new ArrayList<>();

        for (String row : picture) {
            StringBuilder enlargedRow = new StringBuilder();
            for (char c : row.toCharArray()) {
                for (int i = 0; i < k; i++) {
                    enlargedRow.append(c);
                }
            }

            for (int i = 0; i < k; i++) {
                enlargedPicture.add(enlargedRow.toString());
            }
        }

        return enlargedPicture;
    }
}
```

##### 참고사이트


### 느낀점
```
세상에.. 생각하는 모든게 메소드로 존재할 줄이야.. 
``` 