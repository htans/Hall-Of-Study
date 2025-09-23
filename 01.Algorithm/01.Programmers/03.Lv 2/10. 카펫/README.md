# [level 2] 카펫

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42842)


### 실행문
```java
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        for(int height = 3; height <= Math.sqrt(total); height++ ) {
            if( total % height == 0 ) {
                int width = total / height; 
                if( (width - 2) * (height - 2) == yellow) {
                    return new int[] {width, height};
                }   
            }
        }
        
        return new int[0];
    }
}
```

### ChatGPT
```java
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        for(int height = 3; height <= Math.sqrt(total); height++ ) {
            if( total % height == 0 ) {
                int width = total / height; 
                if( (width - 2) * (height - 2) == yellow) {
                    return new int[] {width, height};
                }   
            }
        }
        
        return new int[0];
    }
}
```

##### 참고사이트

### 느낀점
```
이번 문제는 문제를 이해하는데도 좀 오래 걸렸네요.
결국에 문제에서는 갈색 카펫수랑 노란색 카펫수를 알려줄테니, 
1. 정사각형으로 배치가 가능한지 체크해보고! 2. 가로 세로 숫자를 알려달라! 이거네요.

정사각형은 그림에도 있지만, 높이가 최소한 3이니까, for문을 3부터 돌리고, 정사각형이니 total에 제곱근만 접근하면 리소스가 줄어들고,
항상 0으로 떨어지면 정사각형이라는거고! 안에는 빡빡 
-2가 잉? 왜 -2이지? 했는데, 가로세로 서로 겹치는 부분이 있으니 -2 를 해주는거였네요.

뭔가 소스를 보면 허무한데, 문제만 보면 멘붕이... ㅋㅋㅋ 이번 문제도 너무 재미있었음 ㅎㅎㅎㅎㅎㅎㅎ
아직 당당하게 풀지못해서 한...
조만간 디졌다 넌
``` 