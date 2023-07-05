import axios from "axios";

export const findAll = async () => {
    try {
        const rs = await axios.get(`http://localhost:8080/ranking`)
        return rs.data;
    } catch (e) {
        console.log(e)
    }
}