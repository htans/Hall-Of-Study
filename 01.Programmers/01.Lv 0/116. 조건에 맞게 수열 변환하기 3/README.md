# [level 0] 조건에 맞게 수열 변환하기 3

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181835)


### 실행문
```java
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        
        if(k % 2 == 0) {
            for(int i = 0; i < arr.length; i++) {
                answer[i] = arr[i] + k;
            }
        } else {
            for(int i = 0; i < arr.length; i++) {
                answer[i] = arr[i] * k;
            }
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
덩실덩실
``` 