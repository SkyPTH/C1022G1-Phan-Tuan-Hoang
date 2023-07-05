import React, {useEffect, useState} from "react";
import Header from "../common/header/Header";
import Footer from "../common/footer/Footer";
import * as ProductService from '../service/ProductService'
import {useNavigate} from "react-router";
import {findAccountByNameAccount} from "../service/AccountService'";
import {Field, Form, Formik} from "formik";
import * as CartService from "../service/CartService";
import {createCart} from "../service/CartService";
import "react-toastify/dist/ReactToastify.css"
import {toast, ToastContainer} from "react-toastify"
import ReactPaginate from "react-paginate";

export default function Home() {
    const [products, setProducts] = useState([])
    const [page, setPage] = useState(0)
    const token = localStorage.getItem("token")
    const [pageCount, setPageCount] = useState(0)
    const [size, setSize] = useState(0)
    const [totalRecords, setTotalRecords] = useState(0);
    let stt = page * size + 1;
    const handlePageClick = (data) => {
        console.log(data.selected)
        setPage(data.selected);
    };
    const productList = async () => {
        const result = await ProductService.searchList('','','','','',page)

        setProducts(result.content)
        setPageCount(result.totalPages);
        setSize(result.size);
        setTotalRecords(result.totalElements);
    }
    useEffect(() => {
        productList();
        document.title = "Riot Shop - Shop acc top 1 VN";
    }, [page, size, totalRecords]);
    const navigate = useNavigate();
    // useEffect(() => {
    //     productList();
    //
    // }, []);

    const username = localStorage.getItem("username");
    const account = JSON.parse(localStorage.getItem("account"));
    const [user, setUser] = useState(null);
    useEffect(() => {
        const findAccountByUsername = async () => {

            const result = await findAccountByNameAccount(username,token);
            setUser(result);
        };
        findAccountByUsername();
    }, []);
    const formatPrice = (n) => {
        return n.toFixed(0).replace(/./g, function (c, i, a) {
            return i > 0 && c !== "." && (a.length - i) % 3 === 0 ? "," + c : c;
        });
    };
    return (
        <>
            <Header/>
            <div>
                <div id="carouselExampleIndicators" className="carousel slide container" style={{marginTop: '80px'}}
                     data-bs-ride="carousel">
                    <div className="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to={0}
                                className="active" aria-current="true" aria-label="Slide 1"/>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to={1}
                                aria-label="Slide 2"/>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to={2}
                                aria-label="Slide 3"/>
                    </div>
                    <div className="carousel-inner">
                        <div className="carousel-item active">
                            <img src="../images/c4a0cf3ac1188ded65feb23ef4359a68.jpg" className="d-block w-100"
                                 alt="..."/>
                        </div>
                        <div className="carousel-item">
                            <img src="../images/hinh-nen-lien-minh-toc-chien-2.jpg" className="d-block w-100"/>
                        </div>
                        <div className="carousel-item">
                            <img src="../images/maxresdefault.jpg" className="d-block w-100" alt="..."/>
                        </div>
                    </div>
                    <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"/>
                        <span className="visually-hidden">Previous</span>
                    </button>
                    <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"/>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
                <div className="container sl-sebox" style={{paddingTop: '50px', marginBottom: '130px'}}>
                    <div className='row'>
                        <Formik
                            initialValues={{
                                nameProduct: '',
                                idRank: '',
                                nameSkin: '',
                                priceRange: ''
                            }}
                            onSubmit={async (values) => {
                                const [minPrice, maxPrice] = values.priceRange.split('-');
                                const result = await ProductService.searchList(values.nameProduct, values.idRank, values.nameSkin, minPrice, maxPrice);
                                setProducts(result.content);
                            }}
                        >
                            <Form>
                                <div className='row'>
                                    <div className='col-4'><a style={{color:"white"}}>Tên tài khoản:</a>
                                        <Field type='text' name='nameProduct' placeholder='Nhập tên tài khoản' className='form-control' />
                                    </div>
                                    <div className='col-4'>
                                        <a style={{color:"white"}}>Xếp hạng : </a>
                                        <Field as='select' name='idRank' className='form-select'>
                                            <option value="">---Tìm theo xếp hạng----</option>
                                            <option value="1">Thách đấu</option>
                                            <option value="2">Đại cao thủ</option>
                                            <option value="3">Cao thủ</option>
                                            <option value="4">Kim cương</option>
                                            <option value="5">Bạch kim</option>
                                            <option value="6">Vàng</option>
                                            <option value="7">Bạc</option>
                                            <option value="8">Đồng</option>
                                        </Field>
                                    </div>
                                    <div className='col-4'>
                                        <a style={{color:"white"}}>Tên trang phục</a>
                                        <Field type='text' name='nameSkin' placeholder='Nhập tên trang phục' className='form-control' />

                                    </div>
                                    <div className='col-4'>
                                        <a style={{color:"white"}}>Khoảng giá:</a>
                                        <Field as='select' name='priceRange' id='priceRange' className='form-select'>
                                            <option value=''>---Chọn khoảng giá---</option>
                                            <option value='0-100000'>Dưới 100k</option>
                                            <option value='100000-300000'>100k - 300k</option>
                                            <option value='300000-500000'>300k - 1 triệu</option>
                                            <option value='1000000-2000000'>1 triệu - 2 triệu</option>
                                            <option value='2000000-5000000'>2 triệu - 5 triệu</option>
                                            <option value='5000000-100000000'>Trên 5 triệu</option>
                                        </Field>
                                    </div>
                                    <div className='col-4'>
                                        <button type='submit' className='btn btn-warning' style={{marginTop:"25px"}}>Tìm kiếm</button>
                                    </div>
                                </div>
                            </Form>
                        </Formik>

                    </div>
                    <div className="row">
                        <div className="w-100 blink" style={{
                            height: '100%',
                            fontSize: '53px',
                            fontWeight: 'bolder',
                            color: 'white',
                            textAlign: 'center',
                            border: 'red solid 2px',
                            marginTop: '40px'
                        }}><span>
                            Danh sách tài khoản</span>
                        </div>
                        {products.length==0?<div style={{
                            height: '100%',
                            fontSize: '30px',
                            fontWeight: 'bolder',
                            color: 'white',
                            textAlign: 'center'}}
                        ><a >Không tìm thấy sản phẩm phù hợp</a></div>:''}
                        {products.map((product) => (
                            <div className="col-xl-3 col-md-6 col-12 m-b-20 p-3 border-cart" style={{margin: '20px 5px ', }}>
                                <div style={{paddingTop: '25% !important', marginTop: '20px'}} className="skin-effect">
                                    <img className="w-100" style={{height: "150px"}} src={product.imageProduct}/>
                                </div>
                                <div className="container-fluid" style={{margin: '5px'}}>
                                    <div style={{fontSize: '25px', color: 'yellow', fontWeight: 'bolder'}}>
                                        {formatPrice(product.price)} đ
                                    </div>
                                    <div style={{fontSize: '20px', color: 'white'}}>
                                        Số tướng: {product.numberChamp}
                                    </div>
                                    <div style={{fontSize: '20px', color: 'white'}}>
                                        Rank: {product.ranking.nameRanking}
                                    </div>
                                    <div style={{fontSize: '20px', color: 'white'}}>
                                        Số trang phục : {product.skinDetailSet.length}
                                    </div>
                                    <div className="text-center" style={{marginTop: '20px', marginBottom: '15px'}}>
                                        <button onClick={event => navigate(`/detail/${product.idProduct}`)}
                                                className="btn btn-primary"
                                                style={{width: '75px', marginRight: '10px',fontSize:"15px"}}>Chi tiết
                                        </button>
                                        {!user ?
                                            <button className="btn btn-danger" onClick={() => navigate('/login')}>Mua
                                                ngay</button>
                                            : <Formik initialValues={{
                                                priceProduct: product.price,
                                                productId: product.idProduct,
                                                accountUserId: user.idAccount
                                            }}
                                                      onSubmit={async (values) => {
                                                          let res = await CartService.checkCartExist(user.idAccount, product.idProduct,token)
                                                          if (res.data) {
                                                              toast("Sản phẩm đã có trong giỏ hàng!");
                                                          } else {
                                                              createCart(values,token);
                                                              toast("Thêm vào giỏ hàng thành công!")
                                                              navigate("/cart");

                                                          }
                                                      }
                                                      }
                                            >
                                                <Form style={{display: "inline"}}>
                                                    <button type='submit' className="btn btn-danger" style={{fontSize:"15px"}}>Thêm vào giỏ</button>
                                                </Form>
                                            </Formik>
                                        }

                                    </div>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
                <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}><ReactPaginate
                    previousLabel={'Trước'}
                    nextLabel={'Sau'}
                    pageCount={pageCount}
                    onPageChange={handlePageClick}
                    containerClassName="pagination"
                    pageClassName="page-item"
                    pageLinkClassName="page-link"
                    previousClassName="page-item"
                    previousLinkClassName="page-link"
                    nextClassName="page-item"
                    nextLinkClassName="page-link"
                    activeClassName="active"
                /></div>
                <ToastContainer/>
            </div>
            <Footer/>
        </>
    )
}