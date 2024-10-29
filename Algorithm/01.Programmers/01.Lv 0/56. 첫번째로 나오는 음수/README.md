# [level 0] 첫 번째로 나오는 음수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181896)


### 실행문
```java
class Solution {
    public int solution(int[] num_list) {
        int answer = -1;
        
        for(int i = 0; i < num_list.length; i++ ) {
            if (num_list[i] < 0) {
                answer = i; 
                break;
            }    
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
Flag 를 하나 만들어서 프로토콜을 구성했는데, 정확도가 10% 밖에 나오지 않아서 어떤식으로 해야할지 고민을 했습니다.
생각해보니 answer 에 바로 -1 를 주고, i값을 할당하면 Flag 도 필요없네요... ㄷㄷ
``` 