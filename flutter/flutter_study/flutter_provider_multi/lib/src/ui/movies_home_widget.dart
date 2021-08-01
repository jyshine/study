import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_study/src/model/Movie.dart';
import 'package:flutter_study/src/provider/movies_provider.dart';
import 'package:provider/provider.dart';

class MoviesHomeWidget extends StatelessWidget {
  MoviesHomeWidget({Key? key}) : super(key: key);
  late MoviesProvider _moviesProvider;

  Widget _makeListView(List<Movie> movies){
    return ListView.separated(
        itemBuilder: (BuildContext context, int index){
          return Padding(
            padding: EdgeInsets.all(10),
            child: Container(
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(20),
                boxShadow: [BoxShadow(
                  color: Colors.grey.withOpacity(0.3),
                  spreadRadius: 3,
                  blurRadius: 3,
                  offset: Offset(0, 0),
                )]
              ),
              height: 200,
              child: Row(
                children: [
                  ClipRRect(
                    borderRadius: BorderRadius.only(
                      topLeft: Radius.circular(20),
                      bottomLeft: Radius.circular(20),
                    ),
                    child: Image.network(movies[index].posterUrl),
                  ),
                  Expanded(child: Padding(
                    padding: const EdgeInsets.all(15.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        Text(
                          movies[index].title,
                          style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 18,
                          ),
                        ),
                        SizedBox(height: 10,),
                        Expanded(
                          child: Text(
                            movies[index].overview,
                            overflow: TextOverflow.ellipsis,
                            maxLines: 8,
                            style: TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 13,
                            ),
                          ),
                        ),

                      ],
                    ),
                  ),)
                ],
              )
            ),
          );
            // Center(child: Text(movies[index].title),);
        },
        separatorBuilder: (BuildContext context, int index){
          return Divider();

        },
        itemCount: movies.length,
    );
  }

  @override
  Widget build(BuildContext context) {
    _moviesProvider = Provider.of<MoviesProvider>(context, listen: false);
    _moviesProvider.loadMovies();

    return Scaffold(
      appBar: AppBar(title: Text("Movie Provider"),),
      body: Consumer<MoviesProvider>(builder: (context, provider,widget){
        if(provider.movies != null && provider.movies.length > 0){
          return _makeListView(provider.movies);
        }
        return Center(child: CircularProgressIndicator());
        // return Container();
      })
    );
  }
}
