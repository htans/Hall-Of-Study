# [level 0] 카운트 업

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181920)


### 실행문
```java
class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1]; // 배열의 크기를 동적으로 조절
        int i = 0;
        
        for(; start_num <= end_num; start_num++) {
            answer[i] = start_num;
            i++;
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
공부할수록, 배열을 정말 모른다는 생각을 많이 합니다.
그리고 당연한 말이지만, Log를 더 확실히 봐야겠다는 생각을 매번 합니다.
``` 