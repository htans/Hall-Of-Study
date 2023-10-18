# [level 0] 이어 붙인 수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181928#)


### 실행문

```java
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sum = 0; 
        int sum2 = 0; 
        String sumstr = "";
        String sumstr2 = "";    
        
        for(int i = 0; i < num_list.length; i++) {
            
            if(num_list[i] % 2 == 1) {
                sumstr += "" + num_list[i];
            }
            
            if(num_list[i] % 2 == 0) {
                sumstr2 += "" + num_list[i];
            }
            
            if(num_list.length -1 == i ) {
                int intstr = Integer.parseInt(sumstr);
                int intstr2 = Integer.parseInt(sumstr2);
                
                answer = intstr + intstr2;
            }

        }
        
        return answer;
    }
}
```


### 느낀점
```
문제를 읽고, 컴파일을 해보니 문제1은 통과가 되는데, 문제2가 통과가 안되어서 문제를 계속 읽어봤는데 잘못된줄 알았습니다. 
하지만, 함정이네요... 
홀수 자릿수가 아니고, 인자에 홀수, 짝수를 구분하는거였습니다. 
하지만, 많은 사람들이 푼 문제가 절대 이럴리가 없다는 생각으로 다시 입출력 예제를 보면서 읽어보니 제가 잘못되었네요.
또 한번 반성하고, 변수명과 변환하지 않아도 계산할 수 있는 식을 더 공부해봐야겠네요. 
``` 