function solution(array, commands) {
    var answer = [];

    var value1 =commands.map( a => {
        //console.log(a[0],a[1],a[2]);
        //console.log(array.slice(a[0]-1,a[1]))
        //array.slice(a[0]-1,a[1]).sort((next,prev) => console.log(next-prev));
        
        return array.slice(a[0]-1,a[1]).sort()[a[2]-1];
    })

    
    console.log(value1);

    return answer;
}

var array = [1, 5, 2, 6, 3, 7, 4];
var commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];

solution(array,commands);

//arr.sort((a, b) => a - b)  오름차순
//arr.sort((a, b) => b-a) 내림차순