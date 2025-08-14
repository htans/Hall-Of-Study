# [level 0] 간단한 식 계산하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181865)


### 실행문
```java
class Solution {
    public int solution(String binomial) {
        
        String[] strArray = binomial.split(" ");
        
        String operator = strArray[1];
        int num1 = Integer.parseInt(strArray[0]);
        int num2 = Integer.parseInt(strArray[2]);
        int answer = 0;
        
        switch(operator) {
            case("+") :
                answer = num1 + num2;
                break;
            case("-") :
                answer = num1 - num2;
                break;
            case("*") :
                answer = num1 * num2;
                break;
        }   
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
변환을 지금도 기억을 못하네요...
기억할때까지 자주 사용하는 방법 밖에는 없는 것 같습니다.
``` 