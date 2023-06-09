import * as BookService from '../service/BookService'
import * as BookTypeService from '../service/BookTypeService'
import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router";
import {NavLink} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import {ErrorMessage, Field, Form, Formik} from "formik";
export default function BookList() {
    const [bookList, setBookList] = useState([])
    const [bookTypeList,setBookTypeList]=useState([])
    const [titleDelete,setTitleDelete] = useState('')
    const [idDelete,setIdDelete] = useState(0)
    const navigate=useNavigate()
    const findByTitle = async (title) => {
        setBookList(await BookService.findByTitle(title))
    }
    useEffect(() => {

        findByTitle()
    }, [])

    useEffect(() => {
        const typeList= async () => {
            setBookTypeList(await BookTypeService.findAll())
        }
        typeList()
    }, [])
    const handleUpdate = (id)=>{
        navigate(`/update/${id}`)
    }
    const handleDelete = async (id,title) => {
            setIdDelete(id)
            setTitleDelete(title)
    }
    const handleDeleteModal = async (id)=>{
        await BookService.deleteById(id)
        findByTitle()
    }
    return (
        <>
            <NavLink to='/create' className='btn btn-primary'>Create</NavLink>
            <Formik  initialValues={
                {
                    title:''
                }
            } onSubmit={values => {findByTitle(values.title)}} >
                <Form>
                    <Field name='title' type='text' placeholder='Search by title'/>
                    <button type='submit'>Search</button>
                </Form>
            </Formik>
            <h2>Book List</h2>
            <table className='table table-striped' border='solid 1px'>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Number</th>
                    <th>Type</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                {
                    bookList.map((book) => (
                        <tr key={book.id}>
                            <td>{book.id}</td>
                            <td>{book.title}</td>
                            <td>{book.number}</td>
                            <td>{bookTypeList.filter((bookType) => (bookType.id == book.bookType))[0]?.name}</td>
                            <td><button type='button' onClick={()=> handleUpdate(book.id)} className='btn-primary btn'>Update</button></td>
                            <td><button type={'button'} onClick={()=> handleDelete(book.id,book.title)} className='btn btn-danger' data-bs-toggle="modal" data-bs-target="#exampleModal">
                                Delete
                            </button></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>

            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Ban co muon xoa <span></span>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button data-bs-dismiss="modal" onClick={()=>{}} type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )

}