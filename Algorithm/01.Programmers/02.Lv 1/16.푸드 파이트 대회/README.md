# [level 1] 푸드 파이터 대회

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/134240)


### 실행문
```java
class Solution {
    public String solution(int[] food) {
        
        String answer = "";
        String fiStr = "";
        String laStr = "";
            
        for( int i = 1; i < food.length; i++ ) {
            int foodCnt = food[i] / 2;
            for( int j = 0; j < foodCnt; j++ ) {
                fiStr += i;
                laStr = i + laStr;
            } 
        }
        
        answer = fiStr + "0" + laStr;
        
        return answer;
 
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(int[] food) {
        StringBuilder fiStr = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int foodCnt = food[i] / 2;
            for (int j = 0; j < foodCnt; j++) {
                fiStr.append(i);
            }
        }
        
        String laStr = fiStr.reverse().toString();
        fiStr.reverse().append("0").append(laStr);
        
        return fiStr.toString();
    }
}
```

##### 참고사이트
1. [참고 링크](https://onlyfor-me-blog.tistory.com/317) 

### 느낀점
```
소스로 보면 간단한 문제인데, 문제를 이해하는데 조금 시간이 걸렸습니다.
확살히 문제를 많이 풀어봐야겠다는 생각을 다시금 하게 해준 문제 입니다.
그리고 쳇형님은 StringBuilder 를 이용하여 reverse()로 뒤집고, append()로 0을 추가한다음 마지막에 laStr 변수에 쌓인걸 넣어줬네요.
제 방법으로 하면 매번 Stirng 을 +로 이어서 붙이는데, 이러면 매번 새로운 객체를 생성해서 성능과 속도에 영향이 있다는것을 처음 알아습니다.
StringBuilder도 자주 쓰는 클래스이지만, 이런 장점도 모르고 사용한것 같아서 부끄럽네요.
이번에도 정말 재미있음 굳굳
``` 