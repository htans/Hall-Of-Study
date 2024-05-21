# [level 0] 문자열 바꿔서 찾기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181864)


### 실행문
```java
class Solution {
    public int solution(String myString, String pat) {
        
        String[] strArray = myString.split("");        
        String[] strNum = new String[myString.length()];
        String strNum2 = "";
        int answer = 0;
        
        for(int i = 0; i < strArray.length; i++) {
            if(strArray[i].equals("A")) {
                strNum[i] = "B";
            } else if(strArray[i].equals("B")) {
                strNum[i] = "A";
            }
        }
        
        for(int j = 0; j < strNum.length; j++) {
            strNum2 += strNum[j];
        }
        
        if(strNum2.contains(pat)) {
            answer = 1;
        }

        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
ㅇㅅㅇ;;;;
``` 