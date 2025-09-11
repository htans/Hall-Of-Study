# [level 1] 체육복

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42862#)


### 실행문
```java
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        HashSet<Integer> SetL = new HashSet<>();
        HashSet<Integer> SetR = new HashSet<>();
        
        for(int l : lost) {
            SetL.add(l);
        }
        
        for(int r : reserve) {
            SetR.add(r);
        }
        
        // 체육복이 없으면서 여분이 있는애들은 제거
        HashSet<Integer> overlap = new HashSet<>(SetL);
        overlap.retainAll(SetR);
        SetL.removeAll(overlap);
        SetR.removeAll(overlap);
        
        // 빌릴 수 있는 애들은 제거
        for(int i : new HashSet<>(SetL)) {
            if( SetR.contains(i - 1) ) {
                SetL.remove(i);
                SetR.remove(i-1);
            } else if( SetR.contains(i+1) ) { 
                SetL.remove(i);
                SetR.remove(i+1);
            }
        }

        return n - SetL.size();
    }
}
```

### ChatGPT
```java
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        HashSet<Integer> SetL = new HashSet<>();
        HashSet<Integer> SetR = new HashSet<>();
        
        for(int l : lost) {
            SetL.add(l);
        }
        
        for(int r : reserve) {
            SetR.add(r);
        }
        
        // 체육복이 없으면서 여분이 있는애들은 제거
        HashSet<Integer> overlap = new HashSet<>(SetL);
        overlap.retainAll(SetR);
        SetL.removeAll(overlap);
        SetR.removeAll(overlap);
        
        // 빌릴 수 있는 애들은 제거
        for(int i : new HashSet<>(SetL)) {
            if( SetR.contains(i - 1) ) {
                SetL.remove(i);
                SetR.remove(i-1);
            } else if( SetR.contains(i+1) ) { 
                SetL.remove(i);
                SetR.remove(i+1);
            }
        }

        return n - SetL.size();
    }
}
```

##### 참고사이트

### 느낀점
```
와.. 진짜 엄청 어려운 문제 였어요....
조건으로만 봤을때 삼중 For문을 돌려야하나??? ㅇㅅㅇ???? 그건 좀 아닌뎈ㅋㅋㅋ 
하다가 힌트로 HashSet 배열을 사용해야한다는것을 알았습니다.
HashSet은 중첩이 안되는 배열로 알고 있는데, 이걸 대체 여기서 어떻게 활용하라는거지???? 한 30분 머리 쥐어뜯다가 유레카 외쳤네용 ㅋㅋㅋ
HashSet 배열을 직접 for문을 도는게 위험하다는것도 이번에 처음 알았습니다.
실제로 브라우저 컴파일러가 오류를 많이 뱉었고, 무슨 문제인지 또 한참 찾았네요.
구글링 해보니 임시 배열을 하나 더 만들면서 SetR 배열을 복사해놓고, retainAll() 로 교집함 값만 냄겨놓고!!
removeAll(overlap); 해주면!! 빡빡!! 크흐... 신기신기ㅋㅋㅋ 
마지막 조건에서는 for문에 직접 for(int i : new HashSet<>(SetL)) 로 돌리는데 이부분도 정말 신기했습니다.
처음 보는 문법인데, 막상 다른걸 어떻게 했지? 하면 생각이.. .ㅋㅋㅋㅋ 
짧지만 정말 강렬한 문제 였어요!@#!@$
``` 