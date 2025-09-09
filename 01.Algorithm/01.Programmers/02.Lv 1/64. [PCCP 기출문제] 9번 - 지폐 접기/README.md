# [level 1] [PCCP 기출문제] 1번 - 지폐 접기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/340199)


### 실행문
```java
class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int minx = wallet[0];
        int miny = wallet[1];
       
        double x = bill[0];
        double y = bill[1];
        
        boolean chkFlag = false;
        int answer = 0;
        
        while(!chkFlag) {
            
            // 지갑 넣어봄
            if(x <= minx && y <= miny) {
                break;
            } else if (y <= minx && x <= miny) {
                break;
            }
           
            // 큰 쪽을 반으로 접어야함
            if(x > y) {
                x = Math.floor(x / 2);    
            } else {
                y = Math.floor(y / 2);    
            }
            
            answer++;
            
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int walletWidth = wallet[0];
        int walletHeight = wallet[1];
        int billWidth = bill[0];
        int billHeight = bill[1];
        
        int answer = 0;
        
        while (true) {
            if (fits(walletWidth, walletHeight, billWidth, billHeight)) {
                break;
            }
            
            // 긴 쪽을 반으로 접음
            if (billWidth >= billHeight) {
                billWidth /= 2;
            } else {
                billHeight /= 2;
            }
            
            answer++;
        }
        
        return answer;
    }
    
    private boolean fits(int wW, int wH, int bW, int bH) {
        return (bW <= wW && bH <= wH) || (bH <= wW && bW <= wH);
    }
}
```

##### 참고사이트

### 느낀점
```
항상 드는 생각은 소스보면 쉬워보이는데, 소스가 나오는 과정까지 오래 걸렸어요... ㅋㅋㅋ
큰쪽을 반으로 접어야하는데, X-Y 값 두개를 댕강 반으로 자르질 않나... ㅋㅋㅋ 실력이 없는게 코딩테스트를 하면서 들어나는것 같아서 부끄럽... ㅋㅋㅋ
하나 확실한건 전체적인 문제를 파악하고, 머리로 한번 돌려보고, 그걸 기점으로 잘라서 하나하나씩 코딩을 해보다보면 전체적인 소스가 나오고, 거기에서 줄일 부분과 중첩되는 부분, 문제되는 부분들이 하나씩 보이는것 같아요.
솔직히 0레벨 문제를 시작할때만해도 머리속으로 다 소스 돌려보고 요로요로요로롱 하는 모습을 상상했다면, 지금은 하나씩 한줄을 작성해보고, 다른 간단한 방법은 없는지, 이렇게 해결하는게 맞는지를 생각해보는 것 같아요.

챗형님은 firts() 라는 private 함수로 빼서 지갑에 들어가는지를 체크하는게 추가 되었네요.
굳굳 이번문제도 너무 재미있었고, 생각보다 오래걸려서 아쉽.. ㅠㅠ
``` 