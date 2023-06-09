import * as ProductService from '../service/ProductService'
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Field, Form, Formik } from "formik";
import Fuse from 'fuse.js';

export default function ProductList() {
    const [pageCount, setPageCount] = useState(0);
    const [page, setPage] = useState(0);
    const [size, setSize] = useState(0);
    let stt = page * size + 1;
    const [showMessage, setShowMessage] = useState(false);
    const [firstRecord, setFirstRecord] = useState(1);
    const [lastRecord, setLastRecord] = useState(0);
    const [totalRecords, setTotalRecords] = useState(0);
    const [showRecords, setShowRecords] = useState(true);
    const [productList, setProductList] = useState([]);
    const [filteredProductList, setFilteredProductList] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    const findByName = async (name) => {
        const rs = await ProductService.findByName(name);
        setProductList(rs);
        setFilteredProductList(rs);
    }

    useEffect(() => {
        findByName();
    }, []);

    const navigate = useNavigate();

    const handleSearch = (value) => {
        setSearchTerm(value);
        const fuse = new Fuse(productList, {
            keys: ['name']
        });
        const results = fuse.search(value);
        setFilteredProductList(results.map((result) => result.item));
    };

    const sortByQuantityAscending = () => {
        const sortedList = [...filteredProductList];
        sortedList.sort((a, b) => a.quantity - b.quantity);
        setFilteredProductList(sortedList);
    }

    return (
        <>
            <Formik
                initialValues={{
                    name: ""
                }}
                onSubmit={values => {
                    handleSearch(values.name);
                }}
            >
                <Form>
                    <Field name="name" type="text" placeholder="Search by name" />
                    <button className='btn-primary btn' type='submit'>Tìm kiếm</button>
                </Form>
            </Formik>
            <h2>Product List</h2>
            <button className='btn-primary btn' onClick={sortByQuantityAscending}>Sắp xếp theo số lượng tăng dần</button>
            <table className='table table-striped'>
                <thead>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Name</th>
                    <th>Quantity</th>
                </tr>
                </thead>
                <tbody>
                {filteredProductList.map((product, index) => (
                    <tr key={product.id}>
                        <td>{product.code}</td>
                        <td>{product.name}</td>
                        <td>{product.quantity}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </>
    )
}
