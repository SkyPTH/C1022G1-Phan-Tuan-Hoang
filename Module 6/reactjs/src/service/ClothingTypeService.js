import axios from "axios";

export const findAll = async () => {
    try {
        return (await axios.get(`http://localhost:3000/typeClothing`)).data
    } catch (e) {
        console.log(e)
    }
}