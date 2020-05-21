import getPlayerList from '../services/api.js';
import renderRoster from '../views/roster.js';

export default function(){
    getPlayerList().then(renderRoster);
     
};