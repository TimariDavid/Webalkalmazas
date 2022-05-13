import "./App.css";
import { Route, Routes } from "react-router-dom";
import HomePage from "./pages/Home";
import PhonesPage from "./pages/Phones";
import TabletsPage from "./pages/Tablets";
import Layout from "./components/layout/Layout";

function App() {
  return (
    <Layout>
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route exact path="/phone" element={<PhonesPage />} />
        <Route exact path="/tablet" element={<TabletsPage />} />
      </Routes>
    </Layout>
  );
}

export default App;
