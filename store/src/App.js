import "./App.css";
import React, { Component }  from 'react';
import { Route, Routes } from "react-router-dom";
import HomePage from "./pages/Home";
import PhonesPage from "./pages/Phones";
import TabletsPage from "./pages/Tablets";
import WatchsPage from "./pages/Watch";
import TvsPage from "./pages/Tv";
import Layout from "./components/layout/Layout";
import Login from "./pages/Login";
import Register from "./pages/Register";

function App() {
  return (
    <Layout>
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route exact path="/phone" element={<PhonesPage />} />
        <Route exact path="/tablet" element={<TabletsPage />} />
        <Route exact path="/watch" element={<WatchsPage />} />
        <Route exact path="/tvhome" element={<TvsPage />} />
        <Route exact path="/login" element={<Login />} />
        <Route exact path="/register" element={<Register />} />
      </Routes>
    </Layout>
  );
}
  
export default App;
