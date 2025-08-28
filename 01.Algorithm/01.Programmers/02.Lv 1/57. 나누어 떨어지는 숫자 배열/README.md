# [level 1] 나누어 떨어지는 숫자 배열

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12910?language=java)


### 실행문
```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> AL = new ArrayList<>();
        for(int i = 0; i < arr.length; i++ ) {
            if(arr[i] % divisor == 0 ) {
                AL.add(arr[i]);
            }
        }
        
        if(AL.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(AL);
        int[] answer = new int[AL.size()];
        
        for(int j = 0; j < AL.size(); j++ ) {
            answer[j] = AL.get(j);
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
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
문제에 조건들이 굉장히 많아서 아! 이거 까다롭겠다 생각했는데, 생각외로 쉽게 풀수 있었습니다.
나누어 떨어지는 값들의 갯수를 알수 없기에 넣을 배열을 어떻게 해야되나 생각했는데, 그때 떠오른게 ArrayList() 메소드 였고, 오랜만에 ArrayList()를 사용한것 같네요.
ArrayList() 배열의 size 크기가 0 이면 아무것도 없다는거니까, 바로 return new int[] {-1}; 로 해서 뱉어주면 되는거고, 그 이후에는 배열은 Array.sort() 를 써서 정렬시키면 되는데,
컬렉션이기 때문에, Collections.sort() 써서 오름차순을 해주고, 그 배열을 그대로 int[] answer 배열에 똑같은 사이즈로 뽁뽁 넣어서 반환해주면!!! 끝끝!!! ㅎㅎㅎㅎ

혹시 몰라서 오름차순이 아니라 내림차순으로 하면 어쩌나하고 그부분도 알아보니,
Collections.sort(AL, Collections.reverseOrder());, ArrayList.sort(Comparator.reverseOrder()); 로 하면 될것 같네요. 생각보다 낯선...

챗형님이 만드신걸 보면 당연히 부족하지만, 그래도 큰 틀은 비슷한것 같아서 만족합니다!!
정말 많은걸 배울 수 있었고, 자신감도 올라가는 문제 였어요!! ㅎㅎㅎ
``` 

