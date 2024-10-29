# [level 0] 특별한 이차원 배열 2

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181831)


### 실행문
```java
class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        boolean CheckFlag = false;
        
        for(int i = 0; i < arr.length; i++ ) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] != arr[j][i]) {
                    CheckFlag = true;                    
                }
            }
        }
        
        if(CheckFlag) {
            return answer = 0;
        } else {
            return answer = 1;
        }
        
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int[][] arr) {
        int n = arr.length;
        
        for(int i = 0; i < n; i++ ) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }
        
        return 1;
    }
}
```

##### 참고사이트




### 느낀점
```
세상에... 문제도 이해하는데 한참... ㅠㅠ...
문제를 통과해도 ChatGPT한테 물어보면서 간소화를 시키고, 다른 프로토콜이 있는지, 더 간단하고 유지보수가 좋은 소스를 생각하기 위해 
노력해야 겠음요
``` 