import axios from "axios";

export const findByAccountId = async (accountId) => {
    try {
        const rs = await axios.get(`http://localhost:8080/public/cart/findByAccountID?accountId=${accountId}`)
        return rs.data;
    } catch (e) {
        console.log(e)
    }
}
export const findCartByNameAccount = async (nameAccount,auth) => {
    try {
        const headers = { Authorization: "Bearer " + auth}
        console.log(auth)
        const rs = await axios.get(`http://localhost:8080/user/cart/findByNameAccount?nameAccount=${nameAccount}`,{headers})
        return rs.data
    } catch (e) {
        console.log(e)
    }
}
export const createCart = async (cart,auth) => {
    try {
        const headers = { Authorization: "Bearer " + auth}
        return await axios.post(`http://localhost:8080/user/cart/create`, {...cart},{headers})
    } catch (e) {
        console.log(e)
    }
}
export const checkCartExist=(accountID,productID,auth)=>{
    const headers = { Authorization: "Bearer " + auth}
   return axios.get(`http://localhost:8080/user/cart/checkExist?accountID=${accountID}&productID=${productID}`,{headers})
}
export const updateCart = async (cart) => {
    try {
        return await axios.put(`http://localhost:8080/public/cart/update`, {...cart})
    } catch (e) {
        console.log(e)
    }
}
export const deleteCart = async (id,auth) => {
    try {
        const headers = { Authorization: "Bearer " + auth}
        return await axios.delete(`http://localhost:8080/user/cart/delete?id=${id}`,{headers})
    } catch (e) {
        console.log(e)
    }
}