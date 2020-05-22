export default function renderPost({ name, charName, guildName, pvpKillFame, pvpRatio}){
   window.location.hash = "#roster";
    /*$('#app')
        .empty()
            .append($('<h3>').text('Added to data base: if fields are empty the Albion API might not have responded, resubmit your post please.'))
            .append($('<h1>').text(`Player Name: ${name}`))
            .append($('<br>'))
            .append($('<h2>').text(`Character Name: ${charName}`))
            .append($('<h2>').text(`Guild Name: ${guildName}`))
            .append($('<h2>').text(`PVP fame: ${pvpKillFame}`))
            .append($('<h2>').text(`PVP Ratio: ${pvpRatio}`))
            .append($('<h2>').text('Back to Roster').click(function(){
                window.location.hash = "#roster";
            }));
            */
};