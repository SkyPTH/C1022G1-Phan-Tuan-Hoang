import * as ClothingService from '../service/ClothingService'
import * as ClothingTypeService from '../service/ClothingTypeService'
import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router";
import {NavLink} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import {ErrorMessage, Field, Form, Formik} from "formik";

export default function ClothingList() {
    const [clothingList, setClothingList] = useState([])
    const findByName = async (name) => {
        const rs = await ClothingService.findByName(name)
        setClothingList(rs)
    }
    useEffect(() => {
        findByName()
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
    const handleUpdate = (id) => {
        navigate(`/update/${id}`)
    }
    if (clothingList.length == 0) {
        return (<><h2>Không tìm thấy sản phẩm</h2></>)
    }
    return (
        <>

            <Formik initialValues={
                {
                    name: '',
                    typeClothing: ''
                }
            } onSubmit={
                (values) => {
                   console.log(values)
                    findByName(values.name,values.typeClothing.id)

                }
            }>
                <Form>
                    <Field name='name' type='text' placeholder='Search by name'/>
                    <span>Clothing Type</span>
                    <Field as='select' name='typeClothing'>
                        {
                            typeList.map(value => (
                                <option value={value.id}>{value.name}</option>
                            ))
                        }
                    </Field>
                    <button className='btn-primary btn' type='submit'>Search</button>
                </Form>
            </Formik>
            <h2>Clothing List</h2>
            <table className='table table-striped'>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Day</th>
                    <th>Quantity</th>
                    <th>Type</th>
                    <th>Update</th>
                </tr>
                </thead>
                <tbody>
                {
                    clothingList.map((clothing) => (
                        <tr>
                            <td>{clothing.id}</td>
                            <td>{clothing.name}</td>
                            <td>{clothing.time}</td>
                            <td>{clothing.number}</td>
                            <td>{
                                typeList.filter((type) => (type.id == clothing.typeClothing))[0]?.name
                            }</td>
                            <td>
                                <button className='btn btn-primary'
                                        onClick={event => handleUpdate(clothing.id)}>Update
                                </button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    )
}