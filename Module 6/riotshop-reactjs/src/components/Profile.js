import React, {useEffect, useState} from "react";
import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
import * as ProductService from '../service/ProductService'
import {useNavigate} from "react-router";
import {findAccountByNameAccount} from "../service/AccountService'";
import {Form, Formik} from "formik";
import * as CartService from "../service/CartService";
import {toast} from "react-toastify";
import {createCart} from "../service/CartService";
import Dropdown from "react-bootstrap/Dropdown";
export default function Profile() {
    const token = localStorage.getItem("token")
    const username = localStorage.getItem("username");
    const [user, setUser] = useState(null);
    const navigate=useNavigate();
    const handleLogout = () => {
        localStorage.clear();
        navigate("/")
    };
    useEffect(() => {
        const findAccountByUsername = async () => {
            const result = await findAccountByNameAccount(username,token);
            setUser(result);
            console.log(user)
        };
        findAccountByUsername();
    }, []);

    return(
        <>
            <Header/>
            {user&& (<div className="container sl-sebox"
                     style={{paddingTop: '50px', marginBottom: '130px', marginTop: '40px'}}>
                    <div className="row">
                        <div className="w-100 h-100" style={{
                            height: '100%',
                            fontSize: '53px',
                            fontWeight: 'bolder',
                            color: 'white',
                            textAlign: 'center',
                            border: 'red solid 2px'
                        }}><a>
                            Thông tin tài khoản</a>
                        </div>
                        <div className="row" style={{padding: "15px"}}>
                            <div className="row">
                                <div className="col-4">
                                    <img className="w-100" style={{height: "100%"}} src={user.image}/>
                                </div>
                                <div className="col-6" style={{
                                    fontSize: '28px',
                                    fontWeight: 'bolder',
                                    color: 'yellow',
                                    margin:'10px'
                                }}><p>
                                    Tên tài khoản : {user.nameAccount}
                                </p>
                                    <p>
                                        Email: {user.email}
                                    </p>
                                    <p>
                                        Số điện thoại : {user.phoneNumber}
                                    </p>

                                    <p>
                                        <button className="btn btn-primary" style={{width:'160px'}}>Cập nhật thông tin</button>
                                    </p>
                                    <p>
                                        <button className="btn btn-primary" style={{width:'160px'}}>Thay đổi mật khẩu</button>
                                    </p>
                                    <p>
                                        <button onClick={event => navigate('/')} className="btn btn-primary" style={{width:'160px'}}>Trang chủ</button>
                                    </p>
                                    <p>
                                        <button  onClick={handleLogout} className="btn btn-primary" style={{width:'160px'}}>Đăng xuất</button>
                                    </p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>)}
            <Footer/>
        </>
    )
}