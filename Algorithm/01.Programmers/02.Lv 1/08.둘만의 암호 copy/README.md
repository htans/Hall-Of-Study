# [level 1] 개인정보 수집 유효기간

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/150370)


### 실행문
```java
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap< String, Integer > termsHashMap = new HashMap<>();
        ArrayList< Integer > answerList = new ArrayList<>();
        
        // HashMap 타입저장
        for( int i = 0; i < terms.length; i++ ) {
            String[] splitTerms = terms[i].split(" ");
            termsHashMap.put(splitTerms[0], Integer.parseInt(splitTerms[1]) )  ; 
        }
        
        for( int j = 0; j < privacies.length; j++ ) {
            
            // 날짜
            String[] privaciesSplit = privacies[j].split(" ");
            
            // split - 2021.05.02
            String[] privaciesSplit_Date = privaciesSplit[0].split("\\.");

            String a = privaciesSplit_Date[0]; // 연도
            String b = privaciesSplit_Date[1]; // 월
            String c = privaciesSplit_Date[2]; // 일

            // 버전타입의 월
            Integer a_Month = termsHashMap.get(privaciesSplit[1]);
            
            // 계산
            Integer fun_Year = (Integer.parseInt(b) + a_Month) / 12;
            Integer fun_Month = (Integer.parseInt(b) + a_Month) % 12;
            
            if (fun_Month == 0) {
                fun_Month = 12;
                a = Integer.toString(Integer.parseInt(a) - 1);
            }
            
            // 월 계산
            if (fun_Year > 0) {
                a = Integer.toString(Integer.parseInt(a) + fun_Year);
                if ( fun_Month >= 9) {
                    b = Integer.toString(fun_Month);
                } else {
                    b = "0" + Integer.toString(fun_Month); 
                }
            } else {
                if ( fun_Month >= 9 ) {
                    b = Integer.toString(fun_Month);    
                } else {
                    b = "0" + Integer.toString(fun_Month);    
                }
            }

            // 새로운 날짜 생성
            String date2 = a + "." + b + "." + c;

            // 날짜 비교
            int result = today.compareTo(date2);
            if ( result >= 0 ) {
                answerList.add( j + 1);
            }
            
        }
        
        int[] answer = new int[ answerList.size() ];
        for( int a = 0; a < answerList.size(); a++ ) {
            answer[a] = answerList.get(a);
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 날짜 변환 유틸리티 메서드
        int convertDateToDays(String date) {
            String[] parts = date.split("\\.");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            return (year * 12 * 28) + (month * 28) + day; // 모든 날짜를 일 단위로 변환
        }

        int todayInDays = convertDateToDays(today);
        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        // 약관 정보를 HashMap에 저장
        for (String term : terms) {
            String[] split = term.split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]) * 28); // 월 단위를 일 단위로 변환
        }

        // 개인정보 유효성 검사
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String date = split[0];
            String termType = split[1];

            // 유효 기간 계산
            int startDateInDays = convertDateToDays(date);
            int expirationDateInDays = startDateInDays + termsMap.get(termType);

            // 오늘 날짜와 비교
            if (todayInDays >= expirationDateInDays) {
                answerList.add(i + 1);
            }
        }

        // 결과 변환
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

##### 참고사이트


### 느낀점
```
처음으로 3일 이상 고민하던 문제 였네요.
다 작성하고 보니 100줄도 안되고 프로토콜이 생각보다 간단한것 같아서 현타가 왔습니다 ㅋㅋㅋ
ChatGPT 한테 물어보니 역시 개선해야할 부분이 많고, 월/일 구간을 구지 나눠서 계산해서 더 복잡하게 했던 것 같습니다.
하지만, 확실히 코딩테스트 하기 전에 정확하게 문제가 무엇이고, 어떤것을 구현해야 되는지 생각에 방향이 많이 잡히는 것 같고,
노트에 프로토콜을 어떻게 구상할지 단계별로 적어놓고, 정확도가 100% 가 나오지 않으면 어떤 부분에서 문제가 있겠다 라는 생각이 들기도 합니다.
어쩌면... 제일 좋은 코드는... 담당자가 있는 소스가 아닌가... 하는 생각이 들긴드네요 ㅋㅋㅋ
개꿀잼 문제였고, 카카오 문제라고 해서 엄청 신기하고, 엄청 어렵겠지!? 했는데 역시 어렵네요 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
``` 