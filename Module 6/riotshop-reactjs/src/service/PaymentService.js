import axios from "axios";

export const payment = async (totalPrice , auth) => {
    const headers = { Authorization: "Bearer " + auth}
    try {
        const result = (await axios.post(`http://localhost:8080/user/order-detail/payment`, {...totalPrice},{headers})).data;
        return result;
    } catch (e) {
        console.log(e);
    }
}
export const history=async (name,auth)=>{
    const headers = { Authorization: "Bearer " + auth}
    return (await axios.get(`http://localhost:8080/user/order?name=${name}`,{headers})).data
}