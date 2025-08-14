# [level 0] [PCCE 기출문제] 5번 / 산책

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250129?language=java)


### 실행문
```java
class Solution {
    public int[] solution(String route) {
        int east = 0;
        int north = 0;
        int[] answer = new int [2];
        for(int i=0; i<route.length(); i++){
            switch(route.charAt(i)){
                case 'N':
                    north++;
                    break;
                case 'S':
                    north--;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    east--;                    
                    break;
            }
        }
        answer[0] = east;
        answer[1] = north;
        return answer;
    }
}
```


### ChatGPT
```java
```


##### 참고사이트


### 느낀점
```
ㅇㅅㅇ?
``` 