import React, {useEffect} from "react";
import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
import {Field, Form, Formik} from "formik";
import {signup} from "../service/SercurityService";
import {toast} from "react-toastify";
import {useNavigate} from "react-router";


export default function SignUp() {
    const navigate=useNavigate()
    useEffect(() => {
        document.title = "Đăng ký";
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
                                                    <span>Đăng ký</span>
                                                </h1>
                                                <Formik
                                                initialValues={{
                                                    username:"",
                                                    password:"",
                                                    email:"",
                                                    phoneNumber:"",
                                                    roles:["user"]
                                                }}
                                                onSubmit={values => {
                                                    signup(values).then(response=>{toast(response.message)})
                                                    navigate("/")
                                                }}
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
                                                        <div className="form-group">
                                                            <Field
                                                                type="password"
                                                                name="password"
                                                                id="password"
                                                                placeholder="Mật khẩu"
                                                            />
                                                        </div>
                                                        <div className="form-group">
                                                            <Field
                                                                type="text"
                                                                name="email"
                                                                id="email"
                                                                placeholder="Email"
                                                            />
                                                        </div>
                                                        <div className="form-group">
                                                            <Field
                                                                type="text"
                                                                name="phoneNumber"
                                                                id="phoneNumber"
                                                                placeholder="Phone number"
                                                            />
                                                        </div>
                                                        <div className="pull-xs-left">
                                                            <input className="btn btn-style btn_50" type="submit"
                                                                   value="Đăng ký"/>
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