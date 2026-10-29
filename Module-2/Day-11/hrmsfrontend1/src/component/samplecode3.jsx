import React, { useEffect } from 'react'
import { useState } from 'react';




function Samplecode3() {

    
       const [count, setCount] = useState(100);
       const [point, setPointer]  = useState(100);

       const inc = ()=> {
        setCount(count +2);
       }
    
       const dec = () => {
        setCount(count -2);
       }


       const pointinc = ()=> {
        setCount(point +2);
       }
    
       const pointdec = () => {
        setCount(point -2);
       }


       useEffect(()=>{
         console.log("Component update")
         console.log("Current count")
       })

  return (
    <div>
      
        <h1> Count : {count} </h1>

        <h1> Pointer : {point} </h1>
        <button onClick={inc}> Increment</button>
        <button onClick={pointdec}> Decrement</button> 


    </div>
  )
}

export default Samplecode3
