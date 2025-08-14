# [level 1] 두 개 뽑아서 더하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=java)


### 실행문
```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> num_list = new ArrayList <>();
        
        for(int i = 0; i < numbers.length-1; i++ ) {
            for(int j = i; j < numbers.length-1; j++ ){
                int a = numbers[i] + numbers[j+1];
                
                if(!num_list.contains(a) ) {
                    num_list.add(a);
                }
                
            }
        }
        
        Collections.sort(num_list);
        
        return num_list;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        Set<Integer> sumSet = new HashSet<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }
        
        // Set → List 변환 후 정렬
        ArrayList<Integer> result = new ArrayList<>(sumSet);
        Collections.sort(result);
        
        return result;
    }
}
```

##### 참고사이트

### 느낀점
```
이제 생각보다 제 생각을 정리하고, 정리한걸 코드로 풀어내는게 익숙해진 것 같네요.
별다른 무리 없이 풀긴했지만, Collections 같은 메소드는 제가 자주 사용하지 않으니 금방 까먹는 것 같아요.
중요한 메소드별이나 자주 쓰는 배열선언 같은건 따로 정리해놓고, 반복적으로 체크해야 하지 않을까 생각합니다.
메소드가 있으면 가지고 있는 문제가 한방에 해결될수도 있으니 ㅎㅎ
챗 형님은 Set 이라는 배열을 선언해서 거기에 다 넣고, ArrayList 형식인 result에 반환해서 정리하고 뱉네요.
처음 알았는데, HashSet 은 ArrayList 와 다르게 중복된 값을 허용하지 않아서 지금처럼 중복된 값들을 정리할때는 HashSet 배열을 이용해서 값들을 정리하면 따로 contains() 같은 메소드를 사용하지 않아도 
자동으로 정리되니 좋네요.
근데 아쉬운게 HashSet은 Collections.sort() 가 통하지 않아서 ArrayList로 빼는거보면... ㅋㅋ 코어를 잘 생각해서 필요한 길로 선택하는게 제일 좋을 것 같네요.
이번에도 너무 재미있었어요 ㅋㅋ 헤헤
``` 