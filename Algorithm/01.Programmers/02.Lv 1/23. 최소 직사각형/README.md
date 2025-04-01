# [level 1] 최소직사각형

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86491)


### 실행문
```java
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int a = 0;
        int b = 0;
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < sizes.length; i++ ) {
            if(sizes[i][0] < sizes[i][1]) {
                a = sizes[i][1];
                b = sizes[i][0];
            } else {
                a = sizes[i][0];
                b = sizes[i][1];
            }
            
            if(x < a) {
                x = a;
            } 
            if (y < b){
                y = b;
            }
            
        }
        
        return answer = x * y;
    }
}
```

### ChatGPT
```java
class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }
}
```

##### 참고사이트

### 느낀점
```
생각나는대로 막 풀다보니까 핵심포인트인 정렬이 필요해보이더라구요.
그래서 ??? 상태에서 채점을 눌렀는데 제가 작성한 소스지만 뭔가 빈약해보이고 찝찝하더군요 ㅋㅋㅋㅋ
그래도 패스가 되서 넘겼는데,
챗형이 핵짐을 딱 집어주시네요.
Math.max, Math.min 을 사용해서 maxWidth, maxHeight 만 비교해서 끌고가면 되는거였습니다.
이제 뭔가 알듯말듯 포인트를 알듯말듯 하면서 극혐...
하지만 너무 재미있었음 ㅎㅎㅎ
``` 