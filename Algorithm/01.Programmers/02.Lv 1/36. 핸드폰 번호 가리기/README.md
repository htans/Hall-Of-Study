# [level 1] 핸드폰 번호 가리기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12948)


### 실행문
```java
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int front_cnt = phone_number.length() - 4;
        for(int i = 0; i < front_cnt; i++) {
            answer += "*";
        } 
        answer += phone_number.substring( front_cnt, phone_number.length() );
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String masked = "*".repeat(len - 4);
        String visible = phone_number.substring(len - 4);
        return masked + visible;
    }
}
```

##### 참고사이트

### 느낀점
```
이제 정말 조금씩 조금씩 1레벨 수준에 도달하는것 같습니다.
코딩테스트를 풀면서 생긴 버릇이 문제를 읽고, 입출력 예를 보면서 이해한 내용이 맞는지 확인하고, 확인된 생각을 정리하면서
어떤 부분을 함수로, 메소드로 처리가 가능한지 그리고 과부화나 이슈가 날 부분은 없는지 제가 생각하면서 체크하는게 이번 문제를 통해 확실히 느껴졌고,
코딩테스트 라는게 프로토콜을 풀수 있는지 없는지도 중요하고, 방어코드 처리하는 부분도 중요하겠지만. 
제가 위에서 얘기한 다양한 시각으로 풀이 방법을 생각해보고 고민해보고 시도해보는 자체가 코어가 아닌가 하는 쓸때없는 생각이 들었습니다 ㅋㅋㅋ
일상 생활에서 볼법한 문제를 실제로 코딩테스트로 풀어보면서 재밌고, 신기하다는 생각이 항상 들어요 ㅋㅋㅋ
제가 작성한 소스도 좋지만, for문이 있기 때문에 for문을 대체할 수 있는게 없을까 라는 생각이 강하게 들었는데, repeat() 이라는 메소드도 이번 문제에서 처음 알았네요...
전체 길이에서 -4 만큼 반복하면 되는거고, 따로 front_cnt 가 필요없고 각 필요한 부분마다 -4를 붙이면 더 가독성이 좋은 코드가 나왔을텐데 아쉽네요 ㅋㅋ
이번 문제도 정말 재미있었습니다.
``` 

