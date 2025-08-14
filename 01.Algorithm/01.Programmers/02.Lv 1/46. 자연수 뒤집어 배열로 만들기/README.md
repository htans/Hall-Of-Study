# [level 1] 자연수 뒤집어 배열로 만들기

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12932)


### 실행문
```java
class Solution {
    public int[] solution(long n) {
        
        String str = String.valueOf(n);
        String[] temp = str.split("");
        
        int[] answer = new int[temp.length];
        int j = 0;
        for(int i = temp.length-1; i >= 0; i-- ) {
            answer[j] = Integer.parseInt(temp[i]);
            j++;
        }
        
        return answer;
    }
}
```

### ChatGPT
```java
class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = str.charAt(len - 1 - i) - '0';
        }

        return answer;
    }
}
```

##### 참고사이트

### 느낀점
```
바로 직전에 풀던 문제랑 비슷한 느낌이라서 어렵지 않게 풀 수 있었네요! 
Long 타입으로 원본문자열이 넘어오기 때문에, String으로 변환해주고, 그걸 split()메소드로 찢어서 역으로 배열에 채워넣는걸로 문제를 풀었는데,
역시.. 챗형님은 String()변환까지는 동일하게 했는데, chartAt() 메소드를 이용해서 하나씩 넣네요.. 크흐..
분명 메소드는 이제 좀 눈에 익고, 어떻게 사용하는지 아는 메소드인데, 효율적으로 빡빡 생각 안나는게 너무 서러워요 ㅠㅠㅠㅠㅠ
다양한 방법이 있고, 기존 방식을 풀었더라도, 다른 방법이 있는지 틀을 깨고 항상 접근해야 할 것 같아요!
그리고 str.charAt(len - 1 - i) - '0'; 인데, String형을 int형으로 바로 반환해주는것도 이번에 처음 알았네요 ㄷㄷㄷ 굳굳

이번 문제도 너무 재미있었습니다. ㅎㅎㅎ
``` 

