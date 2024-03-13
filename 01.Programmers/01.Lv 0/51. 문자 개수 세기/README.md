# [level 0] 문자 개수 세기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181902)


### 실행문
```java
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                answer[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                answer[26 + c - 'a']++;
            }
        }

        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
처음보는 유형에 문제 입니다.
처음에는 문자 마다 if문을 사용해서 하다가 도저히 이건 아닌것 같더군요.
구글링을 해보다보니 워낙 유명하고, 오래된 문제들이라서 다양한 해결방법이 나왔지만,
위에 방식처럼 프로토콜을 구성하는것이 저에게는 맞다고 느껴졌습니다.
더 다양한 문제를 풀어보고, 많은 프로토콜을 경험해봐야겠네요.
``` 