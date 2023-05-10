import axios from "axios";

export const findAll = async () => {
    try {
        let result = await axios.get(`https://jsonplaceholder.typicode.com/todos`)
        return result.data
    }
    catch (error) {
        console.log(error)
    }
}
export const save=async (inputToDo)=>{
    try {
        return await axios.post('https://jsonplaceholder.typicode.com/todos',inputToDo)
    }
    catch (error) {
        console.log(error)
    }
}