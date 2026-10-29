import React from 'react'
import {useState} from 'react'




function sampleCode(props) {

   const [count, setCount] = useState(0);

   const inc = ()=> {
    setCount(count +1);
   }

   const dec = () => {
    setCount(count -1);
   }

  return (
    <div>
      Sample code component
       
      {/* <h1> Vishal love : {props.name}  </h1>
      <h1> Murari love : {props.name1}    </h1> */}
{/* 
        <h1> Count : {count} </h1>

        <button onClick={inc}> Increment</button>
        <button onClick={dec}> Decrement</button> */}



        
        
    </div>
  )
}

export default sampleCode
