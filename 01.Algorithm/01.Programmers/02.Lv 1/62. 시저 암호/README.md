# [level 1] 시저 암호

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12926)


### 실행문
```java
class Solution {
    public String solution(String s, int n) {
        
        String[] sp = s.split("");
        String answer = "";
        
        for(String spp : sp) {
            char c = spp.charAt(0);
            if(c == ' ') {
                answer += ' ';
            } else if( Character.isUpperCase(c) ) {
                answer += (char)(((c - 'A' + n) % 26) + 'A');
            } else if( Character.isLowerCase(c) ) {
                answer += (char)(((c - 'a' + n) % 26) + 'a');
            }
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(String s, int n) {
        
        String[] sp = s.split("");
        String answer = "";
        
        for(String spp : sp) {
            char c = spp.charAt(0);
            if(c == ' ') {
                answer += ' ';
            } else if( Character.isUpperCase(c) ) {
                answer += (char)(((c - 'A' + n) % 26) + 'A');
            } else if( Character.isLowerCase(c) ) {
                answer += (char)(((c - 'a' + n) % 26) + 'a');
            }
        }
        
        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
분명 해본 문제 같은데, 처음 보는 문제라서 어떤식으로 해야되는지 감도 안잡혔습니다.
s 로 문자열이 넘어오니까, 하나씩 split()으로 찢어서 isUpperCase() 같은걸로 어떻게 구분하고,
answer 변수에 다 넣어놓고, 마지막에 n 만큼 뒤에서 마이너스, n만큼 플러스 해서 하면되지 않을까!? 하고 처음에는 감을 잡았는데
도저히 그런식으로는 복잡해지고 답이 아닌것 같더라구요.
그래서 구글링과 챗형님의 도움으로 결국에는 간단한 답을 찾을 수 있었습니다
split()으로 다 찢어서 char 타입을 이용해서 (c-'A' + n) 이 공식이 해당 문자에 n번째 다음에 해당하는 문자이고, 
z 다음에 a가 와야하니까 ((c-'A' + n) % 26) 알파벳 숫자만큼 나누고, 거기에 이제 원래 문자로 복구 해주는 'A' 를 해주면!!!
(((c - 'A' + n) % 26 ) + 'A') 결국 이 공식이 해당 문제에 제일 핵심인것 같네요.
그리고 핵심인 공식을 쓰기위해서는 char 타입이 변환이 꼭 필요했습니다.
저 공식을 활용하면 어쨋든 하나씩 찢어와서 n번째에 해당하는 문자를 answer 변수에 쌓기 때문에 for문 한방이면 끝끝

크흐.. 챗형님... 넘나 대단하고... 구글링 해보니 이런 생각을 하신분들도 대단하고... 크흐...
아직 배울것이 넘나 많습니다... ㅠㅠ 
너무 재미있었고, 막상 다 해놓고 보면 이걸 생각못해!?! 하는데 문제 풀때는 너무 답답하고 바보같아서 서러워요 ㅠㅠㅠㅠㅠㅠ
``` 