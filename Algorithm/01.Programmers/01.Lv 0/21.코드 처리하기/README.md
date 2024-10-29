# [level 0] 코드 처리하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181932)


### 실행문

```java
class Solution {
    public String solution(String code) {
        String[] List_Code = code.split("");
        String answer = "";
        String ret = "";
        int mode = 0;
        
        for(int i = 0; i < List_Code.length; i++){
            
            if(List_Code[i].equals("1")) {
                if(mode == 0) {
                    mode = 1;
                } else {
                    mode = 0;
                }
            } 
            
            if(mode == 0 ) {
                if(!List_Code[i].equals("1")) { // '1' 이 아닐때
                    if(i % 2 == 0 ) { // 짝수 일때
                        ret += List_Code[i];
                    }
                }
            } else {
                if(!List_Code[i].equals("1")) { // '1' 이 아닐때
                    if(i % 2 == 1 ) { // 홀수 일때
                        ret += List_Code[i];
                    }
                }
            }
            
            // System.out.println(List_Code[i] + " " + mode + " " + ret);
            
        } 
        
        if(ret == "") { 
            ret = "EMPTY";
        }
        
        answer = ret;
        
        return answer;
    }
}
```


### 느낀점
```
생각보다 긴 문제라서 당황했고, 글만 읽어보고 코딩했을때는 결과물이 맞지 않았습니다.
입출력 예제에 있는 테이블과 코드에서 데이터를 찍어보면서 확인하니까, 정상적으로 풀 수 있었습니다.
문장을 끝까지 잘 읽어보는 습관과 히스토리를 찍어보면서 하나씩 해야하는 습관을 가져야 할 것 같습니다.
``` 