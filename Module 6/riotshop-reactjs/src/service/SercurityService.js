import axios from "axios";

export const login = async (value) => {
    try {
        const rs = await axios.post(`http://localhost:8080/public/login`,value)
        return rs.data;
    } catch (e) {
        console.log(e)
    }
}
export const confirmEmail= async (value)=>{
try {
    const rs= await  axios.post(`http://localhost:8080/api/public/confirm-email`,value)
    return rs;
} catch (e) {
    console.log(e)
}
}
export const signup = async (value) => {
    try {
        const rs = await axios.post(`http://localhost:8080/public/signup`,value)
        return rs.data;
    } catch (e) {
        console.log(e)
    }
}
