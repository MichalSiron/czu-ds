import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8088/api'
});
instance.defaults.headers.common['Content-Type'] = 'application/json';
// instance.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

export default instance;