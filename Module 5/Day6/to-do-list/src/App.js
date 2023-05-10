import './App.css';
import {BrowserRouter, NavLink, Route, Routes} from 'react-router-dom'
import ToDoList from "./components/ToDoList";
import BookList from "./components/BookList";
import BookCreate from "./components/BookCreate";
import BookUpdate from "./components/BookUpdate";
function App() {
    return (<>
            <BrowserRouter>
            <NavLink to='/to-do-list'>To-do list</NavLink>
                <NavLink to='/books'>Book list</NavLink>
            <Routes>
                <Route path='/to-do-list' element={<ToDoList/>}/>
                <Route path='/books' element={<BookList/>}/>
                <Route path='/book-create' element={<BookCreate/>}/>
                <Route path='/update/:id' element={<BookUpdate/>}/>
            </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
