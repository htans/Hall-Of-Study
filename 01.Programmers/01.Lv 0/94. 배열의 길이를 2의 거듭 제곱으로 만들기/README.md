# [level 0] 배열의 길이를 2의 거듭제곱으로 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181857)


### 실행문
```java
class Solution {
    public int[] solution(int[] arr) {

        int work_Num = 0;         
        for(int i = 0; work_Num < arr.length; i++) {
            work_Num = (int)Math.pow(2, i);
        }
                
        int[] answer = new int[work_Num];
        for(int j = 0; j < work_Num; j++) {
            if(j < arr.length) {
                answer[j] = arr[j];
            } else {
                answer[j] = 0;
            }
        }
        
        return answer;       
    }
}
```

##### 참고사이트


### 느낀점
```
ㅋ
``` 