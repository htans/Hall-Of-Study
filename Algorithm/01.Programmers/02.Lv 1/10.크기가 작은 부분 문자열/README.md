# [level 1] 크기가 작은 부분 문자열

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/147355)


### 실행문
```java
class Solution {
    public int solution(String t, String p) {
        
        int answer = 0;
        
        // 찢을 숫자
        int Size = p.length();
        // 찾을 최대 숫자
        int MaxSize = t.length() - p.length()+1;
        
        String tSplit[] = t.split("");
        
        for (int i = 0; i < MaxSize; i++ ) {
            
            String str_Value = "";
            for (int j = i; j < i + Size; j++) {
                str_Value += tSplit[j];
            }    
            
            if( str_Value.compareTo(p) <= 0 ) {
                answer ++;
            }
            
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int subLength = p.length(); // p의 길이
        
        for (int i = 0; i <= t.length() - subLength; i++) {
            // t의 부분 문자열 추출
            String subString = t.substring(i, i + subLength);
            
            // 문자열 비교 (사전순으로 비교)
            if (subString.compareTo(p) <= 0) {
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
프로토콜은 생각보다 쉬운것 같은데, 런타임 에러 덕분에 여러 공부를 할 수 있었습니다.
뜨문뜨문 사용을 해보고, 대충 생각은 나는지 뭐지 뭐지 하면서 정확하게 부족한곳을 인지할 수 있었습니다.
근데 이번에도 GPT 형이 한걸 보니 한방 맞은것 같네요.
subString() 이라는 메소드를 모르는것도 아닌데... 역시 활용을 해보고, 많은 문제를 봐야 적재적소에 넣을 수 있는것 같네요.
그나저나... ㅋㅋㅋ 시험에 정답 이라고 다 뜨는데 희열감이 // ㅁ //
역시 개꿀잼입니다.
풀이 보면 항상 반성...
``` 