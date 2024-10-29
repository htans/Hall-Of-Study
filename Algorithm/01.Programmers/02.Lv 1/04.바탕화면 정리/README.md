# [level 1] 바탕화면 정리

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/161990)


### 실행문
```java
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char target = '#';
        boolean test = false;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if ( wallpaper[i].charAt(j) == target ) {
                    if( !test) {
                        a = i;
                        b = j;
                        test = true;
                    } else {
                        if ( a > i ) {
                            a = i;
                        } else {
                            c = i;    
                        }
                        
                        if ( b > j ) {
                            b = j;
                        } else {
                            if ( d < j) {
                                d = j;    
                            }
                        }
                    }
                }
            }
        }
        
        if(c == 0 && d == 0) {
            c = a + 1;
            d = b + 1;
        } else {
            c = c + 1;
            d = d + 1;
        }
        
        answer[0] = a;
        answer[1] = b;
        answer[2] = c;
        answer[3] = d;
        
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    // 가장 위쪽, 왼쪽에 있는 파일 위치 갱신
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    // 가장 아래쪽, 오른쪽에 있는 파일 위치 갱신
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }
        
        return new int[] {lux, luy, rdx, rdy};
    }
}
```

##### 참고사이트


### 느낀점
```
이제 그림으로 문제가 나오니 숨질 것 같네요.
부끄럽지만, 이해하기도 어렵고, 그림을 보자마자 숨질 것 같은 느낌을 받을때가 많아요...
그래도 2일동안 틈틈히 생각을 해서 혼자서 풀긴했는데,
다 풀어놓고도 강하게 코드 개선과 간소화가 필요할거라는 생각잌ㅋㅋㅋㅋㅋㅋㅋㅋ
개선된 소스를 봐도 모르는 함수나 이해안되는 부분이 너무 많아서 이해하는데 오래 걸렸네요...
GPT형이 오지게 뺨 때려줘서 오늘도 흐뭇합니땅. ^ㅁ^// 꿀잼
``` 