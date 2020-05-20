export function getPlayer(playerName){
    return new Promise(function (resolve, reject){
        $.ajax({
            url: `https://gameinfo.albiononline.com/api/gameinfo/search?q=${playerName}`,
            crossDomain: true,
            type: 'GET',
            success: function ({Name}, {KillFame}, {FameRatio}){
                const player = {
                    name: Name,
                    killFame: KillFame,
                    fameRatio: FameRatio
                };

                resolve(player);
            },
            error: function (request, error){
                reject(request, error);
            }
        });
    });
}

