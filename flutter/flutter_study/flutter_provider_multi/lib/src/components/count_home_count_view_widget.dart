import 'package:flutter/cupertino.dart';
import 'package:flutter_study/src/provider/count_provider.dart';
import 'package:provider/provider.dart';

class CountHomeCountViewWidget extends StatelessWidget {
  const CountHomeCountViewWidget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    print("build call");
    return Center(
      child: Consumer<CountProvider>(
        builder: (context,provider, child){
          return Text(
            provider.count.toString(),
            style: TextStyle(fontSize: 80),
          );
        },
      ),
    );
  }
}
