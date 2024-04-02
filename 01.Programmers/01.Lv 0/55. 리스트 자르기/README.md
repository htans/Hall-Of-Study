# [level 0] 리스트 자르기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181897)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= slicer[1]; i++) {
                list.add(num_list[i]);
            }
        } else if (n == 2) {
            for (int i = slicer[0]; i < num_list.length; i++) {
                list.add(num_list[i]);
            }
        } else if (n == 3) {
            for (int i = slicer[0]; i <= slicer[1]; i++) {
                list.add(num_list[i]);
            }
        } else {
            for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                list.add(num_list[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
n == 4 일때 문제 이해를 잘 가지 않아서 이해하는데 시간이 오래 걸린것 같습니다.
많은 문제를 풀어보고, 경험해보는것이 중요하다는것을 다시 한번 느끼는 문제였습니다.
``` 