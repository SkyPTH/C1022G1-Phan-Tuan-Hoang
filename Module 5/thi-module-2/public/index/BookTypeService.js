import axios from "axios";

export const findAll= async () => {
    const result= await axios.get('http://localhost:3000/bookType');
    return result.data
}