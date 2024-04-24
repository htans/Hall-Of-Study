# [level 0] 수열과 구간 쿼리 1

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181883)


### 실행문
```java
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int i = 0; i < queries.length; i++ ){
            for(int j = queries[i][0]; j <= queries[i][1]; j++ ) {
                arr[j] += 1;
            }
        }
        
        int[] answer = new int[arr.length];
        for(int a = 0; a < arr.length; a++ ){
            answer[a] = arr[a];
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