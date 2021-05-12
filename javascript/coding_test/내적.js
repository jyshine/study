function solution(a, b) {
    return a.reduce((aa,c,i)=> aa+= a[i]*b[i],0);
}

var a = [-1,0,1];
var b = [1,0,-1];

console.log(solution(a,b));