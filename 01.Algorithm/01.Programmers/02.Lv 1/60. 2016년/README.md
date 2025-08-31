# [level 1] 2026년

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12901)


### 실행문
```java
class Solution {
    public String solution(int a, int b) {
        
        // * 2016 == 윤년
        int total = 0;
            
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; 
        
        // 해당 날짜는 미포함
        for(int i = 0; i < a-1; i++) {
            total += days[i];
        }
        
        // +4 가 들어간건 1월1일이 금요일인데
        // 금요일은 week 배열에서는 [5]번째 == +5 를 해주는건데, 
        // 1일이 금요일인만큼, -1을 해줘야함
        // * 2일이 목요일일시는 [4]번째 == +4 인데, 
        // * 2일이 목요일인만큼, -2를 해서 +2 해줘야함
        int day = (total + b + 4) % 7;
        
        return week[day];
    }
}
```

### ChatGPT
```java
class Solution {
    public String solution(int a, int b) {
        // 2016년은 윤년 (2월 = 29일)
        int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; 
        
        // 1월 1일이 금요일(FRI=week[5]) 기준 → offset = 4
        final int OFFSET = 4;
        
        // 전달까지의 누적 일수
        int daysPassed = 0;
        for (int i = 0; i < a - 1; i++) {
            daysPassed += monthDays[i];
        }
        
        // 해당 달의 일수까지 포함
        daysPassed += b;
        
        // 요일 인덱스 계산
        int dayIndex = (daysPassed + OFFSET) % 7;
        
        return week[dayIndex];
    }
}
```

##### 참고사이트

### 느낀점
```
달력을 구하는 문제는 익숙한거같은데, 생각해보면 처음 풀어보는 문제 였습니다.
문제에서 얘기하는 2016년은 윤달이기 때문에 2월달이 29일까지 있고, 1월 1일이 금요일이라는 기준점을 잘 기억해서
해당 월에 일수만큼 for문을 돌면서 더하는데 해당하는 달은 더하면 안되니 -1 해주고, 
거기에 남은 일수를 더한 다음 7로 나눠서 나오는 숫자대로 week에 기준점을 이용해서 일을 가져오면 되는 문제 였습니다.
현업에서는 월일로 날짜를 구해오는 기능이나 쿼리들이 굉장히 많았는데, 생각해보면 코딩테스트 처럼 구해본적이 없어서 익숙하지만,
처음 풀어보는 문제가 아니였나 생각해봅니다!
챗형님이 풀어준걸 보니 OFFSET을 따로 계산해서 기준점까지 바로 찾아주네요!

문제 덕분에 윤년, 기준점의 개념에 확실히 배울 수 있었고, 너무나도 재미있었어요 ㅎㅎㅎ
``` 

