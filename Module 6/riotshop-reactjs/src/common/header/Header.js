import React, {useEffect, useState} from "react";
import {findAccountByNameAccount} from "../../service/AccountService'";
import Dropdown from "react-bootstrap/Dropdown"
import {useNavigate} from "react-router";
import {NavLink} from "react-router-dom";
import Link from "@mui/material/Link";
import Avatar from "@mui/material/Avatar";
import DropdownMenu from "react-bootstrap/DropdownMenu";

export default function Header() {
    const username = localStorage.getItem("username");
    const account = JSON.parse(localStorage.getItem("account"));
    const [user, setUser] = useState(null);
    const roles = [];
    const navigate = useNavigate();
    const token = localStorage.getItem("token")
    if (account != null) {
        for (let i = 0; i < account.roles.length; i++) {
            roles.push(account.roles[i].authority);
        }
    }
    const handleLogout = () => {
        localStorage.clear();
        window.location.href = "/";
    };
    useEffect(() => {
        const findAccountByUsername = async () => {
            const result = await findAccountByNameAccount(username,token);
            setUser(result);
        };
        findAccountByUsername();
    }, []);
    return (
        <>
            <section style={{marginTop: '0px'}}>
                <nav className="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light fixed-top"
                     id="ftco-navbar">
                    <div className="container-fluid" style={{fontSize: '20px'}}>
                        <div className="order-lg-last p-3 mr-2">
                            <div className="float-left">
                                {username ?
                                    (<div className="float-left">
                                        <div className='float-left'>
                                    <Dropdown>
                                        <Dropdown.Toggle
                                            variant="transparent"
                                            className="d-flex justify-content-center align-items-center border-0"
                                        >
                                            <Avatar>{username[0].toUpperCase()}</Avatar>
                                        </Dropdown.Toggle>
                                        <DropdownMenu>
                                            <Dropdown.Item
                                                onClick={event => navigate('/profile')}
                                                className="text-decoration-none"
                                            >
                                                Thông tin cá nhân
                                            </Dropdown.Item>
                                            <Dropdown.Item
                                                onClick={handleLogout}
                                                className="text-decoration-none"
                                            >
                                                Đăng xuất
                                            </Dropdown.Item>
                                        </DropdownMenu>
                                    </Dropdown>
                                        </div>
                                        <div className="float-left" style={{
                                            color:"white",
                                            marginTop:'7px'

                                        }}
                                             onClick={() =>navigate('/cart') }
                                        >
                                            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35"
                                                 fill="currentColor" className="bi bi-cart"
                                                 style={{paddingBottom: "2px"}} viewBox="0 0 16 16" >
                                                <path
                                                    d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
                                            </svg>
                                        </div>
                                    </div>)
                                 :
                                    (<div className="float-left">
                                    <NavLink to={'/login'} className="text-warning text-user p-1 "
                                       data-target="#modal_login" data-toggle="modal" style={{marginRight: '10px'}}>Đăng nhập
                                    </NavLink>
                                    <NavLink to={'/signup'} className="text-warning text-user m-l-15 p-1"
                                    data-target="#modal_register" data-toggle="modal">Đăng
                                        ký</NavLink>
                                    </div>)
                                    }
                                </div>

                        </div>

                        <div className="circle-img" style={{marginLeft: 0}}><img height="30px"
                                                                                 src="../../images/Screenshot%202023-06-13%20095153.png"/>
                        </div>
                        <div className=" navbar-collapse" id="ftco-nav" style={{marginLeft: '50px'}}>
                            <ul className="navbar-nav mr-auto">
                                <li className="nav-item"><a className="nav-link" href="/"
                                                            style={{fontSize: '17px', fontWeight: 'bolder'}}>Trang
                                    chủ</a></li>
                                {username? <li className="nav-item"><a className="nav-link" href="/history"
                                                                       style={{fontSize: '17px', fontWeight: 'bolder'}}>Lịch sử mua hàng</a></li> :""}

                                <li className="nav-item"><a className="nav-link" href=""
                                                            style={{fontSize: '17px', fontWeight: 'bolder'}}>Liên
                                    hệ</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>

            </section>
        </>
    )
}