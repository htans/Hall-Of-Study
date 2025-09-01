# [level 1] 포켓몬

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/1845)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        
        ArrayList<Integer> AL = new ArrayList<>();
        for(int i = 0; i < nums.length; i++ ) {
            if(!AL.contains(nums[i]) && AL.size() < max ) {
                AL.add(nums[i]);
            }
        }        
            
        return AL.size();
    }
}
```

### ChatGPT
```java
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        return Math.min(set.size(), max);
    }
}
```

##### 참고사이트

### 느낀점
```
문제가 굉장히 길고, 복잡하게 제시되어 있어서 문제를 이해하는데 굉장히 오래 걸렸습니다.
아직은 문제가 길고, 복잡해보이면 헉! 이거 어려운 문제인가!! 하면서 ㅎㄷㄷ 하는 경향이 남아있어서 그런것 같아요... ㅎㅎㅎ
차분하게 문제를 읽어보고 예제데이터를 통해서 결과값이 나오는 과정을 이해해보니 생각보다 어렵지 않은 문제 였습니다.
ArrayList() 배열을 사용해서 체크하는 로직을 작성했는데, 챗형님이 작성하는걸 보니 HashSet() 배열을 사용해서
HashSet() 배열에 중복되지 않게 다 넣어놓고,
마지막 return 할때는 Math.Min() 메소드를 사용해서 위에서 제시한 max값, HashSet()의 크기를 비교해서 작은 수를 반환하는군요...
제가 작성한 소스는 매번 ArrayList() 배열을 contains 하고, Max 값보다 작은지 체크해서 가독성과 성능이 떨어지는데
확실히 챗형님이 작성한 소스처럼 HashSet()과 Math.Min()을 사용하면 간단히 정리되네요... 크흐...
역시... 대단... 많은걸 배울 수 있었습니다 ㅎㅎㅎ
``` 