# [level 1] 두 정수 사이의 합

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12912)


### 실행문
```java
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int ta = a;
        int tb = b;
        
        if(b < a) {
            ta = b;
            tb = a;
        }
        
        for(int i = ta; i <= tb; i++ ) {
            answer += i; 
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        // 등차수열 합 공식: (첫항 + 끝항) * 항의 개수 / 2
        return (long)(min + max) * (max - min + 1) / 2;
    }
}
```

##### 참고사이트

### 느낀점
```
매번 어려운 문제만 나오다가 갑자기 쉬운문제가 나온것 같아서 의문 이였습니다.
for문으로 감싸면 되겠구나 했는데, 조건중에 a보다 b가 작은경우가 있었고, 그냥 생각나는대로 if문을 넣어서 처리했는데,
하면서도 이렇게 해도 되긴할텐데, 문제에서 원하는게 이게 아닐텐데!!! 하면서 끝내버렸네요... ㅋㅋ
챗형님이 작성하신것을 보니 문제가 원하는 방향과 어떤것을 알려주고 했는지 한눈에 파악이 가능했습니다.
Math.Max(). Math.Min() 메소드로 에러를 방지하고, 등차수열 공식을 대입해서 별도에 for문 없이 바로 반환하네요.
문제의 핵심은 등차수열 공식인 (min + max) * (max - min +1) / 2; 공식을 대입해서 푸는것이 핵심인것 요네요.

역시 챗형님.. 분명 공식들도 다 배운것이지만 안쓰다보니 기억에서 사라지고, 이렇게 코딩문제에 대입해서 써보니까 
오래된 메모리를 다시 살리는 느낌이고, 더 재미있는것 같아요!!! ㅎㅎㅎ
이번 문제도 너무 재미있었습니다!!
``` 

