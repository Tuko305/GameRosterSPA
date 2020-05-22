import {postPlayer} from '../services/api.js'
import renderPost from '../views/post.js'

export default function(){
    const playerName = window.location.hash.split('?pname=')[1].split('.')[0];
    const charName = window.location.hash.split('.cname=')[1];
    
    postPlayer(playerName, charName).then(renderPost).catch(renderPost);
}