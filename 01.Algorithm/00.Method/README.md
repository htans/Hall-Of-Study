
## 📐 숫자 관련 메소드
| 메소드 | 설명 |
|--------|------|
| `Math.floor(x)` | 소수점 내림 |
| `Math.ceil(x)` | 소수점 올림 |
| `Math.round(x)` | 소수점 반올림 |
| `Math.trunc(x)` | 소수점 버림 |
| `Math.abs(x)` | 절댓값 |
| `Math.max(a, b, c, …)` | 최댓값 |
| `Math.min(a, b, c, …)` | 최솟값 |
| `Math.pow(x, y)` | 거듭제곱 (`x`의 `y`승) |
| `Math.sqrt(x)` | 제곱근 |
| `Math.cbrt(x)` | 세제곱근 |
| `Math.random()` | 0~1 사이 난수 생성 |
| `parseInt(str, base)` | 정수로 변환 |
| `parseFloat(str)` | 실수로 변환 |
| `Number.isInteger(x)` | 정수 여부 확인 |
| `Number.isNaN(x)` | NaN 여부 확인 |
| `~~x` | `Math.floor(x)` 대체 (빠름) |

### 예시
```js
Math.floor(4.9);       // 4
Math.ceil(4.1);        // 5
Math.round(4.5);       // 5
Math.trunc(4.9);       // 4
Math.abs(-10);         // 10
Math.max(1, 5, 10);    // 10
Math.min(1, 5, 10);    // 1
Math.pow(2, 3);        // 8
Math.sqrt(16);         // 4
Math.cbrt(27);         // 3
Math.random();         // 0 ~ 1 사이 난수
parseInt("42", 10);    // 42
parseFloat("3.14");    // 3.14
Number.isInteger(10);  // true
Number.isNaN(NaN);     // true
~~4.9;                 // 4
```

## 📦 배열 관련 메소드

| 메소드 | 설명 |
|--------|------|
| `arr.map(fn)` | 각 요소 변환 |
| `arr.filter(fn)` | 조건 충족 요소만 반환 |
| `arr.reduce(fn, init)` | 누적 연산 |
| `arr.some(fn)` | 하나라도 true인지 확인 |
| `arr.every(fn)` | 모두 true인지 확인 |
| `arr.find(fn)` | 조건 충족 첫 요소 반환 |
| `arr.findIndex(fn)` | 조건 충족 첫 인덱스 반환 |
| `arr.includes(x)` | 특정 값 포함 여부 확인 |
| `arr.indexOf(x)` | 값의 첫 인덱스 반환 |
| `arr.lastIndexOf(x)` | 값의 마지막 인덱스 반환 |
| `arr.slice(start, end)` | 부분 배열 반환 |
| `arr.splice(start, count, ...items)` | 요소 추가/제거 |
| `arr.concat(arr2)` | 배열 합치기 |
| `arr.push(x)` | 마지막에 추가 |
| `arr.pop()` | 마지막 요소 제거 |
| `arr.shift()` | 첫 요소 제거 |
| `arr.unshift(x)` | 첫 요소 추가 |
| `arr.reverse()` | 배열 뒤집기 |
| `arr.sort(fn)` | 정렬 (`a-b`: 오름차순, `b-a`: 내림차순) |

### 예시
```js
[1, 2, 3].map(x => x * 2);               // [2, 4, 6]
[1, 2, 3, 4].filter(x => x % 2 === 0);   // [2, 4]
[1, 2, 3].reduce((sum, x) => sum + x, 0);// 6
[1, 2, 3].some(x => x > 2);              // true
[1, 2, 3].every(x => x > 0);             // true
[1, 2, 3, 4].find(x => x > 2);           // 3
[1, 2, 3, 4].findIndex(x => x > 2);      // 2
[1, 2, 3].includes(2);                   // true
[1, 2, 3].indexOf(2);                    // 1
[1, 2, 3, 2].lastIndexOf(2);             // 3
[1, 2, 3, 4].slice(1, 3);                // [2, 3]
[1, 2, 3, 4].splice(1, 2, 99);           // [1, 99, 4]
[1, 2].concat([3, 4]);                   // [1, 2, 3, 4]

let arr = [1]; arr.push(2);              // [1, 2]
let arr2 = [1, 2]; arr2.pop();           // [1]
let arr3 = [1, 2]; arr3.shift();         // [2]
let arr4 = [2]; arr4.unshift(1);         // [1, 2]

[1, 2, 3].reverse();                     // [3, 2, 1]
[3, 1, 2].sort((a, b) => a - b);         // [1, 2, 3]
```

## 🔤 문자열 관련 메소드

| 메소드 | 설명 |
|--------|------|
| `str.split(sep)` | 문자열 나누기 |
| `arr.join(sep)` | 배열을 문자열로 |
| `str.trim()` | 앞뒤 공백 제거 |
| `str.trimStart()` | 앞 공백 제거 |
| `str.trimEnd()` | 뒤 공백 제거 |
| `str.toUpperCase()` | 대문자로 변환 |
| `str.toLowerCase()` | 소문자로 변환 |
| `str.replace(a, b)` | 첫 번째 `a`를 `b`로 변경 |
| `str.replaceAll(a, b)` | 모든 `a`를 `b`로 변경 |
| `str.padStart(n, x)` | 앞쪽 길이 맞추기 |
| `str.padEnd(n, x)` | 뒤쪽 길이 맞추기 |
| `str.startsWith(x)` | 특정 문자열로 시작하는지 |
| `str.endsWith(x)` | 특정 문자열로 끝나는지 |
| `str.charAt(i)` | i번째 문자 반환 |
| `str.charCodeAt(i)` | i번째 문자 유니코드 |
| `str.localeCompare(str2)` | 문자열 정렬 비교 (-1, 0, 1 반환) |

### 예시
```js
"hello world".split(" ");             // ["hello", "world"]
["hello", "world"].join(" ");         // "hello world"
"  hello  ".trim();                   // "hello"
"  hello  ".trimStart();              // "hello  "
"  hello  ".trimEnd();                // "  hello"
"hello".toUpperCase();                // "HELLO"
"HELLO".toLowerCase();                // "hello"
"hello world".replace("world", "JS"); // "hello JS"
"hello hello".replaceAll("hello", "hi"); // "hi hi"
"42".padStart(5, "0");                // "00042"
"42".padEnd(5, "0");                  // "42000"
"hello".startsWith("he");            // true
"hello".endsWith("lo");              // true
"hello".charAt(1);                   // "e"
"hello".charCodeAt(1);               // 101
"apple".localeCompare("banana");     // -1
```

## HashSet
```java
import java.util.*;

HashSet<Integer> set = new HashSet<>();

set.add(1);              // 원소 추가
set.add(2);
set.add(1);              // 중복 추가 → 무시됨

set.contains(2);         // true (포함 여부 확인)
set.remove(2);           // 원소 삭제
set.size();              // 크기 반환
set.isEmpty();           // 비었는지 확인
```

## HashMap
```java
import java.util.*;

HashMap<String, Integer> map = new HashMap<>();

map.put("apple", 3);      // 값 추가
map.put("banana", 2);
map.put("apple", 5);      // 같은 키 다시 put → 값 덮어쓰기

map.get("apple");         // 5 (값 꺼내기)
map.getOrDefault("pear", 0); // 없는 키면 기본값 반환

map.containsKey("banana"); // true
map.remove("banana");      // 키 삭제
map.size();                // 크기 반환
map.keySet();              // 모든 키 집합 반환
map.values();              // 모든 값 집합 반환
```

##Queue (FIFO, LinkedList로 많이 씀)
```java
import java.util.*;

Queue<Integer> q = new LinkedList<>();

q.add(1);                 // 삽입 (실패 시 예외)
q.offer(2);               // 삽입 (실패 시 false)

q.peek();                 // 맨 앞 값 확인 (비어있으면 null)
q.poll();                 // 맨 앞 값 꺼내고 제거 (비어있으면 null)
q.remove();               // 맨 앞 값 꺼내고 제거 (비어있으면 예외)

q.isEmpty();              // 비었는지 확인
q.size();                 // 크기 반환
```