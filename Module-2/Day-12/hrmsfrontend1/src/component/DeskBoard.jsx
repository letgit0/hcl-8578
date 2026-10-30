import { BrowserRouter, Route } from "react-router-dom";
import UseFetchApi from "./UseFetchApi";
import Login from "./Component/Login";
import Registration from "./Component/Registration";

function App() {
  return (
    <div>

      <BrowserRouter>

     <Route path="/" element={<Home/>} />
      <Route path="/Login" element={<Login/>} />
       <Route path="/Registration" element={<Registration/>} />
      </BrowserRouter>
      {/* <UseFetchApi /> */}
    </div>
  );
}

export default App;