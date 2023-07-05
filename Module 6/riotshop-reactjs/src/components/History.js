import * as PaymentService from "../service/PaymentService";
import * as OrderDetailService from "../service/OderDetailService";
import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router";
import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
export default function History() {
    const username = localStorage.getItem("username");
    const token = localStorage.getItem("token")
    const [historyList, setHistoryList] = useState([])
    const [detail,setDetail]=useState([])

    useEffect(() => {
        const findByName = async () => {
            console.log(token)
            const rs = await PaymentService.history(username,token)
            setHistoryList(rs)
        };
            findByName(username,token)
    }, [])
    const navigate = useNavigate()
    const handleDetail= async (id,token)=>{
        const rs=await OrderDetailService.findOrderDetailByOrderID(id,token)
        console.log(rs)
        setDetail(rs)
    }
    useEffect(() => {
        document.title = "Lịch sử mua hàng";
    }, []);

    // if (clothingList.length == 0) {
    //     return (<><h2>Không tìm thấy sản phẩm</h2></>)
    // }
    const formatPrice = (n) => {
        return n.toFixed(0).replace(/./g, function (c, i, a) {
            return i > 0 && c !== "." && (a.length - i) % 3 === 0 ? "," + c : c;
        });
    };
    return (
        <>

            <Header/>
            <div style={{marginTop:'100px'}} className='container'>
            <h2 style={{color:'white',textAlign:'center'}}> Lịch sử mua hàng</h2>
            <table className='table' style={{color:'white'}}>
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã đơn hàng</th>
                    <th>Ngày mua</th>
                    <th>Tổng giá (VNĐ)</th>
                    <th>Chi tiết</th>

                </tr>
                </thead>
                <tbody>
                {
                    historyList.map((order,index) => (
                        <tr>
                            <td>{index+1}</td>
                            <td>DH-{index+1}</td>
                            <td>{order.dateOrder}</td>
                            <td>{formatPrice(order.totalPrice)}</td>
                            <td><button className='btn btn-primary' data-bs-toggle="modal"
                                        data-bs-target="#exampleModal" onClick={()=>handleDetail(order.idOrder,token)} >Chi tiết</button></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            </div>
            <div className="modal fade" id="exampleModal" tabIndex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header text-center" style={{color: "red" , fontSize: 20 , fontWeight: "bolder"}}>
                            <h5 className="modal-title" id="exampleModalLabel">Thông tin chi tiết hoá đơn</h5>
                        </div>
                        <div className="modal-body">
                            <table className="table">
                                <thead>
                                <th>Số thứ tự</th>
                                <th>Tên tài khoản</th>
                                <th>Mật khẩu</th>
                                <th>Giá (VNĐ)</th>
                                </thead>
                                <tbody>
                                {detail.map((orderDetail, index) => (
                                    <tr key={index}>
                                        <td>{index + 1}</td>
                                        <td>{orderDetail?.product?.nameProduct}</td>
                                        <td>{orderDetail?.product?.passwordProduct}</td>
                                        <td>{formatPrice(orderDetail?.product?.price)}</td>
                                    </tr>
                                ))}
                                </tbody>
                            </table>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary btn-sm"
                                    data-bs-dismiss="modal">Đóng
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <Footer></Footer>
        </>
    )
}