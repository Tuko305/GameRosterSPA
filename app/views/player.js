export default function renderPlayer({ name, charName, guildName, pvpKillFame, pvpRatio}){
    $('#app')
        .empty()
            .append($('<h1>').text(`Player Name: ${name}`))
            .append($('<br>'))
            .append($('<h2>').text(`Character Name: ${charName}`))
            .append($('<h2>').text(`Guild Name: ${guildName}`))
            .append($('<h2>').text(`PVP fame: ${pvpKillFame}`))
            .append($('<h2>').text(`PVP Ratio: ${pvpRatio}`))
            .append($('<h2>').text('Back to Roster').click(function(){
                window.location.hash = "#roster";
            }));

};