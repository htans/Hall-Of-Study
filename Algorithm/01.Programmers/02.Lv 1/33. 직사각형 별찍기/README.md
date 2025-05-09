# [level 1] 직사각형 별찍기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12969?language=java)


### 실행문
```java
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 0; i < b; i++ ) {
            String c = "";
            for(int j = 0; j < a; j++) {
                c += "*";
            }
            System.out.println(c);
        }
        
    }
}
```

### ChatGPT
```java
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder row = new StringBuilder();
        for (int i = 0; i < a; i++) {
            row.append("*");
        }

        for (int i = 0; i < b; i++) {
            System.out.println(row);
        }
    }
}
```

##### 참고사이트

### 느낀점
```
문제가 대학생때 전공공부할때 풀었던 트리만들기, 순차적으로 별모양 찍기 에서 본 문제랑 비슷한 느낌을 받았습니다.
나름 경력이 이제 생겼다고, For문안에 For문을 쓰는게 찝찝해서 다른 방법으로 이것저것 고민하다가 혼자서 룰을 만든 제한시간 30분이 넘어가서
첫번째로 풀었던 For문안에 For문으로 마무리 했네요.

생각해보면 이중For문이 리소르를 많이 잡아먹고, 비효율적인건 알고 있지만 다른 방법을 어떻게 해야할지 고민은 해본적이 거의 없는 것 같아서 부끄럽습니다만, 이번 문제로 이해를 하고 넘어가자하고 접근했습니다.
챗형님이 작성한걸 보면 StringBuilder에 미리 한줄을 넣어놓고, 출력할 b 라인만큼 출력했네요.
제가 사용한 String 변수에 += 로 넣는것은 값이 커질수록 느리고, For문을 돌릴때마다 String 변수를 생성하기 때문에 속도에서도 이점이 없다는것을 알았습니다.
챗형님이 작성해주신건 그 2가지 문제를 모두 보안할 수 있는 명답이네요.

아! 그리고 이중for문을 사용하는것은 당연하게 시간복잡도가 증가하니까, 당연히 성능이 저하되고, 가독성도 떨어진다는것을 이 작은 문제로 명확하게 알았네요.
모든 조합을 구하는것, 2차원 배열 같은 문제에는 이중for문이 최고의 방법이지만...
필요한 상황 이외에는 이중 for문은 최대한 사용하지 않고, 앞으로도 다른 방법을 지향해야할 것 같아요 ㅎㅎ

이번문제는 어렵지는 않지만, 기초적인 생각을 잡게 해줘서 너무 좋았습니다.
``` 