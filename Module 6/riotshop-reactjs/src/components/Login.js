import React, {useEffect, useState} from "react";
import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
import {useNavigate} from "react-router";
import {Field, Form, Formik} from "formik";
import * as SercurityService from '../service/SercurityService'
import {useDispatch} from "react-redux";
import {receiveAccount} from "../redux/action";
import {login} from "../service/SercurityService";

export default function Login() {
    const navigate=useNavigate();
    const [failedAccount, setFailedAccount] = useState(null);
    useEffect(() => {
        document.title = "Đăng nhập";
    }, []);
return(
    <>
        <Header/>
        <div className="bodywrap" style={{marginTop:"100px",marginBottom:'90px'}} >
            <section className="section">
                <div className="container">
                    <div className="wrap_background_aside page_login">
                        <div className="row" >
                            <div style={{margin : "auto"}} className="col-lg-4 col-md-6 col-sm-12 col-12 col-xl-4 offset-xl-4 offset-lg-4 offset-md-3 offset-xl-3 ">
                                <div style={{background:"#fff" , borderRadius : "5px"}} className="row no-margin align-items-center">
                                    <div className="page-login pagecustome clearfix no-padding">
                                        <div className="wpx">
                                            <ul className="auth-block__menu-list">
                                                <li className="active">
                                                    <a
                                                        href="/login"
                                                        title="Đăng nhập">Đăng nhập</a>
                                                </li>
                                                <li className="active">
                                                    <a href="/signup" title="Đăng ký">Đăng ký</a>
                                                </li>
                                            </ul>
                                            <h1 className="title_heads a-center">
                                                <span>Đăng nhập</span>
                                            </h1>
                                            <Formik initialValues={
                                                {
                                                    username:"",
                                                    password:""
                                                }
                                            }
                                                    onSubmit={values =>login(values).then((e)=>{
                                                        console.log(e)
                                                        setFailedAccount(null);
                                                        localStorage.setItem("token", e.token);
                                                        localStorage.setItem("username", e.username);
                                                        localStorage.setItem("account", JSON.stringify(e));
                                                        window.location.href = "/";
                                                    }).catch((e)=>{
                                                        setFailedAccount("Tên đăng nhập hoặc mật khẩu không đúng")
                                                    })}
                                            >
                                                <Form>
                                            <div id="login" className="section">
                                                <div className="form-signup clearfix" style={{marginTop: "18px"}}>
                                                    <div className="form-group">
                                                        <Field
                                                            type="text"
                                                            name="username"
                                                            id="username"
                                                            placeholder="Nhập tên đăng nhập"
                                                        />
                                                    </div>
                                                    {failedAccount && (
                                                        <p className="error-mess m-0" style={{color:"red"}}>{failedAccount}</p>
                                                    )}
                                                    <div className="form-group">
                                                        <Field
                                                            type="password"
                                                            autoComplete="on"
                                                            name="password"
                                                            id="password"
                                                            placeholder="Mật khẩu"
                                                        />
                                                    </div>
                                                    <div className="pull-xs-left">
                                                        <input className="btn btn-style btn_50" type="submit"
                                                               value="Đăng nhập"/>
                                                    </div>
                                                </div>
                                            </div>
                                                </Form>
                                            </Formik>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
<Footer/>
        </>
)
}