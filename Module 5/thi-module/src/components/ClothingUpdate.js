import * as ClothingService from '../service/ClothingService'
import * as ClothingTypeService from '../service/ClothingTypeService'
import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router";
import {NavLink} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";


export default function ClothingUpdate() {
    const param = useParams()
    const [clothing, setClothing] = useState()
    const findClothing = async () => {
        const rs = await ClothingService.findById(param.id)
        setClothing(rs)
    }
    useEffect(() => {
        findClothing()
    }, [])
    const navigate = useNavigate()
    const [typeList, setTypeList] = useState([])
    const findTypeList = async () => {
        const rs = await ClothingTypeService.findAll()
        setTypeList(rs)
    }
    useEffect(() => {
        findTypeList()
    }, [])
    if (!clothing) {
        return null
    }
    return (
        <>
            <h2>Clothing Update</h2>
            <Formik initialValues={
                {
                    id: clothing.id,
                    name: clothing.name,
                    time: clothing.time,
                    number: clothing.number,
                    typeClothing: clothing.typeClothing
                }
            } onSubmit={
                (values) => {
                    ClothingService.update(values)
                    navigate('/')
                    alert('Update complete')
                }
            }
                    validationSchema={Yup.object({
                        number: Yup.number().min(0, 'Must above 0')
                    })}>
                <Form>
                    <p><Field name='id' type='hidden'/></p>
                    <p><span>Name</span><Field name='name' type='text'/></p>
                    <ErrorMessage name='name' component='span' className='text-danger'/>
                    <p><span>Day</span><Field name='time' type='text'/></p>
                    <p><span>Quantity</span><Field name='number' type='text'/></p>
                    <ErrorMessage name='number' component='span' className='text-danger'/>
                    <p><span>Clothing Type</span>
                        <Field as='select' name='typeClothing'>
                            {
                                typeList.map(value => (
                                    <option value={value.id}>{value.name}</option>
                                ))
                            }
                        </Field></p>

                    <button type='submit' className='btn btn-primary'>Submit</button>
                </Form>
            </Formik>
        </>
    )
}