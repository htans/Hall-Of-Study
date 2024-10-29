# [level 0] 원소들의 곱과 합

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181929)


### 실행문

```java
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int num1 = 0;
        int num2 = 0;
        
        for(int i = 0; i < num_list.length; i++) {
            
            if(num1 == 0) {
                num1 = num_list[i];
                num2 = num_list[i];
            } else {
                num1 = num1 * num_list[i];    
                num2 = num2 + num_list[i];    
            }
            
            if (i == num_list.length - 1) {
                
                double num2_test = Math.pow(num2, 2);
                num2 = (int) Math.ceil(num2_test);
                
                if(num1 < num2) {
                    answer = 1;
                } else {
                    answer = 0;
                }
                
            }
        }
        
        return answer;
    }
}
```


### 느낀점
```
ㅋ
``` 