import React, {useEffect, useState} from "react";
import * as BookService from '../service/BookService'
import {Formik} from "formik";

export default function BookList() {
    const [books, setBooks] = useState()
    useEffect(() => {
        const fetch = async () => {
            return setBooks(await BookService.findAll());
        }
        fetch()
    })
    return (
        <>
       <table>
           <tr>
               <th>ID</th>
               <th>Title</th>
               <th>Quantity</th>
               <th>Update</th>
               <th>Delete</th>
           </tr>
           {
               books.map((book)=>(
                   <tr key={book.id}>
                       <td>{book.id}</td>
                       <td>{book.title}</td>
                       <td>{book.quantity}</td>
                       <td></td>
                       <td></td>
                   </tr>
               ))
           }
       </table>
        </>
    )
}