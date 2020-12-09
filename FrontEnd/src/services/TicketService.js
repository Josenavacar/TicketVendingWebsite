import axios from 'axios';

const TICKET_API_BASE_URL = "http://localhost:8080/api/v1/ticket";

class TicketService {

    getTickets(){
        return axios.get(TICKET_API_BASE_URL);
    }
}

export default new TicketService()