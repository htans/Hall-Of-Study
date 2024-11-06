# [level 1] 대충만든 자판

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/160586)


### 실행문
```java
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<String, Integer> keyHashMap = new HashMap <>();        
        for(int i = 0; i < keymap.length; i++ ) {
            String[] keys = keymap[i].split("");
            for(int j = 0; j < keys.length; j++ ) {
                String key = keys[j]; 
                keyHashMap.put( key, Math.min ( keyHashMap.getOrDefault(key, Integer.MAX_VALUE), j+1 ) );
            }
        }
        
        for(int x = 0; x < targets.length; x++ ) {
            String target = targets[x];
            boolean UseFlag = true;
            int total_count = 0;

            for ( int y = 0; y < target.length(); y++ ) {
                String key = String.valueOf( target.charAt(y) );
                
                if(keyHashMap.containsKey(key) ) {
                    total_count += keyHashMap.get(key);
                } else {
                    UseFlag = false;
                    break;
                }
            }
            
            if (UseFlag) {
                answer[x] = total_count;
            } else {
                answer[x] = -1;
            }
            
        }
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // ASCII 배열 생성 (크기 128, 초기값은 Integer.MAX_VALUE로 설정)
        int[] keyPressCounts = new int[128];
        Arrays.fill(keyPressCounts, Integer.MAX_VALUE);

        // keymap 순회하여 최소 키 입력 횟수를 기록
        for (String keys : keymap) {
            for (int j = 0; j < keys.length(); j++) {
                char c = keys.charAt(j);
                // 최소 입력 횟수 업데이트
                keyPressCounts[c] = Math.min(keyPressCounts[c], j + 1);
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int pressCount = 0;
            boolean canType = true;

            // target의 각 문자에 대해 최소 입력 횟수 더하기
            for (char c : target.toCharArray()) {
                if (keyPressCounts[c] == Integer.MAX_VALUE) {
                    // 문자를 입력할 수 없는 경우
                    canType = false;
                    break;
                }
                pressCount += keyPressCounts[c];
            }

            answer[i] = canType ? pressCount : -1;  // 입력할 수 없는 경우 -1
        }

        return answer;
    }
}
```

##### 참고사이트
1. [참고 링크](https://junghn.tistory.com/entry/JAVA-Map-getOrDefault-%EC%9D%B4%EB%9E%80-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%B0%8F-%EC%98%88%EC%A0%9C) 
2. [참고 링크](https://dpdpwl.tistory.com/138) 


### 느낀점
```
ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 하ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 
``` 