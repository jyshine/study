import 'package:flutter/material.dart';
import 'package:flutter_study/src/provider/bottom_navigation_provider.dart';
import 'package:flutter_study/src/provider/count_provider.dart';
import 'package:flutter_study/src/ui/count_home_widget.dart';
import 'package:flutter_study/src/ui/movies_home_widget.dart';
import 'package:provider/provider.dart';

class Home extends StatelessWidget {
  Home({Key? key}) : super(key: key);
  late BottomNavigationProvider _bottomNavigationProvider;

  Widget _navigationBody(){
    switch(_bottomNavigationProvider.index){
      case 0:
        return CountHomeWidget();
        break;
      case 1:
        return MoviesHomeWidget();
        break;
    }
    return Container();
  }

  Widget _bottomNavigationBar(){
    return BottomNavigationBar(
        items: [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: "HOME"),
          BottomNavigationBarItem(icon: Icon(Icons.movie), label: "MOVIE")
        ],
      currentIndex: _bottomNavigationProvider.index,
      selectedItemColor: Colors.red,
      onTap: (index){
          //provider navigation state
        _bottomNavigationProvider.updateCurrentPage(index);
      },

    );
  }


  @override
  Widget build(BuildContext context) {
    _bottomNavigationProvider = Provider.of<BottomNavigationProvider>(context);

    return Scaffold(
      body: _navigationBody(),
      bottomNavigationBar: _bottomNavigationBar(),
    );
  }
}
