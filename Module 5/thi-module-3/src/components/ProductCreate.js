import React, {useEffect, useState} from "react";
import * as ProductService from '../service/ProductService'
import * as ShopService from '../service/ShopService'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Field, Form, Formik} from "formik";
import * as Yup from "yup";
import {useNavigate} from "react-router";

export default function ProductCreate() {

    const navigate = useNavigate()
    const [shop, setShop] = useState([])
    const findShop = async () => {
        const rs = await ShopService.findAll()
        setShop(rs)
    }
    useEffect(() => {
        findShop()
    }, [])
    return (
        <>
            <Formik initialValues={
                {
                    code: '',
                    name: '',
                    quantity: '',
                    // idCustomer: '',
                    // idEmployee: '',
                    idShop: ''
                }
            } onSubmit={
                values => {
                    ProductService.createProduct(values)
                    navigate('/')
                    alert('Tạo mới thành công')
                }
            }
                    validationSchema={Yup.object({
                        code: Yup.string().required("mã sp không đc trống"),
                        name: Yup.string().required("tên sp không đc trống"),
                        quantity: Yup.number().required("Số lượng không đc trống").min(0, 'Phải lớn hơn 0')
                    })}>
               
                <Form>
                    <Field name='code' type='text' placeholder="Nhập mã sản phẩm"/>
                    <Field name='name' type='text' placeholder="Nhập tên sản phẩm"/>
                    <Field name='quantity' type='number' placeholder="Nhập số lượng sản phẩm"/>
                    <Field name='shop' as='select'>
                        {
                            shop.map(value => (
                                <option value={value.id}>{<value className="nameShop"></value>}</option>
                            ))
                        }
                    </Field>
                    {/*<Field name='' type='text' placeholder=""/>*/}
                    {/*<Field name='' type='text' placeholder=""/>*/}
                </Form>
            </Formik>
        </>
    )
}