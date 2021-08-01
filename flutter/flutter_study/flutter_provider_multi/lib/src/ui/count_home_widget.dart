import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_study/src/components/count_home_count_view_widget.dart';
import 'package:flutter_study/src/provider/count_provider.dart';
import 'package:provider/provider.dart';

class CountHomeWidget extends StatelessWidget {
  CountHomeWidget({Key? key}) : super(key: key);
  late CountProvider _countProvider;

  @override
  Widget build(BuildContext context) {
    _countProvider = Provider.of<CountProvider>(context, listen: false);


    return Scaffold(
      appBar: AppBar(title: Text("Count Provider"),),
      body: CountHomeCountViewWidget(),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          IconButton(
              onPressed: (){
                _countProvider.add();
                },
              icon: Icon(Icons.add)),
          IconButton(
            onPressed: (){
              _countProvider.remove();
              },
            icon: Icon(Icons.remove),)
        ],
        ),
    );
  }
}
