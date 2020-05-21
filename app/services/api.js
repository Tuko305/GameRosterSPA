export default function getPlayerList() {
    return new Promise(function (resolve, reject) {
        $.ajax({
            url: "http://localhost:8080/players",
            type: 'GET',
            success: function (results) {
                resolve(results);
            },
            error: function (request, error){
                reject(request, error);
            },
        });
    });
}
    
export function getPlayer(id){
    return new Promise(function (resolve, reject){
        $.ajax({
            url: `http://localhost:8080/players/${id}`,
            type: 'GET',
            success: function(results){
                resolve(results);
            },
            error: function (request, error){
                reject(request, error);
            }
        });
    });
}

export function postPlayer(playerName, charName){
    return new Promise(function (resolve, reject){
        $.ajax({
            url: `http://localhost:8080/players`,
            type: 'POST',
            data: JSON.stringify({"name": playerName, "charName": charName}),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function (results){
                resolve(results);
            },
            error: function(request, error){
                reject(request, error);
            }
        });
    });
}
    
    

