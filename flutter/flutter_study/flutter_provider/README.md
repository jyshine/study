# flutter_study
    Flutter Provider Study 단일 Provider
    1.ChangeNotifier
        1)ui 구성
            MaterialApp main.dart
                |
            Scaffold    src>home.dart
                |
            body:Center                              floatingActionButton:Row
            src>ui>count_home_widget.dart            src>home.dart
    2.provider 생성
        src>provider에 dart 파일(count_provider.dart) 만들고 CountProvider class 생성 ChangeNotifier 상속
        상태 관리가 필요한 변수 선언 및 기능 작성
        widget을 provider로 감싸줘야한다.
        main.dart > home: 하위 위젯에 대해 provider를 생성해준다.
         create: (BuildContext context) => CountProvider(),
         child: Home()
    3.context를 통해 provider 접근 가능
        Provider.of<class name>(context); 으로 접근.
        변경된 상태에 대한 업데이트를 위해 notifyListeners(); 호출을 해줘야한다.
        외부에서 접근 가능한 값은 get으로 만들어준다.
    4.특정 위젯에 대해서 상태 변경
        Provider 변경될 때마다 하위 위젯들이 build 된다 
        이를 개선하기 위해 상태 변경이 원하는 위젯를 Consumer 감싸서 사용한다.      
        Consumer<CountProvider>(
                builder: (context, provider, child){
                  return Text(
                    provider.count.toString(),
                    style: TextStyle(fontSize: 80),
                  );
                },
              ),
        Provider가 선언된 상위 위젯들은 listen: false 해준다.
        
        


## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://flutter.dev/docs/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://flutter.dev/docs/cookbook)

For help getting started with Flutter, view our
[online documentation](https://flutter.dev/docs), which offers tutorials,
samples, guidance on mobile development, and a full API reference.
