export default function renderPlayer({ name, killFame, fameRatio}){
    $('#app')
        .empty()
            .append($('<h1>').text(`Player Name: ${name}`))
            .append($('<br>'))
            .append($('<h2>').text(`PVP fame: ${killFame}`))
            .append($('<h2>').text(`PVP Ratio: ${fameRatio}`))
            .append($('<h2>').text('Back to Roster').click(function(){
                window.location.hash = "#roster";
            }));

};