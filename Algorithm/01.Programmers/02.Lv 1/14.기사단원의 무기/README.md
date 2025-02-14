# [level 1] 기사단원의 무기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/136798)


### 실행문
```java
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int inCnt = 0;
            
            // 제곱근 사용
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    inCnt++; 
                    if (j != i / j) { 
                        inCnt++;
                    }
                }
            }
            
            if (inCnt > limit) {
                answer += power;
            } else {
                answer += inCnt;
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] divisorCounts = new int[number + 1]; // 약수 개수를 저장하는 배열
        
        for (int i = 1; i <= number; i++) {
            int inCnt = 0;
            
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    inCnt++; 
                    if (j != i / j) { 
                        inCnt++;
                    }
                }
            }

            divisorCounts[i] = inCnt;
        }
        
        for (int i = 1; i <= number; i++) {
            answer += (divisorCounts[i] > limit) ? power : divisorCounts[i];
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
for문을 이중으로 사용하다보니 결과는 제대로 나오는데, 계산하는데 오래 걸려서 시간초과로 뜨더군요.
그러던중 제곱근 형식으로 약수를 하는 방법을 배웠고, 이를 대입해보니 for문 검토양이 2배로 줄어서 계산 시간이 빨라졌습니다.
저의 현업에서는 계산시간이 View 쪽에서 잡아먹는 부분이 많아서 View 쪽만 리펙토링을 진행했었는데, 이렇게 Java 부분도 
계산식이나 메소드로 리펙토링 할 수 있는 범위가 무궁무진 하다는것을 배웠고,
항상 기본에 충실해야 된다 라는 것을 다시한번 상기시켜줍니다.
오늘도 역시 쳇형님은 짝짝 ㅋㅋㅋ 
``` 