# [level 0] 접미사인지 확인하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181908)


### 실행문
```java
class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        
        for(int i = 0; i < my_string.length(); i++) {
            var value = my_string.substring(i);
            if (value.endsWith(is_suffix)) {
                return 1;
            }
        }
          
        return 0;
    }
}
```


##### 참고사이트


### 느낀점
```
매번 업무에서만 사용하던 메소드가 아닌 문제를 해결하기 위해 다양한 메소드를 배우는게 재미있습니다.
하지만, 기본적인 메소드도 모르느거나 사용방법을 제대로 모르는것 같아서 우울...
우울한 만큼 더 열심히 해야겠습니다.
``` 