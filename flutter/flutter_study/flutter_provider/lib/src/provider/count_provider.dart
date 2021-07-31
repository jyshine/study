import 'package:flutter/cupertino.dart';

class CountProvider extends ChangeNotifier{
  // 상태 관리하는 values
  int _count = 0;

  int get count => _count;
  

  void add() {
    _count++;
    notifyListeners();
  }

  void remove() {
    _count--;
    notifyListeners();
  }
}