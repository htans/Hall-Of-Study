# [level 0] 문자열 여러번 뒤집기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181913)


### 실행문
```java
class Solution {
    public String solution(String my_string, int[][] queries) {
        
        for(int i = 0; i < queries .length; i++ ) {
            int[] Inqueries = queries[i];
            
            int start = Inqueries[0];
            int end = Inqueries[1];
            
            StringBuilder sb = new StringBuilder(my_string);
            String reversedSubstring = sb.substring(start, end + 1);
            String reversed = new StringBuilder(reversedSubstring).reverse().toString(); 
            sb.replace(start, end + 1, reversed); 
            my_string = sb.toString(); 
        }
        
        return my_string;
    }
}
```


##### 참고사이트


### 느낀점
```
분명 reverse() 메소드를 직접 활용해서 방법이 있을 것 같은데.. 도저히 정답이 안보여서
바꿀려는 부분을 추출하여, 전체를 reverse() 시키는 방법으로 선택을 했습니다.
하지만, 아직 배열 선언 및 메소드를 사용하는 방법을 명확하게 모르는것 같아서 공부가 더 필요해 보입니다.
아직 ㅈ밥이라는 것을 매번 깨닫고, 반성하게 되는 하루입니다.
``` 