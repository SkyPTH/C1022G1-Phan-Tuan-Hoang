import * as Yup from 'yup'
import React, {useEffect, useState} from "react";
import * as ListService from '../service/ListService'
import {Field, Form, Formik} from "formik";

export default function ToDoList() {
    const [ToDoList, setToDoList] = useState([]);
    useEffect(() => {
        const fetchApi = async () => {
            let result = await ListService.findAll()
            setToDoList(result)
        }
        fetchApi()
    }, [])

    return (
        <>
            <h2>To do List</h2>
            <Formik initialValues={
                {name: ''}
            } onSubmit={(values => {
                const inputToDo = async () => {
                    await ListService.save(values)
                    alert("Thanh cong")
                }
                inputToDo()
            })}
            >
                <Form>
                    <p><Field type='text' name='title'/></p>
                    <p>
                        <button type='submit'>Submit</button>
                    </p>
                </Form>
            </Formik>
            {ToDoList.map((todo) => (
                    <p>ID User: {todo.userId}, ID: {todo.id}, Tittle: {todo.title}, Complete: {todo.completed}</p>
                )
            )}
        </>
    )
}