
function solution(participant, completion) {
    var answer;
    const completionMap = new Map();

    
    for(var i=0; i<participant.length; i++){
        if(completionMap.has(participant[i])){
            completionMap.set(participant[i],completionMap.get(participant[i])+1);   
        }else{
            completionMap.set(participant[i],1);
        }
    }

    console.log(completionMap)

    for(var i=0; i<completion.length; i++){
        if(completionMap.has(completion[i])){
            completionMap.set(completion[i],completionMap.get(completion[i])-1);
        }
    }

    console.log(completionMap)
    for(var key of completionMap.keys()){
        if(completionMap.get(key) ==1){
            answer = key;
        }
    }

    console.log(completionMap);

}


var participant =["mislav", "stanko", "mislav", "ana"];
var completion = ["stanko", "ana", "mislav"];

solution(participant,completion);