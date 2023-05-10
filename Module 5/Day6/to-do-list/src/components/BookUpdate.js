import React, {useEffect, useState} from "react";
import {Field, Form, Formik} from "formik";
import {useNavigate, useParams} from "react-router";
import * as BookService from '../service/BookService'

export default function BookUpdate() {
    let navigate = useNavigate()
    let param = useParams();
    const [book, setBook] = useState()
    useEffect(() => {
        const fetchApi = async () => {
            const rs = await BookService.detail(param.id)
            return setBook(rs)
        }
        fetchApi()
    }, [])
    if (!book) {
        return null
    }
    return (
        <>
            <Formik
                initialValues={
                    {
                        id: book?.id,
                        title: book?.title,
                        quantity: book?.quantity
                    }
                }
                onSubmit={(values => {
                    BookService.update(values)
                        navigate('/books')
                }
                )
                }
            >
                <Form>
                    <h2>Edit book</h2>
                    <div>
                        <Field type='hidden' name='id'/>
                    </div>
                    <div>
                        <Field type='text' name='title' placeholder='Input new title'/>
                    </div>
                    <div>
                        <Field type='number' name='quantity' placeholder='Input new quantity'/>
                    </div>
                    <button type='submit' className='btn btn-primary'>Submit</button>
                </Form>
            </Formik>
        </>
    )
}