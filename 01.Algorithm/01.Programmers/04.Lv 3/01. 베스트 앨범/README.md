# [level 3] 베스트 앨범

* [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42579)


### 실행문
```java
import java.util.*;

class Solution {
    
    static class Song {
        int id;
        int plays;
        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++ ) {
            genreTotal.put( genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i] );
            
            genreSongs.putIfAbsent( genres[i], new ArrayList<>() );
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort( (a, b) -> ( genreTotal.get(b) - genreTotal.get(a)) );
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre : genreOrder) {
            
            List<Song> songs = genreSongs.get(genre);
            
            songs.sort( (s1, s2) -> {
                if(s1.plays == s2.plays) {
                    return s1.id - s2.id;
                } 
                return s2.plays - s1.plays;
            });
            
            for(int i = 0; i < Math.min( 2, songs.size()); i++ ) {
                result.add( songs.get(i).id );
            }
            
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
```

### ChatGPT
```java
import java.util.*;

class Solution {
    
    static class Song {
        int id;
        int plays;
        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++ ) {
            genreTotal.put( genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i] );
            
            genreSongs.putIfAbsent( genres[i], new ArrayList<>() );
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort( (a, b) -> ( genreTotal.get(b) - genreTotal.get(a)) );
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre : genreOrder) {
            
            List<Song> songs = genreSongs.get(genre);
            
            songs.sort( (s1, s2) -> {
                if(s1.plays == s2.plays) {
                    return s1.id - s2.id;
                } 
                return s2.plays - s1.plays;
            });
            
            for(int i = 0; i < Math.min( 2, songs.size()); i++ ) {
                result.add( songs.get(i).id );
            }
            
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
```

##### 참고사이트

### 느낀점
```
홀리몰리 진짜.. 레벨 3 문제라서 엄청 무서웠네요...
솔직히 지금은 퇴사하고 다시 이직준비중이라서 코딩테스트를 집중적으로 하고 있음에도 불구하고, 이 문제 하나로 2일정도 걸렸습니다.
풀다보니 도저히, 혼자서는 해결 못하겠고 역분석하는식으로 들어갔는데 이해하는데도 하루정도 걸린것 같아요.
머리속에서 배열들을 그림을 그리고, 거기에 하나씩 파라미터를 넣고, 리스트를 넣고 하는 그림그리는 형식으로 풀었고, 혹여나 외워버리고, 아 이건 이거! 이건 이거였지! 할까봐 
여러가지 변수를 섞어가면서 계속 시도하고, 하루정도 걸려서 제 머리속에서 확신을 가지고, 어떤식으로 돌아가는지 구조가 보이고, 그걸 코드로 적으면서 하다가 에러 뜨는건 ??? 뭐양 하고 역추적 해서 고치고, 왜 오류가 나는지 이해할 수 있었던것 같아요.

결론은 Total 배열, Songs 배열 2개를 만들어놓고, 한개는 말그대로 총 횟수를 계속 더하면서 저장하고, 한개는 종류별로 횟차를 저장함
그 저장한걸 다시 배열을 만들어서 총 횟수 기준으로 전체 순번을 정하고, 카테고리 별로 돌면서 제일 재생수가 높은 번호 2개만 빡빡 뽑아주면 끝이긴해요.

ㄹㅇ 말은 이렇게 쉬운데, 뭔 소스로 넘어가면 허거덩쓰하네요...
솔직히 어영부영 준비하면서 넘어온 레벨 3문제 급이고, 역분석을 메인으로 하기 때문에, 생각하는 힘이나 프로토콜을 해결하는 능력이 줄어드는게 아닌가 생각합니다만, 솔직히 내가 호로록호로록 다 푼다?? 말도 안되는거임 ㅋㅋㅋ
지금은 역분석 설계가 맞는것 같고, 꾸준히 여러개를 하다보면 패턴이 보이고, 그러면 아! 이거! 이거! 하면서 느낌이오고 빡빡 ㅎㅎㅎㅎ
일단 해야합니다. ㅋㅋㅋ 너무 재미있는 문제였어용
``` 