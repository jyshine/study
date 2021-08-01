import 'package:flutter/cupertino.dart';
import 'package:flutter_study/src/model/Movie.dart';
import 'package:flutter_study/src/repository/movie_repository.dart';

class MoviesProvider extends ChangeNotifier{
  MovieRepository _movieRepository = MovieRepository();
  List<Movie> _movies = [];
  List<Movie> get  movies => _movies;

  loadMovies() async{
    //repository
    List<Movie> listMovies =  await _movieRepository.loadMovies();
    //listmoves 예외처리
    //추가 가공 절차
    _movies = listMovies;
    notifyListeners();
    //업데이트 브로드케스트
  }

}