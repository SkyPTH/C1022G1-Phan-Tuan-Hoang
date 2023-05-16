import axios from "axios";

export const findAll= async () => {
    // console.log((await axios.get('http://localhost:3000/bookType')).data)
    const result= await axios.get('http://localhost:3000/bookType');
    return result.data
}