# [level 1] [PCCP 기출문제] 1번 - 동영상 재생기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12926)


### 실행문
```java
// 첫번째 
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] time = pos.split(":");
        int mm = Integer.parseInt(time[0]);
        int ss = Integer.parseInt(time[1]);
        
        for(String command : commands) {
            if(command.equals("next")) {
                ss += 10;
                if (ss < 60) {
                    mm += 1;
                }
            } else if(command.equals("prev")) {
                ss -= 10;
                if (ss < 0) {
                    ss = 0;
                }
            }
        }
        
        // mm
        if( mm < 10) {
            answer += "0" + Integer.toString(mm);
        } else {
            answer += Integer.toString(mm);
        }
        
        // :
        answer += ":";
        
        // ss
        if( ss < 10 ) {
            answer += "0" + Integer.toString(ss);
        } else {
            answer += Integer.toString(ss);
        }
        
        return answer;
    }
}

// 두번째
class Solution {
    
    // (String) 시간을 (int)초로 변환
    private int toSeconds (String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    // (int)초를 (String) 시간으로 변환
    private String toTime (int seconds) {
        
        int mm = seconds / 60;
        int ss = seconds % 60;
        
        return String.format("%02d:%02d", mm, ss);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int v_Len = toSeconds(video_len);
        int Pos = toSeconds(pos);
        int op_Start = toSeconds(op_start);
        int op_End = toSeconds(op_end);
        
        for(String command : commands) {
            
            if(command.equals("next")) {
                
                if( op_Start <= Pos && Pos < op_End ) {
                    Pos = op_End;
                }
                
                Pos += 10;
                
            } else if( command.equals("prev") ) {
                Pos -= 10;
            }
             
            // 마이너스는 0으로 초기화
            if( Pos < 0 ) {
                Pos = 0;
            }
            
            // 전체 영상 범위
            if( Pos > v_Len ) {
                Pos = v_Len;
            }
            
            // 오프닝 범위
            if( op_Start <= Pos && Pos < op_End ) {
                Pos = op_End;
            }
        }
        
        return toTime(Pos);
    }
}
```

### ChatGPT
```java
class Solution {

    // (String) 시간을 (int)초로 변환
    private int toSeconds(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    // (int)초를 (String) 시간으로 변환
    private String toTime(int seconds) {
        int mm = seconds / 60;
        int ss = seconds % 60;
        return String.format("%02d:%02d", mm, ss);
    }

    // 오프닝 스킵 처리
    private int skipOpening(int pos, int opStart, int opEnd) {
        if (opStart <= pos && pos < opEnd) {
            return opEnd;
        }
        return pos;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int videoLength = toSeconds(video_len);
        int currentPos = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        for (String command : commands) {
            // 커맨드 전에 오프닝 체크
            currentPos = skipOpening(currentPos, opStart, opEnd);

            // 명령 처리
            if (command.equals("next")) {
                currentPos += 10;
            } else { // "prev"
                currentPos -= 10;
            }

            // 범위 보정
            if (currentPos < 0) currentPos = 0;
            if (currentPos > videoLength) currentPos = videoLength;

            // 커맨드 후에도 오프닝 체크
            currentPos = skipOpening(currentPos, opStart, opEnd);
        }

        return toTime(currentPos);
    }
}

```

##### 참고사이트

### 느낀점
```
세상에.. 일상생활에서 있는 일인데 이걸또 코딩으로 풀려고 하니까 너무 어렵더군요.
첫번째 코드는 split(":"); 로 분리해서 작업했었는데, 초단위는 괜찮은데, 분단위까지 계산을 넣을려고 하다보니 너무 복잡해지더라구요.
그래서 아아.. 이거 뭐지뭐지 하고 멘붕에 있다가 초로 변환해서 하면 되겠다 하고 여러가지 시도를 해보는데, 처음으로 기능을 따로 빼서 작업한것 같아요.
어쩌면, 현업에서는 물 흘러가듯이 공통기능인지, 화면에 제약된 기능인지 체크하고 개발하는데, 코딩테스트에서는 그렇게 해볼 생각을 전혀 못해본것 같아요. 
이번 문제에서는 toTime(), toSeconds() 기능을 따로 빼서 비교적 쉽게 풀 수 있었습니다.
테스트 케이스에서 이상한것이 있어서 의아했는데, 당연히 문제를 다시 읽어보고 테스트케이스를 보니 다행히 쉽게 해결했네요!
확실히 전체 프로토콜을 생각해보고, 어떤식으로 해야 간단하고, 가독성있게 작성가능한지 고민하는게 포인트 인것 같아요. 

챗형님은 오프닝 스킵 처리를 하나 더 만들어서 시작할때의 포커스랑 종료할때의 포커스를 같은 기능으로 묶어서 처리하네요!!
하... 아직 멀고 멀었습니다.. ㅋㅋㅋㅋ
하지만, 너무 재미있었고, 다른사람이 볼때는 ?? 이게 뭔... 라고 할 수 있어도 ㅋㅋㅋ 한 이래저래 3일 고민했네욬ㅋㅋ
굳굳 너무 재미있었어용
``` 