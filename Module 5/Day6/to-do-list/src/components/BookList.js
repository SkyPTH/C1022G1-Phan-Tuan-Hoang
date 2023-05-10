import {useEffect, useState} from "react";
import * as BookService from '../service/BookService'
import {NavLink,useNavigate} from "react-router-dom";


export default function Book() {

    const [BookList, setBookList] = useState([])
    useEffect(() => {
        const fetchApi = async () => {
            const rs = await BookService.findAll()
            setBookList(rs)
        }
        fetchApi()
    }, [])
    const navigate = useNavigate()
    const handleUpdate = (id) => {
        navigate(`/update/${id}`)
    }
    return (
        <>
            <NavLink to='/book-create'>Create</NavLink>
            <h2>BookList</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Update</th>
                </tr>
                </thead>

                {
                    BookList.map((books) => (
                        <tr key={books.id}>
                            <td>{books.id}</td>
                            <td>{books.title}</td>
                            <td>{books.quantity}</td>
                            <td>
                                <button type='button' className='btn btn-primary' onClick={()=>handleUpdate(books.id)}>Update</button>
                            </td>
                        </tr>
                    ))
                }

            </table>
        </>
    )
}
