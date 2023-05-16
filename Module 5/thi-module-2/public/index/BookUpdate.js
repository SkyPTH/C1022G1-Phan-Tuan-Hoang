import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router";
import * as BookService from '../service/BookService'
import * as BookTypeService from '../service/BookTypeService'
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";

export default function BookUpdate() {
    const [book, setBook] = useState()
    const param = useParams()
    useEffect(() => {
        const findById = async () => {
            const rs = await BookService.findById(param.id)
            setBook(rs)
        }
        findById()
    },[param.id])
    const [bookType, setBookType] = useState([])
    const bookTypeList = async () => {
        const rs = await BookTypeService.findAll()
        setBookType(rs)
    }
    useEffect(() => {
        bookTypeList()
    },[])
    const navigate = useNavigate()
    if (!book){
        return null
    }
    return (
        <>
            <h2>Book Update</h2>
            <Formik initialValues={
                {
                    id: book?.id,
                    title: book?.title,
                    number: book?.number,
                    bookType: book?.bookType
                }
            } onSubmit={values => {
                BookService.update(values)
                navigate('/')
            }

            } validationSchema={Yup.object(
                {
                    title: Yup.string().required('Must have'),
                    number: Yup.number().required('Must have'),
                    bookType: Yup.string().required('Must have')
                }
            )
            }
            >
                <Form>
                    <Field name='title' type='text'/>
                    <ErrorMessage name='tittle' component='span' className='text-danger'/>
                    <Field name='id' type='hidden'/>
                    <Field name='number' type='number'/>
                    <ErrorMessage name='number' component='span' className='text-danger'/>
                    <Field as='select' name='bookType'>
                    <option value=''>---Chon loai---</option>
                    {bookType.map((type, index) => (
                        <option value={type.id}>{type.name}</option>
                    ))} </Field>
                    <ErrorMessage name='bookType' component='span' className='text-danger'/>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </Form>
            </Formik>
        </>

    )
}