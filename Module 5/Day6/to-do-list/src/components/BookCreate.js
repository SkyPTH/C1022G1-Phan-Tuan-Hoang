import {useNavigate} from "react-router";
import {Field, Form, Formik} from "formik";
import React from "react";
import * as BookService from '../service/BookService'

export default function BookCreate() {
    let navigate = useNavigate()
    return (

        <>
            <h2>Create book</h2>
            <Formik
                initialValues={
                    {
                        title: '',
                        quantity: 0
                    }
                }
                onSubmit={(values =>{ BookService.save(values)
                    navigate('/books')
                })
                }
            >
                <Form>
                    <div className='form-group'>
                        <Field type='text' name='title' placeholder='Input title'/>
                    </div>
                    <div className='form-group'>
                        <Field type='number' name='quantity' placeholder='Input quantity'/>
                    </div>
                    <button type='submit' className='btn btn-primary'>Submit</button>
                </Form>
            </Formik>
        </>
    )
}
