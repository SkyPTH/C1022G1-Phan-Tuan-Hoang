import React, {useEffect, useState} from "react";
import {findAccountByNameAccount} from "../service/AccountService'";
import {useNavigate} from "react-router";
import * as CartService from "../service/CartService";
import * as PaymentService from "../service/PaymentService";
import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
import {toast} from "react-toastify";


export default function Cart() {
    const username = localStorage.getItem("username");
    const account = JSON.parse(localStorage.getItem("account"));
    const [cartList, setCartList] = useState([])
    const [isDelete, setIsDelete] = useState(false)
    const navigate = useNavigate();
    const token = localStorage.getItem("token")
    let totalPrice = cartList.reduce((sum, cart) => sum += cart.priceProduct, 0)

    const formatPrice = (n) => {
        return n.toFixed(0).replace(/./g, function (c, i, a) {
            return i > 0 && c !== "." && (a.length - i) % 3 === 0 ? "," + c : c;
        });
    };
    useEffect(() => {
        document.title = "Giỏ hàng";
    }, []);
    const handlePayment = async (totalPrice) => {
        await PaymentService.payment({totalPrice}, token)
        navigate("/history")
        toast("Thanh toán thành công, thông tin tài khoản ở trong phần Chi tiết")
    }
    useEffect(() => {
        (async () => {
            const result2 = await CartService.findCartByNameAccount(username,token)
            setCartList(result2)
        })()
    }, [isDelete]);
    const [user, setUser] = useState(null);
    useEffect(() => {
        const findAccountByUsername = async () => {
            const result = await findAccountByNameAccount(username,token);
            setUser(result);
        };
        findAccountByUsername();
    }, []);
    return (
        <>

            <Header/>
            <div className="container sl-sebox" style={{paddingTop: '90px', marginBottom: '130px'}}>
                <div className="row">
                    <div className="w-100 " style={{
                        height: '100%',
                        fontSize: '53px',
                        fontWeight: 'bolder',
                        color: 'white',
                        textAlign: 'center',
                        border: 'red solid 2px'
                    }}><a>
                        Giỏ hàng</a>
                    </div>
                    {cartList.length == 0 ?
                        <div>
                            <div className="w-100 " style={{
                                height: '100%',
                                fontSize: '40px',
                                fontWeight: 'bolder',
                                color: 'white',
                                textAlign: 'center',
                            }}>Giỏ hàng chưa có sản phẩm
                            </div>
                            <div className='row' style={{ justifyContent: 'center', alignItems: 'center' }} >
                                <button onClick={() => navigate("/")} className='btn btn-primary' style={{
                                    fontSize: '25px', marginBottom: '15px', width:"250px"
                                }}>
                                    Tiếp tục mua hàng
                                </button>
                            </div>
                        </div>
                        : <div>
                            {
                                cartList.map((cart) => (

                                    <div className='row'>
                                        <div style={{paddingTop: '25% !important', marginTop: '20px'}}
                                             className="col-4">
                                            <img className="w-100" style={{height: "170px"}}
                                                 src={cart.product.imageProduct}/>
                                        </div>
                                        <div className='col-6' style={{
                                            marginTop: '20px',
                                            marginBottom: '15px',
                                            fontSize: '30px',
                                            color: "white"
                                        }}>
                                            <div className='row'>
                                                <a>Tài
                                                    khoản {cart.product.nameProduct} ,hạng {cart.product.ranking.nameRanking}, {cart.product.skinDetailSet.length} trang
                                                    phục </a>
                                            </div>
                                            <div className='row' style={{
                                                marginTop: '3px',
                                                marginBottom: '15px',
                                                fontSize: '40px',
                                                color: "yellow"
                                            }}>
                                                <a>Giá: {formatPrice(cart.product.price)} VNĐ</a>
                                            </div>
                                        </div>
                                        <div className='col-2'>
                                            <button onClick={async () => {
                                                await CartService.deleteCart(cart.idCart,token)
                                                setIsDelete({...isDelete})
                                                navigate("/cart")
                                            }} className='btn btn-danger'
                                                    style={{marginTop: "25%", marginLeft: "40%", background: ""}}>
                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
                                                     fill="currentColor"
                                                     className="bi bi-trash3-fill" viewBox="0 0 16 16">
                                                    <path
                                                        d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
                                                </svg>
                                            </button>
                                        </div>
                                    </div>
                                ))
                            }
                            <div className='row' style={{
                                fontSize: '20px',
                                fontWeight: 'bolder',
                                color: 'white',
                                textAlign: 'left',
                                marginTop: "15px"
                            }}>
                                <div className='col-4'><p>Số lượng tài khoản : {cartList.length}</p>
                                    <p>Tổng giá: {formatPrice(totalPrice)} VNĐ</p>
                                    {/*    {user &&*/}
                                    {/*// <a>Địa chỉ mail nhận thông tin tài khoản : {user.email}</a>*/}
                                    {/*}*/}
                                </div>
                                <div className='col-4'>
                                    <button onClick={() => navigate("/")} className='btn btn-primary' style={{
                                        fontSize: '25px', marginBottom: '15px'
                                    }}>
                                        Tiếp tục mua hàng
                                    </button>
                                </div>
                                <div className='col-4'>
                                    <button onClick={() => handlePayment(totalPrice)} className='btn btn-warning'
                                            style={{
                                                fontSize: '25px', marginBottom: '15px'
                                            }}>Thanh toán bằng VNPAY
                                    </button>

                                </div>
                            </div>
                        </div>}

                </div>
            </div>
            <Footer/>

        </>
    )
}