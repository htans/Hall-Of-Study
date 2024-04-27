# [level 0] 조건에 맞게 수열 변환하기 2

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181881)


### 실행문
```java
import java.util.ArrayList;

class Solution {
    public int solution(int[] arr) {
        
        ArrayList<Integer> temp_before = new ArrayList<>();
        ArrayList<Integer> temp_after = new ArrayList<>();    
        boolean work_flag = false;
        int work_num = 1;
        
        for(int i = 0; i < arr.length; i++) {
            
            if(arr[i] < 0) {
                work_flag = true;
                break;
            } else {
                if(arr[i] >= 50 && arr[i] % 2 == 0) {
                    temp_after.add(arr[i] / 2 );
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    temp_after.add((arr[i] * 2) + 1 );
                } else { 
                    temp_after.add(arr[i]);
                }
            }
        }
    
        int answer = 0;
        if (!temp_after.isEmpty() && temp_after.size() < 1000000) { 
            while(!work_flag) {
                
                temp_before = new ArrayList<>(temp_after); 
                temp_after.clear(); 

                for(int j = 0; j < temp_before.size(); j++) {
                    int value = temp_before.get(j); 
                    if (value >= 100) {
                        break;
                    } else {
                        if (value >= 50 && value % 2 == 0) {
                            temp_after.add(value / 2 );
                        } else if (value < 50 && value % 2 == 1) {
                            temp_after.add((value * 2) + 1 );
                        } else { 
                            temp_after.add(value);
                        }    
                    }
                }
                
                if (temp_before.equals(temp_after)) {
                    if (work_num == 1) {
                        answer = 0;
                        work_flag = true;
                    } else {
                        answer = work_num;
                        work_flag = true;     
                    }
                } 
                work_num++;   
            }    
        } 
        
        return answer;
    }
}

```


##### 참고사이트


### 느낀점
```
심각한 뻘짓을 한것 같습니다.
검색하면 코드야 많이 나오고, 더 효율적으로 짧은 코드가 있지만, 이상한 고집때문에 제가 작성한 로직으로
문제를 해결하고 싶었던것 같습니다.
계속 시도 했지만, 테스트에서 부분적으로 실패가 나와서 고생좀 했습니다.
채점 후 결과는 데이터가 나오지 않기 때문에 계속 다른 방법과 제한사항도 시도 해보다가 결국에는 일부로 에러를 만들어서
테스트를 처음 해본것 같습니다.
다행히 0 처리에서 이슈가 있다는것을 알았고, 잘했든 못했든 해결은 한것 같습니다만,
다른분들의 소스를 보니 더 간략하고, 심플하게 로직을 설계하면 마주치지 못할 이슈 같습니다.
몸소 코드의 간략화를 경험해 볼 수 있는 문제 였습니다.
숨질뻔 했네요 ^ㅁ^;;
``` 