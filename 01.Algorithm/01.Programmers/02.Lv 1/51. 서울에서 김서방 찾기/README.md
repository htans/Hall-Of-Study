# [level 1] 서울에서 김서방 찾기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12919)


### 실행문
```java
class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        for(int i = 0; i < seoul.length; i++ ) {
            if( seoul[i].equals("Kim") ) {
                answer += "김서방은 " + i + "에 있다";
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                return String.format("김서방은 %d에 있다", i);
            }
        }
        return ""; // 기본적으로 여기 도달 안 함
    }
}
```

##### 참고사이트

### 느낀점
```
..?
챗 형님이 하신건 바로 return 으로 String.format 으로 넘겨주네요.
근데 "$d", i 이런 방식은 C언어만 되는지 알았는데, Java에서도 작동을 하는걸 처음 알았습니다.
찾아보니 String.format(), System.out.printf() 2가지 메소드에서 사용이 가능하네요!

엄청 간단한 문제라서 그냥 넘어갈뻔했는데, 신기한점을 발견해서 재밌습니다 ㅋㅋㅋ
``` 

