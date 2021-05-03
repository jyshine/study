# TDD (Test Driven Development)

* * *

## TDD
  TDD와 단위 테스트는 다른 개념이다.
  단위 테스트는 Production Code를 만들고 단위 테스트 코드를 추가할 수 있지만
  TDD는 원칙상 Test Code를 Production Code 보다 먼저 구현해야한다.

  TDD = TFD(Test First Development) + Refectoring
  
  켄트벡 Test Driven Development by Example 중
  -TDD란 프로그래밍 의사결정과 피드백 사이의 간극을 의식하고 이를 제어하는 기술이다.
  -TDD의 아이러니 중 하나는 테스트 기술이 아니라는 점이다. TDD는 분석 기술이며 설계 기술이다.

  TDD를 잘하려면 To Do 리스트를 잘 작성해야한다.
  요구사항 분석을 잘해야 한다 잘 못하면 막막하다.

  TDD 하는 이유
  -디버깅 시간 줄여준다
  -동작하는 문서 역할을 한다.
  -변화에 대한 두려움을 줄여준다.

  TDD 사이클
  Test Fails - Test passes - Refactor - Test Fails
  실패하는 테스트 구현 -> 테스트 성공하도록 Production code 구현 -> 프로덱션 코드와 테스트코드 리팩토링

  원칙 
  1.실패하는 단위 테스트를 작성할 때까지 프로덕션 코드를 작성하지 않는다.
  2.컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다. 
  3.현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다. 
    ( 많은 부분 예측해서 오버엔지리어링 X , 필요한 정도만)

## 숫자야구게임
-요구사항 분석을 통해 대략적인 설계 - 객체 추출
-UI, DB 등과 의존관계를 가지지 않는 핵심 도메인 영역을 집중 설계

MVC 패턴을 적용할 때 Domain 영역 설계
Domain 영역 
|  Base Ball                  | 
|     ↓                       |  ←
|    Balls ① → ③ BallNumber  |  →   단위테스트
    ↑↓
Random 값 생성



## 구현할 기능 목록 작성하기
- 1~9의 숫자 중 랜덤으로 3개의 숫자를 구한다
- 사용자로부터 입력 받는 3개 숫자 예외 처리
  -1~9의 숫자인가?
  -중복 값이 있는가?
  -3자리인가?
- 위치와 숫자 값이 같은 경우 - 스트라이크
- 위치는 다른데 숫자 값이 같은 경우 - 볼
- 숫자 값이 다른 경우 - 낫싱
- 사용자가 입력한 값에 대한 실행 결과를 구한다.


1단계 - Util 성격의 기능이 TDD로 도전하기 좋음
- 사용자로부터 입력 받는 3개 숫자 예외 처리
  -1~9의 숫자인가?
  -중복 값이 있는가?
  -3자리인가?
2단계 - 테스트 가능한 부분에 대해 TDD
  - 위치와 숫자 값이 같은 경우 - 스트라이크
  - 위치는 다른데 숫자 값이 같은 경우 - 볼
  - 숫자 값이 다른 경우 - 낫싱


최소한의 코드로 다양한 테스트를 할 수 있도록 범위 경계에 있는 값들을 비교하라.
TDD 기능 테스트 케이시 개발, 리팩토링 후 커밋 추천 커밋 메시지는 디스플레이 혹은 기능명으로!
Inpu과 Output이 명확한 기능 먼저 TDD 개발
로컬 변수로 만들고 리팩토링으로 없애라.

com / user
123, 456  -> nothing
123, 245  -> 1ball
123, 145  -> 1strike

PlayResult result = BaseBall.play(Arrays.asList(1,2,3),Arrays.asList(4,5,6);

숫자 하나씩 비교 
숫자 하나씩 비교할 땐 위치 값이 필요하다

문제를 큰 단위에서 TDD를 구현하려다 보면 어렵다.
문제를 작은 단위로 쪼개라.

com / user
1 4 , 1 4 -> strike
1 4 , 2 4 -> ball
1 4 , 2 5 -> nothing


Ball(position, ballNo)을 만들고 BallStatus를 만든다. BallStatus는 enum 상수로
nothing - ball - strick 하나씩
객체지향으로 만들어라.
객체 필드에 직접 접근하지 말고 메시지를 보내 전달 받아라.
equls() 메소드를 활동해라.


com / user
123 / 1 4 -> nothing
123 / 1 2 -> ball
123 / 1 1 -> strike

Balls 구현 
List를 ball 타임으로 받는 생성자 필요.
Ballstatus Enum도 필드에 직접 접근하지 말고 메시지 보내서 상태 값 받기


그 다음 구현
com / user
123, 456  -> nothing
123, 245  -> 1ball
123, 145  -> 1strike

PlayResult(strike, ball ) 객체 생성 리스트의 결과 값을 받는다.
getStrike(), getBall(), report(), isEndGame()

클래스 분리할 때 원칙 값을 포장한다
생성자에서 예외처리를 할 수 있다.



