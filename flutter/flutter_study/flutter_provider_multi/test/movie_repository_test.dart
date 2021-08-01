import 'package:flutter_study/src/model/Movie.dart';
import 'package:flutter_study/src/repository/movie_repository.dart';
import 'package:test/test.dart';

Future<void> main() async {
  print("test");
  var loadMovies = await MovieRepository().loadMovies();
  for(Movie mv in loadMovies){
    print(mv.title);
  }


}