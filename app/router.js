import routes from './routes.js';

export default function route() {
    const { roster: defaultRoute } = routes;

    const { init } = Object.values(routes).find(({ hash }) => window.location.hash.startsWith(hash)) || defaultRoute;

    init();
}

window.onhashchange = route;

route();