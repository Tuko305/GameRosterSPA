import {getPlayer} from '../services/api.js';
import renderPlayer from '../views/player.js'

export default function(){
    const playerId = window.location.hash.split('player/')[1];
    console.log(playerId);
    getPlayer(playerId).then(function (player){
        renderPlayer(player);
    });
    

}