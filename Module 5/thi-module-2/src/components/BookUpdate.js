import * as BookService from '../service/BookService'
import * as BookTypeService from '../service/BookTypeService'
import {useState} from "react";
import {useNavigate} from "react-router";

export default function BookUpdate() {
    const [bookTypeList,setBookTypeList]=useState([])
    const typeList= async () => {
        setBookTypeList(await BookTypeService.findAll())
    }

    const navigate = useNavigate()
    return (
        <>

        </>
    )
}