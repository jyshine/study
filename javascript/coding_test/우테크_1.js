function soulution(weights, head2head){

    var answer = [];
    var boxer = new Array();
    
    for(var i =0; i<weights.length; i++){
        var winCount = 0;
        var winOverWegitCount = 0;
        var nonCount =0;
        var winRate = 0;
    
        for(var j=0; j<head2head[i].length; j++){
            //console.log(head2head[i].charAt(j));
            if(head2head[i].charAt(j) == "W"){
                winCount++;
                if(weights[i] < weights[i+1] || weights[i]< weights[i-1]){
                    winOverWegitCount++;
                    //console.log(weights[i])
                }
            }
            if(head2head[i].charAt(j) == "N"){
                nonCount++;
            }
        }
        winRate = winCount/(head2head[0].length - nonCount)*100;
        if(isNaN(winRate)) {
            winRate=0;
        } 
        boxer.push([i+1,weights[i],winRate,winOverWegitCount]);
   
        console.log(winRate);
        //console.log(weights[i] ,",",winRate,",",winOverWegitCount);
    }
    
    boxer.sort( (a, b)=> a[0] - b[0] 
      ).sort( (a, b)=> b[1] -a[1]).sort( (a, b)=> b[3] -a[3]  
      ).sort( (a, b)=> b[2] -a[2] 
      )

      console.log(boxer);
    for(var i=0; i<boxer.length; i++){
        answer.push(boxer[i][0]);
    }
    
    console.log(answer);
    return answer;
}

//var weights = [145,92,86];

//var head2head = ["NLW","WNL","LWN"];

var weights = [50,60,70,55,60];
var head2head = ["NWWLL","LNLLW","LWNWL","WWLNL","WLWWN"];


soulution(weights, head2head)