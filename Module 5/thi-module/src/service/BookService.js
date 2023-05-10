import axios from "axios";

export const findAll = async () => {
    try {
        let rs = (await axios.get('http://localhost:3000/books')).data
        return rs
    } catch (e) {
        console.log(e)
    }
}
export const save = async (book) => {
    try {
        return await axios.post('http://localhost:3000/books',{...book})
    } catch (e) {
        console.log(e)
    }
}
export const update=async (book)=>{
    try {
        return await  axios.put('http://localhost:3000/books',{...book})
    }
    catch (e) {
        console.log(e)
    }
}