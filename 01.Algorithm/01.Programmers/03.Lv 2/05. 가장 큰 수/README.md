# [level 2] 가장 큰 수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42746)


### 실행문
```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++ ) {
            arr[i] = String.valueOf(numbers[i]);
        }
            
        Arrays.sort(arr, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String a : arr) {
            sb.append(a);
        }
        
        return sb.toString();
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++ ) {
            arr[i] = String.valueOf(numbers[i]);
        }
            
        Arrays.sort(arr, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String a : arr) {
            sb.append(a);
        }
        
        return sb.toString();
    }
}
```

##### 참고사이트

### 느낀점
```
저번에 사용해봤던 Arrays.sort(arr, (a, b) -> { ... }); 형식의 람다 정렬인것 같아요.
람다형식의 정렬은 아직도 많이 해본적이 없기 때문에 물음표가 많이 뜨네요...
retrun (b+a).compareTo(a+b); 이 문구가 결국에 코어소스인데, 간단하게 a, b 순으로 하면 작은것부터 정렬되고, b, a 역순으로 하면 큰것부터 정렬되네요.
numbers가 int 타입으로 넘어오지만, 문제에서 요구한건 문자 자체를 제일 큰수로 만들어야하니까, 일단 String 타입으로 변경하고, sort() 메소드로 전부 정렬해보면서 큰수대로 배열에 정리하는게 핵심이네요.
이후에는 String 으로 반환하면 되니까, StringBuilder를 하나 만들어줘서 toString()으로 뽀복 던져주면 되네요.
크흐... 신기방기

그리고 compareTo() 와 compare() 메소드가 좀 헷갈려서 정리

String a = "3";
String b = "30";

// compareTo → 자연 정렬 (문자열 사전순)
System.out.println(a.compareTo(b)); // 양수 ("3" > "30")

// compare → 내가 정한 규칙
Comparator<String> rule = (x, y) -> (y+x).compareTo(x+y);
System.out.println(rule.compare(a, b)); // 음수 (규칙상 "3"이 "30"보다 앞)
``` 