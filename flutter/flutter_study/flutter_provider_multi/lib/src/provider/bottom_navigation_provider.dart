import 'package:flutter/material.dart';

class BottomNavigationProvider extends ChangeNotifier{
  int _index = 0;

  int get index => _index;

  void updateCurrentPage(index){
    _index = index;
    notifyListeners();
  }

}