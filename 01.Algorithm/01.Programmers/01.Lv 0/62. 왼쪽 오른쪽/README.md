# [level 0] 왼쪽 오른쪽

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181890)


### 실행문
```java
class Solution {
    public String[] solution(String[] str_list) {
        
        String[] temp=new String[str_list.length];
        int count=0;
        
        for(int i=0;i<str_list.length;i++){
            if(str_list[i].equals("l")){
                for(int j=0;j<i;j++){
                    temp[count]=str_list[j];
                    count++;
                }
                break;
            }
            else if(str_list[i].equals("r")){
                for(int j=i+1;j<str_list.length;j++){
                    temp[count]=str_list[j];
                    count++;
                }
                break;
            }
        }
        
        String[] answer=new String[count];
        for(int i=0;i<count;i++){
            answer[i]=temp[i];
        }
        
        return answer;
    }
}
```


##### 참고사이트


### 느낀점
```
테스트 케이스를 추가해서 푼 첫번째 문제 같습니다.
처음 문제를 푼 방법으로 시도 했을때는 정확도가 75% 가 나와서 ?????????? 하고 소스를 계속 보았지만, 전혀 이상이 없는것 같아서 
문제를 천천히 읽어보니 'r' 로 된 프로토콜을 풀지 않았었고, 다 풀었는데도 85% 가 나와서 생각보다 긴 시간동안 풀었던 문제 같습니다.
여러 방법과 방어코드를 적용했음에도 85% 가 나와서, 조금은 낯선 방법으로 문제를 해결하느라 상당히 힘들었네요.
하지만 재미있, 역시 저는 아직 멀었습니다.
``` 