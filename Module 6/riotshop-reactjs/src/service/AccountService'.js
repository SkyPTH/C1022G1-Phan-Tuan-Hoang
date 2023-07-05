import axios from "axios";

export const findAccountByNameAccount = async (username,auth) => {
    try {
        const headers = {Authorization: "Bearer " + auth}
        const rs = await axios.get(`http://localhost:8080/user/account/detail?username=${username}`,{headers})
        return rs.data;
    } catch (e) {
        console.log(e)
    }
}