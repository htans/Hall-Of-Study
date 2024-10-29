# [level 0] 9로 나눈 나머지

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181914)


### 실행문
```java
class Solution {
    public int solution(String number) {
        int answer = 0;
        int sum = 0;
        
        String[] number_list = number.split("");
        for(int i = 0; i<number_list.length; i++){
            sum += Integer.parseInt(number_list[i]);
        }
        
        answer = sum%9;
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
예전에 했던 프로토콜이 정확하게 문법으로 기억나지 않아서 많이 답답하네요.
포인트를 기억해서 구글링하면 나오지만... 
기본적인 문법도 헷갈려서 실력이 ㅈ밥이라는것을 매번 느낍니다.
화이팅
``` 