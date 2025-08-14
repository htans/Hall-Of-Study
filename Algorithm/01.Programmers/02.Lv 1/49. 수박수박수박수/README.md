# [level 1] 수박수박수박수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12922)


### 실행문
```java
class Solution {
    public String solution(int n) {
        
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++ ) {
            if( (i & 1) == 1 ) {
                str.append("박");
            } else {
                str.append("수");
            }
        }
        
        String answer = str.toString();
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(int n) {

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append((i & 1) == 0 ? '수' : '박');
        }

        return sb.toString();
    }
}
```

##### 참고사이트

### 느낀점
```
원래의 저라면 홀짝 비교할때 % 연산자를 사용해서 answer 변수에 += "수" : "박" 처럼 집어넣었을텐데
지금은 어느정도 문제를 풀고 했다보니 % 연산자보다 & 연산자로 비트로 비교하는것이 더 빠르고 효율적이라고 했는데, 요즘에는 별 차이 없다고 하더라구요... ㅋㅋㅋ
알고 있다고 어필 해보고 싶은 순간...
그리고 answer 변수에 매번 담다보면 answer 임시변수를 for문이 전체 돌때마다 매번 가지고 있어야해서 비효율이라는것도 알고 있지요 ㅎㅎㅎ
그래서 StringBuilder 메소드. 메모리 변수를 사용하여 처리 하였습니다!

굳굳
``` 

