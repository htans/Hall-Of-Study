# [level 3] 이중우선순위큐

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42628)


### 실행문
```java
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> cnt = new HashMap <>();
        
        for(String op : operations) {
            
            String[] p = op.split(" ");
            String type = p[0];
            int num = Integer.parseInt(p[1]);
                        
            if(type.equals("I")) {
                minHeap.add(num);
                maxHeap.add(num);
                cnt.put( num, cnt.getOrDefault(num, 0) + 1 );
            } else if (type.equals("D")) {   
                if(cnt.isEmpty()) continue;
                
                if(num == 1) {
                    remove(maxHeap, cnt);
                } else {
                    remove(minHeap, cnt);
                }
            }
        }
        
        if(cnt.isEmpty()) return new int[] {0, 0};
        
        int max = getValid(maxHeap, cnt);
        int min = getValid(minHeap, cnt);
        
        return new int[] {max, min};
    }
    
    private int getValid(PriorityQueue<Integer> heap, Map<Integer, Integer> cnt) {
        
        while( !heap.isEmpty()) {
            int val = heap.peek();
            if( cnt.getOrDefault(val, 0) > 0 ) {
                return val;
            } else {
                heap.poll();
            }
        }
        return 0;
    }
    
    private void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> cnt) {
        while(!heap.isEmpty()) {
            int val = heap.poll();
            int c = cnt.getOrDefault(val, 0);
            if(c==0) continue;
            if(c==1) cnt.remove(val);
            else cnt.put( val, c-1 );
            break;
        }
    }
    
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        // 최소 힙 (오름차순) → 최솟값 빠르게 얻기
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙 (내림차순) → 최댓값 빠르게 얻기
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 각 값이 현재 몇 개 살아있는지 기록하는 Map
        Map<Integer, Integer> cnt = new HashMap<>();
        
        // 주어진 연산들 처리
        for(String op : operations) {
            
            String[] p = op.split(" ");   // "I 16" → ["I", "16"]
            String type = p[0];          // 연산 타입: "I" or "D"
            int num = Integer.parseInt(p[1]); // 연산 숫자
            
            if(type.equals("I")) { // 삽입 연산
                minHeap.add(num);  // 두 힙에 모두 넣고
                maxHeap.add(num);
                cnt.put(num, cnt.getOrDefault(num, 0) + 1); // count 증가
            } else if (type.equals("D")) { // 삭제 연산
                if(cnt.isEmpty()) continue; // 큐가 비었으면 무시
                
                if(num == 1) { // 최댓값 삭제
                    remove(maxHeap, cnt);
                } else {       // 최솟값 삭제
                    remove(minHeap, cnt);
                }
            }
        }
        
        // 최종적으로 큐가 비었으면 [0, 0] 반환
        if(cnt.isEmpty()) return new int[] {0, 0};
        
        // 살아있는 최댓값과 최솟값 얻기
        int max = getValid(maxHeap, cnt);
        int min = getValid(minHeap, cnt);
        
        return new int[] {max, min};
    }
    
    // 힙에서 유효한 값(아직 살아있는 값) 꺼내기
    private int getValid(PriorityQueue<Integer> heap, Map<Integer, Integer> cnt) {
        while(!heap.isEmpty()) {
            int val = heap.peek(); // 힙 맨 위 값 확인
            if(cnt.getOrDefault(val, 0) > 0) {
                // count에 남아있으면 살아있는 값 → 반환
                return val;
            } else {
                // 이미 다른 쪽에서 삭제돼서 죽은 값이면 버림
                heap.poll();
            }
        }
        return 0; // 안전 장치 (힙 다 비었을 때)
    }
    
    // 힙에서 값 하나 실제 삭제하기 (count도 같이 갱신)
    private void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> cnt) {
        while(!heap.isEmpty()) {
            int val = heap.poll(); // 힙에서 하나 꺼냄
            int c = cnt.getOrDefault(val, 0); // count 확인
            if(c == 0) continue;              // 이미 죽은 값이면 패스
            if(c == 1) cnt.remove(val);       // 이번에 삭제하면 완전히 사라짐
            else cnt.put(val, c - 1);         // 아직 여러 개 남아 있으면 개수만 감소
            break; // 삭제 1번 완료했으니 종료
        }
    }
}
```

##### 참고사이트

### 느낀점
```
이번 문제는 역분석인데도 불구하고, 3시간? 4시간 정도 걸린것 같아요.

결론부터말하면 문제에서는 I,D를 구분으로 숫자들을 포함시키거나 최대값, 최소값을 빼거나 하는 문제네요.
maxHeap, minHeap, cont 총 3개의 큐와 맵을 이용하여 풀이를 하였고, 
Queue - LinkedList 가 아니라 PriorityQueue - 우선순위큐를 이용하여 풀이를 하는데, 기존 Queue로는 안되는건가? 하고 찾아보니 기본적으로 오름차순을 지원하기 때문에, 
PriorityQueue maxHeap = new PriorityQueue <>(Collections.reverseOrder); 이런식으로 내림차순으로 바꿔주면 간단하게 min,max 큐를 관리할 수 있어서 사용하는거였네요.
cnt는 말그대로 포함되어 있는 숫자가 몇개인지 관리하는 맵이기 때문에, 1은 2개, 3은 1개... 하고 삭제할때, 마지막에 최종값을 가져올때는 이미 우선순위로 관리가 잘 되기 때문에
해당 값을 가져가서 cnt에 있는 숫자인지 아닌지, 있으면 return으로 이거다!! 하고 컷, 없으면 poll()로 버려버리고 다음껄 똑같이 체크하면 살아있는게 정답일거니까 while문으로 반복하면 되네요.

하.... ㅋㅋㅋㅋㅋㅋㅋ 막상 말하니까 별거 없는것 같은데, 역분석 하는데도 오래걸리고, 머리속으로 그림을 그리면서 순서대로 아무것도 없는 상태에서 하려고하니 생각보다 너무 어렵네요 ㅋㅋㅋ
그래도 지금은 문법이나 어떤걸 할려고 할때, 어떤식으로 해야하고, 어떤 메소드를 써야하고 이런건 조금씩 익숙해지는것 같아서 기분이 좋아요.
처음부터 다 아 이건 이렇게 해버릴까!! 하면서 우루룩 하면 좋겠지만, 그건 꿈이고 ㅋㅋㅋ 역분석을 하면서 이건 왜 이렇게 되는지, 저렇게 하면 안되는건지, 어떤 장점이 있는지 체크하면서 천천히 해보는게 저한테 제일 잘 맞는것 같아요.
이번 문제도 너무 재미있었고, 레벨 3 짜리 문제인만큼 소스도 엄청 길어지고, 재미도 업업 ㅋㅋㅋ 굳굳
``` 