# [level 2] 타겟 넘버

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43165)


### 실행문
```java
class Solution {
    
    int[] numbers;
    int target;
    int answer;
    
    void dfs (int index, int sum) {
        // 1. 탈출 조건
        if( index == numbers.length ) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        // 2. 수행동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        
        answer = 0; 
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
}
```

### ChatGPT
```java
class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        System.out.println("최종 answer = " + answer);
        return answer;
    }

    void dfs(int[] numbers, int depth, int sum, int target) {
        // 현재 상태 출력 (depth, sum 값 확인)
        System.out.println("depth=" + depth + ", sum=" + sum);

        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
                System.out.println(">>> target 도달! sum=" + sum + ", answer=" + answer);
            }
            return;
        }

        // 현재 숫자 출력
        System.out.println("numbers[" + depth + "]=" + numbers[depth]);

        // + 선택
        dfs(numbers, depth + 1, sum + numbers[depth], target);

        // - 선택
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
}
```

##### 참고사이트
1. [참고 링크](https://www.youtube.com/watch?v=S2JDw9oNNDk&t=198s)

### 느낀점
```
부끄럽지만, DFS 라는 문자를 처음 본것 같습니다.
문제 자체는 이해할 수 있었지만, 이걸 어떤식으로 소스로 풀어야할지 어떤방식으로 해야할지도 감이 안왔던것 같아서 구글링을 해봤는데, 정답을 봐도 도저히 멘붕 ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
여러 포스팅도 보고, 유튜브도 찾아봤지만, 제가 부족해서겠지만 참고링크에 있는 유튜브를 통해서 소스를 이해할 수 있었습니다.
구글링과 유튜브를 보면서 전체적인 내용도 이해할 수 있었는데,

DFS(깊이 우선 탐색) - 드라마를 하나만 몰아본다 / 경우의 수를 전체를 다 보는 방식이고, 500만개가 넘을경우 시간초과로 뜰 수 있어서 미리 경우의수를 계산하고 접근하는게 좋음
BFS(넓이 우선 탐색) - 드라마를 여러개로 하나씩 본다 / 이건 아직 냄겨놔야겠 ㅎㅎㅎ 궁금궁금

결국에 문제는 DFS 방식을 이용해서 경우의 수를 도출하는 방식인데
전역 변수를 통해서 리소르를 더 효율적으로 관리하는것도 덤으로 배울 수 있었고, 제일 중요한건 수행동작을 먼저 작성하고, 탈출조건을 작성해야 조금 더 생각대로 소스가 나온다는것을 느낄 수 있었습니다.
결국에 index 와 sum 으로 간단하게 문자를 만들어놓고, 머리속에 있는 그림을 통해서 하나씩 출력하는것처럼 하니 이해할 수 있었지만.
재귀함수 라는 것을 확실하게 이해하고, 코딩테스트나 여러 방면에서 활용을 하려면 관련된 문제는 더 풀어봐야 하는것이 확실하네요.
어떻게 보면 대표적인 문제를 이제 처음 푼것이고, 여러문제를 더 풀어보고, 어떤방식으로 풀어야할지 알았으니까, 실제로 어떤식으로 적용을 시킬건지 생각하는 힘과 동작하는 모습들을 더 봐야 재귀함수를 더 완벽하게 이해할 수 있을 것 같아요.

문제들이 더 어려워지고, 복잡해지는데 더 재미지는건 맞... ㅎㅎㅎㅎㅎㅎㅎ
``` 