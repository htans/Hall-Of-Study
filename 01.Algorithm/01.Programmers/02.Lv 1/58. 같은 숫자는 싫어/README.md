# [level 1] 같은 숫자는 싫어

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12906)


### 실행문
```java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++ ) {
            
            if(al.size() == 0) {
                al.add( arr[i] );
            } else {
                
                if( al.get( al.size()-1 ) != arr[i] ) {
                    al.add(arr[i]);
                }
                
                if( !al.contains( arr[i] ) ) {
                    al.add(arr[i]);
                }   
                
            }    
        }
    
        int[] answer = new int[al.size()];
        
        for(int j = 0; j < al.size(); j++) {
            answer[j] = al.get(j);
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // 처음이거나, 직전 값과 다를 때만 추가
            if (result.isEmpty() || result.get(result.size() - 1) != arr[i]) {
                result.add(arr[i]);
            }
        }

        // List → int[] 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
문제중에 * 마크가 있어서 뭔가 했는데, AI 코드 피드백을 받을 수 있는 문제 였습니다.
다행인지 불행인지 AI 피드백 없이 풀 수 있었는데, 문제를 살짝 읽고 아! 같은건 안들어가는구나! 하고 고민 많이 했는데.. ㅋㅋㅋ
결국에 ArrayList 도 contains() 메소드가 존재 했네요! 그래서 없을때만 추가 했었는데, 연속된 문자만 처내는 문구를 너무 늦게봤어요..
문제를 정말 잘 읽어봐야한다는 생각이 다시 또 떠오르는 문제였네요.
기존에 추가하는 부분을 al.get( al.size()-1 ) == arr[i] 전 부분이랑만 비교해서 다르면 추가하면 되었습니다.

그리고 처음에 있는 ai.size() == 0 은 al.isEmpty() 를 추가 했으면 더욱 더 좋은 소스였을텐데 ㅎㅎ 몰랐네용...
이번 문제도 너무 재미있었습니다 ㅎㅎㅎㅎ
``` 

