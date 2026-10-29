import react from 'react'
import SampleCode from './component/sampleCode'
import Samplecode3 from './component/samplecode3';
import './App.css'

import UseFetchApi from './component/UseFetchApi';




function App() {


  const employee = [
    {name : "Smita", age : 21},
    {name : "Vishal", age : 23 },
    {name : "Murari", age : 24},
  ];

  return (
    <>
      
     {/* {employee.map((emp) => {

      return (
        
      <div key={emp.age}> 
         <h3> Name : {emp.name}</h3>
         <h3> Age : {emp.age}</h3>
      </div>
      )
     })}
 */}



        {/* <Samplecode3 />  */}


      <UseFetchApi/>
     

    </>
      

      
  )
}

export default App
