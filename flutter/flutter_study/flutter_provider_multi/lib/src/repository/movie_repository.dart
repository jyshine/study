import 'dart:convert';

import 'package:flutter_study/src/model/Movie.dart';
import 'package:http/http.dart' as http;

class MovieRepository{

  var url = Uri.https("api.themoviedb.org", "/3/movie/popular", {'api_key':'4a3d3deef75439c7a4674f40d747af5b'});

  Future<List<Movie>> loadMovies() async{
    var response = await http.get(url);
    Map<String, dynamic> body = json.decode(response.body);
    List<dynamic> list = body["results"];
    return list.map<Movie>((item) => Movie.fromJson(item)).toList();
  }
}