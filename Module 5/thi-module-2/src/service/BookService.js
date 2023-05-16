import axios from "axios";

export const findByTitle=async (title)=>{
    if(title==null){title=''}
    return (await axios.get(`http://localhost:3000/books?title_like=${title}`)).data
}
export const create=async (book)=>{
    return await axios.post('http://localhost:3000/books',{...book})
}
export const findById=async (id)=>{
    return (await axios.get(`http://localhost:3000/books/${id}`)).data
}
export const update=async (book)=>{
    return await axios.put(`http://localhost:3000/books/${book.id}`,{...book})
}
export const deleteById=async (id)=>{
    return await axios.delete(`http://localhost:3000/books/${id}`)
}