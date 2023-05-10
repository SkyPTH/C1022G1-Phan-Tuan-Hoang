import logo from './logo.svg';
import './App.css';
import {BrowserRouter, NavLink} from "react-router-dom";
import React from "react";
import {Route, Routes} from "react-router";
import BookList from "./components/BookList";

function App() {
    return (
        <>
            <BrowserRouter>
                <NavLink to='/'>Book list</NavLink>
                <Routes>
                    <Route path='/' element={<BookList/>}/>
                </Routes>
            </BrowserRouter>
        </>
    )
}

export default App;
