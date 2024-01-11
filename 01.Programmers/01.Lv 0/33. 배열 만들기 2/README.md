# [level 0] 배열 만들기 2

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181921)


### 실행문
```java
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (String.valueOf(i).matches("[05]+")) {
                resultList.add(i);
            }
        }

        if (resultList.isEmpty()) {
            return new int[]{-1};
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}
```


##### 참고사이트


### 느낀점
```
변환 방법을 더 찾아봐야할 것 같습니다.
정말 기초적인 방법이지만, 제가 모르는 경우나, 잘못사용하고 있는 것도 있었습니다.
``` 