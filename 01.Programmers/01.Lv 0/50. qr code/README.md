# [level 0] qr code

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181903)


### 실행문
```java
class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        String boom = "";
        int end_num = 0;
        
        for (int i = 0; i < code.length(); i = i + q) {
            
            end_num = Math.min(i + q - 1, code.length() - 1);
            
            boom = code.substring(i, end_num + 1);
            if (boom.length() > r) {
                answer += boom.charAt(r);    
            } 
            
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
생각보다 문자열에 갯수와 자리수에 대한 헷갈리는게 많네요.
제가 ㅈ밥이라서 그러겠지만, 방법은 익숙하게 풀어보는 방법 밖에는 없는것 같습니다.
자리수와 갯수를 구분하지 못하면 어떤 프로토콜이든 시작도 못하는것 같아요.
``` 