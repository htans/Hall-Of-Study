# [level 1] 삼총사

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=java)


### 실행문
```java
class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    int sum = number[i] + number[j] + number[k];
                    if( sum == 0 ) {
                        answer++;
                    }
                    
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
    public int solution(int[] number) {
        int answer = 0;

        // 3개 조합 중 0이 되는 경우 찾기
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (isZeroSum(number[i], number[j], number[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    // 세 수의 합이 0인지 판단하는 메소드
    private boolean isZeroSum(int a, int b, int c) {
        return a + b + c == 0;
    }
}
```

##### 참고사이트

### 느낀점
```
조합을 어떻게 해야하는지 고민을 했는데, 간단한 방법이 있었군요.
문제를 잘못 읽어서 연속되는 3개 숫자만 비교하는줄 알았는데, 복합적으로 전부 비교하는 문제라서 천천히 읽어야겠다는 마음을
다시 생각하게 해준 문제 입니다.
챗형님이 리팩토링 한 소스를 보니 줄인다고 줄인건데도 따라갈려면 멀었네요...
100% 정답은 아니지만, 가독성이나 유지보수를 생각하면 확실히 챗형님을 참고 안할수가 없네요 ㅋㅋ
역시나 꿀잼이였습니다.
``` 