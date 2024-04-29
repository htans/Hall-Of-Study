# [level 0] 1로 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181880)


### 실행문
```java
class Solution {
    public int solution(int[] num_list) {
        
        int work_count = 0;
        
        // 배열의 길이가 3보다 크고 15보다 작은 경우에만 실행
        if (num_list.length >= 3 && num_list.length <= 15) {
            for (int i = 0; i < num_list.length; i++) {
                // 배열 요소가 1 이상 30 이하인 경우에만 실행
                if (num_list[i] >= 1 && num_list[i] <= 30) {
                    int value = num_list[i];
                    while (value > 1) {
                        if (value % 2 == 0) {
                            value = value / 2; 
                        } else {
                            value = (value - 1) / 2; 
                        }
                        work_count++;
                    }
                } 
            }
        }
        
        return work_count;
    }
}

```


##### 참고사이트


### 느낀점
```
value - 2 로 적어놓고 20분동안 문제점을 찾았습니다.
할때마다 빡대가리 인증 인것같은 느낌을 받습니다.
``` 