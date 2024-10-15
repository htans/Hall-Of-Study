# [level 1] 추억 점수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/176963)


### 실행문
```java
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int total = 0;
        
        HashMap<String, Integer> NamePoint = new HashMap<>();
        
        for (int i = 0; i < name.length; i++ ) {
            NamePoint.put(name[i], yearning[i]);
        }
        
        for (int x = 0; x < photo.length; x++ ) {
            for(int y = 0; y < photo[x].length; y++ ) {
                total += NamePoint.getOrDefault(photo[x][y], 0);
            }
            if (total > 0 ) {
                answer[x] = total;    
            }
            total = 0;
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        // HashMap 생성 및 데이터 저장
        HashMap<String, Integer> NamePoint = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            NamePoint.put(name[i], yearning[i]);
        }

        // 각 사진의 점수 합산 후 answer 배열에 저장
        for (int x = 0; x < photo.length; x++) {
            int total = 0;  // 행별로 초기화되는 로컬 변수
            for (String person : photo[x]) {
                total += NamePoint.getOrDefault(person, 0);
            }
            answer[x] = total;  // 총합을 answer 배열에 저장
        }

        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
확실히 ChatGPT에게 더 개선되고, 더 효율이 좋은 코딩을 해달라고 할때마다 반성하게 되네요.
어떻게 보면 당연히 처리 해야되거나, 문제가 될 수 있음을 제가 할때 알아서 처리하고 개선하고 방어해야 하는데 꼭 GPT 한테 물어보면 보이네요 ㅋㅋㅋㅋ
한참 부족한게 느껴지고, 더 어려운 문제도 많지만.
개꿀잼 ㅋ
``` 