import * as BookService from '../service/BookService'
import * as BookTypeService from '../service/BookTypeService'
import {useEffect, useState} from "react";
import {useNavigate} from "react-router";
import {NavLink} from "react-router-dom";
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';
export default function BookList() {
    const [bookList, setBookList] = useState([])
    const [bookTypeList,setBookTypeList]=useState([])

    useEffect(() => {
        const findByTitle = async (title) => {
            setBookList(await BookService.findByTitle(title))
        }
        findByTitle()
    }, [])

    useEffect(() => {
        const typeList= async () => {
            setBookTypeList(await BookTypeService.findAll())
        }
        typeList()
    }, [])

    return (
        <>
            <NavLink to='/create' className='btn btn-primary'>Create</NavLink>
            <h2>Book List</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Number</th>
                    <th>Type </th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                {
                    bookList.map((book) => (
                        <tr key={book.id}>
                            <td>{book.id}</td>
                            <td>{book.title}</td>
                            <td>{book.number}</td>
                            <td>{bookTypeList.filter((bookType) => (
                                bookType.id === book.bookType
                            ))[0]?.name}</td>
                            <td></td>
                            <td></td>
                        </tr>
                    ))
                }
            </table>
        </>
    )
}