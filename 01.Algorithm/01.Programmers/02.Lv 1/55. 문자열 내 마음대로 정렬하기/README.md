# [level 1] 문자열 내 마음대로 정렬하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12915)


### 실행문
```java
import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        // 원본 문자열 배열을 n번째 글자 기준으로 정렬
        Arrays.sort(strings, (s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);
            
            if (c1 == c2) {
                return s1.compareTo(s2); // 같으면 사전순 정렬
            } else {
                return Character.compare(c1, c2);
            }
        });
        
        return strings; // 정렬된 배열 그대로 리턴
    }
}
```

### ChatGPT
```java
import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        // 원본 문자열 배열을 n번째 글자 기준으로 정렬
        Arrays.sort(strings, (s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);
            
            if (c1 == c2) {
                return s1.compareTo(s2); // 같으면 사전순 정렬
            } else {
                return Character.compare(c1, c2);
            }
        });
        
        return strings; // 정렬된 배열 그대로 리턴
    }
}
```

##### 참고사이트

### 느낀점
```
처음에는 for문으로 ChatAt() 메소드를 이용해서 sort를 시키고, 정렬이 되면 그 숫자로 매칭시켜서 하면 되겠구나! 했는데
직접 구현을 해보니 쉽지 않고, 까다로운 조건들이 많다는것을 알게 되었습니다.
그래서 분명 문제에서도 이걸 원하지는 않을 것 같고, 다른 방법이 있을거라고 생각해서 삽질을 많이 했는데 제 머리로는 안되겠더라구요... ㅋㅋㅋ 
더 찾아보니 Arrays() 메소드에 많은것을 알 수 있었습니다.
평소에 이용하던건 Sort(a); 처럼 오름차순으로 정리하는것만 알았는데, 람다형식으로 조건을 제시하여 정렬해주는 기능이 있더군요.
위에서 나오는 Arrays.sort( strings, (s1, s2) -> { ... }); 형식을 이용해서 넘어온 strings 자체를 정렬하고 바로 반환,
조건을 제시하여, compareTo() 와 Character.compare() 를 활용하면 다른 변수나 배열없이 깔끔하게 이용 가능하다는것을 알게 되었습니다.
지금까지는 제가 기능을 구현하는 느낌이였다면, 이건 정말 메소드를 잘 활용하는 프로토콜을 배우는 느낌이였어요.
짧은 소스지만, 이해하는데 생각보다 오래 걸렸고, 왜 s1, s2는 선언도 없는데 어디서 튀어나온거지? s1, s2만 넘어오는데 다 정렬이 되지? 1-2, 2-3, 3-4 이런식으로 정렬 되는게 아닌가? c1 == c2 분개해서 그냥 s1.compareTo(s2); 만 하면 되는게 아닌가? 라는 의문점이 많았는데, 챗형님과 구글링을 통해서 하나씩 이해할 수 있었어요.
어떻게 보면 당연한건 것들이였는데 헷갈리거나 모르는 부분이 많아서 부끄럽지만, 재미있었습니다. ㅎㅎㅎㅎ

진짜 챗형님은... 크흐...
이번 문제도 너무 재미있었어요!
``` 

