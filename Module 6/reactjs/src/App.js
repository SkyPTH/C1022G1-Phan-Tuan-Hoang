import React from "react";
import {BrowserRouter, NavLink} from "react-router-dom";
import {Route, Routes} from "react-router";
import ClothingList from "./components/ClothingList";
import ClothingUpdate from "./components/ClothingUpdate";
function App() {
    return (
        <>

            <BrowserRouter>
                <NavLink to='/' className='btn btn-primary'>Clothing List</NavLink>
                <Routes>
                    <Route path='/' element={<ClothingList/>} />
                    <Route path='/update/:id' element={<ClothingUpdate/>} />
                </Routes>
            </BrowserRouter>
        </>

    )
}

export default App;
