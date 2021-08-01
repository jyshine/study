import 'package:flutter/material.dart';
import 'package:flutter_study/src/home.dart';
import 'package:flutter_study/src/provider/bottom_navigation_provider.dart';
import 'package:flutter_study/src/provider/count_provider.dart';
import 'package:flutter_study/src/provider/movies_provider.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MultiProvider(
        providers: [
          ChangeNotifierProvider(create: (BuildContext context) => CountProvider()),
          ChangeNotifierProvider(create: (BuildContext context) => BottomNavigationProvider()),
          ChangeNotifierProvider(create: (BuildContext context) => MoviesProvider()),
        ],
        child: Home(),
      )
    );
  }
}
