# [level 0] 글자 이어 붙여 문자열 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181915)


### 실행문
```java
class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        
        String[] my_string_arr = new String[my_string.length()];
        
        for(int i = 0; i < my_string.length(); i++ ) {
            my_string_arr[i] = String.valueOf(my_string.charAt(i));
        }
        
        for(int j = 0; j < index_list.length; j++) {
            answer += my_string_arr[index_list[j]];
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅋ
``` 