# [level 1] 부족한 금액 계산하기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/82612?language=java)


### 실행문
```java
class Solution {
    public long solution(int price, int money, int count) {
        
        long answer = -1;
        long priceSum = 0; 
        
        for(int i = 1; i <= count; i++ ) {
            priceSum += price * i;
        }

        if(priceSum <= money ) {
            answer = 0; 
        } else {
            answer = priceSum - money;
        }
            
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public long solution(int price, int money, int count) {
        
        long totalCost = (long) price * count * (count + 1) / 2;
        return Math.max(totalCost - money, 0);
    }
}
```

##### 참고사이트

### 느낀점
```
와 대체 챗형님;;; 저걸 저 두줄로 끝내버리네요..
핵심은 저 totalCost 를 푸는 수식같아요. 분명 머리로는 아는문제인데..
price * count * (count + 1 ) / 2; 
솔직히 머리를 탁 쳤습니다.
처음에 제 소스에도 priceSum 변수를 int로 선언해서 정확도가 계속 떨어져서 나와서 어떤 부분이 문제가 있지? 쳐다보다가 return형 타입이 long이라서 타입 길이에 관련된 이슈일거라고 생각하고 long으로 타입을 바꿔서 했거든요...
무튼 챗형 쩐다..
머리속에 각인.. 그리고 꿀잼... 굳
``` 
