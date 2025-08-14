# [level 1] 제일 작은 수 제거하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12935)


### 실행문
```java
class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length < 2) {
            return new int[]{-1};
        }
        
        // 최소 값 추출
        int Min = arr[0];
        for (int num : arr) {
            if (num < Min) {
                Min = num;
            }
        }
        
        // 새로운 배열 생성
        int[] answer = new int[arr.length - 1];
        int idx = 0;
        
        for(int num : arr ) {
            if(Min != num) {
                answer[idx++] = num;
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length < 2) return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(x -> x != min).toArray();
    }
}
```

##### 참고사이트

### 느낀점
```
조금은 익숙해진 문제 형식이라서 어떤식으로 풀어야겠다 라는 방식은 어렵지 않게 떠올렸는데,
매번 제 코딩 스타일이 for(int i = 0; i < test; i++) 이런 스타일이라서 이번 문제에서는 최대한 그걸 벗어나고자 노력해본것 같아요.
문법이 익숙하지 않아서 찾아보긴했지만... ㅋㅋ 그래도 확실히 스타일을 바꿔서 풀어보니 직관적이고, 
직관적이다보니 디버깅 하기에도 편안 장점을 많이 느꼈습니다.
answer[idx++] = num; 같은 부분이 익숙해지기 쉽지 않을것 같은데, 이번 기회에 잘 배울 수 있어서 다행이고, 앞으로 코딩스타일을 바꿔볼 생각 입니다.
챗형님은 Stream API 로 풀어주셨는데, 확실히 Stream API는 전혀 다른 세상인것 같아요.
Stream API 도 기억이 흐릿해서 개념정리를 다시 했는데, API를 사용하는 만큼 API 자체의 명칭도 익숙해져야할 것 같고, 
해당 API의 사용방법과 조합방법도 익숙해질 필요가 있겠구나 라는 생각이 드네요.
회사 코드리뷰나 백엔드 부분에 많이 쓰인다고 하니 직관적이고, 효율성이 보장되기 때문에 이지 않을까 싶습니다.
코드리뷰 할때 각 개발자마다 프로토콜이 다를텐데 매번 해석에 시간을 많이 쓸수도 없으니까, 협업을 위해 규격화를 하는 틀이 아닌가 생각하네요.
하지만, 코딩테스트는 프로토콜을 생각해내고, 효율적인 문제해결이 포인트이니까, 지금은 Stream API를 메인으로 하지 않을 생각이에요!

이번 문제도 꿀잼 ㅎㅎㅎㅎㅎ
``` 

