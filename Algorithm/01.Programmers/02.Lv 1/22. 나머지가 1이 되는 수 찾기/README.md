# [level 1] 나머지가 1이 되는 수 찾기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87389)


### 실행문
```java
class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 2; i < n; i++ ) {
            if(n % i == 1) {
                return answer = i;
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return -1; // 이건 이론상 도달할 수 없는 부분 (문제에서 항상 존재한다고 했으니)
    }
}
```

##### 참고사이트

### 느낀점
```
음..?
``` 