import axios from 'axios';

const MATCH_API_BASE_URL = "http://localhost:8080/api/v1/match";

class MatchService {

    getMatches(){
        return axios.get(MATCH_API_BASE_URL);
    }
}

export default new MatchService()