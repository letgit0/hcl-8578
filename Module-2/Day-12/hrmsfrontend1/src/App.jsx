
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Login from './component/Login';
import Register from './component/Register';
// import UseFetchApi from './component/UseFetchApi';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/Register" element={<Register/>} />
      </Routes>

      {/* Uncomment this if you want to display employee data */}
      {/* <UseFetchApi /> */}
    </BrowserRouter>
  );
}

export default App;
