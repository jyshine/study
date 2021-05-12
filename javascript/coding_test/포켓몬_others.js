
function solution(nums) {
    const noDuplicatePokemon = new Set(nums);
    console.log(noDuplicatePokemon);
    const pokemonVarietyCount = noDuplicatePokemon.size;
    const pokemonCounts = nums.length;
    return pokemonVarietyCount > pokemonCounts/2 ? pokemonCounts/2 : pokemonVarietyCount;

}
var nums = [3,3,3,2,2,4];

//solution(nums);
console.log(solution(nums));