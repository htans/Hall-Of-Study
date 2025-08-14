# [level 1] 행렬의 덧셈

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12950?language=java)


### 실행문
```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        for(int i = 0; i < arr1.length; i++ ) {
            for(int j = 0; j < arr1[i].length; j++) {
                int total = arr1[i][j] + arr2[i][j];
                answer[i][j] = total;
            }
        }
        
        return answer;
    }
}   
```

### ChatGPT
```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr1[0].length;
        int[][] answer = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                answer[i][j] = arr1[i][j] + arr2[i][j];

        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
음...?
``` 

