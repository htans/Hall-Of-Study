# [level 0] 배열 만들기 4

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181918)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> result = new ArrayList<> ();
        
        int i = 0;
        for(;;) {            
            if(i < arr.length) {
                if(result.size() == 0 ) {
                    result.add(arr[i]);
                    i++;
                } 
                else if(result.get(result.size() - 1) < arr[i]) {
                    result.add(arr[i]);
                    i++;
                } else if(result.get(result.size() - 1) >= arr[i]) {
                    result.remove(result.size() - 1);
                }
            } else {
                break;
            }
        }

        int[] stk = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            stk[j] = result.get(j);
        }
        
        return stk;

    }
}
```


##### 참고사이트


### 느낀점
```
배열을 다양하게 선언해서 문제를 풀 수 있다는 사실을 매번 깨닫고 있습니다.
당연한 이야기지만, 배열의 자리수와 값을 정확하게 이해하고, 문제를 정확하게 읽어야 답을 풀 수 있다는것도 매번 느끼고 있습니다.
문제를 잘못 읽거나, 잘못 이해해서 문제 푸는 시간이 늘어나는 경우가 많습니다.
그게 실력이겠지만, 실수가 나오면 정답이라는것에 초점을 두지 않고, 문제에 나온 조건이 잘 들어가 있는지, 프로토콜이 제대로 돌아가고 있는지,
순차적으로 해결하는 방법을 습득한것 같습니다.
하지만 아직까지 ㅈ밥이네요. 
``` 