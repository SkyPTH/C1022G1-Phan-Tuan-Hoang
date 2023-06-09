import * as BookService from '../service/BookService'
import {useNavigate, useParams} from "react-router";
import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup'
export default function BookUpdate() {
    const navigate = useNavigate()
    const [book,setBook]=useState()
    const idParam=useParams()
    const findById= async () => {
        setBook(await BookService.findbyID(idParam.id))
    }
    useEffect(() => {
        findById()
        console.log(book)
    },[])
    if(!book){return null}
    return(
        <>
            <Formik
                initialValues={
                    {
                        id:book.id,
                        title:book.title,
                        number:book.number
                    }
                }
                onSubmit={values => {
                    BookService.update(values)
                    navigate('/')
                }
                }
                validationSchema={ Yup.object( {
                        title:Yup.string().required('Must fill'),
                        number:Yup.number().required('Must fill')
                    }
                )
                }
            >
                <Form>
                    <Field name='title' type='text' placeholder='Input title'/>
                    <ErrorMessage name='title' component='span'/>
                    <Field name='id' type='hidden' placeholder=''/>
                    <Field name='number' type='number' placeholder='Input number'/>
                    <ErrorMessage name='number' component='span'/>
                    <button type='submit'>Submit</button>
                </Form>
            </Formik>
        </>
    )

}