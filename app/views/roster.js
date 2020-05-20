export default function renderRoster(){
    $('#app')
        .empty()
            .append($('<h1>').text('Roster'))
            .append($('<br>'))
            .append($('<h2>').text('Joao Vitor Fonseca').click(function(){
                window.location.hash = "#playercarecka";
            }))
            .append($('<h2>').text('Bruno Fernandes').click(function(){
                window.location.hash = "#playeromened";
            }))
            .append($('<h2>').text('Hugues Bonnaure').click(function(){
                window.location.hash = "#playerMortiscia";
            }));

};