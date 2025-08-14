# [level 1] 숫자 문자열과 영단어

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/81301)


### 실행문
```java
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("zero", "0");
        map1.put("one", "1");
        map1.put("two", "2");
        map1.put("three", "3");
        map1.put("four", "4");
        map1.put("five", "5");
        map1.put("six", "6");
        map1.put("seven", "7");
        map1.put("eight", "8");
        map1.put("nine", "9");
        
        for(String key : map1.keySet() ) {
            s = s.replace( key, map1.get(key) );
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.Map;

class Solution {
    private static final Map<String, String> WORD_TO_NUMBER = Map.of(
        "zero", "0",
        "one", "1",
        "two", "2",
        "three", "3",
        "four", "4",
        "five", "5",
        "six", "6",
        "seven", "7",
        "eight", "8",
        "nine", "9"
    );

    public int solution(String s) {
        for (String word : WORD_TO_NUMBER.keySet()) {
            s = s.replace(word, WORD_TO_NUMBER.get(word));
        }
        return Integer.parseInt(s);
    }
}
```

##### 참고사이트

### 느낀점
```
이제 문제를 보면 문제를 정확하게 읽고, 밑에 있는 입출력 예제를 보면서 내가 이해한게 맞나 체크하기 시작했어요.
그리고 생각대로 입출력 예제도 잘 나오고, 포토콜이 정의가 되면 어떤식으로 그리고 어떤 메소드로 풀어야 되는지 생각해보는 습관이 생겼네요.
오우... 나도 몰랐는데.. 제가 그렇게 하니 신기.. ㅋㅋ
그리고 메소드 같은것을 적용해서 순차적으로 종이에 적어보고 그게 번호순으로 정리가 되면 그때 소스를 작성하는 순서가 생긴걸 이번에 느낀것 같아요.
어쩌면, 코딩테스트를 설명해주는 유튜브나 게시물에서도 다 이런식으로 하지만, 제 습관을 그리고 이걸 제가 온전하게 다 활용할려면 코어를 이해하고 풀어야한다는 생각이 있었는데,
지금은 생각하지 않아도 이 순차대로 가는것 같아서 다행이네요.
처음으로 챗형님이랑 크게 다르지 않은 프로토콜을 작성한것 같아서 저한테는 아주 중요한 코딩테스트 문제가 되겠네요.
챗형님이 말씀해준건 jdk 버전이 올라가면서 사용방법을 설명해준것 같고, 문제를 해결하는 코어는 똑같은것 같아서 다행입니다.
역시 실패할 생각으로 하면 언젠가 ㅋㅋㅋ
그리고 솔직히 replace() 메소드가 기억이 안나서 앞에서 어떻게 짤라야하나, 숫자랑 문자랑 비교해야되나 뻘짓을 겁나 했습니다.. ㅋㅋㅋㅋ
역시 꿀잼꿀잼 (*-*3)
``` 
