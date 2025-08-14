# [level 0] 순서 바꾸기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181891)


### 실행문
```java
import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {

        int A_NewSize = num_list.length - n; 
        int B_NewSize = num_list.length - A_NewSize;
        
        int[] A_List = new int[A_NewSize];
        int[] B_List = new int[B_NewSize];
        
        for(int i = 0; i < A_NewSize; i++ ) {   
            A_List[i] = num_list[n + i ];
        }
        
        for(int i = 0; i < B_NewSize; i++ ) {   
            B_List[i] = num_list[i];
        }
        
        int Total_NewSize = A_List.length + B_List.length;
        int[] answer = new int[Total_NewSize];

        System.arraycopy(A_List, 0, answer, 0, A_List.length);
        System.arraycopy(B_List, 0, answer, A_List.length, B_List.length);
        
        return answer;
    }
}
```


##### 참고사이트
1. [참고 링크](https://hianna.tistory.com/601) 

### 느낀점
```
간단한 문제 였던것 같은데, 구글링해서 여러 정보들을 사용할때 대충보고 사용한다는것을 느꼈습니다.
arraycopy 경우 정확하게 보지 않고, 사용해서 answer 배열이 이상하게 나온다던지, 프로토콜 도중에 문제가 있는것을 눈치 못채고 다른곳에서 문제를 찾고 있다던지
천천히 그리고 꼼꼼히 본다면 전혀 나타나지 않을 문제 였지만, 다양하게 문제가 발생하는것을 보고 개발 뿐만이 아닌. 저의 생활에서 까지도 천천히 그리고 꼼꼼히 하는 마음가짐이 중요하다는것을 알게 되었습니다.

코딩 테스트 짱
``` 