# [level 1] 덧칠하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/161989)


### 실행문
```java
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int sum = 0;
        
        for( int i = 0; i < section.length; i++ ) { 
            
            if ( i == 0 ) {
                sum += section[i] + m -1;
                answer++;
            } else if ( section[i] > sum ) {
                sum = section[i] + m -1;
                answer++;
            }
            
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int sum = section[0] + m - 1;
        
        for (int i = 1; i < section.length; i++) {
            if (section[i] > sum) {
                sum = section[i] + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
그림을 보면서 문제를 이해하고, 정리하는게 아주 조금은 익숙해졌습니다.
글을 보면서 이해하고, 풀이를 하는 능력을 키우고 싶은데, 지금은 어디 부분이 잘못 되어있는지 로그 찍어보고, 변환 되는 데이터를 찍어보면서 천천히 하고 있습니다.
이번것도 개꿀잼 ^ㅁ^
아 그리고 1로 하면 처음에 i==0 조건을 쓸필요가 없다니.. GPT형;; 형은 어디까지;; ㅠ 반성합니다..
``` 