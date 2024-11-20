# [level 1] 둘만의 암호

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/155652)


### 실행문
```java
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] sArr = s.toCharArray();
        
        for( int i = 0; i < sArr.length; i++ ) {
            
            char sChar = sArr[i];
            int sNum = (int) sChar;
            int tCount = sNum + index;
            
            for( int j = sNum; j <= tCount; j++ ) {
                char newsChar = (char) ('a' + (j - 'a') % 26);
                String news = String.valueOf(newsChar);
                
                if ( skip.contains( news ) ) {
                    tCount ++;
                }
                
                if ( j == tCount ) {
                    answer += news;
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
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] skipChars = new boolean[26];
        
        // skip 문자열의 문자를 배열로 표시해 빠른 확인
        for (char c : skip.toCharArray()) {
            skipChars[c - 'a'] = true;
        }
        
        for (char c : s.toCharArray()) {
            int count = 0; // 유효한 이동 횟수
            char current = c;
            
            while (count < index) {
                current = (char) ('a' + (current - 'a' + 1) % 26); // 다음 문자로 이동
                if (!skipChars[current - 'a']) { // 건너뛰는 문자 확인
                    count++;
                }
            }
            
            answer.append(current);
        }
        
        return answer.toString();
    }
}
```

##### 참고사이트


### 느낀점
```
확실히 프로토콜을 머리로 생각하고, 정리하는 스킬은 조금 늘어난 것 같습니다.
그걸 소스로 천천히 옮기는게 중요한거 겠지요.
이번 코딩문제도 재미있었고, current = (char) ('a' + (current - 'a' + 1) % 26); 문구는 솔직히 처음 본것 같습니다.
항상 재미있는 문제가 나오는게 신기하네용
머리 터지겠네 ^ㅁ^;;
``` 