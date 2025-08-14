# [level 1] 문자열 나누기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/140108)


### 실행문
```java
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String x = "";
        String y = "";
        int xcnt = 0;   
        int ycnt = 0;
        
        for(int i = 0; i < s.length(); i++ ) {
            if( x == null || x == "") {
                x = s.substring( i, i+1 );
                xcnt++;
            } else {
                if( x.equals( s.substring(i, i+1) ) ) {
                    xcnt++;
                } else {
                    y = s.substring( i, i+1 );
                    ycnt++;
                }
            }
            
            if( xcnt == ycnt || i+1 == s.length() ) {
                x = "";
                xcnt = 0;
                y = "";
                ycnt = 0;
                answer++;
            }
        }
        
        return answer;
    }
}   
```

### ChatGPT
```java
class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0); // 첫 번째 문자를 기준으로 x를 설정
        int xCount = 0; // x의 개수
        int yCount = 0; // x가 아닌 문자의 개수
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                xCount++;
            } else {
                yCount++;
            }

            // x와 y의 개수가 같아지면 하나의 구간이 완성됨
            if (xCount == yCount) {
                answer++;
                // 다음 구간을 위해 초기화
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1); // 새로운 x 설정
                }
                xCount = 0;
                yCount = 0;
            }
        }

        // 반복문 종료 후 처리되지 않은 문자가 있을 경우 추가
        if (xCount > 0 || yCount > 0) {
            answer++;
        }
        
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
문뜩, 문제를 이해하고 메모장에서 풀때는 잘 아는것 같은데,
그걸 순서대로 정리하여 소스로 풀이하는것이 제일 중요하다는 생각을 했습니다.
처음에는 아무생각없이 하니 어디가 틀린건지, 어디서 잘못된건지 잘 모르겠더군요.
구간별로 검토 로직을 추가하고, 로우 하나씩 결과물을 출력하고 보니 잘못된것을 쉽게 파악할 수 있었습니다.
그래서 문제풀이 하는것도 중요하고, 간결한 소스를 만드는것도 중요하지만, 저만에 코드 풀이 방식이나 검토방식을 개선해야겠다는 생각이 많이 드는 문제 였습니다.
변수명 부터 시작해서, 검증하는 출력까지 여러 생각이 드는 문제였습니다. 굳굳
``` 