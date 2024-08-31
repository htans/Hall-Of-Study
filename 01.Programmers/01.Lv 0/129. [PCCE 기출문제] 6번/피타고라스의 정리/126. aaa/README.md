# [level 0] [PCCE 기출문제] 6번 / 가채점

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250128)


### 실행문
```java
class Solution {
    public String[] solution(int[] numbers, int[] our_score, int[] score_list) {
        int num_student = numbers.length;
        String[] answer = new String[num_student];

        for (int i = 0; i < num_student; i++) {
            if (our_score[i] == score_list[ numbers[i]-1]) {
                answer[i] = "Same";
            }
            else {
                answer[i] = "Different";
            }
        }

        return answer;
    }
}
```


### ChatGPT
```java
```


##### 참고사이트


### 느낀점
```
종이를 써야하는 이유를 절실히 느낀 문제띠..
``` 