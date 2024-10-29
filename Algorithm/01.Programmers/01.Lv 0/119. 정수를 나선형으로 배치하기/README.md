# [level 0] 정수를 나선형으로 배치하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181832)


### 실행문
```java
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int num = 1; // 채울 숫자
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        
        while (num <= n * n) {
            // 왼쪽에서 오른쪽으로 이동
            for (int i = left; i <= right; i++) {
                answer[top][i] = num++;
            }
            top++;
            
            // 위에서 아래로 이동
            for (int i = top; i <= bottom; i++) {
                answer[i][right] = num++;
            }
            right--;
            
            // 오른쪽에서 왼쪽으로 이동
            for (int i = right; i >= left; i--) {
                answer[bottom][i] = num++;
            }
            bottom--;
            
            // 아래에서 위로 이동
            for (int i = bottom; i >= top; i--) {
                answer[i][left] = num++;
            }
            left++;
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
ㅇㅅㅇ> 호액호액
``` 