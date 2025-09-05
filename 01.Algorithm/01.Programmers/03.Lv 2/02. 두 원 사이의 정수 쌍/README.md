# [level 2] 두 원 사이의 정수 쌍

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181187)


### 실행문
```java
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 0; i <= r2; i++) {
            
            int maxY = (int)Math.floor( Math.sqrt( (long)r2*r2 - (long)i * i));
            int minY = 0;
            if(i < r1) {
                minY = (int)Math.ceil( Math.sqrt( (long)r1*r1 - (long)i * i ));
            }
            answer += (maxY - minY + 1);
        }
        
        answer = answer * 4 - ((r2-r1+1) *4);
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 0; x <= r2; x++) {
            int maxY = (int)Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
            int minY = 0;
            if (x < r1) {
                minY = (int)Math.ceil(Math.sqrt((long)r1 * r1 - (long)x * x));
            }
            answer += (maxY - minY + 1);
        }

        // 전체 점 개수는 4배인데, x=0축과 y=0축은 2번씩만 세어야 함
        answer = answer * 4 - ( (r2 - r1 + 1) * 4 );

        return answer;
    }
}
```

##### 참고사이트
1. [참고 링크](https://www.youtube.com/watch?v=6JgRGuT4ItE)
2. [참고 링크](https://www.youtube.com/watch?v=DL69uGuAGNo)

### 느낀점
```
이번 문제는 하... 진심.. 멘붕이였습니다 ㅋㅋㅋㅋㅋㅋㅋㅋ
읽어보니 공식을 이용해서 푸는것같은데, 공식을 이용해서 푼건 부끄럽지만 이번이 처음인것 같았고
제가 현업에서 일할때도 공식을 이용해서 푸는 이슈는 한번도 껵어보지 못한것 같아요.
솔직히는 10분동안 이런저런것을 시도해봤지만, 전혀 프로토콜이 생각나지 않았고, 구글링과 챗형님에 도움을 받았습니다.
하지만, 설명을 봐도 모르겠더군요....
천천히 이해하는게 맞는것 같아서 부끄럽지만 피타고라스 강의, 원의 방정식 강의를 다시 봤네요 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
문제를 읽어보니 이제는 메소드나 그런걸 떠나서 공식을 알아야 대입을하고, 어떤식으로 소스에 반영할건지, 어떤 타입으로 반환할건지가 나올것같다는 판단을 했습니다.
소스를 보고도 이해하는데 1시간정도 걸린것 같아요.

int maxY = (int)Math.floor( Math.sqrt( (long)r2*r2 - (long)i * i));
int minY = 0;
if(i < r1) {
    minY = (int)Math.ceil( Math.sqrt( (long)r1*r1 - (long)i * i ));
}
answer += (maxY - minY + 1);
이 부분이 결국에 핵심 부분인데, 공식을 이용해서 해당 x 축에 maxY, minY값을 구해서 빼면서 속하는 값만 더하고, (+1은 2,2 일 경우도 포함이니까!)

answer = answer * 4 - ( (r2 - r1 + 1) * 4 );
는 한사면측만 구했으니까, 그걸 4배로 해서 원에 4방향을 구하는건데, 뒤에 있는 ( (r2 - r1 + 1) * 4 ); 이게 도통 ... ㅋㅋㅋㅋ 머리아 안들어오더군요
결국에는 (r2 - r1 + 1) 은 해당 축에 해당하는 포인트 갯수이고, *4는 뒤에서 *4를 해줘서 축의 포함 갯수가 8개가 증가된 만큼 필요부분 제외하고 불필요한 부분(*4)만 계산해서 빼면 되는거였네요!!!

레벨2 문제라서 모든게 낯설고, 어색하고 공식이 나오고 앞으로는 어떤게 나올지 ㅋㅋㅋ 걱정되기도 하지만 재미있기도 합니다.
막상 풀이를 해보면 별것도 없는것같은데, 이해하는데 지금은 1 ~ 2시간 걸리고, 고등학교 졸업한지 10년이 넘었는데 공식이 필요해보여서 유튜브 강의 찾아보곸ㅋㅋㅋ 허거덩쓰 
이번 문제는 정말 어렵고, 물음이 많았지만, 지금은 오히려 기억에 제일 남았고, 제일 재미있는 문제가 되었네요 ㅋㅋㅋ
굳굳
``` 