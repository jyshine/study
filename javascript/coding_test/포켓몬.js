
function solution(nums) {
    var answer = 0;
    
    //배열의 n/2 명 선택
    //종류별 1명 선택

    let porketmons = new Map();
    
    for(var i in nums){
        if(porketmons.has(nums[i])) {
            porketmons.set(nums[i], porketmons.get(nums[i])+1);
        }else{
            porketmons.set(nums[i], 1);
        } 
    }

    if(porketmons.size > nums.length/2){
       return nums.length/2;
    }else{
        return porketmons.size;
    }
}


var nums = [1,2,3,4,5,6];

//solution(nums);
console.log(solution(nums));