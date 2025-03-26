# [level 1] 숫자 짝궁

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131128)


### 실행문
```java
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        HashMap<String, Integer> xMap = new HashMap<>();
        HashMap<String, Integer> yMap = new HashMap<>();
        
        for (String x : X.split("")) {
            xMap.put(x, xMap.getOrDefault(x, 0) + 1 );
        }
        
        for (String y : Y.split("")) {
            yMap.put(y, yMap.getOrDefault(y, 0) + 1 );
        }
        
        List<String> result = new ArrayList<>();
        
        for(String key : xMap.keySet()) {
            if(yMap.containsKey(key)) {
                int minCount = Math.min(xMap.get(key), yMap.get(key));
                for(int i = 0; i < minCount; i++) {
                    result.add(key);
                }
            }
        }
        
        if(result.size() == 0 ) return "-1";
        
        result.sort(Comparator.reverseOrder());
        
        if(result.get(0).equals("0")) return "0";
        
        for(String s : result ) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 0부터 9까지 각 숫자의 등장 횟수를 저장할 배열
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        // X 문자열에서 각 숫자의 개수를 xCount에 저장
        for (char ch : X.toCharArray()) {
            xCount[ch - '0']++;
        }

        // Y 문자열에서 각 숫자의 개수를 yCount에 저장
        for (char ch : Y.toCharArray()) {
            yCount[ch - '0']++;
        }

        // 결과를 이어붙일 StringBuilder
        StringBuilder answer = new StringBuilder();

        // 큰 수부터 작은 수까지 순회하면서 짝꿍 숫자 만들기
        for (int i = 9; i >= 0; i--) {
            // X, Y에서 공통으로 등장하는 개수만큼 반복
            int count = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < count; j++) {
                answer.append(i); // 숫자를 결과에 추가
            }
        }

        // 공통된 숫자가 없는 경우
        if (answer.length() == 0) return "-1";

        // 0만 반복된 경우 (예: "0", "00", "000" 등)
        if (answer.charAt(0) == '0') return "0";

        // 만들어진 문자열 반환
        return answer.toString();
    }
}
```

##### 참고사이트

### 느낀점
```
코딩문제를 보면 티비나 어디에서 접했던 문제를 코딩으로 풀어야하는 문제가 제법 많은 것 같습니다.
머리로는 이해하고 풀수 있는데, 코딩으로 풀려고 하다보니 생각보다 어렵고, 처음보는 메소드들도 많고, 기억이 안나는 메소드들도 있더라구요.
처음 코딩문제를 풀때는 무조껀 합격을 위해서 코딩했다면, 이젠 시간이나 리소스도 문제가 되는걸 보니 참 신기하네요.
처음에는 answer 를 String 으로 처리해서 매번 새로운 String을 만들어서 처리가 오래 걸렸는데, StringBuilder를 활용하니 쉽게 통과되는것도 무서운 경험이였습니다.
결국에 다른쪽을 많이 건드렸는데, 결국 메소드 하나의 차이였다니..
이제는 푸는것도 중요하지만, 많이 풀어보고 많은 오류를 겪어봐야 할것 같다는 느낌이 드네요.
챗형이 문제를 푸는 경지를 보면 숫자는 배열로 하는게 가장 빠르고, 리소스가 적게 든다고 하고, 제가 30분 걸쳐서 만든 소스보다 더 효율적이고 가독성이 좋은 소스를 보니 허망하고 ㅋㅋㅋ
이번에도 너무 재미있었고, 많은걸 배운 문제 였습니다.
``` 