import axios from "axios";

export const findByName = async (search) => {
    try {
    //     if (name == null) {
    //         name = ''
    //     }
    //     if (type == null) {
    //         type = ''
    //     }
    //     console.log(type)
        if(search==null){search=''}
        // debugger
        return (await axios.get(`http://localhost:8080/product`)).data

    } catch (e) {
        console.log(e)
    }
}
export const createProduct = async (discount) => {
    return await axios.post(
        "http://localhost:8080/api/admin/discount/create",
        {
            ...discount,
        },
    );
};