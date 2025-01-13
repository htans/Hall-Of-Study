# [level 1] 가장 가까운 같은 글자


* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/142086)


### 실행문
```java
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        String MainStr = "";
        
        for (int i = 0; i < s.length(); i++) {
            String currentChar = s.substring(i, i+1);
            
            int lastIndex = MainStr.lastIndexOf(currentChar);
            if (lastIndex != -1) {
                answer[i] = i - lastIndex;
            } else {
                // 처음 등장한 경우
                answer[i] = -1;
            }
            
            // MainStr에 현재 문자 추가
            MainStr += currentChar;
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
오우 독감 걸리고 현업에 크리티컬로 오랜만에 코딩문제푸니 재미지네요.
엄청 오래 고민하고, 중간저장 후 다시 풀었는데 했던게 너무 비비꼬아서 무슨말인지 몰라서 초기화 후 
간단하게 생각하고 다시 접근해서 풀었습니다. 
IndexOf 가 아닌 lastIndexOf만 알았어도 금방 풀었을텐데...ㅎㅎㅎ 
``` 