# [level 1] 하샤드 수

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12947)


### 실행문
```java
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int xLeng = String.valueOf(x).length();
        String[] xArray = new String[xLeng];        
        
        String xStr = String.valueOf(x);
        xArray = xStr.split("");
        
        int xTotal = 0;
        for(int i = 0; i < xArray.length; i++ ) { 
            xTotal += Integer.valueOf(xArray[i]);
        }
        
        if(x % xTotal != 0 ) {
            answer = false;
        } 
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public boolean solution(int x) {
        int sum = 0;
        String str = String.valueOf(x);

        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        return x % sum == 0;
    }
}
```

```java 
class Solution {
    public boolean solution(int x) {
        return x % (String.valueOf(x).chars().map(c -> c - '0').sum()) == 0;
    }
}
```

##### 참고사이트

### 느낀점
```
멍청해보이겠지만, 하샤드 수라는 단어를 처음 들어본것 같아요... ㅋㅋㅋ
문제를 읽어보니 int타입으로 된 변수를 String 타입으로 변환해서 split()메소드로 찢고 계산하는것 밖에는 생각이 안나더라구요.
String 타입이면 자릿수를 뽑을 수 있으니 변수 크기 정하는데도 좋고, 가공하기에 좋을거라고 생각했었습니다.
String 타입을 Integer 로 변환할때 Integer.parseInt() 와 Integer.valueOf() 두개가 생각났었는데, 생각흐름상 Integer.valueOf() 메소드를 사용했는데, 
단순 계산문제니까, 챗형님이랑 조금 찾아보니 Integer.parseInt() 메소드가 더 효율적이였네요.
valueOf() 메소드는 객체를 반환 하는걸로 알고 있는데, 계산문제에서 이슈가 나는 일이 빈번하더라구요. 까먹... 반성... ㅋㅋㅋ 
챗형님은 보니 String타입으로 변환하면, chatAt으로 자릿수 만큼 하나씩 꺼내와서 바로 sum인 변수로 보내고, 이걸 0으로 반환되면 True 니까 바로 빡빡...
역시.. 찬양...ㅋㅋㅋㅋ
최근에는 조금 잘해진줄 알았는데, 반성을 많이 하게 됩니다.. ㅋㅋㅋ
코딩테스트할때는 개인목표로 시간을 30분 정해놓고 하는데, 처음에는 30분을 풀로 채워서 문제를 풀었다면, 이제는 시간 여유가 조금 있으니까
제가 푼 소스를 다시 보면서 더 간단하게, 가독성있게 할 수 있는 부분이 없는지 체크가 필요할것 같아요.
그저... 빨리 푼것에 좋았는데 바보같았네용... ㅋㅋㅋ
그래도 너무 재미있었습니다.
``` 

