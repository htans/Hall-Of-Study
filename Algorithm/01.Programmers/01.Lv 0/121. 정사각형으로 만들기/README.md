# [level 0] 정사각형으로 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181830)


### 실행문
```java
class Solution {
    public int[][] solution(int[][] arr) {
        
        int a = arr.length;
        int b = arr[0].length;
        int[][] answer;
        
        if ( a < b ) {
                
            answer = new int[b][b];
            
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {        
                    answer[i][j] = arr[i][j];
                }
            }       
            
        } else {
            answer = new int[a][a];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {        
                    answer[i][j] = arr[i][j];
                }
            }
        }
        
        return answer;
        
    }
}

```

### ChatGPT
```java
class Solution {
    public int[][] solution(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;

        if (rowCount > colCount) {
            // 열의 수를 행의 수에 맞추기 위해 각 행에 0을 추가
            int[][] answer = new int[rowCount][rowCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
            return answer;
        } else if (rowCount < colCount) {
            // 행의 수를 열의 수에 맞추기 위해 각 열에 0을 추가
            int[][] answer = new int[colCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
            return answer;
        } else {
            // 행과 열의 수가 같을 경우 원래 배열 반환
            return arr;
        }
    }
}
```

##### 참고사이트




### 느낀점
```
자리수만 채워넣고 0을 어떻게 하지? 하다가 얻어걸렸네요.
배열에 아무것도 없을때는 0이 들어가는걸 문제 풀면서 처음 알았습니다.
이차원배열은 할때마다 머리아픔 ㅠ
``` 