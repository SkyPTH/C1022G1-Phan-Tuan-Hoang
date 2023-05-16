import {BrowserRouter,NavLink} from "react-router-dom";
import {Route, Routes} from "react-router";
import React from "react";
import BookList from "./components/BookList";
import BookCreate from "./components/BookCreate";
import BookUpdate from "./components/BookUpdate";

function App() {
    return (
        <>
            <BrowserRouter>
                <NavLink to={'/'}>Book list</NavLink>
               <Routes>
                   <Route path='/' element={<BookList/>}/>
                   <Route path='/create' element={<BookCreate/>}/>
                   <Route path='/update' element={<BookUpdate/>}/>
               </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
