# [level 1] 콜라츠 추측

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12943?language=java)


### 실행문
```java
class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        
       while(n != 1) {
            if(answer >= 500) {
                answer = -1;
                break;
            }

            if(n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            answer++;
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int num) {
        long n = num;

        for (int i = 0; i < 500; i++) {
            if (n == 1) return i;
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
        }

        return -1;
    }
}
```

##### 참고사이트

### 느낀점
```
해당 문제를 읽어볼때는 짝수와 홀수를 판별해서 각 항목에 맞는 계산식을 구하는 문제 였습니다.
콜라츠 라는 단어도 처음 들어보지만, 간단한 문제네? 하고 풀고 있는데 
예제 1, 예제 2는 통과가 나오는데, 500번 이상 돌았을때 -1 를 반환하는 예제 3에서는 계속 488번 에서 멈추고 계산하는 숫자도 1를 반환하는 이슈가 생기더라구요.
디버깅 해봐도 도저히 어떤 부분인지 헤매고 있었는데, 조금 생각해보니 1이 나오는게 말이 안되는 상황 같았습니다.
기하급수적으로 증폭이 될것 같았는데, 마지막에 1를 반환한다는건 int형에 문제가 아닐까 하는 생각이 들었고, long 형식으로 바꾸니 정상적으로 로직이 풀어졌습니다.
챗형님도 보니 그런 이슈 때문에 long n = num; 을 넣고 아예 시작하네요.
챗형님은 for문 자체에 500번을 걸어서 for문이 정상적으로 끝나면 -1 를 반환해서 if문이 필요없었고, 
for문 안에서 n == 1 이면 return 으로 i를 반환.
즉, 돌아간 횟수를 바로 반환하여 for문으로 더 가독성과 효율이 좋은 형식으로 풀어주셨네요... 역시 갓... 
아직 따라갈려면 멀었나봅니다.. ㅋㅋㅋ 
이번 문제도 너무 재미있었고, 솔직히 어이없었어요... ㅋㅋㅋㅋ int 미웡..
``` 

