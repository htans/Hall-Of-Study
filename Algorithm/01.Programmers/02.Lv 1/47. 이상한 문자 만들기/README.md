# [level 1] 이상한 문자 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12930)


### 실행문
```java
// 1단계 
class Solution {
    public String solution(String s) {
        
        String[] temp = s.split(" ");
        String answer = "";
        
        for(int i = 0; i < temp.length; i++ ) {
            
            for(int j = 0; j < temp[i].length(); j++ ) {
                if(j % 2 == 0) {
                    // 짝수 - 대문자
                    String str = String.valueOf(temp[i].charAt(j));
                    answer += str.toUpperCase();
                } else {
                    // 홀수 - 소문자
                    String str = String.valueOf(temp[i].charAt(j));
                    answer += str.toLowerCase();
                }
            }
            
            answer += " ";
            
        }
        
        return answer.trim();
    }

}

// 최종
class Solution {
    public String solution(String s) {

        String answer = "";
        String chkStr = "";

        int chkNum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            chkStr = String.valueOf(s.charAt(i));

            if( chkStr.equals(" ") ) {
                chkNum = 0;
                answer += " ";
            } else {
                if( chkNum % 2 == 0 ) {
                    // 짝수
                    answer += chkStr.toUpperCase();
                } else {
                    // 홀수
                    answer += chkStr.toLowerCase();
                }
                
                chkNum++; 
            }
        }
        
        return answer;
    }

}
```

### ChatGPT
```java
// 성능/가독성 위주 리팩토링
// - StringBuilder로 문자열 누적 (불필요한 임시 문자열 생성 제거)
// - 불필요한 임시 변수(chkStr) 제거, char 직접 처리
// - % 대신 비트 연산으로 짝/홀 판별(미세 최적화)
// - 변수명 의미 있게 정리

class Solution {
    public String solution(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder(s.length());
        int indexInWord = 0; // 공백으로 구분되는 단어 내 인덱스

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                // 공백이면 단어 인덱스 리셋
                indexInWord = 0;
                sb.append(' ');
            } else {
                // 짝수: 대문자, 홀수: 소문자
                boolean even = (indexInWord & 1) == 0;
                sb.append(even ? Character.toUpperCase(c) : Character.toLowerCase(c));
                indexInWord++;
            }
        }

        return sb.toString();
    }
}
```

##### 참고사이트

### 느낀점
```
막상 풀어놓고 보면 간단한데, 이번 문제는 생각보다 저한테는 난이도가 있는 문제였어요.
처음에는 split() 메소드를 이용해서 공백을 구분하고, 각 단어 별로 하나씩 홀수,짝수를 진행하는 형식이였는데
for문이 2번 들어가고, 가독성이 떨어져서 체크하는 것도 쉽지 않았습니다.
아예 처음부터 하는 마음으로 생각해보니 for문으로 공백을 구분할 필요가 없고, 공백을 기준으로 초기화 하면 되겠다 라는 마음이 들었습니다.
그래서 전체 문자열을 charAt() 메소드로 가져와서 하나씩 비교 했고, 덕분에 어렵지않게 마무리 할 수 있었습니다만.
챗형님은 String.ValueOf() 같은 타입변환없이 char 형식으로 바로 공백을 체크하시네요.
분명 제가 시도할때 안됬는데, 지금 생각해보면 안될거라고 생각하고 공부한지 얼마안된 String.ValueOf() 를 쓴걸지도..
덕분에 쓸때없는 타입변환은 빠지고, StringBuilder로 하나씩 append 하기 때문에 임시 문자열을 유지할 필요가 없군요.
그리고 a & 1 == 0 이건 처음본것 같아요.
보니까, 비트로 변환하면 짝수는 0이 나오고, 홀수는 1이 나오니까, 구지 길게 구분안해도 된다는것을 알 수 있었습니다.
이제 어느정도 풀수는 있겠는데, 확실히 챗형님은 못따라가겠어욬ㅋㅋㅋㅋ

그래도 넘나 재미있는 문제 였습니다!
``` 

