import axios from "axios";

export const findAll = async () => {
    try {
        let rs=await axios.get('http://localhost:3000/books')
        return rs.data
    } catch (err) {
        console.log(err)
    }
}
export const save = async (input) => {
    try {
        return (await axios.post('http://localhost:3000/books', {...input}))
    } catch (err) {
        console.log(err)
    }
}
export const detail =async (id)=>{
    try {
        return ((await axios.get(`http://localhost:3000/books/${id}`)).data)
    }
    catch (e) {
        console.log(e)
    }
}
export const update=async (book)=>{
    try {

        return (await axios.put(`http://localhost:3000/books/${book.id}`,{...book}))
    }
    catch (e) {
        console.log(e)
    }
}