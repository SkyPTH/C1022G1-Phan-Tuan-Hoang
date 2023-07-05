import React, {useEffect, useState} from "react";
import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
import * as ProductService from '../service/ProductService'
import {useNavigate, useParams} from "react-router";
import {createCart} from "../service/CartService";
import * as CartService from "../service/CartService";
import {toast, ToastContainer} from "react-toastify";
import {findAccountByNameAccount} from "../service/AccountService'";
import {Form, Formik} from "formik";
export default function Detail() {
    const [product, setProduct] = useState("")
    const [user, setUser] = useState(null);
    const navigate = useNavigate();
    const token = localStorage.getItem("token")
    const username = localStorage.getItem("username");
    useEffect(() => {
        const findAccountByUsername = async () => {
            const result = await findAccountByNameAccount(username,token);
            setUser(result);
        };
        findAccountByUsername();
        console.log(user)
    }, []);
    const findProductById = async (id) => {
        const result = await ProductService.findById(id)
        setProduct(result)
    }
    useEffect(() => {
        document.title = "Chi tiết sản phẩm";
    }, []);
    const param = useParams();
    useEffect(() => {

        findProductById(param.id);

    }, []);
    const formatPrice = (n) => {
        return n.toFixed(0).replace(/./g, function (c, i, a) {
            return i > 0 && c !== "." && (a.length - i) % 3 === 0 ? "," + c : c;
        });
    };
    return (
        <>
            <Header/>
            {product && (
                <div>
                    <div className="container sl-sebox"
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
                                    <div className="col-6">
                                        <img className="w-100" style={{height: "100%"}} src={product.imageProduct}/>
                                    </div>
                                    <div className="col-6" style={{

                                        fontSize: '23px',
                                        fontWeight: 'bolder',
                                        color: 'yellow',
                                    }}><p>
                                        Tên tài khoản : {product.nameProduct}
                                    </p>
                                        <p>
                                            Rank : {product.ranking.nameRanking}
                                        </p>
                                        <p>
                                            Số tướng : {product.numberChamp}
                                        </p>
                                        <p>
                                            Số trang phục : {product.skinDetailSet.length}
                                        </p>
                                        <p>
                                            Giá: {formatPrice(product.price)} đ
                                        </p>
                                        <div>
                                            <Formik initialValues={{
                                                priceProduct: product.price,
                                                productId: product.idProduct,
                                                accountUserId: user?.idAccount
                                            }}
                                                    onSubmit={async (values) => {
                                                        let res = await CartService.checkCartExist(user.idAccount, product.idProduct,token)
                                                        if (res.data) {
                                                            toast("Sản phẩm đã có trong giỏ hàng!");
                                                        } else {
                                                            createCart(values,token);
                                                            toast("Thêm vào giỏ hàng thành công!")
                                                            console.log("Thêm vào giỏ hàng thành công!")
                                                            navigate("/cart");
                                                        }
                                                    }
                                                    }
                                            >
                                                <Form style={{display: "inline"}}>
                                                    <button type="submit" className="btn btn-outline-warning" style={{

                                                        fontSize: '20px',
                                                        fontWeight: 'bold',
                                                        marginRight: "10px"
                                                    }}>
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="23" height="23"
                                                             fill="currentColor" className="bi bi-cart"
                                                             style={{paddingBottom: "2px"}} viewBox="0 0 16 16">
                                                            <path
                                                                d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
                                                        </svg>
                                                        &nbsp;
                                                        <span style={{paddingTop: "10px", font: "Roboto"}}>
                                        Thêm vào giỏ hàng </span>
                                                    </button>
                                                </Form>
                                            </Formik>


                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div className="row">
                            <button className="btn btn-warning">Danh sách trang phục</button>
                        </div>
                        <div className="row">
                            {
                                product.skinDetailSet.map((skinDetail)=>(
                                    <div className="col-xl-2 col-md-4 col-12 m-b-20 " style={{marginBottom:"10px"}}>
                                        <div className="row" style={{textAlign:"center",color:'yellow'}}>
                                            <span>{skinDetail.skin.nameSkin}</span>
                                        </div>
                                        <div className="row">
                                            <img className="w-100 h-100" style={{height: "150px"}} src={skinDetail.skin.imageSkin}/>
                                        </div>
                                    </div>
                                    )
                                )
                            }
                        </div>
                    </div>
                    <ToastContainer/>
                </div>
            )}
            <Footer/>

        </>
    )
}