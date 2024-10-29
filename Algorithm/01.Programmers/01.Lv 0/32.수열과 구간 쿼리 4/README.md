# [level 0] 수열과 구간 쿼리 4

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181922)


### 실행문
```java
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
      
        for(int i = 0; i < arr.length; i++ ) {
            for(int j = 0; j < queries.length; j++) {
                int Inqueries[] = queries[j];
                
                if(Inqueries[0] <= i) {
                    if(i <= Inqueries[1]) {
                        if(i % Inqueries[2] == 0) {
                            arr[i] = arr[i] + 1;
                        }
                    }
                }   
            }
        }
        
        answer = arr; 
        
        for(int i = 0; i < answer.length; i++ ) {
            System.out.println(answer[i]);
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
for문 사용하는 방법을 많이 배워야 할것 같습니다.
for문에서 여러 문제들이 발생했고, 머리로만 풀려다가 시간을 옴팡지게 보내고, 천천히 로그를 찍어보면서 해결할 수 있었습니다.
어쩌면, 코딩테스트는 정확한 프로토콜과 실수가 났을때 대처법을 알려주는 것 같네요.
그리고 문제에서 i 를 사용해야하는것을 문제 이해를 잘못해서 시간을 보내는 경우가 많았고,
코드 실행에 테스트 문향은 통과 했는데, 제출 후 채점에서 테스트 케이스들을 통과 못하여서 ??? 했지만...
역시 저의 실수 였습니다.
누군가에겐 ㅈ밥문제겠지만, 저는 뿌듯뿌듯 합니당
``` 