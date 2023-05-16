import axios from "axios";

export const findByName = async (name, type) => {
    try {
        if (name == null) {
            name = ''
        }
        if (type == null) {
            type = ''
        }
        console.log(type)
        return (await axios.get(`http://localhost:3000/clothing?name_like=${name}&typeClothing_like=${type}`)).data
    } catch (e) {
        console.log(e)
    }
}
export const update = async (clothing) => {
    try {
        return await axios.put(`http://localhost:3000/clothing/${clothing.id}`, {...clothing})
    } catch (e) {
        console.log(e)
    }
}
export const findById = async (id) => {
    try {
        return (await axios.get(`http://localhost:3000/clothing/${id}`)).data
    } catch (e) {
        console.log(e)
    }
}