# [level 0] 세 개의 구분자

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181862#)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
        
        String[] strArray = myStr.split("");
        String strResult = "";
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals("a") || strArray[i].equals("b") || strArray[i].equals("c")) {
                strResult += "-";
            } else {
                strResult += strArray[i];
            }
        }
        
        String[] strArray2 = strResult.split("-");
        ArrayList<String> strArray3 = new ArrayList<>();    
        for (int j = 0; j < strArray2.length; j++) {
            if (strArray2[j].length() != 0) {
                strArray3.add(strArray2[j]);
            }
        }
        
        String[] answer;
        if (strArray3.size() > 0) {
            answer = new String[strArray3.size()];
            for (int x = 0; x < strArray3.size(); x++) {
                answer[x] = strArray3.get(x);
            }
        } else {
            answer = new String[1];
            answer[0] = "EMPTY";
        }
        
        return answer;
    }
}

// 속도 관련 이슈로 변경
import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
        StringBuilder strResult = new StringBuilder();
        
        for (int i = 0; i < myStr.length(); i++) {
            char c = myStr.charAt(i);
            if (c == 'a' || c == 'b' || c == 'c') {
                strResult.append('-');
            } else {
                strResult.append(c);
            }
        }
        
        String[] strArray2 = strResult.toString().split("-");
        ArrayList<String> strArray3 = new ArrayList<>();
        
        for (String str : strArray2) {
            if (!str.isEmpty()) {
                strArray3.add(str);
            }
        }
        
        if (strArray3.size() > 0) {
            return strArray3.toArray(new String[0]);
        } else {
            return new String[] {"EMPTY"};
        }
    }
}
```


##### 참고사이트


### 느낀점
```
간단한 문제 같은데, 저는 어렵게 푸는 재주가 있는 것 같네요.
처음 프로토콜은 모든 문제를 패스 했지만, 결과 관련해서는 속도 이슈로 통과되지 않았습니다.
for문을 너무 많이 난발하는것 같아서 항상 걱정이였는데, 이 문제로인해 걱정한 부분을 집중적으로 고민하면서 배웠네요.
StringBuilder 를 사용하면 속도면에서 향상된다는 정보를 찾았고, 대입해서 수정해보니 통과를 할 수 있었습니다.
현업에서라면 ㅋㅋㅋ 오 되누 하면서 넘어갔을것 같은데, 반성이 되네용.
``` 