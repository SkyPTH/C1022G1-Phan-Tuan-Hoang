import * as ProductService from '../service/ProductService'
import {useNavigate, useParams} from "react-router";
import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup'
import "react-toastify/dist/ReactToastify.css"
import {toast, ToastContainer} from "react-toastify"
export default function Update() {
    const navigate = useNavigate()
    const [product,setProduct]=useState()
    const idParam=useParams()
    const findById= async () => {
        setProduct(await ProductService.findById(idParam.id))
    }
    useEffect(() => {
        findById()
    },[])
    if(!product){return null}
    return(
        <>
            <Formik
                initialValues={{
                    idProduct: product.idProduct,
                    nameProduct: product.nameProduct,
                    numberChamp: product.numberChamp,
                    price: product.price,
                    imageProduct: product.imageProduct,
                    ranking:{
                        idRanking : product.ranking.idRanking
                    }
                }}
                onSubmit={(values) => {
                    ProductService.update(values);
                    navigate('/');
                    toast("Cập nhật sản phẩm thành công")
                }}
            >
                {({ handleSubmit }) => (
                    <div className="container sl-sebox" style={{ paddingTop: '50px', marginBottom: '130px', marginTop: '40px' }}>
                        <form onSubmit={handleSubmit}>
                            <div className="row">
                                <div
                                    className="w-100"
                                    style={{
                                        height: '100%',
                                        fontSize: '53px',
                                        fontWeight: 'bolder',
                                        color: 'white',
                                        textAlign: 'center',
                                        border: 'red solid 2px',
                                    }}
                                >
                                    <a>Chỉnh sửa sản phẩm</a>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-4">Tên</div>
                                <div className="col-8">
                                    <Field name="nameProduct" type="text" placeholder="Nhập tên" />
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-4">Số tướng</div>
                                <div className="col-8">
                                    <Field name="numberChamp" type="number" placeholder="Nhập số tướng" />
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-4">Giá</div>
                                <div className="col-8">
                                    <Field name="price" type="number" placeholder="Nhập giá" />
                                </div>
                            </div>
                            <Field name="idProduct" type="hidden" placeholder="" />
                            <Field name="passwordProduct" type="hidden" placeholder="" />
                            {/*<Field name="imageProduct" type="hidden" placeholder="" />*/}
                            <div className="row">
                                <div className="col-12">
                                    <button type="submit">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                )}
            </Formik>

        </>
    )

}