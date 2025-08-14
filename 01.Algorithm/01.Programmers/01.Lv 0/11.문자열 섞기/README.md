# [level 0] 문자열 섞기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181942)


### 실행문

```java
class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        
        String[] List_str1 = str1.split("");
        String[] List_str2 = str2.split("");
        
        int Length_str1 = str1.length();
        int Length_str2 = str2.length();

        int Length_Max = 0;
        if (Length_str1 >= Length_str2) {
            Length_Max = Length_str1;
        } else {
            Length_Max = Length_str2;
        }
        
        for(int i = 0; i < Length_Max; i++ ){
            answer += List_str1[i] + List_str2[i];
        }
        
        return answer;
    }
}
```


### 느낀점

```
부끄럽지만, 매일 사용하는 선언과 for문인데도 매일 복사해서 쓰다보니 헷갈리는게 있었습니다. (핑계+1)
코딩문제 만큼은 복사하지 않고, 타이핑만 사용하고 복사하지 않고 해야겠습니다.
처음에는 코딩문제를 어떻게 공부하고, 풀어야 하나 막막했는데... 아직까지는 재밌습니다.
``` 
