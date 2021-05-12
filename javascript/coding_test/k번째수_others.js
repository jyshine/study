function solution(array, commands) {
    var answer = [];
    

    answer = commands.map(a=>{
        return array.slice(a[0]-1,a[1]).sort((b,c)=>b-c)[a[2]-1];
    })
    return answer;


    var array = [1, 5, 2, 6, 3, 7, 4];
    var commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];

    solution(array,commands);
}