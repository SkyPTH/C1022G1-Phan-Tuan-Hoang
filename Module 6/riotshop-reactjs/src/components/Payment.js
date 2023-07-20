import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
import React, {useEffect} from "react";
import {Formik} from "formik";
import {useNavigate, useParams} from "react-router";
import * as PaymentService from "../service/PaymentService";

import "react-toastify/dist/ReactToastify.css"
import {toast, ToastContainer} from "react-toastify"
export default function Payment() {
    const param=useParams()
    const totalPrice=param.vnp_Amount
    const token = localStorage.getItem("token")
    const navigate = useNavigate()
    const handlePayment = async (totalPrice) => {
        await PaymentService.confirmPayment({totalPrice}, token)
        toast("Thanh toán thành công, thông tin tài khoản ở trong phần Chi tiết")
        navigate("/history")
        toast("Thanh toán thành công, thông tin tài khoản ở trong phần Chi tiết")
    }
    useEffect(() => {
        handlePayment(totalPrice)
    },[])

return(
    <>
        <div>
       <ToastContainer/>
        </div>
    </>
)
}