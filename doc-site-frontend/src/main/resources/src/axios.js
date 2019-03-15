import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8088/api'
});

// instance.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

export default instance;