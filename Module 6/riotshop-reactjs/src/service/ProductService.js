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