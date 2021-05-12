
function solution(nums) {
    var answer = 0;
    for(var i=0; i<nums.length;i++){
        for(var j=1+i; j<nums.length;j++){
            for(var k=1+j; k<nums.length;k++){
                const number = nums[i]+nums[j]+nums[k];
                if (isPrime(number)){
                    answer++;
                } 
            }
        }
    }

    function isPrime(number){
        if(number < 2){
            return true;
        }
        for(let i=2; i<number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }
    return answer;
}

var nums = [1,2,7,6,4];
console.log(solution(nums));

