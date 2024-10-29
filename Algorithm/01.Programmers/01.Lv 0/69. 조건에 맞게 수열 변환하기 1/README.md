# [level 0] 조건에 맞게 수열 변환하기 1

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181882)


### 실행문
```java
class Solution {
    public int[] solution(int[] arr) {
        
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] = arr[i] / 2;
            } else if(arr[i] < 50 && arr[i] % 2 == 1) {
                arr[i] = arr[i] * 2;
            }
        }
        
        int[] answer = new int[arr.length];
        for(int j = 0; j < arr.length; j++ ){
            answer[j] = arr[j];
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