import roster from './controllers/roster.js';
import renderPlayer from './controllers/renderPlayer.js';
import renderPost from './controllers/renderPost.js';

export default {
    roster: {
        hash: '#roster',
        init: roster,
    },
    
    player: {
        hash: '#player',
        init: renderPlayer,
    },

    post: {
        hash: '#post',
        init: renderPost
    },


};