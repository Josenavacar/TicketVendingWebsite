import axios from 'axios';
import authHeader from './auth-header';

const TICKET_API_BASE_URL = "http://localhost:8080/api/v1/ticket";

class TicketService {

    getTickets(){
        return axios.get(TICKET_API_BASE_URL, { headers: authHeader() });
    }

    getUnpaidTickets(userID){
        return axios.get(TICKET_API_BASE_URL + "/fan/" + userID + "/0", { headers: authHeader() });
    }

    getPaidTickets(userID){
        return axios.get(TICKET_API_BASE_URL + "/fan/" + userID + "/1", { headers: authHeader() });
    }

    purchaseTicket(matchName, userName, matchID, fanID, paid) {
        return axios.post(TICKET_API_BASE_URL, {
            matchName,
            userName,
            matchID,
            fanID,
            paid
        }, { headers: authHeader() });
    }

    deleteTicket(id) {
        return axios.delete(TICKET_API_BASE_URL + "/" + id, { headers: authHeader() });
    }

    payTicket(id) {
        return axios.put(TICKET_API_BASE_URL + "/buy/" + id, { headers: authHeader() });
    }
    
}

export default new TicketService()