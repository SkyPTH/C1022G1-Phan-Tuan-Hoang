import * as BookService from '../service/BookService'
import * as BookTypeService from '../service/BookTypeService'
import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router";
import 'bootstrap/dist/css/bootstrap.min.css';
import * as Yup from 'yup'
export default function BookCreate() {
    const [bookTypeList, setBookTypeList] = useState([])

    useEffect(() => {
        const typeList = async () => {
            const response = await BookTypeService.findAll()
            setBookTypeList(response)
        }
        typeList()
    }, [])
    const navigate = useNavigate()
    return (
        <>
            <h2>Book Create</h2>
            <Formik
                initialValues={
                    {
                        title: '',
                        number: '',
                        bookType: ''
                    }
                }
                onSubmit={
                    values => {
                        BookService.create(values)
                        navigate('/')
                    }
                }
                validationSchema={Yup.object(
                    {
                        title:Yup.string().required('Must have'),
                        number:Yup.number().required('Must have'),
                        bookType:Yup.string().required('Must have')
                    }
                )}
            >
                <Form>
                    <Field name='title' type='text' placeholder='Title'/>
                    <ErrorMessage name='title' component='span' className='text-danger'/>
                    <Field name='number' type='text' placeholder='Number'/>
                    <ErrorMessage name='number' component='span' className='text-danger'/>
                    <Field as='select' name='bookType' >
                        <option value={''}>---Chon loai---</option>
                        {
                            bookTypeList.map((bookType, index) => (
                                <option value={bookType.id}>{bookType.name}</option>
                            ))
                        }
                    </Field>
                    <ErrorMessage name='bookType' component='span' className='text-danger'/>
                    <button type='submit' className='btn btn-primary'>Submit</button>
                </Form>
            </Formik>
        </>

    )
}