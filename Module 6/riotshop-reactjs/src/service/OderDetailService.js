import axios from "axios";

export const findOrderDetailByOrderID= async (id, auth) => {
    try {
        const headers = {Authorization: "Bearer " + auth}
        return (await axios.get(`http://localhost:8080/user/order-detail?id=${id}`, {headers})).data;

    }
    catch (e) {
        console.log(e)
    }
}