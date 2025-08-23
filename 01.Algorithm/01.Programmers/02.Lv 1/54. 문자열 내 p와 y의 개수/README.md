# [level 1] 문자열 내 p와 y의 개수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12916)


### 실행문
```java
class Solution {
    boolean solution(String s) {
        
        String sLower = s.toLowerCase();
        int pnum = 0;
        int ynum = 0;
        for(int i = 0; i < s.length(); i++ ) {
            if( sLower.charAt(i) == 'p') {
                pnum++;
            } else if ( sLower.charAt(i) == 'y' ) {
                ynum++;
            }
        }
        
        boolean answer = false;
        if (pnum == ynum) {
            answer = true;
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int pCount = 0, yCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'p') pCount++;
            else if (c == 'y') yCount++;
        }
        
        return pCount == yCount;
    }
}
```

##### 참고사이트

### 느낀점
```
아아 세상에 제가 풀면서도 뭔가 toCharArray() 메소드를 이용해서 바로 하나씩 비교해서 하면 되지 않나 생각을 했는데, 챗형님이 푸신걸보니 역시 깔끔하네요.
pCount == yCount 로 바로 True 반환하는것도 그렇고, 확실히 빡 깔끔해지네요.
변수에 이름 짓는거나 문법이나 ㅠㅠ 아직까지 너무 멀고도 머네요...
이번 문제도 정말 쉬워보이지만, 실력차이를 그리고 부족한 부분을 명확하게 볼 수 있어서 반성스럽고, 재밌어요 ㅎㅎㅎ
꿀잼입니당
``` 

