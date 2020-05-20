import {getPlayer} from '../services/api.js';
import renderPlayer from '../views/player.js'

export default function(){
    const playerName = window.location.hash.split('player')[1];
    console.log(playerName);
    getPlayer(playerName).then(function (player){
        renderPlayer(player);
    });
    

}