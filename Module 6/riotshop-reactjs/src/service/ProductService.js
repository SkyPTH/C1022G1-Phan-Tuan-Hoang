import axios from "axios";

export const searchList = async (nameProduct,idRank,nameSkin,minPrice,maxPrice,page) => {
    try {
        const rs = await axios.get(`http://localhost:8080/public/product?nameProduct=${nameProduct ? nameProduct : ''}&idRank=${idRank ? idRank : ''}&nameSkin=${nameSkin ? nameSkin : ''}&minPrice=${minPrice ? minPrice : 0}&maxPrice=${maxPrice ? maxPrice : 5000000}&page=${page}`)
        return rs.data;
    } catch (e) {
        console.log(e)
    }
}
export const findById= async (id)=>{
    try {
        const rs=await axios.get(`http://localhost:8080/public/product/detail?idProduct=${id}`)
        return rs.data
    }
    catch (e) {
        console.log(e)
    }
}
export const deleteProduct = async (id, auth) => {
    const headers = { Authorization: "Bearer " + auth };
    try {
        await axios.delete(
            `http://localhost:8080/public/product/delete/${id}`,
            { headers }
        );
    } catch (err) {
        console.log(err);
    }
};
export const update=async (product)=>{
    try {
        return await axios.patch(`http://localhost:8080/public/product/update`,{ ...product })}
    catch (e) {
        console.log(e)
    }
}

