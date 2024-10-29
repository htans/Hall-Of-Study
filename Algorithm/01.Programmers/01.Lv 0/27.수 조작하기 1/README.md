# [level 0] 수 조작하기 1 

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181926)


### 실행문
```java
class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        
        String[] list_control = control.split("");
        
        for(int i = 0; i < list_control.length; i++) {
            
            if(list_control[i].contains("w")) {
                n += + 1;
            } else if (list_control[i].contains("s")) {
                n += - 1;
            } else if (list_control[i].contains("d")) {
                n += + 10;
            } else if (list_control[i].contains("a")) {
                n += - 10;
            }
        }
        
        answer = n;
        
        return answer;
    }
}
```


##### 참고사이트
1. [참고 링크](https://hianna.tistory.com/556) 


### 느낀점
```
ㅋ 역시 코딩이 재미있습니다. 잘 풀리면...
``` 