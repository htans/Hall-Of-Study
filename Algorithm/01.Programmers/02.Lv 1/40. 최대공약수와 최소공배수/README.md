# [level 1] 최대공약수와 최소공배수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=java)


### 실행문
```java
class Solution {
    public int[] solution(int n, int m) {
        
        int a = 0;
        int b = 0;
        
        if(n > m ) {
            a = n;
            b = m;
        } else {
            a = m;
            b = n; 
        }
        
        while( b != 0 ) {
            int temp = 0;
            temp = a % b;
            a = b; 
            b = temp;
        }
        // System.out.println("계산 GCD : " + a);
        
        // LCM = n * m / GCD
        int lcm = n * m / a;
        // System.out.println("계산 LCM : " + lcm);
        int[] answer = {a, lcm};
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int lcm = n * m / gcd;
        return new int[]{gcd, lcm};
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
```

##### 참고사이트

### 느낀점
```
퇴사하고, ForYouJOB 프로젝트를 개발하느라 코딩테스트를 두달만에 한것 같네요.
프로젝트 진행 동시에 코딩테스트도 한문제씩 하려고 했는데, 양쪽 토끼를 못잡을 것 같아서 프로젝트에 집중하고 다 끝내고 돌아왔는데 어머...
오랜만에 코딩테스트를 하는만큼 감각이 많이 사라진게 느껴지네요.
for문으로 solution을 돌리지 않나 ㅋㅋㅋ 세상...
꾸준히 해야겠다는 마음을 강력하게 느꼈습니다. ㅋㅋ
문제도 처음에 잘못 읽어서 최소공배수, 최대공배수 이렇게 읽어서 1분정도 ???? 떠 있었네요... 반성...
최대공약수, 최소공배수는 % 로 처리로 여러가지를 시도 했지만, 시원한 프로토콜을 발견 못하고 있다가 유클리드 호제법을 발견했습니다.
도저히, 바로 소스로 표현할 수 없을것 같아서 다시 배운다는 마음으로 종이에 3문제 정도 풀어보고 풀이과정을 토대로 소스로 변환했습니다.
변환하면서도 쓸때없는 변수와 매칭되지 않는 이름들을 사용했지만. 감각이 돌아오기 위해서는 일단 풀어야한다는 마음으로 임했네요.
챗형님을 보니 따로 getGCD를 선언해서 최소공배수를 구하는 펑션을 따로 빼놓고, 보기편하게 gcd, lcm을 출력해주시네요.
역시.. 넘우 현타... ㅋㅋ 하지만 재미있었습니다.
난이도는 높지 않지만, 퇴사 후 여러 마음이 붕 떠있는데 그런걸 다잡아주는 문제로 기억할것 같습니다.
더 열심히 해야징 ㅋㅋ 역시 꿀잼입니다.
``` 

