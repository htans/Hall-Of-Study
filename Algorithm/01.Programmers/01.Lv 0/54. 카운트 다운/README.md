# [level 0] 가까운 1 찾기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181898)


### 실행문
```java
class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        
        for(int i = idx; i < arr.length; i++) {
            if(idx <= i && arr[i] == 1) {
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
테스트 문제 과정에서 계속 실패 결과가 나와서 많이 고민을 했습니다.
질문하기에서 문제 자체에 이슈가 있는것을 알았고, 다행히 해결 할 수 있었습니다.
그리고 테스트 케이스를 통과했는데, 결과 테스트에서 정확도가 23%가 나와서 뭐지? 했었는데
다양한 테스트 케이스를 넣고 테스트 해보니, break가 필요한 부분 이였습니다.
``` 