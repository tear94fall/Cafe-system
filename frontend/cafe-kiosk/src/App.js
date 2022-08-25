import './App.css';
import Navbar from "./component/Navbar";
import { BrowserRouter as Router, Switch, Route, Routes } from 'react-router-dom';
import Home from "./pages/Home"
import Reports from "./pages/Report"
import Products from "./pages/Product"

function App() {
  return (
    <>
    <Router>
      <Navbar />
      <Routes>
        <Route path='/' exact={true} element={<Home/>} />
        <Route path='/reports' exact={true} element={<Reports/>} />
        <Route path='/products' exact={true} element={<Products/>} />
      </Routes>
    </Router>
    </>
  );
}

export default App;
