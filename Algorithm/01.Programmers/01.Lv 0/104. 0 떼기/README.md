# [level 0] 0 떼기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181847)


### 실행문
```java
class Solution {
    public String solution(String n_str) {
        
        String[] arr_str = n_str.split("");
        int work_num = 0;
        for(int i = 0; i < arr_str.length; i++) {
            if( arr_str[i].equals("0") ) {
                work_num ++;
            } else {
                break;   
            }
        }
        
        String answer = n_str.substring(work_num);
      
        return answer;
    }
}
```

##### 참고사이트


### 느낀점
```
ㅇㅁㅇ?
``` 