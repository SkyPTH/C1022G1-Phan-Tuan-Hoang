import './App.css';

import InfoForm from "./components/InfoForm";
import MedicalForm from "./components/MedicalForm";
import {NavLink, Route, Routes} from 'react-router-dom'

function App() {
    return (
        <>
            <NavLink to='/'>Information Form</NavLink>
            <NavLink to='/medical-form'>Medical Form</NavLink>
            <Routes>
                <Route path='/' element={<InfoForm/>}/>
                <Route path='/medical-form' element={<MedicalForm/>}/>
            </Routes>
        </>
    );
}

export default App;
