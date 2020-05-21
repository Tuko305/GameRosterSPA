export default function renderRoster(results){
    console.log(results);
    $('#app')
        .empty()
            .append($('<h1>').text('Roster'))
            .append($('<br>'))
            .append($('<h2>').text('Add new player to output'))
            
            $('#app').append($('<br>'));
            var heyo = $('<form id="heyo">')
                .append(labeling("pname", "Player Name"))
                .append($('<br>'))
                .append(inputing("pname", "Player Name"))
                .append($('<br>'))

            var heyo2 = $('<form id="heyo2">')
                .append(labeling("cname", "Character Name"))
                .append($('<br>'))
                .append(inputing("cname", "Character Name"))
                .append($('<br>'))
                .append($('<button>').text('Submit Request').click(function(){
                    window.location.hash = `#post?pname=${pname.value}.cname=${cname.value}`;
                }))
                
            $('#app').append(heyo).append(heyo2);


            
            results.forEach(player => {
                if(player.pvpKillFame > 0){               
                $('#app').append($('<h2>').text(`${player.name}`).click(function(){
                    window.location.hash = `#player/${player.id}`
                }));
            }
                
            });
            
            function labeling(labelName, playerName){
                return $(`<label for=${labelName}>`).text(playerName)
            }

            function inputing(labelName, playerName){
                return $(`<input type="text" id=${labelName} name=${labelName} value="${playerName}">`)
            }

};