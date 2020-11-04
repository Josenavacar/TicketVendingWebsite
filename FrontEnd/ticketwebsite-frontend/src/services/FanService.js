import axios from 'axios';

const FAN_API_BASE_URL = "http://localhost:8080/api/v1/fan";

class FanService {

    getFans(){
        return axios.get(FAN_API_BASE_URL);
    }
}

export default new FanService()