# [level 0] 문자열 겹쳐쓰기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181943)


### 실행문

```java
class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        String[] strOverwirte = overwrite_string.split("");  
        StringBuffer str = new StringBuffer(my_string);
        String answer = "";
        int len = strOverwirte.length;
        
        StringBuffer Delstr = str.delete(s,len + s);
        StringBuffer Insstr = Delstr.insert(s, overwrite_string);
        
        answer = Insstr.toString();
        
        return answer;
    }
}
```


##### 참고사이트
1. [참고 링크](https://www.appletong.com/entry/%EC%9E%90%EB%B0%94-String-%EC%9B%90%ED%95%98%EB%8A%94-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%B6%94%EC%B6%9C-indexOf-subString-chatAt-token-parseInt) 
2. [참고 링크](https://mozi.tistory.com/502) 


### 느낀점

```
항상 짧은 문제가 나오다가 조금 긴 문제가 나오니 많이 당황스러웠습니다.
'문제를 잘 읽어보고 해야지' 생각했지만, 어떤것이 필요한지에 신경이 몰려있어서, 제일 중요한 overwrite_string으로 바꿔서 출력해야 된다는것은 보지 못했습니다.
처음에는 삽질과 여러가지 쓸때없는 것을 찾아보느라 정신이 멍 했지만, 0단계에서 어려운 문제가 나올리 없다고 생각하고, 기본적인 메서드로 생각하고, 다 지우고 천천히 했습니다.
다 해놓고 정리해보니 5줄도 안나오는 코드인데, 핑계될것 없이 많이 부족하다 라는것을 느꼈습니다.
Stirng 과 StringBuffer 를 자주 사용했지만, 잘 알지도 모르고 사용한것 같아 문제도 중요하지만, 이 기회에 기본적인것들을 다시 배우면서 정리해야겠다고 생각했습니다.
코딩문제가 유명한 사이트인 만큼, 잘못 찾아가면 정답이 나와버리는 경우가 생기는데, 최대한 정답을 보지 않고, 프로토콜을 해결하는 방법과 메서드를 잘 활용해서 공부해야겠다는 생각이 다시금 들었습니다.
세상....
``` 
