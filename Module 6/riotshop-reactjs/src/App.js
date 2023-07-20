import logo from './logo.svg';
import './App.css';
import React from "react";
import {BrowserRouter} from "react-router-dom";
import {Route, Routes} from "react-router";
import Home from "./components/Home";
import Detail from "./components/Detail";
import Login from "./components/Login";
import SignUp from "./components/SignUp";
import Cart from "./components/Cart";
import History from "./components/History";
import Payment from "./components/Payment";
import Profile from "./components/Profile";
import Update from "./components/Update";
function App() {
  return (
    <>
      <BrowserRouter>
          <Routes>
            <Route element={<Home/>} path="" />
              <Route element={<Detail/>} path="/detail/:id" />
              <Route element={<Login/>} path="/login" />
              <Route element={<SignUp/>} path="/signup" />
              <Route element={<Cart/>} path="/cart" />
              <Route element={<History/>} path="/history"/>
              <Route element={<Payment/>} path="/payment"/>
              <Route element={<Profile/>} path="/profile"/>
              <Route element={<Update/>} path="/update/:id"/>
          </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
