import roster from './controllers/roster.js';
import renderPLayer from './controllers/renderPlayer.js';

export default {
    roster: {
        hash: '#roster',
        init: roster,
    },
    
    player: {
        hash: '#player',
        init: renderPLayer,
    },
    

};