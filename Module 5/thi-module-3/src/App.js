import logo from './logo.svg';
import './App.css';
import React from "react";
import {BrowserRouter} from "react-router-dom";
import {Route, Routes} from "react-router";
import List from "./components/List";
import ProductCreate from "./components/ProductCreate";

function App() {
  return (
   <BrowserRouter>
     <Routes>
             <Route path='/' element={<List/>} />
         <Route path='/create' element={<ProductCreate/>} />
     </Routes>
   </BrowserRouter>
  );
}

export default App;
