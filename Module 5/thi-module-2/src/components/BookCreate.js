import * as BookService from '../service/BookService'
import * as BookTypeService from '../service/BookTypeService'
import React, {useEffect, useState} from "react";
import {Field, Form, Formik} from "formik";
import {useNavigate} from "react-router";
import 'bootstrap/dist/css/bootstrap.min.css';
export default function BookCreate() {
    const [bookTypeList, setBookTypeList] = useState([])

    useEffect(() => {
        const typeList = async () => {
            const response = await BookTypeService.findAll()
            console.log(response)
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
            >
                <Form>
                    <Field name='title' type='text' placeholder='Title'/>
                    <Field name='number' type='text' placeholder='Number'/>
                    <Field as='select' name='bookType' >
                        {
                            bookTypeList.map((bookType, index) => (
                                <option value={bookType.id}>{bookType.name}</option>
                            ))
                        }
                    </Field>
                    <button type='submit' className='btn btn-primary'>Submit</button>
                </Form>

            </Formik>
        </>
    )
}